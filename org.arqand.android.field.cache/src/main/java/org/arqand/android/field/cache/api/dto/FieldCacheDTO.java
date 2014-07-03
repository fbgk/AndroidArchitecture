package org.arqand.android.field.cache.api.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * The Class FieldCacheDTO.
 */
public class FieldCacheDTO {
	
	/** The field. */
	private Field	field;
	
	/** The method get. */
	private Method	methodGet;
	
	/** The method set. */
	private Method	methodSet;
	
	/**
	 * Gets the field.
	 * 
	 * @return the field
	 */
	public Field getField() {
		return this.field;
	}
	
	/**
	 * Gets the method get.
	 * 
	 * @return the method get
	 */
	public Method getMethodGet() {
		return this.methodGet;
	}
	
	/**
	 * Gets the method set.
	 * 
	 * @return the method set
	 */
	public Method getMethodSet() {
		return this.methodSet;
	}
	
	/**
	 * Sets the field.
	 * 
	 * @param field
	 *            the new field
	 */
	public void setField(Field field) {
		this.field = field;
	}
	
	/**
	 * Sets the method get.
	 * 
	 * @param methodGet
	 *            the new method get
	 */
	public void setMethodGet(Method methodGet) {
		this.methodGet = methodGet;
	}
	
	/**
	 * Sets the method set.
	 * 
	 * @param methodSet
	 *            the new method set
	 */
	public void setMethodSet(Method methodSet) {
		this.methodSet = methodSet;
	}
	
}
