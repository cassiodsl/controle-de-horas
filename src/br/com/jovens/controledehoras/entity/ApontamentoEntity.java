package br.com.jovens.controledehoras.entity;

import java.io.Serializable;
import java.util.Date;

public class ApontamentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275763475704105815L;
	
	private Long id;
	private Tempo tempo;
	private Date data;
	
	public ApontamentoEntity(Long minutos, Date data){
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
