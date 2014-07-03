package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class LongToString implements ConversionType<String, Long> {
	
	@Override
	public String conversion(final Long object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
	
}
