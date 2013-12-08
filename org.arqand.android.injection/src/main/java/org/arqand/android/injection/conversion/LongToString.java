package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

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
