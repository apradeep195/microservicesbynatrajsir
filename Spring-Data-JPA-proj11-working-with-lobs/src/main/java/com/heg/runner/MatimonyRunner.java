package com.heg.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.entity.MarriageSeeker;
import com.heg.service.IMatrimonyServiceMgmt;

@Component
public class MatimonyRunner implements CommandLineRunner {

	@Autowired
	private IMatrimonyServiceMgmt matriService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Person Name ==== : ");
		String name=sc.next();
		
		System.out.println("Enter Address ====  : ");
		String addrs=sc.next();
		
		System.out.println("Enter PHOTO PATH :  ==== ");
		String photoPath=sc.next();
		InputStream is= new FileInputStream(photoPath);
		System.out.println("PHOTO SIZE PRINT " +is.available());
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes(); 
		
		System.out.println("Enter BIO DATA  PATH :  ==== ");
		String bioDataPath=sc.next();
		File file=new File(bioDataPath);
		Reader reader=new FileReader(file);
		char bioDataContent[]=new char[(int)file.length()] ;
		System.out.println("BIO FILE LENGTH  " +file.length());
		reader.read(bioDataContent);
		
		
		
		System.out.println("IS THE PERSION INDIAN ? ");
		boolean indian = sc.nextBoolean();
		
		
		MarriageSeeker seekar=new MarriageSeeker();
		seekar.setName(name);
		seekar.setAddrs(addrs);	
		
		seekar.setDob(new Date());		
		seekar.setIndian(indian);
		
		
		System.out.println(matriService.registerMarriageSeeker(seekar));
		
	}

}
