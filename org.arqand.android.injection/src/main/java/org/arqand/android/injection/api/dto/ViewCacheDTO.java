package org.arqand.android.injection.api.dto;

/**
 * The Class ViewCacheDTO.
 */
public class ViewCacheDTO {

	/** The clazz return. */
	private Class<?> clazzReturn;

	/** The clazz view. */
	private Class<?> clazzView;

	public ViewCacheDTO() {
	}

	/**
	 * @param clazzReturn
	 */
	public ViewCacheDTO(final Class<?> clazzView) {
		super();
		this.clazzView = clazzView;
	}

	/**
	 * @param clazzReturn
	 * @param clazzView
	 */
	public ViewCacheDTO(final Class<?> clazzReturn, final Class<?> clazzView) {
		super();
		this.clazzReturn = clazzReturn;
		this.clazzView = clazzView;
	}

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
		final ViewCacheDTO other = (ViewCacheDTO) obj;
		if (this.clazzReturn == null) {
			if (other.clazzReturn != null) {
				return false;
			}
		} else if (!this.clazzReturn.equals(other.clazzReturn)) {
			return false;
		}
		if (this.clazzView == null) {
			if (other.clazzView != null) {
				return false;
			}
		} else if (!this.clazzView.equals(other.clazzView)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the clazz return.
	 * 
	 * @return the clazz return
	 */
	public Class<?> getClazzReturn() {
		return this.clazzReturn;
	}

	/**
	 * Gets the clazz view.
	 * 
	 * @return the clazz view
	 */
	public Class<?> getClazzView() {
		return this.clazzView;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.clazzReturn == null) ? 0 : this.clazzReturn.hashCode());
		result = (prime * result) + ((this.clazzView == null) ? 0 : this.clazzView.hashCode());
		return result;
	}

	/**
	 * Sets the clazz return.
	 * 
	 * @param clazzReturn
	 *            the new clazz return
	 */
	public void setClazzReturn(final Class<?> clazzReturn) {
		this.clazzReturn = clazzReturn;
	}

	/**
	 * Sets the clazz view.
	 * 
	 * @param clazzView
	 *            the new clazz view
	 */
	public void setClazzView(final Class<?> clazzView) {
		this.clazzView = clazzView;
	}

}
