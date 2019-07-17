package com.alanlapierre.javatest.player;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

	@Test
	public void looses_when_dice_number_is_too_low() {
		
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(2);
		
		Player player = new Player(dice, 3);
		assertEquals(false, player.play());
	}
	
	
	@Test
	public void wins_when_dice_number_is_big() {
		
		Dice dice = Mockito.mock(Dice.class);
		Mockito.when(dice.roll()).thenReturn(4);
		
		Player player = new Player(dice, 3);
		assertEquals(true, player.play());
	}
}
