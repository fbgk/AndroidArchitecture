package org.arqand.android.conversion.converters;

import java.math.BigDecimal;

import org.arqand.android.conversion.api.ConversionType;

public class StringToBigDecimal implements ConversionType<BigDecimal, String> {
	
	@Override
	public BigDecimal conversion(final String object) {
		BigDecimal bigDecimal = null;
		if (object != null && !object.isEmpty()) {
			bigDecimal = new BigDecimal(object);
		}
		return bigDecimal;
	}
	
}
