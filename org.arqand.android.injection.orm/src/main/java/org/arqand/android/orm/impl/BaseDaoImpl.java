package org.arqand.android.orm.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.conversion.api.CacheConversionService;
import org.arqand.android.conversion.api.ConversionType;
import org.arqand.android.conversion.impl.CacheConversionServiceImpl;
import org.arqand.android.orm.api.BaseDao;
import org.arqand.android.orm.api.CacheDao;
import org.arqand.android.orm.api.constants.OrderBy;
import org.arqand.android.orm.api.dto.SQLDTO;
import org.arqand.android.orm.commons.CommonsContentValues;
import org.arqand.android.orm.commons.CommonsCursorObject;
import org.arqand.android.orm.commons.CommonsTypeDataBase;
import org.arqand.android.orm.exception.ExceptionNullData;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * The Class BaseDaoImpl.
 */
public class BaseDaoImpl implements BaseDao {
	
	/** The arq and helper. */
	final ArqAndHelper				arqAndHelper			= new ArqAndHelper();
	
	/** The cache conversion service. */
	final CacheConversionService	cacheConversionService	= CacheConversionServiceImpl.getInstance();
	
	/** The cache dao. */
	final CacheDao					cacheDao				= new CacheDaoImpl();
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#consult(java.lang.Class, int)
	 */
	@Override
	public <T> T consult(final Class<T> clazz, final int id) {
		return this.consultDB(this.cacheDao.getCache(clazz), id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#consult(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T consult(final T object) {
		final SQLDTO sqldto = this.cacheDao.getCache(object.getClass());
		return (T) this.consultDB(sqldto, this.getID(sqldto, object));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#createDataBase(java.lang.Class[])
	 */
	@Override
	public void createDataBase(final Class<?>... classes) {
		final SQLiteDatabase sqLiteDatabase = this.arqAndHelper.getWritableDatabase();
		final CacheDao cacheDao = new CacheDaoImpl();
		
		for (final Class<?> class1 : classes) {
			final SQLDTO sqldto = cacheDao.getCache(class1);
			final StringBuilder stringBuilder = new StringBuilder();
			if (sqldto.getTable() != null && !sqldto.getTable().isEmpty()) {
				stringBuilder.append("CREATE TABLE ").append(sqldto.getTable()).append("(").append(sqldto.getId()).append(" INTEGER PRIMARY KEY AUTOINCREMENT");
				for (final String columns : sqldto.getColumns()) {
					if (!columns.equals(sqldto.getId())) {
						stringBuilder.append(",").append(columns).append(CommonsTypeDataBase.typeDataBase(sqldto.getMapColumns().get(columns).getClass()));
						if (!sqldto.getListNull().contains(columns)) {
							stringBuilder.append(" NOT NULL ");
						}
					}
				}
				stringBuilder.append(");");
				sqLiteDatabase.execSQL(stringBuilder.toString());
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#delete(int, java.lang.Class)
	 */
	@Override
	public <T> void delete(final Class<T> clazz, final int id) {
		this.deleteDB(this.cacheDao.getCache(clazz), id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public <T> void delete(final T object) {
		final SQLDTO sqldto = this.cacheDao.getCache(object.getClass());
		this.deleteDB(sqldto, this.getID(sqldto, object));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#save(java.lang.Object)
	 */
	@Override
	public <T> T save(final T object) throws ExceptionNullData {
		final SQLDTO sqlDto = this.cacheDao.getCache(object.getClass());
		final SQLiteDatabase sqLiteDatabase = this.arqAndHelper.getWritableDatabase();
		final ContentValues values = CommonsContentValues.createContentValuesORM(sqlDto, object);
		sqLiteDatabase.beginTransaction();
		final Integer dataID = this.getID(sqlDto, object);
		if (dataID == null) {
			final long id = sqLiteDatabase.insert(sqlDto.getTable(), null, values);
			if (id != -1) {
				CommonsReflections.setterValueMethod(object, CommonsReflections.setterMethod(sqlDto.getId(), object), Long.valueOf(id).intValue());
				sqLiteDatabase.setTransactionSuccessful();
			}
		} else if (sqLiteDatabase.update(sqlDto.getTable(), values, sqlDto.getId() + "=" + dataID, null) != 0) {
			sqLiteDatabase.setTransactionSuccessful();
		}
		sqLiteDatabase.endTransaction();
		return object;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#search(java.lang.Object)
	 */
	@Override
	public <T> List<T> search(final T object) {
		final SQLDTO sqlDto = this.cacheDao.getCache(object.getClass());
		return this.convertCursorToListDTO(sqlDto, this.searchCommon(sqlDto, object, null, null));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#search(java.lang.Object, org.arqand.android.orm.api.constants.OrderBy, java.lang.String)
	 */
	@Override
	public <T> List<T> search(final T object, final OrderBy orderBy, final String fieldOrderBy) {
		final SQLDTO sqlDto = this.cacheDao.getCache(object.getClass());
		return this.convertCursorToListDTO(sqlDto, this.searchCommon(sqlDto, object, orderBy, fieldOrderBy));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#searchAll(java.lang.Class)
	 */
	@Override
	public <T> List<T> searchAll(final Class<T> clazz) {
		final SQLDTO sqlDto = this.cacheDao.getCache(clazz);
		return this.convertCursorToListDTO(sqlDto, this.searchCommon(sqlDto, null, null, null));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.BaseDao#searchAll(java.lang.Class, org.arqand.android.orm.api.constants.OrderBy, java.lang.String)
	 */
	@Override
	public <T> List<T> searchAll(final Class<T> clazz, final OrderBy orderBy, final String fieldOrderBy) {
		final SQLDTO sqlDto = this.cacheDao.getCache(clazz);
		return this.convertCursorToListDTO(sqlDto, this.searchCommon(sqlDto, null, orderBy, fieldOrderBy));
	}
	
	/**
	 * SearchCommon.
	 *
	 * @param sqldto
	 *            the sqldto
	 * @param object
	 *            the object
	 * @param orderBy
	 *            the order by
	 * @param fieldOrderBy
	 *            the field order by
	 * @return the cursor
	 */
	protected Cursor searchCommon(final SQLDTO sqldto, final Object object, final OrderBy orderBy, final String fieldOrderBy) {
		final SQLiteDatabase sqLiteDatabase = this.arqAndHelper.getReadableDatabase();
		String orderByString = null;
		if (orderBy != null && fieldOrderBy != null) {
			orderByString = fieldOrderBy + " " + orderBy.getTipo();
		}
		String query = null;
		String[] queryArgs = null;
		if (object != null) {
			final List<String> data = new ArrayList<String>();
			query = "";
			for (final String columns : sqldto.getColumns()) {
				final Field field = sqldto.getMapColumns().get(columns);
				final String dataField = this.getterObject(field, object);
				if (dataField != null) {
					if (!query.isEmpty()) {
						query += " AND ";
					}
					query += " " + columns + " = ? ";
					data.add(dataField);
				}
			}
			if (!data.isEmpty()) {
				queryArgs = new String[] {};
				queryArgs = data.toArray(queryArgs);
			}
		}
		
		return sqLiteDatabase.query(sqldto.getTable(), sqldto.getColumns(), query, queryArgs, null, null, orderByString);
	}
	
	/**
	 * Creates the where. Build where.
	 *
	 * @param strings
	 *            the strings
	 * @return the string
	 */
	private String buildWhere(final String... strings) {
		
		final StringBuilder where = new StringBuilder();
		
		for (final String string : strings) {
			
			if (where.length() != 0) {
				where.append(" AND ");
			}
			
			where.append(string);
			where.append("=?");
			
		}
		
		return where.toString();
		
	}
	
	/**
	 * Consult db.
	 *
	 * @param <T>
	 *            the generic type
	 * @param sqldto
	 *            the sqldto
	 * @param id
	 *            the id
	 * @return the t
	 */
	private <T> T consultDB(final SQLDTO sqldto, final int id) {
		T generic = null;
		if (sqldto != null) {
			final SQLiteDatabase sqLiteDatabase = this.arqAndHelper.getReadableDatabase();
			if (sqLiteDatabase != null) {
				final Cursor cursor = sqLiteDatabase.query(sqldto.getTable(), sqldto.getColumns(), this.buildWhere(sqldto.getId()), new String[] { String.valueOf(id) }, null, null, null);
				generic = this.convertCursorToDTO(sqldto, cursor);
				cursor.close();
			}
		}
		return generic;
	}
	
	/**
	 * Convert cursor.
	 *
	 * @param <T>
	 *            the generic type
	 * @param <M>
	 *            the generic type
	 * @param sqldto
	 *            the sqldto
	 * @param cursor
	 *            the cursor
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	private <T> T convertCursor(final SQLDTO sqldto, final Cursor cursor) {
		final T dto = (T) CommonsReflections.createInstance(sqldto.getCacheDTO().getClazz());
		
		for (final String selectField : sqldto.getColumns()) {

			final Field field = sqldto.getMapColumns().get(selectField);

			final Object value = CommonsCursorObject.convertCursorObject(cursor, field, selectField);

			this.setterObject(field, value, dto, sqldto.getCacheDTO().getMapCacheDTO().get(field).getMethodSet());

		}
		
		return dto;
	}
	
	/**
	 * Convert cursor to dto.
	 *
	 * @param <T>
	 *            the generic type
	 * @param sqldto
	 *            the sqldto
	 * @param cursor
	 *            the cursor
	 * @return the t
	 */
	private <T> T convertCursorToDTO(final SQLDTO sqldto, final Cursor cursor) {
		
		T dto = null;
		/** For of columns */
		
		if (cursor.moveToFirst()) {
			dto = this.convertCursor(sqldto, cursor);
			
		}
		return dto;
	}
	
	/**
	 * Convert cursor to ListDto.
	 *
	 * @param <T>
	 *            the generic type
	 * @param sqldto
	 *            the sqldto
	 * @param cursor
	 *            the cursor
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> convertCursorToListDTO(final SQLDTO sqldto, final Cursor cursor) {
		
		final List<T> listDto = new ArrayList<T>();
		/** For of columns */
		
		if (cursor.moveToFirst()) {
			do {
				listDto.add((T) this.convertCursor(sqldto, cursor));
			} while (cursor.moveToNext());
		}
		return listDto;
	}
	
	/**
	 * Delete db.
	 *
	 * @param sqldto
	 *            the sqldto
	 * @param id
	 *            the id
	 */
	private void deleteDB(final SQLDTO sqldto, final int id) {
		if (sqldto != null && id != 0) {
			final SQLiteDatabase sqLiteDatabase = this.arqAndHelper.getWritableDatabase();
			if (sqLiteDatabase != null) {
				sqLiteDatabase.delete(sqldto.getTable(), this.buildWhere(sqldto.getId()), new String[] { String.valueOf(id) });
			}
		}
	}
	
	/**
	 * Gets the id. Get id of Object
	 *
	 * @param sqldto
	 *            the sqldto
	 * @param object
	 *            the object
	 * @return the id
	 */
	private Integer getID(final SQLDTO sqldto, final Object object) {
		final Method getter = sqldto.getCacheDTO().getMapStringField().get(sqldto.getId()).getMethodGet();
		final Object dataReturn = CommonsReflections.returnValue(object, getter);
		if (dataReturn instanceof Integer) {
			return (Integer) dataReturn;
		}
		return null;
	}
	
	/**
	 * Getter object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param field
	 *            the field
	 * @param dto
	 *            the dto
	 * @return the ter object
	 */
	@SuppressWarnings("unchecked")
	private <T, K> String getterObject(final Field field, final T dto) {
		/** If type data not String */
		String data = null;
		
		final Object objeto = CommonsReflections.returnValue(dto, field);
		
		if (objeto instanceof String) {
			data = (String) objeto;
		} else if (objeto != null) {
			
			final ConversionType<String, K> conversionType = (ConversionType<String, K>) this.cacheConversionService.getConversion(field.getType(), String.class);
			
			data = conversionType.conversion((K) objeto);
			
		}
		return data;
	}
	
	/**
	 * Setter object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param <K>
	 *            the key type
	 * @param field
	 *            the field
	 * @param value
	 *            the value
	 * @param dto
	 *            the dto
	 * @param method
	 *            the method
	 */
	@SuppressWarnings("unchecked")
	private <T, K> void setterObject(final Field field, Object value, final T dto, final Method method) {
		/** If type data not String */
		if (!field.getType().isAssignableFrom(value.getClass())) {
			
			final ConversionType<K, String> conversionType = (ConversionType<K, String>) this.cacheConversionService.getConversion(String.class, field.getType());
			
			value = conversionType.conversion((String) value);
		}
		/** Set object */
		CommonsReflections.invokeSetter(method, dto, value);
	}
}
