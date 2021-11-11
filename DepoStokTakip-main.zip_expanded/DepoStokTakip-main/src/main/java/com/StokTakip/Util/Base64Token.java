package com.StokTakip.Util;

import java.util.Base64;

public class Base64Token {

	
	public static String encode(String email,String password) {
		String  auth= email + ":" + password;
		String token = Base64.getEncoder().encodeToString(auth.getBytes());
		String authHeader = "Basic " + token;
		return authHeader ;
	}
	
	
}
