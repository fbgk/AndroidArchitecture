package org.arqand.android.orm.api.dto;

import org.arqand.android.orm.api.constants.OrderBy;
import org.arqand.android.orm.api.constants.SQLType;

import android.content.ContentValues;

/**
 * The Class SQLExecuteDTO.
 */
public class SQLExecuteDTO {
	
	/** The conditions. */
	private String[]		conditions;
	
	/** The content values. */
	private ContentValues	contentValues;
	
	/** The field order. */
	private String			fieldOrder;
	
	/** The order by. */
	private OrderBy			orderBy;
	
	/** The sql type. */
	private SQLType			sqlType;
	
	public SQLExecuteDTO() {
	}
	
	public SQLExecuteDTO(String[] conditions, ContentValues contentValues, String fieldOrder, OrderBy orderBy, SQLType sqlType) {
		this.conditions = conditions;
		this.contentValues = contentValues;
		this.fieldOrder = fieldOrder;
		this.orderBy = orderBy;
		this.sqlType = sqlType;
	}
	
	/**
	 * Gets the conditions.
	 * 
	 * @return the conditions
	 */
	public String[] getConditions() {
		return this.conditions;
	}
	
	/**
	 * Gets the content values.
	 * 
	 * @return the content values
	 */
	public ContentValues getContentValues() {
		return this.contentValues;
	}
	
	/**
	 * Gets the field order.
	 * 
	 * @return the field order
	 */
	public String getFieldOrder() {
		return this.fieldOrder;
	}
	
	/**
	 * Gets the order by.
	 * 
	 * @return the order by
	 */
	public OrderBy getOrderBy() {
		return this.orderBy;
	}
	
	/**
	 * Gets the sql type.
	 * 
	 * @return the sql type
	 */
	public SQLType getSqlType() {
		return this.sqlType;
	}
	
	/**
	 * Sets the conditions.
	 * 
	 * @param conditions
	 *            the new conditions
	 */
	public void setConditions(String[] conditions) {
		this.conditions = conditions;
	}
	
	/**
	 * Sets the content values.
	 * 
	 * @param contentValues
	 *            the new content values
	 */
	public void setContentValues(ContentValues contentValues) {
		this.contentValues = contentValues;
	}
	
	/**
	 * Sets the field order.
	 * 
	 * @param fieldOrder
	 *            the new field order
	 */
	public void setFieldOrder(String fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	
	/**
	 * Sets the order by.
	 * 
	 * @param orderBy
	 *            the new order by
	 */
	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * Sets the sql type.
	 * 
	 * @param sqlType
	 *            the new sql type
	 */
	public void setSqlType(SQLType sqlType) {
		this.sqlType = sqlType;
	}
	
}
