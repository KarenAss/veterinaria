package com.karen.clinicavet.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.dto.ClienteDTO;
import com.karen.clinicavet.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Transactional
	public Cliente inserir (Cliente cliente) {
		cliente.setId(null);
		return repo.save(cliente);
	}
	
	public List<Cliente> listar(){
		return repo.findAll();
	}
	
	public Cliente fromDto(ClienteDTO obj) {
		Cliente cli = new Cliente(obj.getId(), obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getPetNome(), obj.getPetRaca(), obj.getPetIdade(), obj.getDataConsulta(), obj.getTipoPlano());
		return cli;
	}
}
