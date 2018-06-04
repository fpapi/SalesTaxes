package com.lastminute.fpapi.salestaxes.tests;

import org.junit.Assert;
import org.junit.Test;

import com.lastminute.fpapi.salestaxes.application.Application;
import com.lastminute.fpapi.salestaxes.entities.Item;
import com.lastminute.fpapi.salestaxes.entities.Receipt;

public class InputShoppingBasketsTest {
	private String LS = System.getProperty("line.separator");
	
	private Application app = new Application();
	
	
	@Test
	public void given_firstExcerciseBasket_when_receiptIsEmpty_then_validReceiptCreated() {
		String input =
				"1 book at 12.49"
				+LS+"1 music CD at 14.99"
				+LS+"1 chocolate bar at 0.85"
				;
		
		Receipt receipt = app.generateReceipt(input);
		
		Assert.assertEquals("Wrong number of items created", 3, receipt.getPurchasedGoods().size());
		testSingleItem(receipt.getPurchasedGoods().get(0), 1, "book", 12.49d);
		testSingleItem(receipt.getPurchasedGoods().get(1), 1, "music CD", 16.49d);
		testSingleItem(receipt.getPurchasedGoods().get(2), 1, "chocolate bar", 0.85d);
		
		Assert.assertEquals("Wrong Sales Taxes", 1.50d, receipt.getSalesTaxes(), 0.01);
		Assert.assertEquals("Wrong Total", 29.83d, receipt.getTotal(), 0.01);
	}
	
	@Test
	public void given_secondExcerciseBasket_when_receiptIsEmpty_then_validReceiptCreated() {
		String input =
				"1 imported box of chocolates at 10.00"
				+LS+"1 imported bottle of perfume at 47.50"
				;
		
		Receipt receipt = app.generateReceipt(input);
		
		Assert.assertEquals("Wrong number of items created", 2, receipt.getPurchasedGoods().size());
		testSingleItem(receipt.getPurchasedGoods().get(0), 1, "imported box of chocolates", 10.50d);
		testSingleItem(receipt.getPurchasedGoods().get(1), 1, "imported bottle of perfume", 54.64d);
		
		Assert.assertEquals("Wrong Sales Taxes", 7.65d, receipt.getSalesTaxes(), 0.01);
		Assert.assertEquals("Wrong Total", 65.15d, receipt.getTotal(), 0.01);
	}
	
	@Test
	public void given_thirdExcerciseBasket_when_receiptIsEmpty_then_validReceiptCreated() {
		String input =
				"1 imported bottle of perfume at 27.99"
				+LS+"1 bottle of perfume at 18.99"
				+LS+"1 packet of headache pills at 9.75"
				+LS+"1 box of imported chocolates at 11.25"
				;
		
		Receipt receipt = app.generateReceipt(input);
		
		Assert.assertEquals("Wrong number of items created", 4, receipt.getPurchasedGoods().size());
		testSingleItem(receipt.getPurchasedGoods().get(0), 1, "imported bottle of perfume", 32.19d);
		testSingleItem(receipt.getPurchasedGoods().get(1), 1, "bottle of perfume", 20.89d);
		testSingleItem(receipt.getPurchasedGoods().get(2), 1, "packet of headache pills", 9.75d);
		testSingleItem(receipt.getPurchasedGoods().get(3), 1, "box of imported chocolates", 11.85d);
		
		Assert.assertEquals("Wrong Sales Taxes", 6.70d, receipt.getSalesTaxes(), 0.01);
		Assert.assertEquals("Wrong Total", 74.68d, receipt.getTotal(), 0.01);
	}
	
	
	private void testSingleItem(Item checkingItem, int quantity, String name, double price) {
		Assert.assertEquals("Wrong Item Quantity", quantity, checkingItem.getQuantity());
		Assert.assertEquals("Wrong Item Name", name, checkingItem.getPrintableName());
		Assert.assertEquals("Wrong Item Price", price, checkingItem.getTaxedPrice(), 0.01);
	}

}
