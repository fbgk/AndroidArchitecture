package org.arqand.android.injection.conversion;

import org.arqand.android.injection.api.ConversionType;

/**
 * The Class StringToInteger.
 */
public class StringToInteger implements ConversionType<Integer, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ConversionType#conversion(java.lang.
	 * Object)
	 */
	@Override
	public Integer conversion(final String object) {
		return Integer.valueOf(object);
	}

}
