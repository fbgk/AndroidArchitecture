package org.arqand.android.injection.conversion;

import java.util.Date;

import org.arqand.android.injection.api.ConversionType;

public class DateToString implements ConversionType<String, Date> {

	@Override
	public String conversion(final Date object) {
		return object.toString();
	}

}
