package com.lastminute.fpapi.salestaxes.data.factory.charges;

import java.util.EnumMap;

import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public class SalesTaxDictionary {

	@SuppressWarnings("serial")
	private static final EnumMap<Category, Double> mapForCategories = new EnumMap<Category, Double>(Category.class) {
	{
		put(Category.BASIC, 0.1d);
		put(Category.BOOK, 0.0d);
		put(Category.FOOD, 0.0d);
		put(Category.MEDICAL, 0.0d);
	}};
	
	@SuppressWarnings("serial")
	private static final EnumMap<Origin, Double> mapForOrigins = new EnumMap<Origin, Double>(Origin.class) {{
		put(Origin.FOREIGN, 0.05d);
		put(Origin.NATIONAL, 0.0d);
	}};

	public double getCategoryTaxRatio(Category type) {
		return mapForCategories.get(type);
	}
	
	public double getOriginTaxRatio(Origin type) {
		return mapForOrigins.get(type);
	}
	
}
