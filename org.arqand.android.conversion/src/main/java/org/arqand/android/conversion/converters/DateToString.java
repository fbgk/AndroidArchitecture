package org.arqand.android.conversion.converters;

import java.util.Date;

import org.arqand.android.conversion.api.ConversionType;

public class DateToString implements ConversionType<String, Date> {
	
	@Override
	public String conversion(final Date object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
	
}
