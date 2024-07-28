package com.heg.ruuners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AlertServiceRunner.run()... The cmd line args are");
		for(String arg : args) {
			System.out.println(arg);
		}
		
	}

}
