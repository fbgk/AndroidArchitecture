package org.arqand.android.orm.commons;

import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.conversion.api.CacheConversionService;
import org.arqand.android.conversion.api.ConversionType;
import org.arqand.android.conversion.impl.CacheConversionServiceImpl;
import org.arqand.android.orm.api.dto.SQLDTO;
import org.arqand.android.orm.exception.ExceptionNullData;

import android.content.ContentValues;

/**
 * The Class ContentValuesCommons. Create a ContentValues with data.
 */
public class CommonsContentValues {
	
	/** The cache conversion service. */
	final static CacheConversionService	cacheConversionService	= CacheConversionServiceImpl.getInstance();
	
	/**
	 * Creates the content values orm.
	 * 
	 * @param <K>
	 * 
	 * @param sqlDto
	 *            the sql dto
	 * @param object
	 *            the object
	 * @return the content values
	 * @throws ExceptionNullData
	 *             the exception null data
	 */
	@SuppressWarnings("unchecked")
	public static <K> ContentValues createContentValuesORM(final SQLDTO sqlDto, final Object object) throws ExceptionNullData {
		final ContentValues contentValues = new ContentValues();
		for (final String column : sqlDto.getColumns()) {
			
			final Object data = CommonsReflections.returnValue(object, sqlDto.getMapColumns().get(column));
			
			if (data == null) {
				if (!sqlDto.getListNull().contains(column) && !column.equals(sqlDto.getId())) {
					throw new ExceptionNullData(column);
				}
			} else if (data instanceof String) {
				contentValues.put(column, (String) data);
			} else if (data instanceof Integer) {
				contentValues.put(column, (Integer) data);
			} else if (data instanceof Long) {
				contentValues.put(column, (Long) data);
			} else if (data instanceof Boolean) {
				contentValues.put(column, (Boolean) data);
			} else if (data instanceof Float) {
				contentValues.put(column, (Float) data);
			} else {
				final ConversionType<String, K> conversionType = (ConversionType<String, K>) CommonsContentValues.cacheConversionService.getConversion(sqlDto.getMapColumns().get(column).getType(), String.class);
				contentValues.put(column, conversionType.conversion((K) data));
			}
		}
		return contentValues;
	}
	
}
