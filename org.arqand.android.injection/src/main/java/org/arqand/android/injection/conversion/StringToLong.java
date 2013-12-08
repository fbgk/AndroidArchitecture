package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

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
