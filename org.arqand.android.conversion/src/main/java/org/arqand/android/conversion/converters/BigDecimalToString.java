package org.arqand.android.conversion.converters;

import java.math.BigDecimal;

import org.arqand.android.conversion.api.ConversionType;

public class BigDecimalToString implements ConversionType<String, BigDecimal> {
	
	@Override
	public String conversion(final BigDecimal object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
	
}
