package br.com.jovens.controledehoras.entity;

import java.io.Serializable;

public class ApontamentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275763475704105815L;
	
	private Long id;
	private Tempo tempo;
	private String data;
	
	public ApontamentoEntity(Long minutos, String data){
		tempo = new Tempo(minutos);
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMinutos(){
		return tempo.getMinutos();
	}
	
	public void setMinutos(Long minutos){
		tempo.setMinutos(minutos);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getHoras() {
		return tempo.getHoras();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Apontamento ID: ").append(id).
				append(", Dia: ").append(data).
				append(", Total Horas: ").append(tempo.getHoras());				
		return sb.toString();
	}

}
