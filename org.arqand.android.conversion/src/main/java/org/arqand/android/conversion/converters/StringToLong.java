package org.arqand.android.conversion.converters;

import org.arqand.android.conversion.api.ConversionType;

public class StringToLong implements ConversionType<Long, String> {
	
	@Override
	public Long conversion(final String object) {
		Long long1 = null;
		if (object != null && !object.isEmpty()) {
			long1 = Long.parseLong(object);
		}
		return long1;
	}
	
}
