package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

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
