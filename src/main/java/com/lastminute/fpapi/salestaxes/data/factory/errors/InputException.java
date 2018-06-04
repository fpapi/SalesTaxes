package com.lastminute.fpapi.salestaxes.data.factory.errors;

public class InputException extends Exception {
	
	private static final long serialVersionUID = 3341843146504171204L;
	
	private String missing;
	private String source;

	public InputException(String source, String missing) {
		super("The input '"+source+"' is not valid: missing "+missing);
		this.missing = missing;
		this.source = source;
	}

	public String getMissing() {
		return missing;
	}

	public String getSource() {
		return source;
	}
	
}
