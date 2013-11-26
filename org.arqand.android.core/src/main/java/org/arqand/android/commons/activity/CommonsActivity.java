package org.arqand.android.commons.activity;

import android.app.Activity;

/**
 * Commons for Activity and IVC. Is static.
 */
public class CommonsActivity {

	/** Main activity. */
	private static Activity activity;

	/**
	 * Gets the activity.
	 * 
	 * @return the activity
	 */
	public static Activity getActivity() {
		return activity;
	}

	/**
	 * Sets the activity.
	 * 
	 * @param activity
	 *            the activity
	 */
	public static void setActivity(final Activity activity) {
		CommonsActivity.activity = activity;
	}

}
