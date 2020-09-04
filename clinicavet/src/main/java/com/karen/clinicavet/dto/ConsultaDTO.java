package com.karen.clinicavet.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.karen.clinicavet.domain.enums.EstadoConsulta;

public class ConsultaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty
	private Integer idCliente;
	
	@NotEmpty
	private Integer idMedico;
	
	private Date data;
	private String diagnostico;
	private String receita;
	private EstadoConsulta estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public EstadoConsulta getEstado() {
		return estado;
	}
	public void setEstado(EstadoConsulta estado) {
		this.estado = estado;
	}
	
	

}
