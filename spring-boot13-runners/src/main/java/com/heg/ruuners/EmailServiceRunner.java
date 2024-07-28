package com.heg.ruuners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailServiceRunner.run()");
		System.out.println("No option args " +args.getNonOptionArgs());
		System.out.println("option args" +args.getOptionNames()); 
		System.out.println("source args " +args.getSourceArgs());
		
		
		
	}

}
