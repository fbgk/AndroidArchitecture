package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class StringToBoolean implements ConversionType<Boolean, String> {

	@Override
	public Boolean conversion(final String objeto) {
		if (objeto != null) {
			return Boolean.valueOf(objeto);
		}
		return null;
	}

}
