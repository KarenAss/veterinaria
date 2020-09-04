package com.karen.clinicavet.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void inserir(@Valid @RequestBody MedicoVeterinarioDTO medicoDto) {
		MedicoVeterinario med = serv.fromDto(medicoDto);
		serv.inserir(med);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizar(@Valid @RequestBody MedicoVeterinarioDTO medicoDto) {
		MedicoVeterinario med = serv.fromDto(medicoDto);
		serv.atualizar(med);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar (@PathVariable Integer id) {
		serv.deletar(id);
	
	}
}
