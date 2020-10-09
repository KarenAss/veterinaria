package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.dto.ConsultaDTO;
import com.karen.clinicavet.services.ConsultaService;

@RestController
@RequestMapping(path = "/consultas")
public class ConsultaResource {
	
	@Autowired
	ConsultaService serv;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Consulta>> listar(){
		return ResponseEntity.ok().body(serv.listar());
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody ConsultaDTO consulta) {
		Consulta cons = serv.fromDto(consulta);
		serv.inserir(cons);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cons.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody ConsultaDTO consulta) {
		Consulta cons = serv.fromDto(consulta);
		serv.atualizar(cons);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable Integer id) {
		serv.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Consulta> listarPorId(@PathVariable Integer id){
		return ResponseEntity.ok().body(serv.listarPorId(id));
	}
}
