package org.arqand.android.orm.impl;

import org.arqand.android.commons.activity.CommonsActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ArqAndHelper extends SQLiteOpenHelper {
	
	public ArqAndHelper() {
		super(CommonsActivity.getActivity(), "BD", null, 1);
	}
	
	@Override
	public void onCreate(final SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUpgrade(final SQLiteDatabase arg0, final int arg1, final int arg2) {
		// TODO Auto-generated method stub
		
	}
	
}
