package com.karen.clinicavet.domain;

import java.io.Serializable;
import java.util.Date;

public class Cliente extends Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String petNome;
	private String petRaca;
	private Integer petIdade;
	private Date dataConsulta;
	private String tipoPlano;
	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cliente(Integer id, String nome, Integer idade, String email, String tipoUsuario, String petNome, String petRaca, Integer perIdade, Date dataConsulta, String tipoPlano) {
		super(id, nome, idade, email, tipoUsuario);
		this.petNome  = petNome;
		this.petRaca = petRaca;
		this.petIdade = petIdade;
		this.dataConsulta = dataConsulta;
		this.tipoPlano = tipoPlano;
	}



	public String getPetNome() {
		return petNome;
	}



	public void setPetNome(String petNome) {
		this.petNome = petNome;
	}



	public String getPetRaca() {
		return petRaca;
	}



	public void setPetRaca(String petRaca) {
		this.petRaca = petRaca;
	}



	public Integer getPetIdade() {
		return petIdade;
	}



	public void setPetIdade(Integer petIdade) {
		this.petIdade = petIdade;
	}



	public Date getDataConsulta() {
		return dataConsulta;
	}



	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}



	public String getTipoPlano() {
		return tipoPlano;
	}



	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}
	
	



	@Override
	public void logar() {
		
		// TODO Auto-generated method stub
		
	}



}
