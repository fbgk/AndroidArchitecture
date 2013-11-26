package org.arqand.android.injection.view;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.ProgressBar;

/**
 * The Class ProgressBarInjection.
 */
public class ProgressBarInjection implements ViewInjectionService<ProgressBar, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#getInformation(
	 * java.lang.Object)
	 */
	@Override
	public Integer getInformation(final ProgressBar view) {
		return Integer.valueOf(view.getProgress());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#setInformation(
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final ProgressBar view, final Integer information) {
		view.setProgress(information);
	}

}
