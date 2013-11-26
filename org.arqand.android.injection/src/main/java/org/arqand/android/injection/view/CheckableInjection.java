package org.arqand.android.injection.view;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.Checkable;

/**
 * The Class CheckableInjection.
 */
public class CheckableInjection implements ViewInjectionService<Checkable, Boolean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#getInformation(
	 * java.lang.Object)
	 */
	@Override
	public Boolean getInformation(final Checkable view) {

		return view.isChecked();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#setInformation(
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final Checkable view, final Boolean information) {
		view.setChecked(information.booleanValue());
		;
	}
}
