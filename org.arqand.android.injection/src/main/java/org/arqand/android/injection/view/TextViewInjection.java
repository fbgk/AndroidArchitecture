package org.arqand.android.injection.view;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.TextView;

/**
 * The Class TextViewInjection.
 */
public class TextViewInjection implements ViewInjectionService<TextView, String> {
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#getInformation( java.lang.Object)
	 */
	@Override
	public String getInformation(final TextView view) {
		return view.getText().toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#setInformation( java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final TextView view, final String information) {
		view.setText(information);
	}
	
}
