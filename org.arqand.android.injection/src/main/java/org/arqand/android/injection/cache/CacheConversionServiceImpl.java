package org.arqand.android.injection.cache;

import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.injection.api.ConversionType;
import org.arqand.android.injection.api.dto.ConversionCacheDTO;
import org.arqand.android.injection.cache.api.CacheConversionService;

/**
 * Class dedicated to creating the type converters
 */
public class CacheConversionServiceImpl implements CacheConversionService {

	/** The cache name. */
	private static final String	CACHE_NAME			= CacheConversionServiceImpl.class.getCanonicalName();

	static {
		CommonsCache.addCache(CACHE_NAME, new HashMap<ConversionCacheDTO, ConversionType<?, ?>>());
	}

	/** The method injection. */
	private final String		METHOD_INJECTION	= "conversion";

	/**
	 * Instantiates a new cache conversion service impl.
	 */
	public CacheConversionServiceImpl() {
	}

	/**
	 * Instantiates a new cache conversion service impl.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param conversionTypes
	 *            the conversion types
	 */
	public <T, K> CacheConversionServiceImpl(final ConversionType<T, K>... conversionTypes) {
		for (final ConversionType<T, K> conversionType : conversionTypes) {
			this.setConversion(conversionType);
		}
	}

	/**
	 * Conversion cache dto.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param conversionType
	 *            the conversion type
	 * @return the conversion cache dto
	 */
	private <T, K> ConversionCacheDTO conversionCacheDTO(final ConversionType<T, K> conversionType) {
		final Class<?>[] clazz = CommonsReflections.upClassesMethod(conversionType, this.METHOD_INJECTION);
		final Class<?> clazzReturn = CommonsReflections.returnMethodClass(conversionType, this.METHOD_INJECTION);
		ConversionCacheDTO conversionCacheDTO = null;
		if (clazz != null && clazz.length == 1 && clazzReturn != null) {
			conversionCacheDTO = new ConversionCacheDTO(clazz[0], clazzReturn);
		}
		return conversionCacheDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.cache.api.CacheConversionService#getConversion (java.lang.Class, java.lang.Class)
	 */
	/**
	 * Gets the conversion.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param classSource
	 *            the class source
	 * @param classTarget
	 *            the class target
	 * @return the conversion
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> ConversionType<T, K> getConversion(final Class<T> classSource, final Class<K> classTarget) {
		return ((Map<ConversionCacheDTO, ConversionType<T, K>>) CommonsCache.getCacheMap(CacheConversionServiceImpl.CACHE_NAME)).get(new ConversionCacheDTO(classSource, classTarget));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.cache.api.CacheConversionService#setConversion (org.arqand.android.injection.api.ConversionType)
	 */
	/**
	 * Sets the conversion.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param conversionType
	 *            the conversion type
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> void setConversion(final ConversionType<T, K> conversionType) {
		((Map<ConversionCacheDTO, ConversionType<T, K>>) CommonsCache.getCacheMap(CacheConversionServiceImpl.CACHE_NAME)).put(this.conversionCacheDTO(conversionType), conversionType);
	}

}
