package com.lastminute.fpapi.salestaxes.entities;

public interface Item  {
	
	public int getQuantity();

	public String getPrintableName();

	public ItemType getType();

	public double getPrice();
	
	public double getTaxedPrice();
	
	public double getTax();
	
}
