package org.arqand.android.field.cache.api;

import org.arqand.android.field.cache.api.dto.CacheDTO;

/**
 * Interface that caches all part of the DTO cache application
 */
public interface CacheDTOService {
	
	/**
	 * Gets the value.
	 * 
	 * @param clase
	 *            the clase
	 * @return the value
	 */
	CacheDTO getValue(Class<?> clase);
	
	/**
	 * Sets the cache.
	 * 
	 * @param injectionCacheDTO
	 *            the new cache
	 */
	void setCache(CacheDTO injectionCacheDTO);
	
}
