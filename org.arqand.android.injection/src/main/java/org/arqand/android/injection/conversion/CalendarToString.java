package org.arqand.android.injection.conversion;

import java.util.Calendar;

import org.arqand.android.injection.api.ConversionType;

public class CalendarToString implements ConversionType<String, Calendar> {

	@Override
	public String conversion(final Calendar object) {
		return object.toString();
	}

}
