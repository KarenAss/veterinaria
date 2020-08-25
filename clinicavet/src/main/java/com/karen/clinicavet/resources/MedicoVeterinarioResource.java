package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoVeterinarioResource {

	@Autowired
	MedicoVeterinarioRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<MedicoVeterinario> listar(){
		return repo.findAll();
	}
}
