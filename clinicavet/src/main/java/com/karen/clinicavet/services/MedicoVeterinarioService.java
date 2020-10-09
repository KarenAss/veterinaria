package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cidade;
import com.karen.clinicavet.domain.Endereco;
import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.dto.MedicoVeterinarioDTO;
import com.karen.clinicavet.repository.ConsultaRepository;
import com.karen.clinicavet.repository.EnderecoRepository;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@Service
public class MedicoVeterinarioService {

	@Autowired
	MedicoVeterinarioRepository repo;
	
	@Autowired
	EnderecoRepository endRepo;
	
	@Autowired
	ConsultaRepository conRepo;
	
	public List<MedicoVeterinario> listar(){
		return repo.findAll();
	}
	
	@Transactional
	public MedicoVeterinario inserir (MedicoVeterinario medico) {
		medico.setId(null);
		repo.save(medico);
		endRepo.saveAll(medico.getEnderecos());
		return medico;
	}
	
	public MedicoVeterinario listarPorId(Integer id) {
		Optional<MedicoVeterinario> med = repo.findById(id);
		return med.get();
	}
	
	public MedicoVeterinario fromDto(MedicoVeterinarioDTO obj) {
		MedicoVeterinario med = new MedicoVeterinario(obj.getId(),obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getEspecialidade(), obj.getHorarioTrab(), obj.getSalario(),obj.getSenha(), obj.getCpf());
		Cidade cid = new Cidade(obj.getCidadeId(), null, null);
		Endereco end = new Endereco(null,obj.getLogradouro(),obj.getNumero(),obj.getComplemento(),obj.getBairro(), obj.getCep(),med, cid);
		med.getEnderecos().add(end);
		med.getTelefones().add(obj.getTelefone1());
		if(obj.getTelefone2()!=null) {
			med.getTelefones().add(obj.getTelefone2());
		}
		if(obj.getTelefone3()!=null) {
			med.getTelefones().add(obj.getTelefone3());
		}
		
		return med;
	}
	
	
	public MedicoVeterinario atualizar (MedicoVeterinario medico) {
		MedicoVeterinario med = listarPorId(medico.getId());
		updateEndereco(med,medico);
		update(med, medico);
		repo.save(med);
		return med;
	}
	
	public void update(MedicoVeterinario medicoNew, MedicoVeterinario med) {
		medicoNew.setId(med.getId());
		medicoNew.setNome(med.getNome());
		medicoNew.setIdade(med.getIdade());
		medicoNew.setEmail(med.getEmail());
		medicoNew.setSalario(med.getSalario());
		medicoNew.setEspecialidade(med.getEspecialidade());
		medicoNew.setHorarioTrab(med.getHorarioTrab());
		medicoNew.setSenha(med.getSenha());
		medicoNew.setTelefones(med.getTelefones());
	}
	
	public void updateEndereco(MedicoVeterinario clienteDto, MedicoVeterinario cliente) {
		Integer tam = cliente.getEnderecos().size();
		for (int x = 0;x<cliente.getEnderecos().size();x++) {
			clienteDto.getEnderecos().get(x).setLogradouro(cliente.getEnderecos().get(x).getLogradouro());
			clienteDto.getEnderecos().get(x).setNumero(cliente.getEnderecos().get(x).getNumero());
			clienteDto.getEnderecos().get(x).setComplemento(cliente.getEnderecos().get(x).getComplemento());
			clienteDto.getEnderecos().get(x).setMedico(cliente);
			clienteDto.getEnderecos().get(x).setCidade(cliente.getEnderecos().get(x).getCidade());
			clienteDto.getEnderecos().get(x).setCep(cliente.getEnderecos().get(x).getCep());
			clienteDto.getEnderecos().get(x).setBairro(cliente.getEnderecos().get(x).getBairro());
		}
	}
	
	public void deletar(Integer id) {
		MedicoVeterinario med = listarPorId(id);
		if(med.getConsultas().isEmpty()) {
			endRepo.deleteById(id);
			repo.deleteById(id);
		}
		else{
			endRepo.deleteById(id);
			conRepo.deleteById(id);
			repo.deleteById(id);
		}
	}
}
