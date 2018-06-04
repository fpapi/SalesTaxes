package com.lastminute.fpapi.salestaxes.tests.data.factory;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.lastminute.fpapi.salestaxes.data.factory.SimpleParserFactory;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.entities.Item;
import com.lastminute.fpapi.salestaxes.entities.Receipt;
import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;


public class SimpleParserFactoryTest {
	
	@Test
	public void given_singleValidReceiptRow_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 book at 12.49"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertFalse("No Item Created", receipt.getPurchasedGoods().isEmpty());
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "book", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 12.49d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.BOOK, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			Assert.assertEquals("Wrong Tax", 0.00d, checkingItem.getTax(), 0.01);
			Assert.assertEquals("Wrong Taxed Price", 12.49d, checkingItem.getTaxedPrice(), 0.01);
			Assert.assertEquals("Wrong Total Tax", 0.00d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 12.49d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}
	}
	
	@Test
	public void given_validNationalFoodReceipt_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 chocolate bar at 0.85"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertFalse("No Item Created", receipt.getPurchasedGoods().isEmpty());
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "chocolate bar", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 0.85d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.FOOD, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			Assert.assertEquals("Wrong Tax", 0.00d, checkingItem.getTax(), 0.01);
			Assert.assertEquals("Wrong Taxed Price", 0.85d, checkingItem.getTaxedPrice(), 0.01);
			Assert.assertEquals("Wrong Total Tax", 0.00d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 0.85d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}		
	}
	
	@Test
	public void given_validNationalBasicReceipt_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 music CD at 14.99"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertFalse("No Item Created", receipt.getPurchasedGoods().isEmpty());
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "music CD", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 14.99d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.BASIC, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			Assert.assertEquals("Wrong Tax", 1.50d, checkingItem.getTax(), 0.01);
			Assert.assertEquals("Wrong Taxed Price", 16.49d, checkingItem.getTaxedPrice(), 0.01);
			Assert.assertEquals("Wrong Total Tax", 1.50d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 16.49d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}
	}
	
	@Test
	public void given_validNationalMedicalReceipt_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 packet of headache pills at 9.75"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertFalse("No Item Created", receipt.getPurchasedGoods().isEmpty());
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "packet of headache pills", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 9.75d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.MEDICAL, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			Assert.assertEquals("Wrong Tax", 0.00d, checkingItem.getTax(), 0.01);
			Assert.assertEquals("Wrong Taxed Price", 9.75d, checkingItem.getTaxedPrice(), 0.01);
			Assert.assertEquals("Wrong Total Tax", 0.00d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 9.75d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}
	}
	
	@Test
	public void given_validImportedFoodReceipt_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 imported box of chocolates at 10.00"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertFalse("No Item Created", receipt.getPurchasedGoods().isEmpty());
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "imported box of chocolates", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 10.00d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.FOOD, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.FOREIGN, checkingItem.getType().getGoodsOrigin());
			Assert.assertEquals("Wrong Tax", 0.50d, checkingItem.getTax(), 0.01);
			Assert.assertEquals("Wrong Taxed Price", 10.50d, checkingItem.getTaxedPrice(), 0.01);
			Assert.assertEquals("Wrong Total Tax", 0.50d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 10.50d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}
	}
	
	@Test
	public void given_multipleValidReceiptRow_when_receiptIsEmpty_then_validReceiptCreated() {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 book at 12.49"
																			,"1 music CD at 14.99"
																			,"1 chocolate bar at 0.85"));
		try {
			Receipt receipt = factory.createReceipt();
			Assert.assertEquals("wrong number of Items created", 3, receipt.getPurchasedGoods().size());
			
			Item checkingItem = receipt.getPurchasedGoods().get(0);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "book", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 12.49d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.BOOK, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			
			checkingItem = receipt.getPurchasedGoods().get(1);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "music CD", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 14.99d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.BASIC, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
			
			checkingItem = receipt.getPurchasedGoods().get(2);
			Assert.assertEquals("Wrong Item Quantity", 1, checkingItem.getQuantity());
			Assert.assertEquals("Wrong Item Name", "chocolate bar", checkingItem.getPrintableName());
			Assert.assertEquals("Wrong Item Price", 0.85d, checkingItem.getPrice(), 0.01);
			Assert.assertEquals("Wrong Item Type Category", Category.FOOD, checkingItem.getType().getGoodsType());
			Assert.assertEquals("Wrong Item Type Origin", Origin.NATIONAL, checkingItem.getType().getGoodsOrigin());
	
			Assert.assertEquals("Wrong Total Tax", 1.50d, receipt.getSalesTaxes(), 0.01);
			Assert.assertEquals("Wrong Total Taxed Price", 29.83d, receipt.getTotal(), 0.01);
		} catch (InputException e) {
			fail("Invalid Input Error with a valid input");
		}	
	}
	
	@Rule
	public ExpectedException inputFailureException = ExpectedException.none();
	@Test
	public void given_MissingQuantityReceiptRow_when_reciptIsEmpty_then_inputExceptionThrown() throws InputException {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("book at 12.49"));
		inputFailureException.expect(InputException.class);
		factory.createReceipt();	
	}
	@Test
	public void given_MissingNameReceiptRow_when_reciptIsEmpty_then_inputExceptionThrown() throws InputException {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 at 12.49"));
		inputFailureException.expect(InputException.class);
		factory.createReceipt();	
	}
	@Test
	public void given_MissingPriceReceiptRow_when_reciptIsEmpty_then_inputExceptionThrown() throws InputException {
		SimpleParserFactory factory = new SimpleParserFactory(Arrays.asList("1 book at "));
		inputFailureException.expect(InputException.class);
		factory.createReceipt();	
	}
	
}
