package com.lastminute.fpapi.salestaxes.data.factory.charges;

import com.lastminute.fpapi.salestaxes.entities.ItemType;

public class SalesTaxCalculator implements TaxExtractor {
	private static final SalesTaxDictionary dictionary = new SalesTaxDictionary();
	
	private static SalesTaxCalculator instance = null;
	public static SalesTaxCalculator getInstance() {
		if (instance == null) {
			instance = new SalesTaxCalculator();
		}
		return instance;
	}

	private SalesTaxCalculator() {};

	@Override
	public double computeTax(double price, ItemType type) {
		double taxRatio = dictionary.getCategoryTaxRatio(type.getGoodsType())
				+ dictionary.getOriginTaxRatio(type.getGoodsOrigin())
				;
		
		return Math.ceil(price * taxRatio * 20) / 20.0d;
	}

	@Override
	public double sumUpTaxes(double price, double tax) {
		return price + tax;
	}
	
}
