package com.alanlapierre.javatest.fizzbuzz;

public class FizzBuzz {

	public Object fizzBuzz(Integer number) {
		
		if(number == null){
			throw new IllegalArgumentException("argument is null");
		}
		
		Boolean divisibleBy3 = number % 3 == 0;
		Boolean divisibleBy5 = number % 5 == 0;
		
		if(divisibleBy3 && divisibleBy5){
			return "FizzBuzz";
		}
		else if(divisibleBy3){
			return "Fizz";	
		}
		else if(divisibleBy5){
			return "Buzz";
		}
		
		return "" + number;
	}

}
