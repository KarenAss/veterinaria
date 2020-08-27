package com.karen.clinicavet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private String email;
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



	public Cliente(Integer id, String nome, Integer idade, String email, String petNome, String petRaca, Integer petIdade, Date dataConsulta, String tipoPlano) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.petNome  = petNome;
		this.petRaca = petRaca;
		this.petIdade = petIdade;
		this.dataConsulta = dataConsulta;
		this.tipoPlano = tipoPlano;
	}

	


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



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email + ", petNome=" + petNome
				+ ", petRaca=" + petRaca + ", petIdade=" + petIdade + ", dataConsulta=" + dataConsulta + ", tipoPlano="
				+ tipoPlano + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataConsulta == null) ? 0 : dataConsulta.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((petIdade == null) ? 0 : petIdade.hashCode());
		result = prime * result + ((petNome == null) ? 0 : petNome.hashCode());
		result = prime * result + ((petRaca == null) ? 0 : petRaca.hashCode());
		result = prime * result + ((tipoPlano == null) ? 0 : tipoPlano.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dataConsulta == null) {
			if (other.dataConsulta != null)
				return false;
		} else if (!dataConsulta.equals(other.dataConsulta))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (petIdade == null) {
			if (other.petIdade != null)
				return false;
		} else if (!petIdade.equals(other.petIdade))
			return false;
		if (petNome == null) {
			if (other.petNome != null)
				return false;
		} else if (!petNome.equals(other.petNome))
			return false;
		if (petRaca == null) {
			if (other.petRaca != null)
				return false;
		} else if (!petRaca.equals(other.petRaca))
			return false;
		if (tipoPlano == null) {
			if (other.tipoPlano != null)
				return false;
		} else if (!tipoPlano.equals(other.tipoPlano))
			return false;
		return true;
	}
	
	



	



}
