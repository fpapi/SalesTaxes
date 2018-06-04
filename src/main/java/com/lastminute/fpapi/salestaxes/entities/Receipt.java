package com.lastminute.fpapi.salestaxes.entities;

import java.util.List;

public interface Receipt {
	
	public List<Item> getPurchasedGoods();
	public double getSalesTaxes();
	public double getTotal();

}
