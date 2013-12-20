package org.arqand.android.injection;

import org.arqand.android.commons.activity.CommonsActivity;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.field.cache.api.dto.FieldCacheDTO;
import org.arqand.android.injection.api.ConversionType;
import org.arqand.android.injection.api.InitCacheService;
import org.arqand.android.injection.api.InjectionReflectionService;
import org.arqand.android.injection.api.ViewInjectionService;
import org.arqand.android.injection.api.annotation.Visual;
import org.arqand.android.injection.api.dto.InformationCacheDTO;
import org.arqand.android.injection.api.dto.InjectionFinalCacheDTO;
import org.arqand.android.injection.cache.CacheFinalServiceImpl;
import org.arqand.android.injection.cache.api.CacheFinalService;
import org.arqand.android.injection.conversion.BigDecimalToString;
import org.arqand.android.injection.conversion.CalendarToString;
import org.arqand.android.injection.conversion.DateToString;
import org.arqand.android.injection.conversion.FloatToString;
import org.arqand.android.injection.conversion.IntegerToString;
import org.arqand.android.injection.conversion.LongToString;
import org.arqand.android.injection.conversion.StringToBigDecimal;
import org.arqand.android.injection.conversion.StringToDate;
import org.arqand.android.injection.conversion.StringToFloat;
import org.arqand.android.injection.conversion.StringToInteger;
import org.arqand.android.injection.conversion.StringToLong;
import org.arqand.android.injection.view.CheckableInjection;
import org.arqand.android.injection.view.DatePickerInjection;
import org.arqand.android.injection.view.ImageResourceInjection;
import org.arqand.android.injection.view.ImageStringInjection;
import org.arqand.android.injection.view.ProgressBarInjection;
import org.arqand.android.injection.view.TextViewInjection;
import org.arqand.android.injection.view.TimePickerInjection;

import android.view.View;

/**
 * The Class InjectionServiceImpl.
 */
public class InjectionReflectionServiceImpl implements InjectionReflectionService {

	/** The cache injection service. */
	private final CacheFinalService	cacheFinalService	= new CacheFinalServiceImpl();

	/** The init cache service. */
	private final InitCacheService	initCacheService	= new InitCacheServiceImpl();

	/**
	 * Instantiates a new injection reflection service impl.
	 */
	public InjectionReflectionServiceImpl() {

		this.factoryConversionType(new BigDecimalToString(), new CalendarToString(), new DateToString(), new FloatToString(), new IntegerToString(), new LongToString(), new StringToBigDecimal(), new StringToDate(), new StringToFloat(), new StringToInteger(), new StringToLong());
		this.factoryInjectionView(new CheckableInjection(), new DatePickerInjection(), new ProgressBarInjection(), new TextViewInjection(), new TimePickerInjection(), new ImageResourceInjection(), new ImageStringInjection());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionReflectionService# factoryConversionType(org.arqand.android.injection.api.ConversionType[])
	 */
	@Override
	public void factoryConversionType(final ConversionType<?, ?>... conversionType) {
		this.initCacheService.factoryConverType(conversionType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionReflectionService# factoryInjectionView (org.arqand.android.injection.api.ViewInjectionService[])
	 */
	@Override
	public void factoryInjectionView(final ViewInjectionService<?, ?>... injectionServices) {
		this.initCacheService.factoryViewCache(injectionServices);
	}

	/**
	 * Gets the object.
	 * 
	 * @param <T>
	 *            Object getter
	 * @param <K>
	 *            View class
	 * @param <M>
	 *            Getter value view
	 * @param <L>
	 *            Getter value conversion
	 * @param injectionFinalCacheDTO
	 *            the injection final cache dto
	 * @param view
	 *            the view
	 * @return the object
	 */
	@SuppressWarnings("unchecked")
	private <T, K, M, L> T getObject(final InjectionFinalCacheDTO injectionFinalCacheDTO, final View view) {

		T object = null;

		if (injectionFinalCacheDTO != null) {
			object = (T) CommonsReflections.createInstance(injectionFinalCacheDTO.getClassDTO());

			if (object != null) {
				for (final InformationCacheDTO informationCacheDTO : injectionFinalCacheDTO.getListInformation()) {
					Object field = ((ViewInjectionService<K, M>) informationCacheDTO.getViewInjectionService()).getInformation((K) view.findViewById(informationCacheDTO.getViewId()));

					if (informationCacheDTO.getConversionTypeViewToDTO() != null) {

						field = ((ConversionType<L, M>) informationCacheDTO.getConversionTypeViewToDTO()).conversion((M) field);

					}
					if (field != null) {
						CommonsReflections.invokeSetter(informationCacheDTO.getFieldCacheDTO().getMethodSet(), object, field);
					}
				}
			}
		}

		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionService#getterVisual(java.lang .Class)
	 */
	@Override
	public <T> T getterVisual(final Class<?> clazz) {

		final View view = CommonsActivity.getActivity().getWindow().getDecorView().getRootView();

		return this.getObject(this.searchInjectionCache(clazz, view), view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionService#getterVisual(java.lang .Class, android.view.View)
	 */
	@Override
	public <T> T getterVisual(final Class<?> clazz, final View view) {

		return this.getObject(this.searchInjectionCache(clazz, view), view);
	}

	/**
	 * Search the DTO in the cache, but found, creates a new one and puts it in the cache.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param view
	 *            the view
	 * @return the injection cache dto
	 */
	private InjectionFinalCacheDTO searchInjectionCache(final Class<?> clazz, final View view) {

		InjectionFinalCacheDTO injectionFinalCacheDTO = this.cacheFinalService.getCacheFinal(clazz, view.getId());

		if (injectionFinalCacheDTO == null) {

			injectionFinalCacheDTO = this.initCacheService.createInjectionFinalCache(clazz, view);

			if (injectionFinalCacheDTO != null) {

				this.cacheFinalService.setCacheFinal(injectionFinalCacheDTO);

			}

		}
		return injectionFinalCacheDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionService#setterVisual(java.lang .Object)
	 */
	@Override
	public void setterVisual(final Object object) {

		final View view = CommonsActivity.getActivity().getWindow().getDecorView().getRootView();

		this.setView(object, this.searchInjectionCache(object.getClass(), view), view);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.api.InjectionService#setterVisual(java.lang .Object, android.view.View)
	 */
	@Override
	public void setterVisual(final Object object, final View view) {

		this.setView(object, this.searchInjectionCache(object.getClass(), view), view);

	}

	/**
	 * Sets the view.
	 * 
	 * @param <T>
	 *            Data type field
	 * @param <L>
	 *            Conversion type field
	 * @param <M>
	 *            Type view
	 * @param object
	 *            the object
	 * @param injectionFinalCacheDTO
	 *            the injection final cache dto
	 * @param view
	 *            the view
	 */
	@SuppressWarnings("unchecked")
	private <T, L, M> void setView(final Object object, final InjectionFinalCacheDTO injectionFinalCacheDTO, final View view) {

		if (injectionFinalCacheDTO != null) {
			for (final InformationCacheDTO informationCacheDTO : injectionFinalCacheDTO.getListInformation()) {

				FieldCacheDTO fieldCacheDTO = informationCacheDTO.getFieldCacheDTO();

				Visual visual = CommonsReflections.returnAnnotation(Visual.class, fieldCacheDTO.getField());

				if (visual != null && !visual.isPassword()) {

					Object data = CommonsReflections.returnValue(object, fieldCacheDTO.getMethodGet());
					if (informationCacheDTO.getConversionTypeDTOToView() != null) {

						data = ((ConversionType<L, T>) informationCacheDTO.getConversionTypeDTOToView()).conversion((T) data);
					}
					if (data != null) {
						((ViewInjectionService<M, L>) informationCacheDTO.getViewInjectionService()).setInformation((M) view.findViewById(informationCacheDTO.getViewId()), (L) data);
					}
				}
			}
		}
	}

}
