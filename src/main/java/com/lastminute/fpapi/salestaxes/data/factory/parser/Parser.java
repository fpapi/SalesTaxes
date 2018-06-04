package com.lastminute.fpapi.salestaxes.data.factory.parser;

import com.lastminute.fpapi.salestaxes.data.factory.charges.TaxExtractor;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.data.factory.typing.ItemTypeStrategy;
import com.lastminute.fpapi.salestaxes.entities.ReceiptRow;

public interface Parser {

	public void setCurrentRow(String currentRow);

	public void setItemTypeStrategy(ItemTypeStrategy assigner);
	
	public void setSalesTaxCalculator(TaxExtractor calculator);

	public ReceiptRow parseRow() throws InputException;

}
