package org.arqand.android.conversion.converters;

import java.util.Date;

import org.arqand.android.conversion.api.ConversionType;

public class StringToDate implements ConversionType<Date, String> {
	
	@SuppressWarnings("deprecation")
	@Override
	public Date conversion(final String object) {
		Date date = null;
		if (object != null && !object.isEmpty()) {
			date = new Date(Date.parse(object));
		}
		return date;
	}
	
}
