package org.arqand.android.orm.api.constants;

public enum OrderBy {
	
	ASC("ASC"), DES("DESC");
	
	private String	tipo;
	
	private OrderBy(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
