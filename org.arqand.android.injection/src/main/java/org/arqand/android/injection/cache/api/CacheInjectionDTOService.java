package org.arqand.android.injection.cache.api;

import org.arqand.android.injection.api.dto.InjectionCacheDTO;

/**
 * Interface that caches all part of the DTO cache application
 */
public interface CacheInjectionDTOService {

	/**
	 * Gets the value.
	 * 
	 * @param clase
	 *            the clase
	 * @return the value
	 */
	InjectionCacheDTO getValue(Class<?> clase);

	/**
	 * Sets the cache.
	 * 
	 * @param injectionCacheDTO
	 *            the new cache
	 */
	void setCache(InjectionCacheDTO injectionCacheDTO);

}
