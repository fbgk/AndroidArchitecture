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
	
	/** The list field cache dt os. */
	private Map<String, FieldCacheDTO>	mapStringField;
	
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
	 * Gets the map string field.
	 * 
	 * @return the map string field
	 */
	public Map<String, FieldCacheDTO> getMapStringField() {
		return this.mapStringField;
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
	
	/**
	 * Sets the map string field.
	 * 
	 * @param mapStringField
	 *            the map string field
	 */
	public void setMapStringField(Map<String, FieldCacheDTO> mapStringField) {
		this.mapStringField = mapStringField;
	}
	
}
