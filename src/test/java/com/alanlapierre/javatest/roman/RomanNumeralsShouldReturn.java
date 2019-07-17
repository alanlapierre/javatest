package com.alanlapierre.javatest.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanNumeralsShouldReturn {

	@Test
	public void I_when_number_is_1() {
		String result = RomanNumerals.arabicToRoman(1);
		assertThat( result, is("I") );
	}

	@Test
	public void II_when_number_is_2() {
		String result = RomanNumerals.arabicToRoman(2);
		assertThat( result, is("II") );
	}
	
	@Test
	public void III_when_number_is_3() {
		String result = RomanNumerals.arabicToRoman(3);
		assertThat( result, is("III") );
	}
	
	@Test
	public void V_when_number_is_5() {
		String result = RomanNumerals.arabicToRoman(5);
		assertThat( result, is("V") );
	}
	
	@Test
	public void VI_when_number_is_6() {
		String result = RomanNumerals.arabicToRoman(6);
		assertThat( result, is("VI") );
	}	

	@Test
	public void VII_when_number_is_7() {
		String result = RomanNumerals.arabicToRoman(7);
		assertThat( result, is("VII") );
	}	
	
	@Test
	public void X_when_number_is_10() {
		String result = RomanNumerals.arabicToRoman(10);
		assertThat( result, is("X") );
	}

	@Test
	public void XI_when_number_is_11() {
		String result = RomanNumerals.arabicToRoman(11);
		assertThat( result, is("XI") );
	}

	@Test
	public void XV_when_number_is_15() {
		String result = RomanNumerals.arabicToRoman(15);
		assertThat( result, is("XV") );
	}
	
	@Test
	public void XVI_when_number_is_16() {
		String result = RomanNumerals.arabicToRoman(16);
		assertThat( result, is("XVI") );
	}
	
	
	@Test
	public void L_when_number_is_50() {
		String result = RomanNumerals.arabicToRoman(50);
		assertThat( result, is("L") );
	}
	
	
	@Test
	public void LI_when_number_is_51() {
		String result = RomanNumerals.arabicToRoman(51);
		assertThat( result, is("LI") );
	}
	
	@Test
	public void LV_when_number_is_55() {
		String result = RomanNumerals.arabicToRoman(55);
		assertThat( result, is("LV") );
	}

	@Test
	public void LVI_when_number_is_56() {
		String result = RomanNumerals.arabicToRoman(56);
		assertThat( result, is("LVI") );
	}
	
	@Test
	public void LX_when_number_is_60() {
		String result = RomanNumerals.arabicToRoman(60);
		assertThat( result, is("LX") );
	}

	
	@Test
	public void LXX_when_number_is_70() {
		String result = RomanNumerals.arabicToRoman(70);
		assertThat( result, is("LXX") );
	}
	
	@Test
	public void LXXX_when_number_is_80() {
		String result = RomanNumerals.arabicToRoman(80);
		assertThat( result, is("LXXX") );
	}
	
	@Test
	public void LXXXI_when_number_is_81() {
		String result = RomanNumerals.arabicToRoman(81);
		assertThat( result, is("LXXXI") );
	}
	
	@Test
	public void LXXXV_when_number_is_85() {
		String result = RomanNumerals.arabicToRoman(85);
		assertThat( result, is("LXXXV") );
	}

	
	@Test
	public void LXXXVI_when_number_is_86() {
		String result = RomanNumerals.arabicToRoman(86);
		assertThat( result, is("LXXXVI") );
	}

	
	@Test
	public void CXXVI_when_number_is_126() {
		String result = RomanNumerals.arabicToRoman(126);
		assertThat( result, is("CXXVI") );
	}
	
	@Test
	public void MMDVII_when_number_is_2507() {
		String result = RomanNumerals.arabicToRoman(2507);
		assertThat( result, is("MMDVII") );
	}
	
	
	@Test
	public void IV_when_number_is_4() {
		String result = RomanNumerals.arabicToRoman(4);
		assertThat( result, is("IV") );
	}
	
	@Test
	public void IX_when_number_is_9() {
		String result = RomanNumerals.arabicToRoman(9);
		assertThat( result, is("IX") );
	}

	
	@Test
	public void XIV_when_number_is_14() {
		String result = RomanNumerals.arabicToRoman(14);
		assertThat( result, is("XIV") );
	}
	
	@Test
	public void XIX_when_number_is_19() {
		String result = RomanNumerals.arabicToRoman(19);
		assertThat( result, is("XIX") );
	}
	
	@Test
	public void XXIV_when_number_is_24() {
		String result = RomanNumerals.arabicToRoman(24);
		assertThat( result, is("XXIV") );
	}
	
	@Test
	public void XL_when_number_is_40() {
		String result = RomanNumerals.arabicToRoman(40);
		assertThat( result, is("XL") );
	}
	
	@Test
	public void XLIX_when_number_is_49() {
		String result = RomanNumerals.arabicToRoman(49);
		assertThat( result, is("XLIX") );
	}
	
	@Test
	public void MCMXCIX_when_number_is_1999() {
		String result = RomanNumerals.arabicToRoman(1999);
		assertThat( result, is("MCMXCIX") );
	}
	
	@Test
	public void MMMCMXCIX_when_number_is_3999() {
		String result = RomanNumerals.arabicToRoman(3999);
		assertThat( result, is("MMMCMXCIX") );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exception_when_number_is_greater_then_3999() {
		RomanNumerals.arabicToRoman(4000);
	}
		
	
	
}
