package br.com.jovens.controledehoras.entity;

import java.io.Serializable;
import java.util.Date;

public class ApontamentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275763475704105815L;
	
	private Long id;
	private Integer hora;
	private Integer minuto;
	private Date data;
	
	public ApontamentoEntity(){}
	
	public ApontamentoEntity(Integer hora, Integer minuto, Date data){
		this.hora = hora;
		this.minuto = minuto;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Apontamento ID: ").append(id).
				append(", Dia: ").append(data).
				append(", Total Horas: ").append(hora).
				append(", Tota Minutos: ").append(minuto);
		return sb.toString();
	}

}
