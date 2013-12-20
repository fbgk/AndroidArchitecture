package org.arqand.android.injection.api.dto;

import org.arqand.android.field.cache.api.dto.FieldCacheDTO;
import org.arqand.android.injection.api.ConversionType;
import org.arqand.android.injection.api.ViewInjectionService;

/**
 * The Class InformationCacheDTO.
 */
public class InformationCacheDTO {

	/** The conversion type dto to view. */
	private ConversionType<?, ?>		conversionTypeDTOToView;

	/** The conversion type view to dto. */
	private ConversionType<?, ?>		conversionTypeViewToDTO;

	/** The field cache dto. */
	private FieldCacheDTO				fieldCacheDTO;

	/** The view id. */
	private int							viewId;

	/** The view injection service. */
	private ViewInjectionService<?, ?>	viewInjectionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final InformationCacheDTO other = (InformationCacheDTO) obj;
		if (this.conversionTypeDTOToView == null) {
			if (other.conversionTypeDTOToView != null) {
				return false;
			}
		} else if (!this.conversionTypeDTOToView.equals(other.conversionTypeDTOToView)) {
			return false;
		}
		if (this.conversionTypeViewToDTO == null) {
			if (other.conversionTypeViewToDTO != null) {
				return false;
			}
		} else if (!this.conversionTypeViewToDTO.equals(other.conversionTypeViewToDTO)) {
			return false;
		}
		if (this.fieldCacheDTO == null) {
			if (other.fieldCacheDTO != null) {
				return false;
			}
		} else if (!this.fieldCacheDTO.equals(other.fieldCacheDTO)) {
			return false;
		}
		if (this.viewId != other.viewId) {
			return false;
		}
		if (this.viewInjectionService == null) {
			if (other.viewInjectionService != null) {
				return false;
			}
		} else if (!this.viewInjectionService.equals(other.viewInjectionService)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the conversion type dto to view.
	 * 
	 * @return the conversion type dto to view
	 */
	public ConversionType<?, ?> getConversionTypeDTOToView() {
		return this.conversionTypeDTOToView;
	}

	/**
	 * Gets the conversion type view to dto.
	 * 
	 * @return the conversion type view to dto
	 */
	public ConversionType<?, ?> getConversionTypeViewToDTO() {
		return this.conversionTypeViewToDTO;
	}

	/**
	 * Gets the field cache dto.
	 * 
	 * @return the field cache dto
	 */
	public FieldCacheDTO getFieldCacheDTO() {
		return this.fieldCacheDTO;
	}

	/**
	 * Gets the view id.
	 * 
	 * @return the view id
	 */
	public int getViewId() {
		return this.viewId;
	}

	/**
	 * Gets the view injection service.
	 * 
	 * @return the view injection service
	 */
	public ViewInjectionService<?, ?> getViewInjectionService() {
		return this.viewInjectionService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.conversionTypeDTOToView == null ? 0 : this.conversionTypeDTOToView.hashCode());
		result = prime * result + (this.conversionTypeViewToDTO == null ? 0 : this.conversionTypeViewToDTO.hashCode());
		result = prime * result + (this.fieldCacheDTO == null ? 0 : this.fieldCacheDTO.hashCode());
		result = prime * result + this.viewId;
		result = prime * result + (this.viewInjectionService == null ? 0 : this.viewInjectionService.hashCode());
		return result;
	}

	/**
	 * Sets the conversion type dto to view.
	 * 
	 * @param conversionTypeDTOToView
	 *            the conversion type dto to view
	 */
	public void setConversionTypeDTOToView(final ConversionType<?, ?> conversionTypeDTOToView) {
		this.conversionTypeDTOToView = conversionTypeDTOToView;
	}

	/**
	 * Sets the conversion type view to dto.
	 * 
	 * @param conversionTypeViewToDTO
	 *            the conversion type view to dto
	 */
	public void setConversionTypeViewToDTO(final ConversionType<?, ?> conversionTypeViewToDTO) {
		this.conversionTypeViewToDTO = conversionTypeViewToDTO;
	}

	/**
	 * Sets the field cache dto.
	 * 
	 * @param fieldCacheDTO
	 *            the new field cache dto
	 */
	public void setFieldCacheDTO(final FieldCacheDTO fieldCacheDTO) {
		this.fieldCacheDTO = fieldCacheDTO;
	}

	/**
	 * Sets the view id.
	 * 
	 * @param viewId
	 *            the new view id
	 */
	public void setViewId(final int viewId) {
		this.viewId = viewId;
	}

	/**
	 * Sets the view injection service.
	 * 
	 * @param viewInjectionService
	 *            the view injection service
	 */
	public void setViewInjectionService(final ViewInjectionService<?, ?> viewInjectionService) {
		this.viewInjectionService = viewInjectionService;
	}

}
