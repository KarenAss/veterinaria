package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

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
	
	public Cliente listarPorId(Integer id){
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.get();
	}
	
	public Cliente fromDto(ClienteDTO obj) {
		Cliente cli = new Cliente(obj.getId(), obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getPetNome(), obj.getPetRaca(), obj.getPetIdade(), obj.getDataConsulta(), obj.getTipoPlano());
		return cli;
	}
	
	public Cliente atualizar(Cliente cliente) {
		Cliente cli = listarPorId(cliente.getId());
		update(cli, cliente);
		repo.save(cli);
		return cli;
	}
	
	public void update (Cliente clienteDto, Cliente cliente) {
		clienteDto.setId(cliente.getId());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setIdade(cliente.getIdade());
		clienteDto.setDataConsulta(cliente.getDataConsulta());
		clienteDto.setPetNome(cliente.getPetNome());
		clienteDto.setPetIdade(cliente.getPetIdade());
		clienteDto.setPetRaca(cliente.getPetRaca());
		clienteDto.setTipoPlano(cliente.getTipoPlano());
	}
	
	public void deletar(Integer id) {
		repo.deleteById(id);
	}
}
