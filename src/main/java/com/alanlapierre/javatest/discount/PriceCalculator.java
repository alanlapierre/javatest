package com.alanlapierre.javatest.discount;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

	private List<Double> prices = new ArrayList<>();
	private Double discount = 0D;
	
	public Double getTotal() {
		Double result = 0D;
		
		for(Double price: prices){
			result += price;
		}
		return result * ((100 - discount) / 100);
	}

	public void addPrice(double d) {
		prices.add(d);
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
