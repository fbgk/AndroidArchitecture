package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

public class FloatToString implements ConversionType<String, Float> {

	@Override
	public String conversion(final Float object) {
		return object.toString();
	}

}
