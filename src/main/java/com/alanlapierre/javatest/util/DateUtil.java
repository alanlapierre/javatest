package com.alanlapierre.javatest.util;

public class DateUtil {

	public static Boolean isLeapYear(Integer year){
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
