package com.karen.clinicavet.services;

import java.util.List;

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
	
	@Transactional
	public Consulta inserir(Consulta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
}
