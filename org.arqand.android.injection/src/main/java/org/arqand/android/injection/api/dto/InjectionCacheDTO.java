package org.arqand.android.injection.api.dto;

import java.util.List;

/**
 * The Class InjectionCacheDTO.
 */
public class InjectionCacheDTO {

	/** The clazz. */
	private Class<?> clazz;

	/** The list field cache dt os. */
	private List<FieldCacheDTO> listFieldCacheDTOs;

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
		final InjectionCacheDTO other = (InjectionCacheDTO) obj;
		if (this.clazz == null) {
			if (other.clazz != null) {
				return false;
			}
		} else if (!this.clazz.equals(other.clazz)) {
			return false;
		}
		if (this.listFieldCacheDTOs == null) {
			if (other.listFieldCacheDTOs != null) {
				return false;
			}
		} else if (!this.listFieldCacheDTOs.equals(other.listFieldCacheDTOs)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the clazz.
	 * 
	 * @return the clazz
	 */
	public Class<?> getClazz() {
		return this.clazz;
	}

	/**
	 * Gets the list field cache dt os.
	 * 
	 * @return the list field cache dt os
	 */
	public List<FieldCacheDTO> getListFieldCacheDTOs() {
		return this.listFieldCacheDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.clazz == null) ? 0 : this.clazz.hashCode());
		result = (prime * result) + ((this.listFieldCacheDTOs == null) ? 0 : this.listFieldCacheDTOs.hashCode());
		return result;
	}

	/**
	 * Sets the clazz.
	 * 
	 * @param clazz
	 *            the new clazz
	 */
	public void setClazz(final Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Sets the list field cache dt os.
	 * 
	 * @param listFieldCacheDTOs
	 *            the new list field cache dt os
	 */
	public void setListFieldCacheDTOs(final List<FieldCacheDTO> listFieldCacheDTOs) {
		this.listFieldCacheDTOs = listFieldCacheDTOs;
	}

}
