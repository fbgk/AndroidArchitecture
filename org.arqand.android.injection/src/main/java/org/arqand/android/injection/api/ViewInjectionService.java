package org.arqand.android.injection.api;

/**
 * The Interface ViewInjectionService.
 * 
 * @param <T>
 *            the generic type
 * @param <K>
 *            the key type
 */
public interface ViewInjectionService<T, K> {

	/**
	 * Gets the information.
	 * 
	 * @param view
	 *            the view
	 * @param clazz
	 *            the clazz
	 * @return the information
	 */
	public K getInformation(T view);

	/**
	 * Sets the information.
	 * 
	 * @param view
	 *            the view
	 * @param information
	 *            the new information
	 */
	public void setInformation(T view, K information);

}
