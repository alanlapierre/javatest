package com.alanlapierre.javatest.fizzbuzz;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzShould {
	
	/*
    Usando TDD (empieza por los tests), implementa una función que dado un número:
	Si el número es divisible por 3, retorna “Fizz”
	Si el número es divisible por 5, retorna “Buzz”
	Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
	En otro caso, retorna el mismo número
    */
	
	private FizzBuzz fizzBuzz;
	
	@Before
	public void setup(){
		fizzBuzz = new FizzBuzz();
}
	
	
	@Test
	public void return_fizz_when_number_is_divisible_by_3(){
		assertThat(fizzBuzz.fizzBuzz(3), is("Fizz"));
		assertThat(fizzBuzz.fizzBuzz(6), is("Fizz"));
	}


	@Test
	public void return_buzz_when_number_is_divisible_by_5(){
		assertThat(fizzBuzz.fizzBuzz(5), is("Buzz"));
		assertThat(fizzBuzz.fizzBuzz(10), is("Buzz"));
	}
	
	@Test
	public void return_fizzbuzz_when_number_is_divisible_by_3_and_5(){
		assertThat(fizzBuzz.fizzBuzz(15), is("FizzBuzz"));
		assertThat(fizzBuzz.fizzBuzz(30), is("FizzBuzz"));
	}

	@Test
	public void return_number_when_number_is_not_divisible_by_3_or_5(){
		assertThat(fizzBuzz.fizzBuzz(2), is("2"));
		assertThat(fizzBuzz.fizzBuzz(16), is("16"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throw_exception_when_number_is_null(){
		fizzBuzz.fizzBuzz(null);
	}
}
