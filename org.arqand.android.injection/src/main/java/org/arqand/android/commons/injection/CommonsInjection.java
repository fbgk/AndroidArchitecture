package org.arqand.android.commons.injection;

import org.arqand.android.injection.api.InjectionReflectionService;

/**
 * The Class CommonInjection.
 */
public class CommonsInjection {
	
	/** The injection reflection service. */
	private static InjectionReflectionService	injectionReflectionService;
	
	/**
	 * Gets the injection reflection service.
	 *
	 * @return the injection reflection service
	 */
	public static InjectionReflectionService getInjectionReflectionService() {
		return injectionReflectionService;
	}
	
	/**
	 * Sets the injection reflection service.
	 *
	 * @param injectionReflectionService
	 *            the new injection reflection service
	 */
	public static void setInjectionReflectionService(InjectionReflectionService injectionReflectionService) {
		CommonsInjection.injectionReflectionService = injectionReflectionService;
	}
	
}
