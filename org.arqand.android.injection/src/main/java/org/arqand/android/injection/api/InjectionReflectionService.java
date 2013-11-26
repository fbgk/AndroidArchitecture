package org.arqand.android.injection.api;

import android.view.View;

/**
 * Interface for develop a Injection View Controller.
 */
public interface InjectionReflectionService {

	/**
	 * Factory conversion type.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param conversionType
	 *            the conversion type
	 */
	public void factoryConversionType(ConversionType<?, ?>... conversionType);

	/**
	 * Factory injection view.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param injectionServices
	 *            the injection services
	 */
	public void factoryInjectionView(ViewInjectionService<?, ?>... injectionServices);

	/**
	 * Returns the object according to the view loaded in the main application.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            Object Class to be recovered
	 * @return the object Recovered Object Instance
	 */
	public <T> T getterVisual(Class<?> clazz);

	/**
	 * Returns the object according to the view.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            Object Class to be recovered
	 * @param view
	 *            View where data is retrieved.
	 * @return the object Recovered Object Instance
	 */
	public <T> T getterVisual(Class<?> clazz, View view);

	/**
	 * Insert the object information to the main application view.
	 * 
	 * @param object
	 *            The object to be treated
	 */
	public void setterVisual(Object object);

	/**
	 * Insert the object information to the view.
	 * 
	 * @param object
	 *            The object to be treated
	 * @param view
	 *            View data to be injected.
	 */
	public void setterVisual(Object object, View view);

}
