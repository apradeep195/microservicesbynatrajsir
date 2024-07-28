package com.heg;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) throws IOException {
		System.out.println("File Handling program");
		
		File file=new File("abc.txt");
		file.createNewFile();
		System.out.println(file.exists());
		FileWriter fw=new FileWriter(file);
	//	fw.write("Hi I am Coding wallah sir");
	//	fw.close();
		
		FileReader fr=new FileReader(file);
		System.out.println(fr.read()); 
		
		
	}

}
