package org.arqand.android.injection.cache.api;

import org.arqand.android.injection.api.ViewInjectionService;
import org.arqand.android.injection.api.dto.ViewCacheDTO;

/**
 * Interface dedicated to the creation of cache for the view and its transformation to concrete data.
 */
public interface CacheInjectionViewService {
	
	/**
	 * Gets the value. Find the values ​​only by the view class
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewClass
	 *            the view class
	 * @return the value
	 */
	public <T, K> ViewInjectionService<T, K> getValue(Class<?> viewClass);
	
	/**
	 * Gets the value. Retrieves the value for the view
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewCacheDTO
	 *            the view cache dto
	 * @return the value
	 */
	public <T, K> ViewInjectionService<T, K> getValue(ViewCacheDTO viewCacheDTO);
	
	/**
	 * Sets the value. Sets the required values ​​for the injection of the views
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewCacheDTO
	 *            the view cache dto
	 * @param viewInjectionService
	 *            the view injection service
	 */
	public <T, K> void setValue(ViewInjectionService<T, K> viewInjectionService);
	
}
