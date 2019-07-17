package com.alanlapierre.javatest.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumerals {

	private static Map<Integer, String> basicSymbols = new HashMap<Integer, String>();
	private static Map<Integer, String> specificCurrentValueMap = new HashMap<Integer, String>();
	private static Map<Integer, Integer> specificCurrentKeyMap = new HashMap<Integer, Integer>();
	
	private static List<Integer> excludedFromRepetition = new ArrayList<Integer>();
	
	

	static {
		basicSymbols.put(1, "I");
		basicSymbols.put(5, "V"); 
		basicSymbols.put(10, "X"); 
		basicSymbols.put(50, "L");
		basicSymbols.put(100, "C");
		basicSymbols.put(500, "D"); 
		basicSymbols.put(1000, "M");
		
		specificCurrentValueMap.put(10, "I");
		specificCurrentValueMap.put(100, "X");
		specificCurrentValueMap.put(500, "C");
		specificCurrentValueMap.put(1000, "C");
		
		specificCurrentKeyMap.put(10, 1);
		specificCurrentKeyMap.put(100, 10);
		specificCurrentKeyMap.put(500, 100);
		specificCurrentKeyMap.put(1000, 100);
		
		excludedFromRepetition.add(5);
		excludedFromRepetition.add(50);
		excludedFromRepetition.add(500);

	}
	

	public static String arabicToRoman(int number) throws IllegalArgumentException {

		if(number > 3999) {
			throw new IllegalArgumentException("value must be less than 4000");
		}
		
		String result = "";
		String numberStr = "" + number;

		String zeros = "";
		
		for (int i = numberStr.length() - 1; i >= 0; i--) {
			if(numberStr.charAt(i) != '0') {
				Integer numberToConvert = Integer.parseInt(numberStr.charAt(i) + zeros);
				result = convert(numberToConvert) + result;
			}
			zeros += "0";
		}

		return result;

	}
	
	private static String convert(Integer number) {
		
		String result = basicSymbols.get(number);
		
		if(result != null) {
			return result;
		} else {
			
			result = "";
			
			Integer currentKey = 0;
			Integer nextKey = 0;
			
			List<Integer> listOfKeys = new ArrayList<Integer>(basicSymbols.keySet());
			Collections.sort(listOfKeys);
			
			for (Integer key : listOfKeys) {
		        if(number > key) {
		        	currentKey = key;
		        } else {
		        	nextKey = key;
		        	break;
		        }
			}
			
			if(isPowOfTen(nextKey - number)) {
				String currentValue = specificCurrentValueMap.get(nextKey);
				if(currentValue == null) {
					currentValue = basicSymbols.get(currentKey);
				}
				result = currentValue + basicSymbols.get(nextKey);

			} else {
				
				if(excludedFromRepetition.contains(currentKey)) {
					
					String currentValue = specificCurrentValueMap.get(nextKey);
					if(currentValue == null) {
						currentValue = basicSymbols.get(currentKey);
					}
					
					Integer specificCurrentKey = specificCurrentKeyMap.get(nextKey);
					if(specificCurrentKey == null) {
						specificCurrentKey = currentKey;
					}
					
					result = basicSymbols.get(currentKey);
					
					Integer aux = (number - currentKey) / specificCurrentKey; 
							
					for (int i = 0 ; i < aux  ; i++) {
						result += currentValue;
					}
							
				} else {
					Integer aux = number/currentKey;
					for (int i = 0 ; i < aux  ; i++) {
						result += basicSymbols.get(currentKey);
					}
				}
			}
		}
		
		return result;
	}
	
	
	private static Boolean isPowOfTen(Integer number) {
		for (int i=0;i<10;i++) {
			  Integer pow = (int)Math.pow(10,i);
			  if(pow == number) {
				  return true;
			  }			  
		}
		
		return false;
	}
	

}
