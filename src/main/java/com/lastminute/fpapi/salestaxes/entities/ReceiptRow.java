package com.lastminute.fpapi.salestaxes.entities;

import java.io.Serializable;

public class ReceiptRow implements Serializable, Item {
	
	private static final long serialVersionUID = -8482448482102992702L;
	
	private int quantity;
	private String printableName;
	private ItemType type;
	private double price;
	private double taxedPrice;
	private double tax;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrintableName() {
		return printableName;
	}
	public void setPrintableName(String printableName) {
		this.printableName = printableName;
	}
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTaxedPrice() {
		return taxedPrice;
	}
	public void setTaxedPrice(double taxedPrice) {
		this.taxedPrice = taxedPrice;
	}	
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		return String.format("ReceiptRow [quantity=%s, printableName=%s, type=%s, price=%s, taxedPrice=%s, tax=%s]",
				quantity, printableName, type, price, taxedPrice, tax);
	}

}
