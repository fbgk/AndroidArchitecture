package org.arqand.android.modal;

import java.util.Calendar;

import org.arqand.android.commons.activity.CommonsActivity;
import org.arqand.android.modal.api.LoadDialog;
import org.arqand.android.modal.dto.DialogDTO;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

/**
 * The Class TimePickerDialogBuilder.
 */
public class TimePickerDialogBuilder implements OnTimeSetListener {

	/** The codigo. */
	private int	codigo;

	/**
	 * Instantiates a new time picker dialog builder.
	 */
	public TimePickerDialogBuilder() {
		this.crearTimeDialog(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true, 0);
	};

	/**
	 * Instantiates a new time picker dialog builder.
	 * 
	 * @param codigo
	 *            the codigo
	 */
	public TimePickerDialogBuilder(final int codigo) {
		this.crearTimeDialog(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true, codigo);
	};

	/**
	 * Instantiates a new time picker dialog builder.
	 * 
	 * @param hourOfDay
	 *            the hour of day
	 * @param minute
	 *            the minute
	 * @param is24HourView
	 *            the is24 hour view
	 */
	public TimePickerDialogBuilder(final int hourOfDay, final int minute, final boolean is24HourView) {
		this.crearTimeDialog(hourOfDay, minute, is24HourView, 0);
	}

	/**
	 * Instantiates a new time picker dialog builder.
	 * 
	 * @param hourOfDay
	 *            the hour of day
	 * @param minute
	 *            the minute
	 * @param is24HourView
	 *            the is24 hour view
	 * @param codigo
	 *            the codigo
	 */
	public TimePickerDialogBuilder(final int hourOfDay, final int minute, final boolean is24HourView, final int codigo) {
		this.crearTimeDialog(hourOfDay, minute, is24HourView, codigo);
	}

	/**
	 * Crear time dialog.
	 * 
	 * @param hourOfDay
	 *            the hour of day
	 * @param minute
	 *            the minute
	 * @param is24HourView
	 *            the is24 hour view
	 * @param codigo
	 *            the codigo
	 */
	private void crearTimeDialog(final int hourOfDay, final int minute, final boolean is24HourView, final int codigo) {
		new TimePickerDialog(CommonsActivity.getActivity(), this, hourOfDay, minute, is24HourView).show();
		this.codigo = codigo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.TimePickerDialog.OnTimeSetListener#onTimeSet(android.widget
	 * .TimePicker, int, int)
	 */
	@Override
	public void onTimeSet(final TimePicker view, final int hourOfDay, final int minute) {
		final DialogDTO<Calendar> dialogDTO = new DialogDTO<Calendar>();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(0, 0, 0, view.getCurrentHour(), view.getCurrentMinute(), 0);
		dialogDTO.setObject(calendar);
		dialogDTO.setCodigo(this.codigo);
		((LoadDialog) CommonsActivity.getActivity()).getterObjectDialog(dialogDTO);
	}

}
