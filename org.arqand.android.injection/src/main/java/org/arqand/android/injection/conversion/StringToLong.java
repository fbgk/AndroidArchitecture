package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

public class StringToLong implements ConversionType<Long, String> {

	@Override
	public Long conversion(final String object) {
		return Long.valueOf(object);
	}

}
