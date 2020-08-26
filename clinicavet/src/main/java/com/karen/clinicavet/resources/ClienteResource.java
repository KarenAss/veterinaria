package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.repository.ClienteRepository;
import com.karen.clinicavet.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteRepository repo;
	
	@Autowired
	ClienteService serv;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listar() {
		
		return repo.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(Cliente cliente) {
		serv.inserir(cliente);
	}
}
