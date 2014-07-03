package br.com.jovens.controledehoras.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.jovens.controledehoras.database.DataBaseHelper;
import br.com.jovens.controledehoras.database.ControleHorasContract.TabelaApontamento;
import br.com.jovens.controledehoras.entity.ApontamentoEntity;

public class ApontamentoDAO {
	
	DataBaseHelper dbHelper;
	
	public ApontamentoDAO(Context context){
		dbHelper = new DataBaseHelper(context);
	}
	
	public Long save(ApontamentoEntity apontamento){
		Long newRowId = 0L;
		try {
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			
			ContentValues values = new ContentValues();
			values.put(TabelaApontamento.COLUMN_NAME_APONTAMENTO_ID, apontamento.getId());
			values.put(TabelaApontamento.COLUMN_NAME_MINUTOS, apontamento.getMinutos());
			values.put(TabelaApontamento.COLUMN_NAME_DATA, apontamento.getData());		
			
			newRowId = db.insert(TabelaApontamento.TABLE_NAME, null, values);			
			
		} catch(Exception e) {
			e.printStackTrace();
			Log.e("ERRO", e.getMessage());
		}
		return newRowId;
	}
}
