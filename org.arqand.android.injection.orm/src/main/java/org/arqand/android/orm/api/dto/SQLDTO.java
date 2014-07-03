package org.arqand.android.orm.api.dto;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.arqand.android.field.cache.api.dto.CacheDTO;

/**
 * The Class SQLDTO. Cache SQL.
 */
public class SQLDTO {
	
	/** The cache dto. */
	private CacheDTO			cacheDTO;
	
	/** The columns. */
	private String[]			columns;
	
	/** The id. */
	private String				id;
	
	/** The list null. Field null */
	private List<String>		listNull;
	
	/** The map columns. */
	private Map<String, Field>	mapColumns;
	
	/** The map columns. */
	private Map<String, SQLDTO>	mapDTO;
	
	/** The table. */
	private String				table;
	
	/**
	 * Gets the cache dto.
	 * 
	 * @return the cache dto
	 */
	public CacheDTO getCacheDTO() {
		return this.cacheDTO;
	}
	
	/**
	 * Gets the columns.
	 * 
	 * @return the columns
	 */
	public String[] getColumns() {
		return this.columns;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Gets the list null.
	 * 
	 * @return the list null
	 */
	public List<String> getListNull() {
		return this.listNull;
	}
	
	/**
	 * Gets the map columns.
	 * 
	 * @return the map columns
	 */
	public Map<String, Field> getMapColumns() {
		return this.mapColumns;
	}
	
	/**
	 * Gets the map dto.
	 * 
	 * @return the map dto
	 */
	public Map<String, SQLDTO> getMapDTO() {
		return this.mapDTO;
	}
	
	/**
	 * Gets the table.
	 * 
	 * @return the table
	 */
	public String getTable() {
		return this.table;
	}
	
	/**
	 * Sets the cache dto.
	 * 
	 * @param cacheDTO
	 *            the new cache dto
	 */
	public void setCacheDTO(CacheDTO cacheDTO) {
		this.cacheDTO = cacheDTO;
	}
	
	/**
	 * Sets the columns.
	 * 
	 * @param columns
	 *            the new columns
	 */
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Sets the list null.
	 * 
	 * @param listNull
	 *            the new list null
	 */
	public void setListNull(List<String> listNull) {
		this.listNull = listNull;
	}
	
	/**
	 * Sets the map columns.
	 * 
	 * @param mapColumns
	 *            the map columns
	 */
	public void setMapColumns(Map<String, Field> mapColumns) {
		this.mapColumns = mapColumns;
	}
	
	/**
	 * Sets the map dto.
	 * 
	 * @param mapDTO
	 *            the map dto
	 */
	public void setMapDTO(Map<String, SQLDTO> mapDTO) {
		this.mapDTO = mapDTO;
	}
	
	/**
	 * Sets the table.
	 * 
	 * @param table
	 *            the new table
	 */
	public void setTable(String table) {
		this.table = table;
	}
	
}
