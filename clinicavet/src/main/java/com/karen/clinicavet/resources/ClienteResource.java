package com.karen.clinicavet.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listar() {
		Cliente c1 = new Cliente(1,"Karen Assunção", 19, "karenadf", "Cliente", "Thor", "Vira lata", 2,new Date(System.currentTimeMillis()), "Premium");
		Cliente c2 = new Cliente(1,"Arthur Assunção", 10, "arthurf", "Cliente", "July", "Lhasa Apso", 2,new Date(System.currentTimeMillis()), "Premium");
	
		List lista = new ArrayList();
		lista.add(c1);
		lista.add(c2);
		
		return lista;
		
	}
}
