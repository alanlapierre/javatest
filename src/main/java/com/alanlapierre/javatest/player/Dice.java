package com.alanlapierre.javatest.player;

import java.util.Random;

public class Dice {
	
	private Integer sides;
	
	public Dice(Integer sides) {
		this.sides = sides;
	}

	public Integer roll() {
		return new Random().nextInt(sides) + 1;
	}
}
