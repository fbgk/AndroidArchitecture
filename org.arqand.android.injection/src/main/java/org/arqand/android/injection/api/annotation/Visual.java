package org.arqand.android.injection.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to indicate the id of the view, and if it can be null.
 * 
 * @author fbgk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Visual {
	
	/**
	 * Indicates whether a field can be null. The default is set to true.
	 * 
	 * @return true, if is null
	 */
	boolean isNull() default true;
	
	/**
	 * Checks if is password.
	 * 
	 * @return true, if is password
	 */
	boolean isPassword() default false;
	
	/**
	 * IDs for the view.
	 * 
	 * @return the int[]
	 */
	int[] value();
	
}
