package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class IntegerToString implements ConversionType<String, Integer> {
	
	@Override
	public String conversion(final Integer object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
	
}
