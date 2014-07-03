package org.arqand.android.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Annotation Column.
 * 
 * Registration will be created to indicate that a column for the <code>@Entity</code> within the class.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	/**
	 * Checks that the data(field) is not null when being inserted or updated
	 * 
	 * Default is false
	 * 
	 * @return true, if is null
	 */
	boolean isNull() default false;
	
	/**
	 * Name of the column that you want to give (if not put any field name will be used)
	 * 
	 * @return the string
	 */
	String value() default "";
	
}
