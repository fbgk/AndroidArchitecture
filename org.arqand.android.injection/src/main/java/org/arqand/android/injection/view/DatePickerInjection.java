package org.arqand.android.injection.view;

import java.util.Calendar;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.DatePicker;

/**
 * The Class DatePickerInjection.
 */
public class DatePickerInjection implements ViewInjectionService<DatePicker, Calendar> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#getInformation(
	 * java.lang.Object)
	 */
	@Override
	public Calendar getInformation(final DatePicker view) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(view.getYear(), view.getMonth(), view.getDayOfMonth(), 0, 0, 0);
		return calendar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.arqand.android.injection.api.ViewInjectionService#setInformation(
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final DatePicker view, final Calendar information) {
		view.updateDate(information.get(Calendar.YEAR), information.get(Calendar.MONTH), information.get(Calendar.DAY_OF_MONTH));
	}

}
