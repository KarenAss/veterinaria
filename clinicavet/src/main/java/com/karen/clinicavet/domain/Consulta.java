package com.karen.clinicavet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.karen.clinicavet.domain.enums.EstadoConsulta;

@Entity
public class Consulta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idCliente;
	private Integer idMedico;
	private Date data;
	private String diagnostico;
	private String receita;
	private Integer estado;
	
	public Consulta() {
		
	}

	public Consulta(Integer id, Integer idCliente, Integer idMedico, Date data, String diagnostico, String receita,
			EstadoConsulta estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idMedico = idMedico;
		this.data = data;
		this.diagnostico = diagnostico;
		this.receita = receita;
		this.estado = estado.getCod();
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", idCliente=" + idCliente + ", idMedico=" + idMedico + ", data=" + data
				+ ", diagnostico=" + diagnostico + ", receita=" + receita + ", estado=" + estado + "]";
	}

	
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
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idMedico == null) ? 0 : idMedico.hashCode());
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
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idMedico == null) {
			if (other.idMedico != null)
				return false;
		} else if (!idMedico.equals(other.idMedico))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}
	
	
	
	
}
