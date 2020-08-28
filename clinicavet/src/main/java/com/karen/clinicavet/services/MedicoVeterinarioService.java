package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.dto.MedicoVeterinarioDTO;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@Service
public class MedicoVeterinarioService {

	@Autowired
	MedicoVeterinarioRepository repo;
	
	public List<MedicoVeterinario> listar(){
		return repo.findAll();
	}
	
	@Transactional
	public MedicoVeterinario inserir(MedicoVeterinario medico) {
		medico.setId(null);
		return repo.save(medico);
	}
	
	public MedicoVeterinario listarPorId(Integer id) {
		Optional<MedicoVeterinario> med = repo.findById(id);
		return med.get();
	}
	
	public MedicoVeterinario fromDto(MedicoVeterinarioDTO obj) {
		MedicoVeterinario med = new MedicoVeterinario(obj.getId(),obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getEspecialidade(), obj.getHorarioTrab(), obj.getSalario());
		return med;
	}
	
	public MedicoVeterinario atualizar (MedicoVeterinario medico) {
		MedicoVeterinario med = listarPorId(medico.getId());
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
	}
	
	public void deletar(Integer id) {
		repo.deleteById(id);
	}
}
