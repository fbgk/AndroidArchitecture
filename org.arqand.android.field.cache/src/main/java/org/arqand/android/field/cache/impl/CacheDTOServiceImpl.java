package org.arqand.android.field.cache.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.field.cache.api.CacheDTOService;
import org.arqand.android.field.cache.api.dto.CacheDTO;
import org.arqand.android.field.cache.api.dto.FieldCacheDTO;

/**
 * Class that caches all part of the DTO cache application.
 */
public class CacheDTOServiceImpl implements CacheDTOService {
	
	private static final CacheDTOService	CACHE_DTO_SERVICE	= new CacheDTOServiceImpl();
	
	/** The Constant CACHE_NAME. */
	private static final String				CACHE_NAME			= CacheDTOServiceImpl.class.getCanonicalName();
	
	static {
		CommonsCache.addCache(CACHE_NAME, new HashMap<String, CacheDTO>());
	}
	
	public static CacheDTOService getInstance() {
		return CACHE_DTO_SERVICE;
	}
	
	private CacheDTOServiceImpl() {
	}
	
	/**
	 * Gets the cache.
	 * 
	 * @return the cache
	 */
	@SuppressWarnings("unchecked")
	private Map<String, CacheDTO> getCache() {
		return (Map<String, CacheDTO>) CommonsCache.getCacheMap(CACHE_NAME);
	}
	
	/**
	 * Gets the injection cache dto.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the injection cache dto
	 */
	private CacheDTO getInjectionCacheDTO(final Class<?> clazz) {
		
		/** Create InjectionCacheDTO */
		final CacheDTO cacheDTO = new CacheDTO();
		cacheDTO.setClazz(clazz);
		cacheDTO.setMapCacheDTO(new HashMap<Field, FieldCacheDTO>());
		cacheDTO.setMapStringField(new HashMap<String, FieldCacheDTO>());
		
		/** Search Field, Setter, Getter */
		for (final Field field : CommonsReflections.returnFields(clazz)) {
			
			final FieldCacheDTO fieldCacheDTO = new FieldCacheDTO();
			fieldCacheDTO.setField(field);
			fieldCacheDTO.setMethodGet(CommonsReflections.returnMethod(field, clazz));
			fieldCacheDTO.setMethodSet(CommonsReflections.setterMethod(field, clazz));
			cacheDTO.getMapStringField().put(field.getName(), fieldCacheDTO);
			cacheDTO.getMapCacheDTO().put(field, fieldCacheDTO);
		}
		return cacheDTO;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @param clase
	 *            the clase
	 * @return the value
	 */
	@Override
	public CacheDTO getValue(final Class<?> clase) {
		CacheDTO cacheDTO = this.getCache().get(clase.getCanonicalName());
		if (cacheDTO == null) {
			cacheDTO = this.getInjectionCacheDTO(clase);
			this.setCache(cacheDTO);
		}
		return cacheDTO;
	}
	
	/**
	 * Sets the cache.
	 * 
	 * @param injectionCacheDTO
	 *            the new cache
	 */
	@Override
	public void setCache(final CacheDTO injectionCacheDTO) {
		this.getCache().put(injectionCacheDTO.getClazz().getCanonicalName(), injectionCacheDTO);
	}
	
}
