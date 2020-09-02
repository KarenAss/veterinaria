package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.dto.ClienteDTO;
import com.karen.clinicavet.dto.ClienteNewDTO;
import com.karen.clinicavet.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	
	@Autowired
	ClienteService serv;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listar() {
		
		return serv.listar();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody ClienteNewDTO clienteDto) {
		Cliente cli = serv.fromDto(clienteDto);
		serv.inserir(cli);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizar(@RequestBody ClienteNewDTO clienteDto) {
		Cliente cli = serv.fromDto(clienteDto);
		serv.atualizar(cli);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar (@PathVariable Integer id) {
		serv.deletar(id);
		
	}
}
