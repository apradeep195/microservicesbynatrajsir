package com.ndms.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndms.excetion.NotDesiredInputException;

@Component
public class CommonUtils {

	private static final Logger logger=LogManager.getLogger(CommonUtils.class);

	    public static String stringNoticePeriod(int value) {
	    	if(value==1)
	    		return "one";
	    	else if(value==2)
	    		return "two";
	    	else if(value==3)
	    		return "three";
	    	else
	    		return "";
	    }
	    
	    public static Integer convertYESNOToInt(String str) {
	    	if(str==null) 
	    		throw new NotDesiredInputException();
	    	else if(str.toUpperCase().equals("YES"))
	    		return 1;
	    	else if(str.toUpperCase().equals("NO"))
	    		return 0;
	    	else
	    		throw new NotDesiredInputException();
	    }
	    
	    
	    public static Integer convertYESNOToIntEmail(String str) {
	    	if(str==null) 
	    		throw new NotDesiredInputException();
	    	else if(str.toUpperCase().equals("NA"))
	    		return 0;
	    	else if(str.toUpperCase().equals("EXTERNAL"))
	    		return 1;
	    	else if( str.toUpperCase().equals("INTERNAL"))
	    		return 2;
	    	else
	    		throw new NotDesiredInputException();
	    }
//	    
	    
	    public static String addZeroBeforeString(String numString) {
	
	    	if(numString!=null) {
	    	Long number= Long.parseLong(numString);
	    	if(number<10) {
	    		numString="0"+numString;
	    	}
	    }	
	    	return numString;
	    }
	    public static String addZeroBeforeString(Long numLong) {
	    	String numString="";
	    	if(numLong!=null) {
	    	if(numLong<10) {
	    		numString=  "0"+numLong;
	         	}
	    	else
	    		numString=""+numLong;
	        }	
	    	return numString;
	    }
	    

		  public  static MediaType getMediaTypeFromPath(String fileName) {
			  
			  String extension=fileName.substring(fileName.indexOf('.')+1,fileName.length());
	
			  return  new MediaType("application",extension);
			  
		  }
	    
	    public static String getPathWithContext(final HttpServletRequest request) {
	    	  return  request.getScheme() + "://" + request.getServerName()+":" + request.getServerPort()+""+request.getContextPath();
	    }
	    
	    public static String saveFile(MultipartFile file,String folderPath) throws IOException {
	    	
	    	String filePath;
	    	String fileName=CommonUtils.getUniqueString()+"."+CommonUtils.getExtension(file);
	    	
	    	filePath=folderPath+fileName;
	        // read from a file
	        FileOutputStream fio=new FileOutputStream(filePath);
	    	fio.write(file.getBytes());
		    fio.close();
		    
	    	return fileName;
	    }
    public static String saveFileWithFilePath(MultipartFile file,String folderPath) throws IOException {
	    	
	    	String filePath;
	    	String fileName=CommonUtils.getUniqueString()+"."+CommonUtils.getExtension(file);
	    	
	    	filePath=folderPath+fileName;
	        // read from a file
	        FileOutputStream fio=new FileOutputStream(filePath);
	    	fio.write(file.getBytes());
		    fio.close();
		    
	    	return filePath;
	    }
	
	  
	    
	    public static String getCurrentDate() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date c= new Date();
			return sdf.format(c);
	    }
	    
	    public static String formatDate(Date date,DateFormat format)  {
	    	String strDate="";
	    	try {
			    SimpleDateFormat formatter = new SimpleDateFormat(format.getFormat());  
			    strDate= formatter.format(date);
			}
			catch(Exception ex) {}
				return strDate;
		    }

	    
	    
	    public static String formatDateTimeStamp(Date date) throws ParseException {
	    	
	    //	logger.debug("Un Formated Date "+date);
	    	
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		    String strDate= formatter.format(date);  
			
			//logger.debug("Formated String "+strDate);
			
			return strDate;
	    }
	    

    

	    public static Pageable getPageble(int pageNo,int pageSize) {
	    	return PageRequest.of(pageNo,pageSize);
	    }
	   
	public static Object covertJSONObject(JSONObject jsonObject,Class clazz)
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return	objectMapper.convertValue(jsonObject, clazz);
	}

	public static void copyProperties(Object source,Object target)
	{
		if(source!=null)
	    	BeanUtils.copyProperties(source, target);
		else
			logger.error("Exception while copying ",new Exception("Source can not be null"));
	}
	
	public static <T>  T copyProperties(Object source,Class<T> clazz) throws InstantiationException, IllegalAccessException
	{
		if(source==null)
			return null;
		
		T target=null;
		if(source!=null) {
		    target= clazz.newInstance();
		    BeanUtils.copyProperties(source, target);
		}
		else
			logger.error("Exception while copying ",new Exception("Source can not be null"));
		
	    return target;
	}

	public static void copyPropertiesWithFieldIgnorance(Object source,Object target,String... propertiesToBeIngored)
	{
		BeanUtils.copyProperties(source, target,propertiesToBeIngored);
	}

	public static <T,V> List<V> copyList(List<T> source,Class<V> targetClazz,String... propertiesToBeIngored)
	{
		List<V> targetList=new ArrayList<V>();
		source.forEach(model->{
			V v=null;
			try {
				v = targetClazz.newInstance();
				BeanUtils.copyProperties(model,v,propertiesToBeIngored);
			}
			catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			targetList.add(v);
		});
		return targetList;
	}
	public static <T,V> List<V> copyList(List<T> source,Class<V> targetClazz)
	{
		List<V> targetList=new ArrayList<V>();
		source.forEach(model->{
			V v=null;
			try {
				v = targetClazz.newInstance();
				BeanUtils.copyProperties(model,v);
			}
			catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			targetList.add(v);
		});
		return targetList;
	}
	public static String convertJSONString(Object source)
	{
		ObjectMapper mapper = new ObjectMapper();	
		return	mapper.convertValue(source, JSONObject.class).toJSONString();
	}
	
	public static String getServerAddress(HttpServletRequest request)
	{
       return request.getScheme() + "://" + request.getServerName() +":" + request.getServerPort()+""+request.getContextPath(); 		 	  
	}
	
	public static String getUniqueString() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String  getRequestURI(HttpServletRequest request)
	{
	       return  request.getRequestURI();

	}

	public static String toInitCap(String param) {
     try {
    	   if (param != null && param.length() > 0) {
    		   param=param.toLowerCase();
               char[] charArray = param.toCharArray();
               charArray[0] = Character.toUpperCase(charArray[0]);
               // set capital letter to first position
               return new String(charArray);
               // return desired output
           } else {
               return "";
           }
     }
     catch(Exception ex) {
        return param;
     }
    }
	
	public static String formatDate(Date date)
	{
	  String dateString;
		try {
			if(date==null) {	return "";		}
			SimpleDateFormat DateFor = new SimpleDateFormat("dd-MMM-yy");
			dateString= DateFor.format(date);
		}
		catch(Exception ex) {
			logger.debug("Error",ex);
			dateString="";
		}
		return dateString;
		
	}
	
	public static String formatMonthDate(Date date)
	{
	  String dateString;
		try {
			if(date==null) {	return "";		}
			SimpleDateFormat DateFor = new SimpleDateFormat("dd MMM yyyy");
			dateString= DateFor.format(date);
		}
		catch(Exception ex) {
			logger.debug("Error",ex);
			dateString="";
		}
		return dateString;
		
	}
	
	public static String encodeStringToBase64(String normalString)
	{
		
		return Base64.getEncoder().encodeToString(normalString.getBytes());
	}
	
	public static Date getValidationDateFromString(String dateString) {
		Date date=null;
		try {
			if(dateString!="")
				date=CommonUtils.covertStringToDate(dateString);
			else
				date= CommonUtils.getDefaultValidate();
		}
		catch (java.text.ParseException ex) {
			date= CommonUtils.getDefaultValidate();
			logger.error("Error orrured while parsing Date (Auto assigned "+date.toString()+") "+ex);
		}
		return date;
	}
	
	public static String decodeStringToBase64(String base64String)
	{
		byte[] decodedBytes = Base64.getDecoder().decode(base64String);
		return  new String(decodedBytes);
	}
	public static Date covertStringToDate(String dateString) throws ParseException
	{
		Date date=null;
      //Instantiating the SimpleDateFormat class
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      
      //Parsing the given String to Date object
	  date = formatter.parse(dateString);
	  return date;
	}
	public static Date getDefaultValidate()
	{
		    Date date=null;
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date currentDate = new Date();
	        System.out.println(dateFormat.format(currentDate));

	        // convert date to calendar
	        Calendar c = Calendar.getInstance();
	        c.setTime(currentDate);

	       c.add(Calendar.DATE, 7);

	        // convert calendar to date
	        Date defaultDate = c.getTime();
	        
	        logger.debug("Generated default date "+defaultDate);
	        
	        return defaultDate;
	}
	public static String  getExtension(MultipartFile file)
	{
		return FilenameUtils.getExtension(file.getOriginalFilename());
	}
	public static String  getExtension(File file)
	{
		return FilenameUtils.getExtension(file.getName());
	}

	public static String resolveBloodGroup(Integer value) {
		
		if(value==null)
		    	return "";
		
		if(value==10)
			return "A+VE";
		else if(value==20)
			return "A-VE";
		else if(value==30)
			return "B+VE";
		else if(value==40)
			return "B-VE";
		else if(value==50)
			return "AB+VE";
		else if(value==60)
			return "AB-VE";
		else if(value==70)
			return "0+VE";
		else if(value==80)
			return "0-VE";
		else {
			return "-";
		}
	}

	public static String resolveCategory(String category) {
		
		if(category!=null&&category.equalsIgnoreCase("GEN")) 
			   category="General";
	  return category;
	}
	public static String resolveGender(Integer gender) {
		if(gender==null)
			return "";
		
		String genderString="";
		
		if(gender==1) 
			genderString="Male";
		else if(gender==2)
			genderString="Female";
		else
			genderString="Other";
		
	return genderString;
	}
public static String resolveMaritalStatus(String maritalStatusStr) {
		
		String maritalS="";
		Integer maritalStatus;
		try {
			maritalStatus= Integer.parseInt(maritalStatusStr);
		}
		catch(Exception ex) {
			logger.error("Exception" +ex);
			return maritalS;
		}
		
		if(maritalStatus==1) 
			maritalS="Single";
		else if(maritalStatus==2)
			maritalS="Married";
		else if(maritalStatus==3)
			maritalS="Widower";
		else if(maritalStatus==4)
			maritalS="Divorcee";
		else
			maritalS="";
		
	   return maritalS;
	}


		
}
