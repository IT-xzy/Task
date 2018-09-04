package com.leo.utils;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args){
		Map<String,Object> claims = new HashMap<String,Object>();
		claims.put("id",1243);
		claims.put("username","lssl");
		String token = JavaWebToken.createJWT(claims,(long)12*24*60*60*1000);
		System.out.println(token);
	}
}
