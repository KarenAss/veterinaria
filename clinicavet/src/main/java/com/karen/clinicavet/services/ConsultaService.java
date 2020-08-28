package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.dto.ConsultaDTO;
import com.karen.clinicavet.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository repo;
	
	public List<Consulta> listar() {
		return repo.findAll();
	}
	
	public Consulta listarPorId(Integer id) {
		Optional<Consulta> consulta = repo.findById(id);
		return consulta.get();
	}
	
	@Transactional
	public Consulta inserir(Consulta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Consulta atualizar(Consulta obj) {
		Consulta consulta = listarPorId(obj.getId());
		update(consulta, obj);
		repo.save(consulta);
		return consulta;
	}
	
	public void update (Consulta consultaNew, Consulta consulta) {
		consultaNew.setId(consulta.getId());
		consultaNew.setIdCliente(consulta.getIdCliente());
		consultaNew.setIdMedico(consulta.getIdMedico());
		consultaNew.setData(consulta.getData());
		consultaNew.setDiagnostico(consulta.getDiagnostico());
		consultaNew.setEstado(consulta.getEstado());
		consultaNew.setReceita(consulta.getReceita());
	}
	
	public void deletar(Integer id) {
		repo.deleteById(id);
	}
}
