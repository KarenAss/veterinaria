package com.karen.clinicavet.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class MedicoVeterinarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Integer idade;
	private String email;
	private String especialidade;
	private Date horarioTrab;
	private Double salario;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String numero;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String cep;
	
	private Integer cidadeId;
	
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
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public Date getHorarioTrab() {
		return horarioTrab;
	}
	public void setHorarioTrab(Date horarioTrab) {
		this.horarioTrab = horarioTrab;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getCidadeId() {
		return cidadeId;
	}
	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	

}
