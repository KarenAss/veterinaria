package com.karen.clinicavet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public void inserir (Cliente cliente) {
		cliente.setId(null);
		repo.save(cliente);
	}
}
