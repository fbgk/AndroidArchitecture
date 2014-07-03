package org.arqand.android.injection.view;

import java.util.Calendar;

import org.arqand.android.injection.api.ViewInjectionService;

import android.widget.TimePicker;

/**
 * The Class TimePickerInjection.
 */
public class TimePickerInjection implements ViewInjectionService<TimePicker, Calendar> {
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#getInformation( java.lang.Object)
	 */
	@Override
	public Calendar getInformation(final TimePicker view) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(0, 0, 0, view.getCurrentHour(), view.getCurrentMinute(), 0);
		return calendar;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.arqand.android.injection.api.ViewInjectionService#setInformation( java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setInformation(final TimePicker view, final Calendar information) {
		view.setCurrentHour(information.get(Calendar.HOUR_OF_DAY));
		view.setCurrentMinute(information.get(Calendar.MINUTE));
	}
	
}
