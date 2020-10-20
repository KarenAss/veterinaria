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

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.dto.ClienteNewDTO;
import com.karen.clinicavet.kafka.Producer;
import com.karen.clinicavet.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	
	@Autowired
	ClienteService serv;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		
		return ResponseEntity.ok().body(serv.listar());
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody ClienteNewDTO clienteDto) throws InterruptedException {
		Cliente cli = serv.fromDto(clienteDto);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		serv.inserir(cli);
		Producer producer = new Producer();
		producer.main(cli);
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody ClienteNewDTO clienteDto) {
		Cliente cli = serv.fromDto(clienteDto);
		serv.atualizar(cli);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable Integer id) {
		serv.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> listarPoId(@PathVariable Integer id) {
		
		return ResponseEntity.ok().body(serv.listarPorId(id));
		
	}
}
