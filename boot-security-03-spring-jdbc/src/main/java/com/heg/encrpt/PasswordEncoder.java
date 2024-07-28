package com.heg.encrpt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pws1 = encoder.encode("rani");
		String pws2 = encoder.encode("ramesh");
		
		System.out.println(pws1);
		System.out.println(pws2);

	}

}
