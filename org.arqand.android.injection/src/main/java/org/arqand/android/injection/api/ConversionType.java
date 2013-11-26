package org.arqand.android.injection.api;

/**
 * The Interface ConversionType.
 * 
 * @param <T>
 *            the generic type
 * @param <K>
 *            the key type
 */
public interface ConversionType<T, K> {

	/**
	 * Converts one data type to another
	 * 
	 * @param object
	 *            the object
	 * @return the t
	 */
	public T conversion(K object);

}
