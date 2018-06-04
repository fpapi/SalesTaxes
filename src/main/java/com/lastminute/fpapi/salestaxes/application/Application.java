package com.lastminute.fpapi.salestaxes.application;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.lastminute.fpapi.salestaxes.data.factory.ReceiptFactory;
import com.lastminute.fpapi.salestaxes.data.factory.SimpleParserFactory;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.entities.Receipt;

public class Application {
	
	public Receipt generateReceipt(String input) {
		if (StringUtils.isAllBlank(input)) {
			throw new IllegalArgumentException("Input can not be empty.");
		}
		List<String> rows = Arrays.asList(input.split(System.getProperty("line.separator")));
		ReceiptFactory factory = new SimpleParserFactory(rows);
		try {
			return  factory.createReceipt();
		} catch (InputException e) {
			throw new IllegalArgumentException("Input is not valid: missing "+e.getMissing()+" at line "+e.getSource(),e);
		}
	}

}
