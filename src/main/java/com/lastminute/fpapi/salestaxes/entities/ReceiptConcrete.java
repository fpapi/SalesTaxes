package com.lastminute.fpapi.salestaxes.entities;

import java.util.LinkedList;
import java.util.List;

public class ReceiptConcrete implements Receipt {
	
	private List<Item> purchasedGoods = new LinkedList<>();
	private double salesTexsed = 0.0d;
	private double total = 0.0d;

	@Override
	public List<Item> getPurchasedGoods() {
		return purchasedGoods;
	}
	
	@Override
	public double getSalesTaxes() {
		return salesTexsed;
	}

	@Override
	public double getTotal() {
		return total;
	}

	public void addPurchasedGoods(Item purchasedGood) {
		this.purchasedGoods.add(purchasedGood);
	}

	public void setSalesTexsed(double salesTexsed) {
		this.salesTexsed = salesTexsed;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
