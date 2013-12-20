package org.arqand.android.injection;

import java.util.ArrayList;

import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.field.cache.api.CacheDTOService;
import org.arqand.android.field.cache.api.dto.CacheDTO;
import org.arqand.android.field.cache.api.dto.FieldCacheDTO;
import org.arqand.android.field.cache.impl.CacheDTOServiceImpl;
import org.arqand.android.injection.api.ConversionType;
import org.arqand.android.injection.api.InitCacheService;
import org.arqand.android.injection.api.ViewInjectionService;
import org.arqand.android.injection.api.annotation.Visual;
import org.arqand.android.injection.api.dto.InformationCacheDTO;
import org.arqand.android.injection.api.dto.InjectionFinalCacheDTO;
import org.arqand.android.injection.api.dto.ViewCacheDTO;
import org.arqand.android.injection.cache.CacheConversionServiceImpl;
import org.arqand.android.injection.cache.CacheInjectionViewServiceImpl;
import org.arqand.android.injection.cache.api.CacheConversionService;
import org.arqand.android.injection.cache.api.CacheInjectionViewService;

import android.view.View;

/**
 * The Class InitCacheServiceImpl.
 */
public class InitCacheServiceImpl implements InitCacheService {

	/** The Constant NAME_VIEW_INJECTION. */
	private static final String				NAME_VIEW_INJECTION			= "getInformation";

	/** The cache conversion service. */
	private final CacheConversionService	cacheConversionService		= new CacheConversionServiceImpl();

	/** The cache injection dto service. */
	private final CacheDTOService			cacheDTOService				= CacheDTOServiceImpl.getInstance();

	/** The cache injection view service. */
	private final CacheInjectionViewService	cacheInjectionViewService	= new CacheInjectionViewServiceImpl();

	/**
	 * Creates the information.
	 * 
	 * @param iden
	 *            the iden
	 * @param fieldCacheDTO
	 *            the field cache dto
	 * @return the information cache dto
	 */
	private InformationCacheDTO createInformation(final int iden, final FieldCacheDTO fieldCacheDTO, final View view) {

		InformationCacheDTO informationCacheDTO = null;

		// We got the view by id configured in the Visual annotation
		final Object object = view.findViewById(iden);

		if (object != null) {

			ViewInjectionService<?, ?> viewInjectionService = this.cacheInjectionViewService.getValue(new ViewCacheDTO(fieldCacheDTO.getField().getType(), object.getClass()));

			// If we find the return of the light, we seek only view
			if (viewInjectionService == null) {

				viewInjectionService = this.cacheInjectionViewService.getValue(object.getClass());

				if (viewInjectionService != null) {

					final Class<?> clazzReturn = CommonsReflections.returnMethodClass(viewInjectionService, NAME_VIEW_INJECTION);

					final ConversionType<?, ?> conversionTypeDTOToView = this.cacheConversionService.getConversion(fieldCacheDTO.getField().getType(), clazzReturn);

					if (conversionTypeDTOToView != null) {

						final ConversionType<?, ?> conversionTypeViewToDTO = this.cacheConversionService.getConversion(clazzReturn, fieldCacheDTO.getField().getType());

						if (conversionTypeViewToDTO != null) {
							informationCacheDTO = new InformationCacheDTO();
							informationCacheDTO.setFieldCacheDTO(fieldCacheDTO);
							informationCacheDTO.setViewId(iden);
							informationCacheDTO.setConversionTypeDTOToView(conversionTypeDTOToView);
							informationCacheDTO.setConversionTypeViewToDTO(conversionTypeViewToDTO);
							informationCacheDTO.setViewInjectionService(viewInjectionService);

						}
					}
				}
			} else {
				informationCacheDTO = new InformationCacheDTO();
				informationCacheDTO.setFieldCacheDTO(fieldCacheDTO);
				informationCacheDTO.setViewId(iden);
				informationCacheDTO.setViewInjectionService(viewInjectionService);
			}
		}
		return informationCacheDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InitCacheService#createInjectionFinalCache (java.lang.Class, int)
	 */
	@Override
	public InjectionFinalCacheDTO createInjectionFinalCache(final Class<?> clazz, final View view) {
		final InjectionFinalCacheDTO injectionFinalCacheDTO = new InjectionFinalCacheDTO();
		injectionFinalCacheDTO.setClassDTO(clazz);
		injectionFinalCacheDTO.setId(view.getId());
		injectionFinalCacheDTO.setListInformation(new ArrayList<InformationCacheDTO>());

		final CacheDTO cacheDTO = this.cacheDTOService.getValue(clazz);

		// Look for each data field for transformations as charged
		for (final FieldCacheDTO fieldCacheDTO : cacheDTO.getMapCacheDTO().values()) {

			Visual visual = CommonsReflections.returnAnnotation(Visual.class, fieldCacheDTO.getField());

			if (visual != null) {

				for (final int iden : visual.value()) {

					final InformationCacheDTO informationCacheDTO = this.createInformation(iden, fieldCacheDTO, view);

					if (informationCacheDTO != null) {

						injectionFinalCacheDTO.getListInformation().add(informationCacheDTO);

					}
				}
			}
		}
		return injectionFinalCacheDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InitCacheService#factoryConverType(org .arqand.android.injection.api.ConversionType[])
	 */
	@Override
	public void factoryConverType(final ConversionType<?, ?>... conversionTypes) {
		for (final ConversionType<?, ?> conversionType : conversionTypes) {
			this.cacheConversionService.setConversion(conversionType);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InitCacheService#factoryViewCache(org .arqand.android.injection.api.ViewInjectionService[])
	 */
	@Override
	public void factoryViewCache(final ViewInjectionService<?, ?>... viewInjectionServices) {
		for (final ViewInjectionService<?, ?> viewInjectionService : viewInjectionServices) {
			this.cacheInjectionViewService.setValue(viewInjectionService);
		}
	}

}
