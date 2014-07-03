package org.arqand.android.injection.view;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.ImageView;

/**
 * The Class CheckableInjection. This class no return.
 */
public class ImageResourceInjection implements ViewInjectionService<ImageView, Integer> {
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#getInformation( java.lang.Object)
	 */
	@Override
	public Integer getInformation(final ImageView view) {
		return Integer.valueOf(0);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#setInformation( java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final ImageView view, final Integer information) {
		view.setImageResource(information);
	}
}
