package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.services.ConsultaService;

@RestController
@RequestMapping(path = "/consultas")
public class ConsultaResource {
	
	@Autowired
	ConsultaService serv;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Consulta> listar(){
		return serv.listar();
	}
	
	@PostMapping(value="/rest/account/json", consumes = {"application/json"})
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody Consulta consulta) {
		serv.inserir(consulta);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void atualizar(@RequestBody Consulta consulta) {
		serv.atualizar(consulta);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar (@PathVariable Integer id) {
		serv.deletar(id);
		
	}
}
