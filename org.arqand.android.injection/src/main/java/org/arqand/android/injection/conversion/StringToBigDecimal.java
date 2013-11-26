package org.arqand.android.injection.conversion;

import java.math.BigDecimal;

import org.arqand.android.injection.api.ConversionType;

public class StringToBigDecimal implements ConversionType<BigDecimal, String> {

	@Override
	public BigDecimal conversion(final String object) {
		return new BigDecimal(object);
	}

}
