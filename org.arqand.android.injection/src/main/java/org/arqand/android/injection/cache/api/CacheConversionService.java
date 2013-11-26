package org.arqand.android.injection.cache.api;

import org.arqand.android.injection.api.ConversionType;

/**
 * Interface dedicated to creating the type converters
 */
public interface CacheConversionService {

	/**
	 * Gets the conversion.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param classSource
	 *            the class source
	 * @param classTarget
	 *            the class target
	 * @return the conversion
	 */
	<T, K> ConversionType<T, K> getConversion(Class<T> classSource, Class<K> classTarget);

	/**
	 * Sets the conversion.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param conversionType
	 *            the conversion type
	 */
	<T, K> void setConversion(ConversionType<T, K> conversionType);

}
