package org.arqand.android.injection.listadapter.comparator;

import java.util.Comparator;

import org.arqand.android.injection.listadapter.api.ListViewHeader;
import org.arqand.android.injection.listadapter.api.TypeList;

/**
 * The Class ComparatorHeader.
 */
public class ComparatorHeader implements Comparator<ListViewHeader> {

	/** The header id. */
	private final int	headerId;

	/** The view id. */
	private final int	viewId;

	/**
	 * Instantiates a new comparator header.
	 * 
	 * @param headerId
	 *            the header id
	 * @param viewId
	 *            the view id
	 */
	public ComparatorHeader(int headerId, int viewId) {
		super();
		this.headerId = headerId;
		this.viewId = viewId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ListViewHeader o1, ListViewHeader o2) {

		Object object1 = o1.groupView(this.viewId, this.headerId);
		Object object2 = o2.groupView(this.viewId, this.headerId);

		int comparator = -1;

		if (object1.equals(object2)) {
			comparator = 0;
			if (TypeList.HEADER.equals(o1.typeItemList(this.viewId, this.headerId))) {
				comparator = 1;
				// } else if (TypeList.HEADER.equals(o2.typeItemList(this.viewId, this.headerId))) {
				// comparator = 1;
			}
		}
		return comparator;
	}
}
