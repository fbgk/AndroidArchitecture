package org.arqand.android.injection.listadapter.api;

/**
 * The Interface ListViewHeader.
 */
public interface ListViewHeader {
	
	/**
	 * Group view. Grouped by the object returned by the interface
	 * 
	 * @param itemViewID
	 *            the item view id
	 * @param headerViewID
	 *            the header view id
	 * @return the object
	 */
	public Object groupView(int itemViewID, int headerViewID);
	
	/**
	 * Type item list. Type item in the list
	 * 
	 * @param itemViewID
	 *            the item view id
	 * @param headerViewID
	 *            the header view id
	 * @return the type list
	 */
	public TypeList typeItemList(int itemViewID, int headerViewID);
	
}
