package org.arqand.android.injection.api.dto;

import java.util.List;

/**
 * The Class InjectionFinalCacheDTO.
 */
public class InjectionFinalCacheDTO extends MapFinalCacheDTO {
	
	/** The list information. */
	private List<InformationCacheDTO>	listInformation;
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.dto.MapeoFinalCacheDTO#equals(java.lang .Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final InjectionFinalCacheDTO other = (InjectionFinalCacheDTO) obj;
		if (this.listInformation == null) {
			if (other.listInformation != null) {
				return false;
			}
		} else if (!this.listInformation.equals(other.listInformation)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the list information.
	 * 
	 * @return the list information
	 */
	public List<InformationCacheDTO> getListInformation() {
		return this.listInformation;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.dto.MapeoFinalCacheDTO#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + ((this.listInformation == null) ? 0 : this.listInformation.hashCode());
		return result;
	}
	
	/**
	 * Sets the list information.
	 * 
	 * @param listInformation
	 *            the new list information
	 */
	public void setListInformation(final List<InformationCacheDTO> listInformation) {
		this.listInformation = listInformation;
	}
	
}
