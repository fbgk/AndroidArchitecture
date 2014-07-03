package org.arqand.android.modal;

import org.arqand.android.commons.activity.CommonsActivity;
import org.arqand.android.commons.injection.CommonsInjection;
import org.arqand.android.modal.api.LoadDialog;
import org.arqand.android.modal.dto.DialogDTO;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;

/**
 * The Class DialogBuilder.
 */
public class DialogBuilder implements OnClickListener {
	
	/** The button left. */
	private int				buttonLeft;
	
	/** The button left click. */
	
	private OnClickListener	buttonLeftClick;
	
	/** The button right. */
	private int				buttonRight;
	
	/** The button right click. */
	private OnClickListener	buttonRightClick;
	
	/** The dto. */
	private DialogDTO<?>	dto;
	
	/** The icon. */
	private int				icon;
	
	private LoadDialog		loadDialog;
	
	/** The message. */
	private int				message;
	
	/** The title. */
	private int				title;
	
	/** The view. */
	private int				view;
	
	/** The view object. */
	private View			viewObject;
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param button
	 *            the button
	 * @param message
	 *            the message. Message for modal.
	 */
	public DialogBuilder(final int button, final int message) {
		this.build(0, button, 0, message, null, null, 0, null, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param button
	 *            the button left
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int button, final int view, final DialogDTO<?> dto) {
		this.build(0, button, 0, 0, null, null, view, dto, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param button
	 *            the button left
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int button, final int view, final DialogDTO<?> dto, LoadDialog loadDialog) {
		this.build(0, button, 0, 0, null, null, view, dto, 0, loadDialog);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title. Title for modal.
	 * @param button
	 *            the button
	 * @param message
	 *            the message. Message for modal.
	 */
	public DialogBuilder(final int title, final int button, final int message) {
		this.build(title, button, 0, message, null, null, 0, null, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param button
	 *            the button left
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int title, final int button, final int view, final DialogDTO<?> dto) {
		this.build(title, button, 0, 0, null, null, view, dto, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param button
	 *            the button
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int button, final int view, final DialogDTO<?> dto, final int icon) {
		this.build(title, button, 0, 0, null, null, view, dto, icon, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param button
	 *            the button
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int button, final int view, final DialogDTO<?> dto, final int icon, LoadDialog loadDialog) {
		this.build(title, button, 0, 0, null, null, view, dto, icon, loadDialog);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param button
	 *            the button left
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int title, final int button, final int view, final DialogDTO<?> dto, LoadDialog loadDialog) {
		this.build(title, button, 0, 0, null, null, view, dto, 0, loadDialog);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param button
	 *            the button
	 * @param message
	 *            the message
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int button, final int message, final int icon) {
		this.build(title, button, 0, message, null, null, 0, null, icon, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto) {
		this.build(title, buttonLeft, buttonRight, 0, null, null, view, dto, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto, final int icon) {
		this.build(title, buttonLeft, buttonRight, 0, null, null, view, dto, icon, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto, final int icon, LoadDialog loadDialog) {
		this.build(title, buttonLeft, buttonRight, 0, null, null, view, dto, icon, loadDialog);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto, LoadDialog loadDialog) {
		this.build(title, buttonLeft, buttonRight, 0, null, null, view, dto, 0, loadDialog);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param buttonLeftClick
	 *            the button left click
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto, final OnClickListener buttonLeftClick) {
		this.build(title, buttonLeft, buttonRight, 0, null, buttonLeftClick, view, dto, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param buttonLeftClick
	 *            the button left click
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int view, final DialogDTO<?> dto, final OnClickListener buttonLeftClick, final int icon) {
		this.build(title, buttonLeft, buttonRight, 0, null, buttonLeftClick, view, dto, icon, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param message
	 *            the message
	 * @param buttonRightClick
	 *            the button right click
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int message, final OnClickListener buttonRightClick) {
		this.build(title, buttonLeft, buttonRight, message, buttonRightClick, null, 0, null, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param message
	 *            the message
	 * @param buttonRightClick
	 *            the button right click
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int message, final OnClickListener buttonRightClick, final int icon) {
		this.build(title, buttonLeft, buttonRight, message, buttonRightClick, null, 0, null, icon, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param message
	 *            the message
	 * @param buttonRightClick
	 *            the button right click
	 * @param buttonLeftClick
	 *            the button left click
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int message, final OnClickListener buttonRightClick, final OnClickListener buttonLeftClick) {
		this.build(title, buttonLeft, buttonRight, message, buttonRightClick, buttonLeftClick, 0, null, 0, null);
		this.show();
	}
	
	/**
	 * Instantiates a new dialog builder.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param message
	 *            the message
	 * @param buttonRightClick
	 *            the button right click
	 * @param buttonLeftClick
	 *            the button left click
	 * @param icon
	 *            the icon
	 */
	public DialogBuilder(final int title, final int buttonLeft, final int buttonRight, final int message, final OnClickListener buttonRightClick, final OnClickListener buttonLeftClick, final int icon) {
		this.build(title, buttonLeft, buttonRight, message, buttonRightClick, buttonLeftClick, 0, null, icon, null);
		this.show();
	}
	
	/**
	 * Builds the.
	 * 
	 * @param title
	 *            the title
	 * @param buttonLeft
	 *            the button left
	 * @param buttonRight
	 *            the button right
	 * @param message
	 *            the message
	 * @param buttonRightClick
	 *            the button right click
	 * @param buttonLeftClick
	 *            the button left click
	 * @param view
	 *            the view
	 * @param dto
	 *            the dto
	 * @param icon
	 *            the icon
	 */
	private void build(final int title, final int buttonLeft, final int buttonRight, final int message, final OnClickListener buttonRightClick, final OnClickListener buttonLeftClick, final int view, final DialogDTO<?> dto, final int icon, LoadDialog loadDialog) {
		this.title = title;
		this.buttonLeft = buttonLeft;
		this.buttonRight = buttonRight;
		this.message = message;
		this.buttonRightClick = buttonRightClick;
		this.buttonLeftClick = buttonLeftClick;
		this.view = view;
		this.dto = dto;
		this.icon = icon;
		this.loadDialog = loadDialog;
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.content.DialogInterface.OnClickListener#onClick(android.content .DialogInterface, int)
	 */
	@Override
	public void onClick(final DialogInterface dialog, final int which) {
		Object object = null;
		if (this.dto.getObject() != null) {
			object = CommonsInjection.getInjectionReflectionService().getterVisual(this.dto.getObject().getClass(), this.viewObject);
		}
		final DialogDTO<Object> dialogDTO = new DialogDTO<Object>();
		dialogDTO.setCodigo(this.dto.getCodigo());
		dialogDTO.setObject(object);
		if (this.loadDialog == null) {
			if (CommonsActivity.getActivity() instanceof LoadDialog) {
				((LoadDialog) CommonsActivity.getActivity()).getterObjectDialog(dialogDTO);
			}
		} else {
			this.loadDialog.getterObjectDialog(dialogDTO);
		}
		dialog.cancel();
	}
	
	/**
	 * On create dialog.
	 * 
	 * @param savedInstanceState
	 *            the saved instance state
	 * @return the dialog
	 */
	public void show() {
		AlertDialog.Builder builder = new AlertDialog.Builder(CommonsActivity.getActivity());
		// Title and icon setter
		if (this.title != 0) {
			if (this.icon != 0) {
				builder = builder.setIcon(this.icon);
			}
			builder = builder.setTitle(this.title);
		}
		// Message or View and dto
		if (this.message != 0) {
			builder = builder.setMessage(this.message);
		} else if (this.view != 0) {
			final LayoutInflater vi = (LayoutInflater) CommonsActivity.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.viewObject = vi.inflate(this.view, null);
			CommonsInjection.getInjectionReflectionService().setterVisual(this.dto.getObject(), this.viewObject);
			builder = builder.setView(this.viewObject);
		}
		
		// Button left load
		OnClickListener onClickListener = null;
		if (this.buttonLeftClick == null) {
			onClickListener = new OnClickListener() {
				@Override
				public void onClick(final DialogInterface dialog, final int which) {
					dialog.cancel();
				}
			};
		} else {
			onClickListener = this.buttonLeftClick;
		}
		builder = builder.setNegativeButton(this.buttonLeft, onClickListener);
		
		// Button right load
		if (this.buttonRight != 0) {
			OnClickListener onClickListenerRight = null;
			if (this.buttonRightClick != null) {
				onClickListenerRight = this.buttonRightClick;
			} else {
				onClickListenerRight = this;
			}
			builder = builder.setPositiveButton(this.buttonRight, onClickListenerRight);
		}
		builder.show();
	}
}
