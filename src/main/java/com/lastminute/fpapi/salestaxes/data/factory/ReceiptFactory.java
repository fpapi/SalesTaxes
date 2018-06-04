package com.lastminute.fpapi.salestaxes.data.factory;

import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.entities.Receipt;

public interface ReceiptFactory {
	
	public Receipt createReceipt() throws InputException;

}
