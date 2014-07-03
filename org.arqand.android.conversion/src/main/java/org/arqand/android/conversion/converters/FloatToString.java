package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

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
