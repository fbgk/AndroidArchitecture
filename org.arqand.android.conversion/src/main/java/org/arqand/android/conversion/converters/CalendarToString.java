package org.arqand.android.conversion.converters;

import java.util.Calendar;

import org.arqand.android.conversion.api.ConversionType;

public class CalendarToString implements ConversionType<String, Calendar> {
	
	@Override
	public String conversion(final Calendar object) {
		String string = "";
		if (object != null) {
			string = object.toString();
		}
		return string;
	}
	
}
