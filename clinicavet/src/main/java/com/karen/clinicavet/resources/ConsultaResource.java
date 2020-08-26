package com.karen.clinicavet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
