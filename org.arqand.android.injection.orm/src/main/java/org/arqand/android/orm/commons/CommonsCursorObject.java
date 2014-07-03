package org.arqand.android.orm.commons;

import java.lang.reflect.Field;

import android.database.Cursor;

/**
 * The Class CommonsCursorObject. Class convert for cursor to object.
 */
public class CommonsCursorObject {
	
	/**
	 * Convert cursor object. Convert one column to object valid. If have not object valid create a String.
	 *
	 * @param <K>
	 *            the key type
	 * @param cursor
	 *            the cursor
	 * @param field
	 *            the field
	 * @param column
	 *            the column
	 * @return the k
	 */
	@SuppressWarnings("unchecked")
	public static <K> K convertCursorObject(final Cursor cursor, final Field field, final String column) {
		
		K data = null;
		if (cursor != null) {
			if (field.getType().isAssignableFrom(Float.class)) {
				data = (K) new Float(cursor.getFloat(cursor.getColumnIndex(column)));
			} else if (field.getType().isAssignableFrom(Double.class)) {
				data = (K) new Double(cursor.getDouble(cursor.getColumnIndex(column)));
			} else if (field.getType().isAssignableFrom(Integer.class)) {
				data = (K) new Integer(cursor.getInt(cursor.getColumnIndex(column)));
			} else if (field.getType().isAssignableFrom(Long.class)) {
				data = (K) new Long(cursor.getLong(cursor.getColumnIndex(column)));
			} else if (field.getType().isAssignableFrom(Boolean.class)) {
				data = (K) Boolean.valueOf(cursor.getInt(cursor.getColumnIndex(column)) > 0);
			} else {
				data = (K) cursor.getString(cursor.getColumnIndex(column));
			}
		}
		return data;
	}
	
}
