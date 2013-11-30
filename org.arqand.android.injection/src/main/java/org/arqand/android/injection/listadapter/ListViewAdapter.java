package org.arqand.android.injection.listadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arqand.android.commons.activity.CommonsActivity;
import org.arqand.android.commons.injection.CommonsInjection;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by fbgk on 26/11/13.
 * 
 * @param <T>
 *            the generic type
 */
public class ListViewAdapter<T> extends ArrayAdapter<T> {

	/** The Constant TAG. */
	private static final String TAG = ListViewAdapter.class.getName();

	/** The vi. */
	private final LayoutInflater layoutInflater = (LayoutInflater) CommonsActivity.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	/** The lista adaptadores. */
	private final List<T> listAdapter;

	/** The list view. Cache */
	private final Map<Integer,View> mapView;

	/** The view id. */
	private final int viewId;

	/**
	 * Instantiates a new commons list view impl.
	 * 
	 * @param resource
	 *            the resource
	 * @param loadList
	 *            the load list
	 */
	public ListViewAdapter(final int resource, final List<T> loadList) {
		super(CommonsActivity.getActivity(), resource, loadList);
		this.listAdapter = loadList;
		this.viewId = resource;
		this.mapView = new HashMap<Integer, View>(loadList.size());
		Log.i(TAG, "Load ListViewAdapter");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(final int position, View convertView, final ViewGroup parent) {
		Log.i(TAG, "Load Data");
		if (this.mapView.get(position) != null) {
			Log.i(TAG, "Load Cache");
			convertView = this.mapView.get(position);
		} else {
			Log.i(TAG, "Load View Inject");
			convertView = this.layoutInflater.inflate(this.viewId, null);
			CommonsInjection.getInjectionReflectionService().setterVisual(this.listAdapter.get(position), convertView);
			this.mapView.put(Integer.valueOf(position), convertView);
		}
		return convertView;
	}
}
