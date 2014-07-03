package org.arqand.android.injection.cache.api;

import org.arqand.android.injection.api.dto.InjectionFinalCacheDTO;

/**
 * Interface created for the data cache and view class
 */
public interface CacheFinalService {
	
	/**
	 * Retrieve the data from the cache according to the class and the id of the view
	 * 
	 * @param clazz
	 *            the clazz
	 * @param id
	 *            the id
	 * @return the cache final
	 */
	public InjectionFinalCacheDTO getCacheFinal(Class<?> clazz, int id);
	
	/**
	 * Sets the data that has been retrieved from somewhere
	 * 
	 * @param mapFinalCacheDTO
	 *            the new cache final
	 */
	public void setCacheFinal(InjectionFinalCacheDTO injectionFinalCacheDTO);
	
}
