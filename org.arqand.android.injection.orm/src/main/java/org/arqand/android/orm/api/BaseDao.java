package org.arqand.android.orm.api;

import java.util.List;

import org.arqand.android.orm.api.constants.OrderBy;
import org.arqand.android.orm.exception.ExceptionNullData;

/**
 * The Interface BaseDao.
 * 
 * Basic interface for creating the data needed to access the DB
 */
public interface BaseDao {
	
	/**
	 * Consult a data from id and object class
	 * 
	 * @param <T>
	 *            the generic type
	 * @param id
	 *            the id
	 * @param clazz
	 *            the clazz
	 * @return the t
	 */
	public <T> T consult(Class<T> clazz, int id);
	
	/**
	 * Consult a data from object with PrimaryKey
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return the t
	 */
	public <T> T consult(T object);
	
	/**
	 * Delete. Delete a data from id and object class
	 * 
	 * @param <T>
	 *            the generic type
	 * @param id
	 *            the id
	 * @param clazz
	 *            the clazz
	 */
	public <T> void delete(Class<T> clazz, int id);
	
	/**
	 * Delete. Delete a data from object with PrimaryKey
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 */
	public <T> void delete(T object);
	
	/**
	 * Save. Save data (Insert or Modify)
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return the t
	 * @throws ExceptionNullData
	 */
	public <T> T save(T object) throws ExceptionNullData;
	
	/**
	 * Search. Search data
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return the list
	 */
	public <T> List<T> search(T object);
	
	/**
	 * Search. Searh data by object and order by field
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @param orderBy
	 *            the order by
	 * @param fieldOrderBy
	 *            the field order by
	 * @return the list
	 */
	public <T> List<T> search(T object, OrderBy orderBy, String fieldOrderBy);
	
	/**
	 * Search all. Search all result.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the clazz
	 * @return the list
	 */
	public <T> List<T> searchAll(Class<T> clazz);
	
	/**
	 * Search all. Search all result, with order by for field.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the clazz
	 * @return the list
	 */
	public <T> List<T> searchAll(Class<T> clazz, OrderBy orderBy, String fieldOrderBy);
	
	/**
	 * Create a database with class.
	 * 
	 * @param classes
	 */
	public void createDataBase(Class<?>... classes);
	
}
