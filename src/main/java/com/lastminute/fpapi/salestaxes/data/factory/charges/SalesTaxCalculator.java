package com.lastminute.fpapi.salestaxes.data.factory.charges;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lastminute.fpapi.salestaxes.entities.ItemType;

public class SalesTaxCalculator implements TaxExtractor {
	private static final Logger logger = LogManager.getLogger();
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
		logger.traceEntry("computeTax", price, type);
		double taxRatio = dictionary.getCategoryTaxRatio(type.getGoodsType())
				+ dictionary.getOriginTaxRatio(type.getGoodsOrigin())
				;

		double output = Math.ceil(price * taxRatio * 20) / 20.0d;
		logger.traceExit(output);
		return output;
	}

	@Override
	public double sumUpTaxes(double price, double tax) {
		logger.traceEntry("sumUpTaxes", price, tax);
		return price + tax;
	}
	
}
