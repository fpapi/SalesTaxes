package com.lastminute.fpapi.salestaxes.application;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang3.StringUtils;

import com.lastminute.fpapi.salestaxes.data.factory.ReceiptFactory;
import com.lastminute.fpapi.salestaxes.data.factory.SimpleParserFactory;
import com.lastminute.fpapi.salestaxes.data.factory.errors.InputException;
import com.lastminute.fpapi.salestaxes.entities.Receipt;

public class Application {
	private static final Logger logger = LogManager.getLogger();
	
	public Receipt generateReceipt(String input) {
		logger.traceEntry(input);
		if (StringUtils.isAllBlank(input)) {
			throw new IllegalArgumentException("Input can not be empty.");
		}
		List<String> rows = Arrays.asList(input.split(System.getProperty("line.separator")));
		logger.debug("initializing the SimpleParserFactory", rows);
		ReceiptFactory factory = new SimpleParserFactory(rows);
		try {
			logger.info("creating the receipt with "+rows.size()+" rows");
			Receipt receipt = factory.createReceipt();
			logger.traceExit(receipt);
			return receipt;
		} catch (InputException e) {
			logger.catching(e);
			throw new IllegalArgumentException("Input is not valid: missing "+e.getMissing()+" at line "+e.getSource(),e);
		}
	}

}
