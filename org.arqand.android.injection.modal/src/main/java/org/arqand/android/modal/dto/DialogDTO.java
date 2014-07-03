package org.arqand.android.modal.dto;

/**
 * The Class DialogDTO.
 * 
 * @param <T>
 *            the generic type
 */
public class DialogDTO<T> {
	
	/** The codigo. */
	private int	codigo;
	
	/** The object. */
	private T	object;
	
	/**
	 * The Constructor.
	 */
	public DialogDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param codigo
	 *            the codigo
	 * @param object
	 *            the object
	 */
	public DialogDTO(int codigo, T object) {
		super();
		this.codigo = codigo;
		this.object = object;
	}
	
	/**
	 * Gets the codigo.
	 * 
	 * @return the codigo
	 */
	public int getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Gets the object.
	 * 
	 * @return the object
	 */
	public T getObject() {
		return this.object;
	}
	
	/**
	 * Sets the codigo.
	 * 
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Sets the object.
	 * 
	 * @param object
	 *            the new object
	 */
	public void setObject(final T object) {
		this.object = object;
	}
	
	@Override
	public String toString() {
		return "DialogDTO [codigo=" + this.codigo + ", object=" + this.object + "]";
	}
	
}
