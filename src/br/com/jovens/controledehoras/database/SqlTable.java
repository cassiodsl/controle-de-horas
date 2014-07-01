package br.com.jovens.controledehoras.database;

public interface SqlTable {
	
	public String getDataBaseName();
	
	public Integer getDataBaseVersion();
	
	public String getTableName();
	
	public String getScriptCreateTable();
	
}
