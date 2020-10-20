package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cidade;
import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.domain.Endereco;
import com.karen.clinicavet.dto.ClienteDTO;
import com.karen.clinicavet.dto.ClienteNewDTO;
import com.karen.clinicavet.repository.ClienteRepository;
import com.karen.clinicavet.repository.ConsultaRepository;
import com.karen.clinicavet.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
	@Autowired
	private ConsultaRepository conRepo;
	
	
	@Transactional
	public Cliente inserir (Cliente cliente) {
		cliente.setId(null);
		repo.save(cliente);
		endRepo.saveAll(cliente.getEndereco());
		
		System.out.println("Inseriu no banco");
		return cliente;
	}
	
	public List<Cliente> listar(){
		return repo.findAll();
	}
	
	public Cliente listarPorId(Integer id){
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.get();
	}
	
	public Cliente fromDto(ClienteDTO obj) {
		Cliente cli = new Cliente(obj.getId(), obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getPetNome(), obj.getPetRaca(), obj.getPetIdade(), obj.getDataConsulta(), obj.getTipoPlano(), obj.getSenha(),obj.getCpf());
		cli.getTelefones().add(obj.getTelefone1());
		if(obj.getTelefone2()!=null) {
			cli.getTelefones().add(obj.getTelefone2());
		}
		if(obj.getTelefone3()!=null) {
			cli.getTelefones().add(obj.getTelefone3());
		}
		
		return cli;
	}
	public Cliente fromDto(ClienteNewDTO obj) {
		Cliente cli = new Cliente(obj.getId(), obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getPetNome(), obj.getPetRaca(), obj.getPetIdade(), obj.getDataConsulta(), obj.getTipoPlano(),obj.getSenha(),obj.getCpf());
		Cidade cid = new Cidade(obj.getCidadeId(), null, null);
		Endereco end = new Endereco(null,obj.getLogradouro(),obj.getNumero(),obj.getComplemento(),obj.getBairro(), obj.getCep(),cli, cid);
		cli.getEndereco().add(end);
		cli.getTelefones().add(obj.getTelefone1());
		if(obj.getTelefone2()!=null) {
			cli.getTelefones().add(obj.getTelefone2());
		}
		if(obj.getTelefone3()!=null) {
			cli.getTelefones().add(obj.getTelefone3());
		}
		
		return cli;
	}
	
	public Cliente atualizar(Cliente cliente) {
		Cliente cli = listarPorId(cliente.getId());
		updateEndereco(cli,cliente);
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
		clienteDto.setSenha(cliente.getSenha());
		clienteDto.setTelefones(cliente.getTelefones());
	}
	
	public void deletar(Integer id) {
		Cliente cli = listarPorId(id);
		if(cli.getConsultas().isEmpty()) {
			endRepo.deleteById(id);
			repo.deleteById(id);
		}
		else{
			endRepo.deleteById(id);
			conRepo.deleteById(id);
			repo.deleteById(id);
		}
	}
	
	public void updateEndereco(Cliente clienteDto, Cliente cliente) {
		Integer tam = cliente.getEndereco().size();
		for (int x = 0;x<cliente.getEndereco().size();x++) {
			clienteDto.getEndereco().get(x).setLogradouro(cliente.getEndereco().get(x).getLogradouro());
			clienteDto.getEndereco().get(x).setNumero(cliente.getEndereco().get(x).getNumero());
			clienteDto.getEndereco().get(x).setComplemento(cliente.getEndereco().get(x).getComplemento());
			clienteDto.getEndereco().get(x).setCliente(cliente);
			clienteDto.getEndereco().get(x).setCidade(cliente.getEndereco().get(x).getCidade());
			clienteDto.getEndereco().get(x).setCep(cliente.getEndereco().get(x).getCep());
			clienteDto.getEndereco().get(x).setBairro(cliente.getEndereco().get(x).getBairro());
		}
	}
}
