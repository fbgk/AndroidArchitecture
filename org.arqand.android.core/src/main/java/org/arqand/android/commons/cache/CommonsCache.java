package org.arqand.android.commons.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class CommonsCache.
 */
public class CommonsCache {
	
	/** The map. */
	private static Map<String, Object>	map	= new HashMap<String, Object>();
	
	/**
	 * Adds the cache.
	 * 
	 * @param key
	 *            the key
	 * @param object
	 *            the object
	 */
	public static void addCache(final String key, final Object object) {
		if (!map.containsKey(key)) {
			map.put(key, object);
		}
	}
	
	/**
	 * Gets the cache map.
	 * 
	 * @param key
	 *            the key
	 * @return the cache map
	 */
	public static Object getCacheMap(final String key) {
		return map.get(key);
	}
	
}
