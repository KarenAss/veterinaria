package com.karen.clinicavet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository repo;
	
	public List<Consulta> listar() {
		return repo.findAll();
	}
}
