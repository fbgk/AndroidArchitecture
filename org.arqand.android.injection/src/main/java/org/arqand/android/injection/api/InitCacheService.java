package org.arqand.android.injection.api;

import org.arqand.android.injection.api.dto.InjectionFinalCacheDTO;

import android.view.View;

/**
 * From caches all the necessary information to make the injection part work.
 */
public interface InitCacheService {

	/**
	 * Creates the injection final cache.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param id
	 *            the id
	 * @return the injection final cache dto
	 */
	public InjectionFinalCacheDTO createInjectionFinalCache(Class<?> clazz, View view);

	/**
	 * Factory conver type.
	 * 
	 * @param conversionTypes
	 *            the conversion types
	 */
	public void factoryConverType(ConversionType<?, ?>... conversionTypes);

	/**
	 * Factory view cache dto.
	 * 
	 * @param viewInjectionServices
	 *            the view injection services
	 */
	public void factoryViewCache(ViewInjectionService<?, ?>... viewInjectionServices);

}
