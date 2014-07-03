package org.arqand.android.orm.commons;

/**
 * The Class CommonsTypeDataBase. Different TypeDataBase for creation DB.
 */
public class CommonsTypeDataBase {
	
	/**
	 * Type data base.
	 *
	 * @param clazz
	 *            the clazz
	 * @return the string
	 */
	public static String typeDataBase(final Class<?> clazz) {
		if ((clazz.equals(Boolean.class)) || (clazz.equals(Boolean.TYPE)) || (clazz.equals(java.util.Date.class)) || (clazz.equals(java.util.Calendar.class)) || (clazz.equals(java.sql.Date.class)) || (clazz.equals(Integer.class)) || (clazz.equals(Integer.TYPE)) || (clazz.equals(Long.class)) || (clazz.equals(Long.TYPE)) || ((!clazz.isPrimitive()))) {
			return " INTEGER ";
		} else if ((clazz.equals(Double.class)) || (clazz.equals(Double.TYPE)) || (clazz.equals(Float.class)) || (clazz.equals(Float.TYPE))) {
			return " FLOAT ";
		}
		return " TEXT ";
	}
	
}
