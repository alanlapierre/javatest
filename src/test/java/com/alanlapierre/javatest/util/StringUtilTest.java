package com.alanlapierre.javatest.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void repeat_string_once(){
		assertEquals("hola", StringUtil.repeat("hola", 1));
	}

	@Test
	public void repeat_string_multiple_times(){
		assertEquals("holaholahola", StringUtil.repeat("hola", 3));
	}
	
	@Test
	public void repeat_string_zero_times(){
		assertEquals("", StringUtil.repeat("hola", 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void repeat_string_negative_times(){
		assertEquals("", StringUtil.repeat("hola", -1));
	}

	@Test
	public void isempty_string_is_not_empty(){
		String str = "test";
		assertFalse(StringUtil.isEmpty(str));
	}
	
	@Test
	public void isempty_string_without_characters_is_empty(){
		String str = "";
		assertTrue(StringUtil.isEmpty(str));
	}

	@Test
	public void isempty_null_is_empty(){
		String str = null;
		assertTrue(StringUtil.isEmpty(str));
	}
	
	@Test
	public void isempty_string_only_with_spaces_is_empty(){
		String str = "   ";
		assertTrue(StringUtil.isEmpty(str));
	}

}
