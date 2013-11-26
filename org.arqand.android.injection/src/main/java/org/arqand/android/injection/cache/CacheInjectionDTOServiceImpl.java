package org.arqand.android.injection.cache;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.injection.api.annotation.Visual;
import org.arqand.android.injection.api.dto.FieldCacheDTO;
import org.arqand.android.injection.api.dto.InjectionCacheDTO;
import org.arqand.android.injection.cache.api.CacheInjectionDTOService;

/**
 * Class that caches all part of the DTO cache application.
 */
public class CacheInjectionDTOServiceImpl implements CacheInjectionDTOService {

	/** The Constant CACHE_NAME. */
	private static final String CACHE_NAME = CacheInjectionDTOServiceImpl.class.getCanonicalName();

	static {
		CommonsCache.addCache(CACHE_NAME, new HashMap<String, InjectionCacheDTO>());
	}

	/**
	 * Gets the cache.
	 * 
	 * @return the cache
	 */
	@SuppressWarnings("unchecked")
	private Map<String, InjectionCacheDTO> getCache() {
		return ((Map<String, InjectionCacheDTO>) CommonsCache.getCacheMap(CACHE_NAME));
	}

	/**
	 * Gets the injection cache dto.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the injection cache dto
	 */
	private InjectionCacheDTO getInjectionCacheDTO(final Class<?> clazz) {

		/** Create InjectionCacheDTO */
		final InjectionCacheDTO injectionCacheDTO = new InjectionCacheDTO();
		injectionCacheDTO.setClazz(clazz);
		injectionCacheDTO.setListFieldCacheDTOs(new ArrayList<FieldCacheDTO>());

		/** Search Field, Setter, Getter and Annotation Visual */
		for (final Field field : CommonsReflections.returnFields(clazz)) {

			final Visual visual = CommonsReflections.returnAnnotation(Visual.class, field);
			/** If there is a visual configured */
			if (visual != null) {

				final FieldCacheDTO fieldCacheDTO = new FieldCacheDTO();
				fieldCacheDTO.setField(field);
				fieldCacheDTO.setVisual(visual);
				fieldCacheDTO.setMethodGet(CommonsReflections.returnMethod(field, clazz));
				fieldCacheDTO.setMethodSet(CommonsReflections.setterMethod(field, clazz));
				injectionCacheDTO.getListFieldCacheDTOs().add(fieldCacheDTO);
			}
		}
		return injectionCacheDTO;
	}

	/**
	 * Gets the value.
	 * 
	 * @param clase
	 *            the clase
	 * @return the value
	 */
	@Override
	public InjectionCacheDTO getValue(final Class<?> clase) {
		InjectionCacheDTO injectionCacheDTO = this.getCache().get(clase.getCanonicalName());
		if (injectionCacheDTO == null) {
			injectionCacheDTO = this.getInjectionCacheDTO(clase);
			this.setCache(injectionCacheDTO);
		}
		return injectionCacheDTO;
	}

	/**
	 * Sets the cache.
	 * 
	 * @param injectionCacheDTO
	 *            the new cache
	 */
	@Override
	public void setCache(final InjectionCacheDTO injectionCacheDTO) {
		this.getCache().put(injectionCacheDTO.getClazz().getCanonicalName(), injectionCacheDTO);
	}

}
