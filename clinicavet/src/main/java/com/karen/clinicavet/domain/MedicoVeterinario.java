package com.karen.clinicavet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MedicoVeterinario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private String email;
	private String especialidade;
	private Date horarioTrab;
	private Double salario;
	private String senha;
	private String cpf;
	
	@ElementCollection
	@CollectionTable(name ="TELEFONEMEDICO")
	private Set<String> telefones = new HashSet<>(); 
	
	@JsonIgnore
	@OneToMany(mappedBy ="cliente")
	private List<Consulta> consultas = new ArrayList<>();
	
	@OneToMany(mappedBy="medico", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	public MedicoVeterinario() {
		
	}
	
	public MedicoVeterinario(Integer id, String nome, Integer idade, String email, String especialidade,
			Date horarioTrab, Double salario, List<Consulta> consultas) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.especialidade = especialidade;
		this.horarioTrab = horarioTrab;
		this.salario = salario;
		this.consultas = consultas;
	}


	public MedicoVeterinario(Integer id, String nome, Integer idade, String email, String especialidade,
			Date horarioTrab, Double salario, String senha, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.especialidade = especialidade;
		this.horarioTrab = horarioTrab;
		this.salario = salario;
		this.cpf = cpf;
		this.senha = senha;
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


	@Override
	public String toString() {
		return "MedicoVeterinario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", email=" + email
				+ ", especialidade=" + especialidade + ", horarioTrab=" + horarioTrab + ", salario=" + salario + ", consultas = "+consultas+", endereços = "+enderecos+"]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
		result = prime * result + ((horarioTrab == null) ? 0 : horarioTrab.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		MedicoVeterinario other = (MedicoVeterinario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (horarioTrab == null) {
			if (other.horarioTrab != null)
				return false;
		} else if (!horarioTrab.equals(other.horarioTrab))
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
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
	
	
	
	
}
