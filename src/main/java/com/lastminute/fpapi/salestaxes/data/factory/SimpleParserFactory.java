package com.lastminute.fpapi.salestaxes.data.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lastminute.fpapi.salestaxes.data.factory.charges.SalesTaxCalculator;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.data.factory.parser.Parser;
import com.lastminute.fpapi.salestaxes.data.factory.parser.ReceiptSimpleParser;
import com.lastminute.fpapi.salestaxes.data.factory.typing.ItemTypeContainsKeyword;
import com.lastminute.fpapi.salestaxes.entities.Receipt;
import com.lastminute.fpapi.salestaxes.entities.ReceiptConcrete;
import com.lastminute.fpapi.salestaxes.entities.ReceiptRow;

public class SimpleParserFactory implements ReceiptFactory {
	private static final Logger logger = LogManager.getLogger();

	private final List<String> rows;

	public SimpleParserFactory(List<String> rows) {
		this.rows = rows;
	}

	@Override
	public Receipt createReceipt() throws InputException {
		logger.traceEntry();
		ReceiptConcrete receipt = new ReceiptConcrete();
		double salesTaxes = 0.0d;
		double total = 0.0d;

		if (rows != null) {
			logger.info("initializing the ReceiptSimpleParser");
			Parser parser = new ReceiptSimpleParser();
			logger.info("setting ItemTypeContainsKeyword as Category/Origin choosing strategy");
			parser.setItemTypeStrategy(ItemTypeContainsKeyword.getInstance());
			logger.info("setting SalesTaxCalculator as tax calculator strategy");
			parser.setSalesTaxCalculator(SalesTaxCalculator.getInstance());
			for (String row : rows) {
				logger.debug("parsing row "+row);
				parser.setCurrentRow(row);
				ReceiptRow item = parser.parseRow();
				salesTaxes += item.getTax();
				total += item.getTaxedPrice();
				logger.debug("adding ReceiptRow "+item);
				receipt.addPurchasedGoods(item);
			}
			
			receipt.setSalesTexsed(salesTaxes);
			receipt.setTotal(total);
		}

		logger.traceExit(receipt);
		return receipt;
	}
}
