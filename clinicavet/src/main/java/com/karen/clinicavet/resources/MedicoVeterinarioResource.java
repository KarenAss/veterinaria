package com.karen.clinicavet.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.dto.MedicoVeterinarioDTO;
import com.karen.clinicavet.services.MedicoVeterinarioService;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoVeterinarioResource {

	@Autowired
	MedicoVeterinarioService serv;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MedicoVeterinario>> listar(){
		return ResponseEntity.ok().body(serv.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody MedicoVeterinarioDTO medicoDto) {
		MedicoVeterinario med = serv.fromDto(medicoDto);
		serv.inserir(med);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(med.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody MedicoVeterinarioDTO medicoDto) {
		MedicoVeterinario med = serv.fromDto(medicoDto);
		serv.atualizar(med);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable Integer id) {
		serv.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public ResponseEntity<MedicoVeterinario> listarPorId(@PathVariable Integer id){
		return ResponseEntity.ok().body(serv.listarPorId(id));
	}
}
