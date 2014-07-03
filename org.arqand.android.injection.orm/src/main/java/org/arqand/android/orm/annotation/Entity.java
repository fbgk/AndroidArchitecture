package org.arqand.android.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Annotation Entity.
 * 
 * Annotation created to indicate that the DTO will have a table.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	
	/**
	 * Value. Name of the table, if you want to give a specific name to put in the value
	 * 
	 * @return the string
	 */
	String value() default "";
	
}
