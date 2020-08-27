package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.dto.MedicoVeterinarioDTO;
import com.karen.clinicavet.services.MedicoVeterinarioService;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoVeterinarioResource {

	@Autowired
	MedicoVeterinarioService serv;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<MedicoVeterinario> listar(){
		return serv.listar();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody MedicoVeterinarioDTO obj) {
		MedicoVeterinario med = serv.fromDto(obj);
		serv.inserir(med);
	}
}
