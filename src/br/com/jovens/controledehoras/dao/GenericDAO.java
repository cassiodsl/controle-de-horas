package br.com.jovens.controledehoras.dao;

import android.content.Context;
import br.com.jovens.controledehoras.database.ControleHorasContract;
import br.com.jovens.controledehoras.database.DataBaseHelper;

public abstract class GenericDAO<T> {
	
	DataBaseHelper dbHelper;
	
	public GenericDAO(Context context){
		dbHelper = new DataBaseHelper(context);
	}
}
