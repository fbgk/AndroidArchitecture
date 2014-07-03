package org.arqand.android.orm.exception;

import android.util.Log;

public class ExceptionNullData extends Exception {
	
	private static final long	serialVersionUID	= -7034834991784956068L;
	
	private String				column;
	
	public ExceptionNullData(String column) {
		Log.e(this.getClass().toString(), "Error. Data is null in column: " + column);
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "Error. Data is null in column: " + this.column;
	}
	
}
