package org.arqand.android.injection.conversion;

import java.util.Date;

import org.arqand.android.injection.api.ConversionType;

public class StringToDate implements ConversionType<Date, String> {

	@SuppressWarnings("deprecation")
	@Override
	public Date conversion(final String object) {
		return new Date(Date.parse(object));
	}

}
