package org.arqand.android.injection.api.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.arqand.android.injection.api.annotation.Visual;

/**
 * The Class FieldCacheDTO.
 */
public class FieldCacheDTO {

	/** The field. */
	private Field field;

	/** The method get. */
	private Method methodGet;

	/** The method set. */
	private Method methodSet;

	/** The visual. */
	private Visual visual;

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
		final FieldCacheDTO other = (FieldCacheDTO) obj;
		if (this.field == null) {
			if (other.field != null) {
				return false;
			}
		} else if (!this.field.equals(other.field)) {
			return false;
		}
		if (this.methodGet == null) {
			if (other.methodGet != null) {
				return false;
			}
		} else if (!this.methodGet.equals(other.methodGet)) {
			return false;
		}
		if (this.methodSet == null) {
			if (other.methodSet != null) {
				return false;
			}
		} else if (!this.methodSet.equals(other.methodSet)) {
			return false;
		}
		if (this.visual == null) {
			if (other.visual != null) {
				return false;
			}
		} else if (!this.visual.equals(other.visual)) {
			return false;
		}
		return true;
	}

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
	 * Gets the visual.
	 * 
	 * @return the visual
	 */
	public Visual getVisual() {
		return this.visual;
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
		result = (prime * result) + ((this.field == null) ? 0 : this.field.hashCode());
		result = (prime * result) + ((this.methodGet == null) ? 0 : this.methodGet.hashCode());
		result = (prime * result) + ((this.methodSet == null) ? 0 : this.methodSet.hashCode());
		result = (prime * result) + ((this.visual == null) ? 0 : this.visual.hashCode());
		return result;
	}

	/**
	 * Sets the field.
	 * 
	 * @param field
	 *            the new field
	 */
	public void setField(final Field field) {
		this.field = field;
	}

	/**
	 * Sets the method get.
	 * 
	 * @param methodGet
	 *            the new method get
	 */
	public void setMethodGet(final Method methodGet) {
		this.methodGet = methodGet;
	}

	/**
	 * Sets the method set.
	 * 
	 * @param methodSet
	 *            the new method set
	 */
	public void setMethodSet(final Method methodSet) {
		this.methodSet = methodSet;
	}

	/**
	 * Sets the visual.
	 * 
	 * @param visual
	 *            the new visual
	 */
	public void setVisual(final Visual visual) {
		this.visual = visual;
	}

}
