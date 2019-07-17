package com.alanlapierre.javatest.util;

public class StringUtil {
	public static String repeat(String str, Integer times) {
		String result = "";
		
		if(times < 0) {
			throw new IllegalArgumentException("negative times not allowed");
		}
		
		for (int i = 0; i <times; i++) {
			result += str;
		}
		
		return result;
	}
	
	public static Boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
