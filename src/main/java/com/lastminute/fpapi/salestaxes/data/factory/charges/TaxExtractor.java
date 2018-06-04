package com.lastminute.fpapi.salestaxes.data.factory.charges;

import com.lastminute.fpapi.salestaxes.entities.ItemType;

public interface TaxExtractor {
	
	double computeTax(double price, ItemType type);

	double sumUpTaxes(double price, double tax);
	
}
