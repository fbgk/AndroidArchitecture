package org.arqand.android.conversion.impl;

import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.conversion.api.CacheConversionService;
import org.arqand.android.conversion.api.ConversionType;
import org.arqand.android.conversion.api.dto.ConversionCacheDTO;

/**
 * Class dedicated to creating the type converters
 */
public class CacheConversionServiceImpl implements CacheConversionService {
	
	private static final CacheConversionService	CACHE_CONVERSION_SERVICE	= new CacheConversionServiceImpl();
	
	/** The cache name. */
	private static final String					CACHE_NAME					= CacheConversionServiceImpl.class.getCanonicalName();
	
	static {
		CommonsCache.addCache(CacheConversionServiceImpl.CACHE_NAME, new HashMap<ConversionCacheDTO, ConversionType<?, ?>>());
	}
	
	public static CacheConversionService getInstance() {
		return CacheConversionServiceImpl.CACHE_CONVERSION_SERVICE;
	}
	
	public static <T, K> CacheConversionService getInstance(final ConversionType<T, K>... conversionTypes) {
		for (final ConversionType<T, K> conversionType : conversionTypes) {
			CacheConversionServiceImpl.CACHE_CONVERSION_SERVICE.setConversion(conversionType);
		}
		return CacheConversionServiceImpl.CACHE_CONVERSION_SERVICE;
	}
	
	/** The method injection. */
	private final String	METHOD_INJECTION	= "conversion";
	
	/**
	 * Instantiates a new cache conversion service impl.
	 */
	private CacheConversionServiceImpl() {
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
	 * @see org.arqand.android.injection.cache.api.CacheConversionService#getConversion (java.lang.Class, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> ConversionType<T, K> getConversion(final Class<T> classSource, final Class<K> classTarget) {
		return ((Map<ConversionCacheDTO, ConversionType<T, K>>) CommonsCache.getCacheMap(CacheConversionServiceImpl.CACHE_NAME)).get(new ConversionCacheDTO(classSource, classTarget));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.cache.api.CacheConversionService#setConversion (org.arqand.android.injection.api.ConversionType)
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public <T, K> void setConversion(final ConversionType<T, K> conversionType) {
		((Map<ConversionCacheDTO, ConversionType<T, K>>) CommonsCache.getCacheMap(CacheConversionServiceImpl.CACHE_NAME)).put(this.conversionCacheDTO(conversionType), conversionType);
	}
	
}
