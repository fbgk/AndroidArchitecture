package org.arqand.android.orm.api;

import org.arqand.android.orm.api.dto.SQLDTO;

/**
 * The Interface CacheDao.
 */
public interface CacheDao {
	
	/**
	 * Gets the cache.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the cache
	 */
	public SQLDTO getCache(Class<?> clazz);
	
}
