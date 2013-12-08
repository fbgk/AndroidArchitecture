package org.arqand.android.injection.listadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arqand.android.commons.injection.CommonsInjection;
import org.arqand.android.injection.listadapter.api.ListViewHeader;
import org.arqand.android.injection.listadapter.api.TypeList;

import android.view.View;
import android.view.ViewGroup;

/**
 * The Class ListViewHeaderAdapter.
 */
public class ListViewHeaderAdapter extends ListViewAdapter<ListViewHeader> {

	/** The view header. */
	protected int	viewHeader;

	/**
	 * Instantiates a new list view header adapter.
	 * 
	 * @param header
	 *            the header
	 * @param listView
	 *            the list view
	 * @param noHeader
	 *            the no header
	 * @param loadList
	 *            the load list
	 */
	public ListViewHeaderAdapter(int header, int listView, ListViewHeader noHeader, List<ListViewHeader> loadList) {
		super(listView, loadList);
		this.viewHeader = header;
		this.listAdapter.add(noHeader);
		this.orderList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.arqand.android.injection.listadapter.ListViewAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (this.mapView.get(position) != null) {
			convertView = this.mapView.get(position);
		} else {
			ListViewHeader listViewHeader = this.listAdapter.get(position);

			if (TypeList.HEADER.equals(listViewHeader.typeItemList(this.viewId, this.viewHeader))) {
				convertView = this.layoutInflater.inflate(this.viewHeader, null);
			} else {
				convertView = this.layoutInflater.inflate(this.viewId, null);
			}
			CommonsInjection.getInjectionReflectionService().setterVisual(listViewHeader, convertView);
			this.mapView.put(Integer.valueOf(position), convertView);
		}
		return convertView;
	}

	/**
	 * Order list.
	 * 
	 * @param noHeader
	 *            the no header
	 */
	private void orderList() {
		Map<Object, List<ListViewHeader>> mapList = new HashMap<Object, List<ListViewHeader>>();
		Map<Object, ListViewHeader> mapHeader = new HashMap<Object, ListViewHeader>();

		for (ListViewHeader listViewHeader : this.listAdapter) {

			Object group = listViewHeader.groupView(this.viewId, this.viewHeader);
			TypeList typeList = listViewHeader.typeItemList(this.viewId, this.viewHeader);

			if (TypeList.HEADER.equals(typeList)) {

				mapHeader.put(group, listViewHeader);

			} else if (mapList.containsKey(group)) {

				mapList.get(group).add(listViewHeader);

			} else {

				List<ListViewHeader> listView = new ArrayList<ListViewHeader>();
				listView.add(listViewHeader);
				mapList.put(group, listView);

			}
		}
		this.listAdapter.clear();
		for (Object object : mapHeader.keySet()) {
			if (mapList.get(object) != null) {
				this.listAdapter.add(mapHeader.get(object));
				this.listAdapter.addAll(mapList.get(object));
			}
		}

	}

}
