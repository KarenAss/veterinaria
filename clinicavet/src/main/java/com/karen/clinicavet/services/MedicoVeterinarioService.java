package com.karen.clinicavet.services;

import java.util.List;

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
	
	public MedicoVeterinario fromDto(MedicoVeterinarioDTO obj) {
		MedicoVeterinario med = new MedicoVeterinario(obj.getId(),obj.getNome(), obj.getIdade(), obj.getEmail(), obj.getEspecialidade(), obj.getHorarioTrab(), obj.getSalario());
		return med;
	}
}
