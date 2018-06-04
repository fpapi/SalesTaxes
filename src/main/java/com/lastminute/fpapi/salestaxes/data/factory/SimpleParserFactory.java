package com.lastminute.fpapi.salestaxes.data.factory;

import java.util.List;

import com.lastminute.fpapi.salestaxes.data.factory.charges.SalesTaxCalculator;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.data.factory.parser.Parser;
import com.lastminute.fpapi.salestaxes.data.factory.parser.ReceiptSimpleParser;
import com.lastminute.fpapi.salestaxes.data.factory.typing.ItemTypeContainsKeyword;
import com.lastminute.fpapi.salestaxes.entities.Receipt;
import com.lastminute.fpapi.salestaxes.entities.ReceiptConcrete;
import com.lastminute.fpapi.salestaxes.entities.ReceiptRow;

public class SimpleParserFactory implements ReceiptFactory {

	private final List<String> rows;

	public SimpleParserFactory(List<String> rows) {
		this.rows = rows;
	}

	@Override
	public Receipt createReceipt() throws InputException {
		ReceiptConcrete receipt = new ReceiptConcrete();
		double salesTaxes = 0.0d;
		double total = 0.0d;

		if (rows != null) {
			Parser parser = new ReceiptSimpleParser();
			parser.setItemTypeStrategy(ItemTypeContainsKeyword.getInstance());
			parser.setSalesTaxCalculator(SalesTaxCalculator.getInstance());
			for (String row : rows) {
				parser.setCurrentRow(row);
				ReceiptRow item = parser.parseRow();
				salesTaxes += item.getTax();
				total += item.getTaxedPrice();
				receipt.addPurchasedGoods(item);
			}
			
			receipt.setSalesTexsed(salesTaxes);
			receipt.setTotal(total);
		}

		return receipt;
	}
}
