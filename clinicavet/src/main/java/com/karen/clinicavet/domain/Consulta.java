package com.karen.clinicavet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.karen.clinicavet.domain.enums.EstadoConsulta;

@Entity
public class Consulta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String diagnostico;
	private String receita;
	private Integer estado;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	
	@ManyToOne
	@JoinColumn(name="medico_id")
	private MedicoVeterinario medico;
	
	public Consulta() {
		
	}

	public Consulta(Integer id, Date data, String diagnostico, String receita,
			EstadoConsulta estado) {
		super();
		this.id = id;
		this.data = data;
		this.diagnostico = diagnostico;
		this.receita = receita;
		this.estado = estado.getCod();
		
	}
	
	public Consulta(Integer id, Date data, String diagnostico, String receita,
			EstadoConsulta estado, Cliente cliente, MedicoVeterinario medico) {
		super();
		this.id = id;
		this.data = data;
		this.diagnostico = diagnostico;
		this.receita = receita;
		this.estado = estado.getCod();
		this.cliente = cliente;
		this.medico = medico;
	}



	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return EstadoConsulta.toEnum(id);
	}

	public void setEstado(EstadoConsulta estado) {
		this.estado = estado.getCod();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((diagnostico == null) ? 0 : diagnostico.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
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
		Consulta other = (Consulta) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (diagnostico == null) {
			if (other.diagnostico != null)
				return false;
		} else if (!diagnostico.equals(other.diagnostico))
			return false;
		if (estado != other.estado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public MedicoVeterinario getMedico() {
		return medico;
	}

	public void setMedico(MedicoVeterinario medico) {
		this.medico = medico;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
}
