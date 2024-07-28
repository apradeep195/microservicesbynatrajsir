package com.heg.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.heg.entity.MarriageSeekerInfo;
import com.heg.model.MarriageSeeker;
import com.heg.service.IMarriageSeekarService;

@Controller
public class MatrimonyOperationsController {

	@Autowired
	private IMarriageSeekarService service;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register_profile")
	public String registerProfile(@ModelAttribute("profile") MarriageSeeker seekar) {
		return "register";
	}
	
	@PostMapping("/register_profile")
	public String performFileUpload(@ModelAttribute("profile") MarriageSeeker seekar, Map<String,Object> map) throws Exception {
		//get Folder location to store uploaded files		
		String location=env.getProperty("upload.store");
		File locationStore= new File(location);
		
		//create the location folder if is not already available
		if(!locationStore.exists())			
			locationStore.mkdir();
		
		//get the original names of the uploading files
		MultipartFile resumeFile=seekar.getResume();
		MultipartFile photoFile=seekar.getPhoto();
		String resumeFileName=resumeFile.getOriginalFilename();
		String photoFileName=photoFile.getOriginalFilename();
		
		//create InputStream representing the uploaded files
		InputStream resumeIStream= resumeFile.getInputStream();
		InputStream photoIStream=photoFile.getInputStream();
		
		//create output streams pointing destination file on the server machine file system
		
		OutputStream resumeOStream=new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photOStream=new FileOutputStream(location+"/"+photoFileName);
		
		//complete operation amoung the stream		
		IOUtils.copy(resumeIStream, resumeOStream);
		IOUtils.copy(photoIStream, photOStream);
		
		//close streams
		resumeIStream.close();
		resumeOStream.close();
		photoIStream.close();
		photOStream.close();
		
		//create entity class object
		MarriageSeekerInfo info=new MarriageSeekerInfo();
		info.setProfileName(seekar.getProfileName());
		info.setGender(seekar.getGender());
		info.setResume(location+"/"+resumeFileName);
		info.setPhoto(location+"/"+photoFileName);
		
		//user Service
		String msg=service.registerProfile(info);
		
		//create model attributes
		map.put("resumeFile", resumeFileName);
		map.put("photoFile", photoFileName);
		map.put("resultMsg", msg);
		
		//logical view name
		return "show_result";
	}
	
	@GetMapping("/display")
	public String displayProfile(Map<String,Object> map) {
		
		Iterable<MarriageSeekerInfo> seekarList=service.getAllProfiles();
		map.put("seekerInfo", seekarList);
		return "show_result";
	}
	
}
