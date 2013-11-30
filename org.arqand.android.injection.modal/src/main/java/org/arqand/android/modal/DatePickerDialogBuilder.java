package org.arqand.android.modal;

import java.util.Calendar;

import org.arqand.android.commons.activity.CommonsActivity;
import org.arqand.android.modal.api.LoadDialog;
import org.arqand.android.modal.dto.DialogDTO;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

/**
 * The Class DatePickerDialogBuilder.
 */
public class DatePickerDialogBuilder implements OnDateSetListener {
	/** The codigo. */
	private int	codigo;

	/**
	 * Instantiates a new date picker dialog builder.
	 */
	public DatePickerDialogBuilder() {
		this.crearDatePicker(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), 0);
	}

	/**
	 * Instantiates a new date picker dialog builder.
	 * 
	 * @param codigo
	 *            the codigo
	 */
	public DatePickerDialogBuilder(final int codigo) {
		this.crearDatePicker(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), codigo);
	}

	/**
	 * Instantiates a new date picker dialog builder.
	 * 
	 * @param year
	 *            the year
	 * @param monthOfYear
	 *            the month of year
	 * @param dayOfMonth
	 *            the day of month
	 */
	public DatePickerDialogBuilder(final int year, final int monthOfYear, final int dayOfMonth) {
		this.crearDatePicker(year, monthOfYear, dayOfMonth, 0);
	}

	/**
	 * Instantiates a new date picker dialog builder.
	 * 
	 * @param year
	 *            the year
	 * @param monthOfYear
	 *            the month of year
	 * @param dayOfMonth
	 *            the day of month
	 * @param codigo
	 *            the codigo
	 */
	public DatePickerDialogBuilder(final int year, final int monthOfYear, final int dayOfMonth, final int codigo) {
		this.crearDatePicker(year, monthOfYear, dayOfMonth, codigo);
	}

	/**
	 * Crear time dialog.
	 * 
	 * @param year
	 *            the year
	 * @param monthOfYear
	 *            the month of year
	 * @param dayOfMonth
	 *            the day of month
	 * @param codigo
	 *            the codigo
	 */
	private void crearDatePicker(final int year, final int monthOfYear, final int dayOfMonth, final int codigo) {
		new DatePickerDialog(CommonsActivity.getActivity(), this, year, monthOfYear, dayOfMonth).show();
		this.codigo = codigo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.DatePickerDialog.OnDateSetListener#onDateSet(android.widget
	 * .DatePicker, int, int, int)
	 */
	@Override
	public void onDateSet(final DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
		final DialogDTO<Calendar> dialogDTO = new DialogDTO<Calendar>();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
		dialogDTO.setObject(calendar);
		dialogDTO.setCodigo(this.codigo);
		((LoadDialog) CommonsActivity.getActivity()).getterObjectDialog(dialogDTO);
	}

}
