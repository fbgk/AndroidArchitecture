package org.arqand.android.injection.view;

import org.arqand.android.injection.api.ViewInjectionService;

import android.net.Uri;
import android.widget.ImageView;

/**
 * The Class CheckableInjection. This class no return.
 */
public class ImageStringInjection implements ViewInjectionService<ImageView, String> {
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#getInformation( java.lang.Object)
	 */
	@Override
	public String getInformation(final ImageView view) {
		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#setInformation( java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final ImageView view, final String information) {
		view.setImageURI(Uri.parse(information));
	}
}
