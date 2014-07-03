package org.arqand.android.injection.api.dto;

/**
 * The Class MapeoFinalCacheDTO.
 */
public class MapFinalCacheDTO {
	
	/** The class dto. */
	private Class<?>	classDTO;
	
	/** The id. */
	private Integer		id;
	
	/**
	 * Instantiates a new map final cache dto.
	 */
	public MapFinalCacheDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new map final cache dto.
	 * 
	 * @param classDTO
	 *            the class dto
	 * @param id
	 *            the id
	 */
	public MapFinalCacheDTO(final Class<?> classDTO, final Integer id) {
		super();
		this.classDTO = classDTO;
		this.id = id;
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
		final MapFinalCacheDTO other = (MapFinalCacheDTO) obj;
		if (this.classDTO == null) {
			if (other.classDTO != null) {
				return false;
			}
		} else if (!this.classDTO.equals(other.classDTO)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the class dto.
	 * 
	 * @return the class dto
	 */
	public Class<?> getClassDTO() {
		return this.classDTO;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.classDTO == null) ? 0 : this.classDTO.hashCode());
		result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
	
	/**
	 * Sets the class dto.
	 * 
	 * @param classDTO
	 *            the new class dto
	 */
	public void setClassDTO(final Class<?> classDTO) {
		this.classDTO = classDTO;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Integer id) {
		this.id = id;
	}
	
}
