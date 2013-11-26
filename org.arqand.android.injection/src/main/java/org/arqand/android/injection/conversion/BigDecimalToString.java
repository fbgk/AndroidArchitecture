package org.arqand.android.injection.conversion;

import java.math.BigDecimal;

import org.arqand.android.injection.api.ConversionType;

public class BigDecimalToString implements ConversionType<String, BigDecimal> {

	@Override
	public String conversion(final BigDecimal object) {
		return object.toString();
	}

}
