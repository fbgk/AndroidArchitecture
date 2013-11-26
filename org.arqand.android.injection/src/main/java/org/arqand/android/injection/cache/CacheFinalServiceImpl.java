package org.arqand.android.injection.cache;

import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.injection.api.dto.InjectionFinalCacheDTO;
import org.arqand.android.injection.api.dto.MapFinalCacheDTO;
import org.arqand.android.injection.cache.api.CacheFinalService;

/**
 * The Class CacheFinalServiceImpl.
 */
public class CacheFinalServiceImpl implements CacheFinalService {

	/** The Constant CACHE_NAME. */
	private static final String CACHE_NAME = CacheFinalServiceImpl.class.getCanonicalName();

	static {
		CommonsCache.addCache(CACHE_NAME, new HashMap<MapFinalCacheDTO, InjectionFinalCacheDTO>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.cache.api.CacheFinalService#getCacheFinal
	 * (java.lang.Class, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public InjectionFinalCacheDTO getCacheFinal(final Class<?> clazz, final int id) {

		return ((Map<MapFinalCacheDTO, InjectionFinalCacheDTO>) CommonsCache.getCacheMap(CACHE_NAME)).get(new MapFinalCacheDTO(clazz, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.cache.api.CacheFinalService#setCacheFinal
	 * (org.arqand.android.injection.api.dto.InformationCacheDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setCacheFinal(final InjectionFinalCacheDTO injectionFinalCacheDTO) {
		((Map<MapFinalCacheDTO, InjectionFinalCacheDTO>) CommonsCache.getCacheMap(CACHE_NAME)).put(new MapFinalCacheDTO(injectionFinalCacheDTO.getClassDTO(), injectionFinalCacheDTO.getId()), injectionFinalCacheDTO);
	}
}
