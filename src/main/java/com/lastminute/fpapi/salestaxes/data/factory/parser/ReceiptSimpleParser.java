package com.lastminute.fpapi.salestaxes.data.factory.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.lastminute.fpapi.salestaxes.data.factory.charges.SalesTaxCalculator;
import com.lastminute.fpapi.salestaxes.data.factory.charges.TaxExtractor;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.data.factory.typing.ItemTypeContainsKeyword;
import com.lastminute.fpapi.salestaxes.data.factory.typing.ItemTypeStrategy;
import com.lastminute.fpapi.salestaxes.entities.ItemType;
import com.lastminute.fpapi.salestaxes.entities.ReceiptRow;

public class ReceiptSimpleParser implements Parser {
	private String currentRow;
	private ItemTypeStrategy assigner = ItemTypeContainsKeyword.getInstance();
	private TaxExtractor calculator = SalesTaxCalculator.getInstance();

	@Override
	public void setCurrentRow(String currentRow) {
		this.currentRow = currentRow;
	}
	
	@Override
	public void setItemTypeStrategy(ItemTypeStrategy assigner) {
		this.assigner  = assigner;
	}	

	@Override
	public void setSalesTaxCalculator(TaxExtractor calculator) {
		this.calculator = calculator;
	}

	@Override
	public ReceiptRow parseRow() throws InputException {
		ReceiptRow item = new ReceiptRow();
		
		item.setQuantity(extractQuantity());
		item.setPrintableName(extractName());
		item.setPrice(extractPrice());
		
		ItemType type = new ItemType();
		type.setGoodsType(assigner.assignCategory(item.getPrintableName()));
		type.setGoodsOrigin(assigner.assignOrigin(item.getPrintableName()));
		item.setType(type);
		
		item.setTax(calculator.computeTax(item.getPrice(), item.getType()));
		item.setTaxedPrice(calculator.sumUpTaxes(item.getPrice(), item.getTax()));
		
		return item;
	}

	private final Pattern PRICE = Pattern.compile(".*at ([0-9]+\\.?[0-9]*)");
	private double extractPrice() throws InputException {
		try {
			return Double.parseDouble(extractor(currentRow, PRICE));
		} catch (NumberFormatException e) {
			throw new InputException(currentRow, "PRICE");
		}
	}

	private final Pattern NAME = Pattern.compile("^[0-9]+ (.*) at");
	private String extractName() throws InputException {
		String name = extractor(currentRow, NAME);
		if (StringUtils.isEmpty(name)) {
			throw new InputException(currentRow, "NAME");
		}
		return name;
	}

	private final Pattern QUANTITY = Pattern.compile("([0-9]+).*");
	private int extractQuantity() throws InputException {
		try {
			return Integer.parseInt(extractor(currentRow, QUANTITY));
		} catch (NumberFormatException e) {
			throw new InputException(currentRow, "QUANTITY");
		}
	}

	private String extractor(String source, Pattern regexp) {
		Matcher mat = regexp.matcher(source);
		return mat.find() ?  mat.group(1) : "";
	}
	
}
