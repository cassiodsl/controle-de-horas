package br.com.jovens.controledehoras.database;

public class TabelaApontamento implements SqlTable {
	
	private final String DATA_BASE_NAME = "CONTROLE_HORAS";
	private final Integer DATA_BASE_VERSION = Integer.valueOf(1);
	private final String TABLE_NAME = "APONTAMENTO";

	@Override
	public String getDataBaseName() {
		return DATA_BASE_NAME;
	}

	@Override
	public Integer getDataBaseVersion() {
		return DATA_BASE_VERSION;
	}

	@Override
	public String getTableName() {		
		return TABLE_NAME;
	}

	@Override
	public String getScriptCreateTable() {
		StringBuffer sb = new StringBuffer("CREATE TABLE ").append(TABLE_NAME).
				append(" ( ").
								append("ID INTEGER PRIMARY KEY AUTOINCREMENT, ").
								append("HORA INTEGER NOT NULL, ").
								append("MINUTO INTEGER NOT NULL, ").
								append("DATA TEXT NOT NULL").
				append(" ); ");
		
		return sb.toString();
	}

}
