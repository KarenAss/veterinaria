package com.karen.clinicavet.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;




public class ClienteNewDTO {

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
	private String senha;
	
	private String cpf;
	@NotEmpty(message="O preenchimento é obrigatório")
	private String telefone1;
	
	private String telefone2;
	private String telefone3;
	
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
	
	private ClienteNewDTO() {
		
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone) {
		this.telefone1 = telefone;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	
}
