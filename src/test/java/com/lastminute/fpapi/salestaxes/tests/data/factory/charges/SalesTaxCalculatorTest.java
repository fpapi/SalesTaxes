package com.lastminute.fpapi.salestaxes.tests.data.factory.charges;

import org.junit.Assert;
import org.junit.Test;

import com.lastminute.fpapi.salestaxes.data.factory.charges.SalesTaxCalculator;
import com.lastminute.fpapi.salestaxes.entities.ItemType;
import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public class SalesTaxCalculatorTest {
	
	@Test
	public void given_aNationBasicItemType_when_priceIs1499_then_taxIs150() {
		double price1 = 14.99d;
		ItemType type1 = new ItemType();
		type1.setGoodsType(Category.BASIC);
		type1.setGoodsOrigin(Origin.NATIONAL);
		
		double tax1 = SalesTaxCalculator.getInstance().computeTax(price1, type1);
		
		Assert.assertEquals("Wrong Calculated Tax", 1.50d, tax1, 0.01);	
	}
	
	@Test
	public void given_aNationFoodItemType_when_priceIs085_then_taxIs000() {
		double price1 = 0.85d;
		ItemType type1 = new ItemType();
		type1.setGoodsType(Category.FOOD);
		type1.setGoodsOrigin(Origin.NATIONAL);
		
		double tax1 = SalesTaxCalculator.getInstance().computeTax(price1, type1);
		
		Assert.assertEquals("Wrong Calculated Tax", 0.00d, tax1, 0.01);	
	}
	
	@Test
	public void given_aForeignFoodItemType_when_priceIs1000_then_taxIs050() {
		double price1 = 0.85d;
		ItemType type1 = new ItemType();
		type1.setGoodsType(Category.FOOD);
		type1.setGoodsOrigin(Origin.FOREIGN);
		
		double tax1 = SalesTaxCalculator.getInstance().computeTax(price1, type1);
		
		Assert.assertEquals("Wrong Calculated Tax", 0.05d, tax1, 0.01);	
	}
	
	@Test
	public void given_aForeignBasicItemType_when_priceIs4750_then_taxIs5465() {
		double price1 = 47.50d;
		ItemType type1 = new ItemType();
		type1.setGoodsType(Category.BASIC);
		type1.setGoodsOrigin(Origin.FOREIGN);
		
		double tax1 = SalesTaxCalculator.getInstance().computeTax(price1, type1);
		
		Assert.assertEquals("Wrong Calculated Tax", 7.15d, tax1, 0.01);	
	}

}
