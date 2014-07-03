package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class StringToFloat implements ConversionType<Float, String> {
	
	@Override
	public Float conversion(final String object) {
		Float float1 = null;
		if (object != null && !object.isEmpty()) {
			float1 = Float.valueOf(object);
		}
		return float1;
	}
	
}
