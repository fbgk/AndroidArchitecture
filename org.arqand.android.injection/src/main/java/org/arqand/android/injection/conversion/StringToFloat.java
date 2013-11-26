package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

public class StringToFloat implements ConversionType<Float, String> {

	@Override
	public Float conversion(final String object) {
		return new Float(object);
	}

}
