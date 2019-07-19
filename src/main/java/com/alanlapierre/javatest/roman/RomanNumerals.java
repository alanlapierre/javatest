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

		// Si numero mayor que 3999 se genera un error.
		
		if(number > 3999) {
			throw new IllegalArgumentException("value must be less than 4000");
		}
		
		String result = "";
		String numberStr = "" + number;

		String zeros = "";
		
		// Separamos el parámetro en unidad, decena, centena, unidad de mil para luego convertir cada uno de estos valores por separado.
		// Es necesario que agreguemos los "ceros" para poder formar 1000, 2000, 100, 200, 10, 20, etc. (según corresponda).
		
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
		
		//Si el número es uno de los simbolos básicos, se retorna inmediatamente su valor.
		if(result != null) {
			return result;
		} else {
			result = generateNonDirectConversion(number);
		}
		return result;
	}

	private static String generateNonDirectConversion(Integer number) {
		String result;
		result = "";
		
		//Determino primeramente entre que simbolos (De la lista basicSymbols) se encuentra el 
		//valor a convertir.
		Integer currentKey = 0;
		Integer nextKey = 0;
		
		List<Integer> listOfKeys = orderBasicSymbols();
		
		for (Integer key : listOfKeys) {
		    if(number > key) {
		    	currentKey = key;
		    } else {
		    	nextKey = key;
		    	break;
		    }
		}
		
		result = complexConversion(number, currentKey, nextKey);
		return result;
	}

	private static List<Integer> orderBasicSymbols() {
		List<Integer> listOfKeys = new ArrayList<Integer>(basicSymbols.keySet());
		Collections.sort(listOfKeys);
		return listOfKeys;
	}

	//Si conocemos el número a convertir, y entre que valores de los básicos se encuentra, 
	// podemos generar el resultado para cada unidad, decena, centena o unidad de mil que se pase.
	
	private static String complexConversion(Integer number, Integer currentKey, Integer nextKey) {
		String result ="";
		if(isPowerOfTen(nextKey - number)) {
			result = substractOfSymbol(currentKey, nextKey);
		} else if(excludedFromRepetition.contains(currentKey)) {
			result = repetitionOfDifferentSymbols(number, currentKey, nextKey);
		} else {
			result = repetitionOfEqualSymbols(number, currentKey);
		}
		return result;
	}

	//Para los numeros del tipo LXX.
	private static String repetitionOfDifferentSymbols(Integer number, Integer currentKey, Integer nextKey) {
		String result="";
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
		return result;
	}

	//Para los números del tipo XXX, MM, etc.
	private static String repetitionOfEqualSymbols(Integer number, Integer currentKey) {
		String result = "";
		Integer aux = number/currentKey;
		for (int i = 0 ; i < aux  ; i++) {
			result += basicSymbols.get(currentKey);
		}
		return result;
	}

	//Para los numeros que se forman restando de un determinado valor ( IX, XC, etc).
	private static String substractOfSymbol(Integer currentKey, Integer nextKey) {
		String result = "";
		String currentValue = specificCurrentValueMap.get(nextKey);
		if(currentValue == null) {
			currentValue = basicSymbols.get(currentKey);
		}
		result = currentValue + basicSymbols.get(nextKey);
		return result;
	}
	
	
	private static Boolean isPowerOfTen(Integer number) {
		for (int i=0;i<10;i++) {
			  Integer pow = (int)Math.pow(10,i);
			  if(pow == number) {
				  return true;
			  }			  
		}
		
		return false;
	}
	

}
