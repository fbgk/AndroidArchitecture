package org.arqand.android.injection.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.injection.api.ViewInjectionService;
import org.arqand.android.injection.api.dto.ViewCacheDTO;
import org.arqand.android.injection.cache.api.CacheInjectionViewService;

/**
 * Class dedicated to the creation of cache for the view and its transformation
 * to concrete data.
 */
public class CacheInjectionViewServiceImpl implements CacheInjectionViewService {

	/** The cache name class. */
	private static final String CACHE_NAME_CLASS = CacheInjectionViewServiceImpl.class.getCanonicalName() + ".Short";

	/** The cache name view. */
	private static final String CACHE_NAME_VIEW = CacheInjectionViewServiceImpl.class.getCanonicalName();

	static {
		CommonsCache.addCache(CACHE_NAME_CLASS, new HashMap<ViewCacheDTO, ViewInjectionService<?, ?>>());
		CommonsCache.addCache(CACHE_NAME_VIEW, new HashMap<Class<?>, ViewInjectionService<?, ?>>());
	}
	/** The method injection. */
	private final String METHOD_INJECTION = "setInformation";

	/**
	 * Cache injection service impl.
	 */
	public void CacheInjectionServiceImpl() {

	}

	/**
	 * Cache injection service impl.
	 * 
	 * @param viewInjectionServices
	 *            the view injection services
	 */
	public void CacheInjectionServiceImpl(final ViewInjectionService<?, ?>... viewInjectionServices) {
		for (final ViewInjectionService<?, ?> viewInjectionService : viewInjectionServices) {
			this.setValue(viewInjectionService);
		}
	}

	/**
	 * Gets the ter class injection.
	 * 
	 * @param viewInjectionService
	 *            the view injection service
	 * @return the ter class injection
	 */
	private ViewCacheDTO getterClassInjection(final ViewInjectionService<?, ?> viewInjectionService) {
		final Class<?>[] clazz = CommonsReflections.upClassesMethod(viewInjectionService, this.METHOD_INJECTION);
		ViewCacheDTO viewCacheDTO = null;
		if ((clazz != null) && (clazz.length == 2)) {
			viewCacheDTO = new ViewCacheDTO(clazz[1], clazz[0]);
		}
		return viewCacheDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.CacheViewInjectionService#getValue(java
	 * .lang.Class)
	 */
	/**
	 * Gets the value.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewClass
	 *            the view class
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> ViewInjectionService<T, K> getValue(final Class<?> viewClass) {
		return ((Map<Class<?>, ViewInjectionService<T, K>>) CommonsCache.getCacheMap(CacheInjectionViewServiceImpl.CACHE_NAME_CLASS)).get(viewClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.CacheViewInjectionService#getValue(org
	 * .arqand.android.injection.api.dto.ViewCacheDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> ViewInjectionService<T, K> getValue(final ViewCacheDTO viewCacheDTO) {

		final Map<ViewCacheDTO, ViewInjectionService<T, K>> cache = new HashMap<ViewCacheDTO, ViewInjectionService<T, K>>((Map<ViewCacheDTO, ViewInjectionService<T, K>>) CommonsCache.getCacheMap(CacheInjectionViewServiceImpl.CACHE_NAME_VIEW));
		ViewInjectionService<T, K> viewInjectionService = cache.get(viewCacheDTO);
		if (viewInjectionService == null) {
			// seek a support class

			final Iterator<ViewCacheDTO> iterator = cache.keySet().iterator();

			// When we found we completed the loop
			while (iterator.hasNext() && (viewInjectionService == null)) {

				final ViewCacheDTO viewCacheDTO2 = iterator.next();

				// If we find the consistent view, we see if the kind of return
				// is equal, we return null if the class is not equal
				if (viewCacheDTO2.getClazzView().isAssignableFrom(viewCacheDTO.getClazzView())) {

					final ViewInjectionService<T, K> viewInjectionServiceReturn = cache.get(viewCacheDTO2);

					if (viewCacheDTO.getClazzReturn().equals(viewCacheDTO2.getClazzReturn())) {
						viewInjectionService = viewInjectionServiceReturn;
					}

					this.putValues(viewInjectionServiceReturn, new ViewCacheDTO(viewCacheDTO2.getClazzReturn(), viewCacheDTO.getClazzView()));
				}
			}
		}
		return viewInjectionService;
	}

	/**
	 * Put values.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewInjectionService
	 *            the view injection service
	 * @param viewCacheDTO
	 *            the view cache dto
	 */
	@SuppressWarnings("unchecked")
	private <T, K> void putValues(final ViewInjectionService<T, K> viewInjectionService, final ViewCacheDTO viewCacheDTO) {
		final Map<Class<?>, ViewInjectionService<?, ?>> mapeoClass = (Map<Class<?>, ViewInjectionService<?, ?>>) CommonsCache.getCacheMap(CacheInjectionViewServiceImpl.CACHE_NAME_CLASS);
		mapeoClass.put(viewCacheDTO.getClazzView(), viewInjectionService);

		final Map<ViewCacheDTO, ViewInjectionService<?, ?>> mapeoView = (Map<ViewCacheDTO, ViewInjectionService<?, ?>>) CommonsCache.getCacheMap(CacheInjectionViewServiceImpl.CACHE_NAME_VIEW);
		mapeoView.put(viewCacheDTO, viewInjectionService);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.CacheViewInjectionService#setValue(org
	 * .arqand.android.injection.api.ViewInjectionService)
	 */

	/**
	 * Sets the value.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param viewInjectionService
	 *            the view injection service
	 */
	@Override
	public <T, K> void setValue(final ViewInjectionService<T, K> viewInjectionService) {
		final ViewCacheDTO viewCacheDTO = this.getterClassInjection(viewInjectionService);
		if (viewCacheDTO != null) {
			this.putValues(viewInjectionService, viewCacheDTO);
		}
	}

}
