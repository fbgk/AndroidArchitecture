package org.arqand.android.injection.orm.view;

import java.util.List;

import org.arqand.android.commons.injection.CommonsInjection;
import org.arqand.android.orm.api.BaseDao;
import org.arqand.android.orm.exception.ExceptionNullData;
import org.arqand.android.orm.impl.BaseDaoImpl;

/**
 * The Class CommonsOrmViewService. Utils for ORM with views.
 */
public class CommonsOrmViewService {

	/**
	 * Getter view orm.
	 *
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            clazz for the data
	 * @return the ter view orm
	 * @throws ExceptionNullData. Exception
	 *             for a data null.
	 */
	public static <T> T getViewOrm(final Class<T> clazz) throws ExceptionNullData {
		final T data = CommonsInjection.getInjectionReflectionService().getterVisual(clazz);
		if (data != null) {
			final BaseDao baseDao = new BaseDaoImpl();
			baseDao.save(data);
		}
		return data;
	}

	/**
	 * Getter view orm. Getter view to class, save information.
	 *
	 * @param <T>
	 *            Type class
	 * @param view
	 *            View where is load information
	 * @param clazz
	 *            Class get information
	 * @return Object for the clazz
	 */
	public static <T> T getViewOrm(final int view, final Class<T> clazz) {
		
	}
	
	/**
	 * Getter view orm.
	 *
	 * @param <T>
	 *            the generic type
	 * @param view
	 *            the view
	 * @param object
	 *            the object
	 * @return the ter view orm
	 */
	public static <T> T getViewOrm(final int view, final T object) {
		
	}
	
	/**
	 * Getter view orm.
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return the ter view orm
	 * @throws ExceptionNullData. Exception
	 *             for a data null.
	 */
	public static <T> T getViewOrm(final T object) throws ExceptionNullData {
		final T data = CommonsInjection.getInjectionReflectionService().getterVisual(Object.class);
		if (data != null) {
			final BaseDao baseDao = new BaseDaoImpl();
			baseDao.save(data);
		}
		return data;
	}
	
	/**
	 * Load all in list view.
	 *
	 * @param clazz
	 *            the clazz
	 * @return true, if load all in list view
	 */
	public static Boolean loadAllInListView(final Class<?> clazz) {
		
	}

	/**
	 * Load all in list view.
	 *
	 * @param clazz
	 *            the clazz
	 * @param view
	 *            the view
	 * @return true, if load all in list view
	 */
	public static Boolean loadAllInListView(final Class<?> clazz, final int view) {
		
	}

	/**
	 * Load objects in list view.
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return true, if load objects in list view
	 */
	public static <T> Boolean loadObjectsInListView(final List<T> object) {
		
	}

	/**
	 * Load objects in list view.
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @param view
	 *            the view
	 * @return true, if load objects in list view
	 */
	public static <T> Boolean loadObjectsInListView(final List<T> object, final int view) {
		
	}

	/**
	 * Load view orm.
	 *
	 * @param clazz
	 *            the clazz
	 * @param id
	 *            the id
	 * @return true, if load view orm
	 */
	public static Boolean loadViewOrm(final Class<?> clazz, final int id) {

	}

	/**
	 * Load view orm.
	 *
	 * @param View
	 *            the View
	 * @param clazz
	 *            the clazz
	 * @param id
	 *            the id
	 * @return true, if load view orm
	 */
	public static Boolean loadViewOrm(final int View, final Class<?> clazz, final int id) {

	}
	
	/**
	 * Load view orm.
	 *
	 * @param <T>
	 *            the generic type
	 * @param View
	 *            the View
	 * @param objeto
	 *            the objeto
	 * @return true, if load view orm
	 */
	public static <T> Boolean loadViewOrm(final int View, final T objeto) {
		
	}
	
	/**
	 * Load view orm.
	 *
	 * @param <T>
	 *            the generic type
	 * @param objeto
	 *            the objeto
	 * @return true, if load view orm
	 */
	public static <T> Boolean loadViewOrm(final T objeto) {
		
	}

	private static String	TAG	= CommonsOrmViewService.class.toString();

}
