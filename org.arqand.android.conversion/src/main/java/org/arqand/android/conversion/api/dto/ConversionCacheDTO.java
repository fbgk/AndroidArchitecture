package org.arqand.android.conversion.api.dto;

/**
 * The Class ViewCacheDTO.
 */
public class ConversionCacheDTO {
	
	/** The clazz return. */
	private Class<?>	clazzSource;
	
	/** The clazz view. */
	private Class<?>	clazzTarget;
	
	/**
	 * Instantiates a new conversion cache dto.
	 */
	public ConversionCacheDTO() {
	}
	
	/**
	 * Instantiates a new conversion cache dto.
	 * 
	 * @param classSource
	 *            the class source
	 * @param classTarget
	 *            the class target
	 */
	public ConversionCacheDTO(final Class<?> classSource, final Class<?> classTarget) {
		super();
		this.clazzSource = classSource;
		this.clazzTarget = classTarget;
	}
	
	/*
	 * (non-Javadoc)
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
		final ConversionCacheDTO other = (ConversionCacheDTO) obj;
		if (this.clazzSource == null) {
			if (other.clazzSource != null) {
				return false;
			}
		} else if (!this.clazzSource.equals(other.clazzSource)) {
			return false;
		}
		if (this.clazzTarget == null) {
			if (other.clazzTarget != null) {
				return false;
			}
		} else if (!this.clazzTarget.equals(other.clazzTarget)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the clazz source.
	 * 
	 * @return the clazz source
	 */
	public Class<?> getClazzSource() {
		return this.clazzSource;
	}
	
	/**
	 * Gets the clazz target.
	 * 
	 * @return the clazz target
	 */
	public Class<?> getClazzTarget() {
		return this.clazzTarget;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.clazzSource == null) ? 0 : this.clazzSource.hashCode());
		result = (prime * result) + ((this.clazzTarget == null) ? 0 : this.clazzTarget.hashCode());
		return result;
	}
	
	/**
	 * Sets the clazz source.
	 * 
	 * @param clazzSource
	 *            the new clazz source
	 */
	public void setClazzSource(final Class<?> clazzSource) {
		this.clazzSource = clazzSource;
	}
	
	/**
	 * Sets the clazz target.
	 * 
	 * @param clazzTarget
	 *            the new clazz target
	 */
	public void setClazzTarget(final Class<?> clazzTarget) {
		this.clazzTarget = clazzTarget;
	}
	
	@Override
	public String toString() {
		return "ConversionCacheDTO [clazzSource=" + this.clazzSource + ", clazzTarget=" + this.clazzTarget + "]";
	}
	
}
