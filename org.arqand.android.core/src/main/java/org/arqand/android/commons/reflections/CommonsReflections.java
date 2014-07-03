package org.arqand.android.commons.reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.arqand.android.commons.activity.CommonsActivity;

import android.content.Context;

/**
 * Created by fbgk on 12/11/2013
 * 
 * Commons Class for Reflections Java.
 */
public class CommonsReflections {
	
	/** The Constant GETTER_CONSTANT. */
	private static final String	GETTER_CONSTANT	= "get";
	
	/** The Constant SETTER_CONSTANT. */
	private static final String	SETTER_CONSTANT	= "set";
	
	/**
	 * New instance's class.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            It create one instance for class
	 * @return a instance for class or null
	 */
	public static <T> T createInstance(final Class<T> clazz) {
		
		T object = null;
		try {
			object = clazz.newInstance();
			
		} catch (final InstantiationException e) {
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		}
		if (object == null) {
			try {
				object = clazz.getDeclaredConstructor(Context.class).newInstance(CommonsActivity.getActivity());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return object;
	}
	
	/**
	 * Returns the method according to the field.
	 * 
	 * @param field
	 *            the field
	 * @param object
	 *            Object of which is to recover
	 * @return the method to retrieve the object
	 */
	public static Method getterMethod(final String field, final Object object) {
		
		return methodGetter(GETTER_CONSTANT, field, object);
	}
	
	/**
	 * Invokes the setter method of the actual field.
	 * 
	 * @param field
	 *            Field object is inserted.
	 * @param source
	 *            The object on which the data is inserted.
	 * @param objeto
	 *            Value of the object.
	 */
	public static void invokeSetter(final Field field, final Object source, final Object objeto) {
		
		try {
			final Method metodo = methodGetter(SETTER_CONSTANT, field.getName(), source);
			if (metodo != null) {
				metodo.invoke(source, objeto);
			}
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Invokes the setter method of the actual field.
	 * 
	 * @param metodo
	 *            the metodo
	 * @param object
	 *            the object
	 * @param objeto
	 *            Value of the object.
	 */
	public static void invokeSetter(final Method metodo, final Object object, final Object args) {
		
		try {
			metodo.invoke(object, args);
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method getter. We recover the data needed. In this case the method.
	 * 
	 * @param type
	 *            the type get or set
	 * @param field
	 *            the field
	 * @param object
	 *            the object
	 * @return the method
	 */
	private static Method methodGetter(final String type, final String field, final Object object) {
		final String stringMetodo = String.format("%s%C%s", type, field.charAt(0), field.substring(1));
		Method method = null;
		Class<?> clazz;
		if (object instanceof Class<?>) {
			clazz = (Class<?>) object;
		} else {
			clazz = object.getClass();
		}
		try {
			if (GETTER_CONSTANT.equals(type)) {
				
				method = clazz.getMethod(stringMetodo);
				
			} else {
				
				final Iterator<Method> iterator = Arrays.asList(clazz.getDeclaredMethods()).iterator();
				while (iterator.hasNext() && method == null) {
					
					final Method comparator = iterator.next();
					
					if (comparator.getName().equals(stringMetodo)) {
						method = comparator;
					}
				}
			}
		} catch (final NoSuchMethodException e) {
			e.printStackTrace();
		}
		return method;
	}
	
	/**
	 * The annotation will return or not according to this last field.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param anotacion
	 *            The annotation you want to recover
	 * @param field
	 *            Where is the annotation class
	 * @return the annotation of object or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T returnAnnotation(final Class<? extends Annotation> anotacion, final Field field) {
		
		T respuesta = null;
		if (anotacion != null && field != null) {
			if (field.isAnnotationPresent(anotacion)) {
				respuesta = (T) field.getAnnotation(anotacion);
			}
		}
		return respuesta;
	}
	
	/**
	 * The annotation will return or not according to this last class.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            Where is the annotation class
	 * @param annotation
	 *            the annotation
	 * @return the annotation of object or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T returnAnnotation(final Class<?> clazz, final Class<? extends Annotation> annotation) {
		
		T respuesta = null;
		if (annotation != null && clazz != null) {
			if (clazz.isAnnotationPresent(annotation)) {
				respuesta = (T) clazz.getAnnotation(annotation);
			}
		}
		return respuesta;
	}
	
	/**
	 * From the name of the class returns the class.
	 * 
	 * @param data
	 *            The name for class
	 * @return the class or null
	 */
	public static Class<?> returnClass(final String data) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(data);
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
	}
	
	/**
	 * Returns the field as the field name.
	 * 
	 * @param name
	 *            the name
	 * @param clazz
	 *            The field name
	 * @return the Field or null
	 */
	public static Field returnField(final String name, final Class<?> clazz) {
		Field field = null;
		try {
			field = clazz.getDeclaredField(name);
		} catch (final SecurityException e) {
			
		} catch (final NoSuchFieldException e) {
			
		}
		return field;
	}
	
	/**
	 * Return fields.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the list
	 */
	public static List<Field> returnFields(final Class<?> clazz) {
		return Arrays.asList(clazz.getDeclaredFields());
	}
	
	/**
	 * Returns the method according to the field.
	 * 
	 * @param field
	 *            Field you want to retrieve the default method
	 * @param object
	 *            Object of which is to recover
	 * @return the method to retrieve the object
	 */
	public static Method returnMethod(final Field field, final Object object) {
		return getterMethod(field.getName(), object);
	}
	
	/**
	 * Return method class.
	 * 
	 * @param object
	 *            the object
	 * @param method
	 *            the method
	 * @return the class
	 */
	public static Class<?> returnMethodClass(final Object object, final String method) {
		final Method[] metodos = object.getClass().getMethods();
		Boolean bandera = Boolean.FALSE;
		Class<?> clazzs = null;
		for (int x = 0; x < metodos.length && !bandera; x++) {
			if (metodos[x].getName().equals(method) && !metodos[x].isBridge()) {
				bandera = Boolean.TRUE;
				clazzs = metodos[x].getReturnType();
			}
		}
		return clazzs;
	}
	
	/**
	 * Retrieves the value of an object according to the field.
	 * 
	 * @param objeto
	 *            Object of which is to recover
	 * @param field
	 *            Campo who is recovering
	 * @return the field object or null
	 */
	public static Object returnValue(final Object objeto, final Field field) {
		
		Object object = null;
		final Method metodo = returnMethod(field, objeto);
		if (metodo != null) {
			object = returnValue(objeto, metodo);
		}
		return object;
	}
	
	/**
	 * Retrieves the value of an object according to the field.
	 * 
	 * @param baseDTO
	 *            the base dto
	 * @param method
	 *            Method which retrieves the object
	 * @return the field object or null
	 */
	public static Object returnValue(final Object baseDTO, final Method method) {
		
		Object objeto = null;
		try {
			objeto = method.invoke(baseDTO);
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}
		return objeto;
	}
	
	/**
	 * Value method. Based on a method name, the method retrieves the data
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @param methodName
	 *            the method name
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public static <T> T returnValueMethod(final Object object, final String methodName) {
		T value = null;
		try {
			final Method method = object.getClass().getMethod(methodName);
			if (method != null) {
				value = (T) returnValue(object, method);
			}
		} catch (final SecurityException e) {
			e.printStackTrace();
		} catch (final NoSuchMethodException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * Returns the method according to the field.
	 * 
	 * @param field
	 *            Field you want to retrieve the default method
	 * @param object
	 *            Object of which is to recover
	 * @return the method to retrieve the object
	 */
	public static Method setterMethod(final Field field, final Object object) {
		
		return methodGetter(SETTER_CONSTANT, field.getName(), object);
	}
	
	/**
	 * Returns the method according to the field.
	 * 
	 * @param field
	 *            Field you want to retrieve the default method
	 * @param object
	 *            Object of which is to recover
	 * @return the method to retrieve the object
	 */
	public static Method setterMethod(final String field, final Object object) {
		
		return methodGetter(SETTER_CONSTANT, field, object);
	}
	
	/**
	 * Value method. Based on a method name, the object inserted into the data set
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @param methodName
	 *            the method name
	 * @param value
	 *            the value
	 * @return the t
	 */
	public static <T> void setterValueMethod(final Object object, final String methodName, final T value) {
		try {
			Method method = null;
			final Method[] methods = object.getClass().getMethods();
			for (int x = 0; x < methods.length && method == null; x++) {
				if (methods[x].getName().equals(method) && !methods[x].isBridge()) {
					method = methods[x];
				}
			}
			if (method != null) {
				invokeSetter(method, object, value);
			}
		} catch (final SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Value method. Based on a method name, the object inserted into the data set
	 * 
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @param methodName
	 *            the method name
	 * @param value
	 *            the value
	 * @return the t
	 */
	public static <T> void setterValueMethod(final Object object, final Method methodName, final T value) {
		try {
			if (methodName != null) {
				invokeSetter(methodName, object, value);
			}
		} catch (final SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Up classes method.From the name of the method and the object is retrieved from the call classes
	 * 
	 * @param object
	 *            the object
	 * @param method
	 *            the method
	 * @return the class[] or null
	 */
	public static Class<?>[] upClassesMethod(final Object object, final String method) {
		final Method[] methods = object.getClass().getMethods();
		Boolean flags = Boolean.FALSE;
		Class<?>[] clazzs = null;
		for (int x = 0; x < methods.length && !flags; x++) {
			if (methods[x].getName().equals(method) && !methods[x].isBridge()) {
				flags = Boolean.TRUE;
				clazzs = methods[x].getParameterTypes();
			}
		}
		return clazzs;
	}
	
}
