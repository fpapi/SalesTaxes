package com.lastminute.fpapi.salestaxes.entities.charges;

public enum Category implements ChargesType {
	
	BASIC(0.1d)
	,BOOK(0)
	,FOOD(0)
	,MEDICAL(0)
	;
	
	private double taxRatio = 0.0d;

	private Category(double taxRatio) {
		this.taxRatio = taxRatio;
	}
	
	public double computeTax(double price) {
		return price * taxRatio;
	}

}
