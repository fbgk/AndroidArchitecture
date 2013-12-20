package org.arqand.android.field.cache.api.dto;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * The Class InjectionCacheDTO.
 */
public class CacheDTO {

	/** The clazz. */
	private Class<?>					clazz;

	/** The list field cache dt os. */
	private Map<Field, FieldCacheDTO>	mapCacheDTO;

	/**
	 * Gets the clazz.
	 * 
	 * @return the clazz
	 */
	public Class<?> getClazz() {
		return this.clazz;
	}

	/**
	 * Gets the map cache dto.
	 * 
	 * @return the map cache dto
	 */
	public Map<Field, FieldCacheDTO> getMapCacheDTO() {
		return this.mapCacheDTO;
	}

	/**
	 * Sets the clazz.
	 * 
	 * @param clazz
	 *            the new clazz
	 */
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Sets the map cache dto.
	 * 
	 * @param mapCacheDTO
	 *            the map cache dto
	 */
	public void setMapCacheDTO(Map<Field, FieldCacheDTO> mapCacheDTO) {
		this.mapCacheDTO = mapCacheDTO;
	}

}
