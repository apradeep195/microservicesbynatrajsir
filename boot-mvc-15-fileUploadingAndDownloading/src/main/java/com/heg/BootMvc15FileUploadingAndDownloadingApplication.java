package com.heg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvc15FileUploadingAndDownloadingApplication {

	public CommonsMultipartResolver createCMResolver() {
		
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(20*1024);
		resolver.setPreserveFilename(true);
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvc15FileUploadingAndDownloadingApplication.class, args);
	}

}
