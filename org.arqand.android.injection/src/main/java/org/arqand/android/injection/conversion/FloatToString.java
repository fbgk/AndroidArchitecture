package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

public class FloatToString implements ConversionType<String, Float> {

	@Override
	public String conversion(final Float object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
}
