package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class BooleanToString implements ConversionType<String, Boolean> {

	@Override
	public String conversion(final Boolean objeto) {
		if (objeto != null) {
			return objeto.toString();
		}
		return null;
	}

}
