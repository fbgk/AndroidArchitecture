package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

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
