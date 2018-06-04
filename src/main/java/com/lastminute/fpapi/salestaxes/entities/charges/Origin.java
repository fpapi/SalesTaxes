package com.lastminute.fpapi.salestaxes.entities.charges;

public enum Origin implements ChargesType {
	
	NATIONAL(0)
	,FOREIGN(0.5d)
	;
	
	private double taxRatio = 0.0d;

	private Origin(double taxRatio) {
		this.taxRatio = taxRatio;
	}
	
	public double computeTax(double price) {
		return price * taxRatio;
	}


}
