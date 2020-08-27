package com.karen.clinicavet.dto;

import java.io.Serializable;
import java.util.Date;


public class ClienteDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Integer idade;
	private String email;
	private String petNome;
	private String petRaca;
	private Integer petIdade;
	private Date dataConsulta;
	private String tipoPlano;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	
}
