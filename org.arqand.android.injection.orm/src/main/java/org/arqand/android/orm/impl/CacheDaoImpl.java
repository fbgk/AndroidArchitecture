package org.arqand.android.orm.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.arqand.android.commons.cache.CommonsCache;
import org.arqand.android.commons.reflections.CommonsReflections;
import org.arqand.android.field.cache.api.CacheDTOService;
import org.arqand.android.field.cache.impl.CacheDTOServiceImpl;
import org.arqand.android.orm.annotation.Column;
import org.arqand.android.orm.annotation.Entity;
import org.arqand.android.orm.annotation.PrimaryKey;
import org.arqand.android.orm.api.CacheDao;
import org.arqand.android.orm.api.dto.SQLDTO;

public class CacheDaoImpl implements CacheDao {
	
	private static final String		CACHE_STRING	= CacheDao.class.getCanonicalName();
	
	static {
		CommonsCache.addCache(CacheDaoImpl.CACHE_STRING, new HashMap<String, SQLDTO>());
	}
	
	private final CacheDTOService	cacheDTOService	= CacheDTOServiceImpl.getInstance();
	
	/**
	 * Creates the sqldto.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the sqldto
	 */
	@SuppressWarnings("unchecked")
	private SQLDTO createSQLDTO(final Class<?> clazz) {
		
		SQLDTO sqldto = null;
		
		final Entity entity = clazz.getAnnotation(Entity.class);
		
		/** Search Entity */
		
		if (entity != null) {
			final Map<String, SQLDTO> mapeo = (Map<String, SQLDTO>) CommonsCache.getCacheMap(CacheDaoImpl.CACHE_STRING);
			
			sqldto = new SQLDTO();
			
			sqldto.setCacheDTO(this.cacheDTOService.getValue(clazz));
			
			mapeo.put(clazz.getCanonicalName(), sqldto);
			/** Initialize Map and List */
			sqldto.setListNull(new ArrayList<String>());
			sqldto.setMapColumns(new HashMap<String, Field>());
			sqldto.setMapDTO(new HashMap<String, SQLDTO>());
			
			/** Set name entity */
			sqldto.setTable(clazz.getSimpleName());
			
			if (!entity.value().isEmpty()) {
				sqldto.setTable(entity.value());
			}
			
			for (final Field field : CommonsReflections.returnFields(clazz)) {
				
				final Column column = field.getAnnotation(Column.class);
				/** Search annotation Column */
				if (column != null) {
					
					/** Column name */
					String name = field.getName();
					if (!column.value().isEmpty()) {
						name = column.value();
					}
					
					/** ID table */
					if (field.isAnnotationPresent(PrimaryKey.class)) {
						sqldto.setId(name);
					}
					
					/** Maps Column and Field */
					sqldto.getMapColumns().put(name, field);
					
					/** If it is null */
					if (column.isNull()) {
						sqldto.getListNull().add(name);
					}
					
					/** If field is annotation entity present,It is a DTO */
					if (field.getType().isAnnotationPresent(Entity.class)) {
						SQLDTO sqldto2 = mapeo.get(field.getType().getCanonicalName());
						if (sqldto2 == null) {
							sqldto2 = this.createSQLDTO(field.getType());
						}
						sqldto.getMapDTO().put(name, sqldto2);
					}
					/** TODO: See list object */
					
				}
			}
			
			sqldto.setColumns(sqldto.getMapColumns().keySet().toArray(new String[sqldto.getMapColumns().size()]));
			
		}
		
		return sqldto;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.orm.api.CacheDao#getCache(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public SQLDTO getCache(final Class<?> clazz) {
		
		final Map<String, SQLDTO> mapeo = (Map<String, SQLDTO>) CommonsCache.getCacheMap(CacheDaoImpl.CACHE_STRING);
		
		SQLDTO sqldto = mapeo.get(clazz.getCanonicalName());
		
		if (sqldto == null) {
			sqldto = this.createSQLDTO(clazz);
		}
		
		return sqldto;
	}
	
}
