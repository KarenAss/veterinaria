package com.karen.clinicavet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.dto.ConsultaDTO;
import com.karen.clinicavet.repository.ClienteRepository;
import com.karen.clinicavet.repository.ConsultaRepository;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository repo;
	
	@Autowired
	ClienteRepository repoCli;
	
	@Autowired
	MedicoVeterinarioRepository repoMed;
	
	public List<Consulta> listar() {
		return repo.findAll();
	}
	
	public Consulta listarPorId(Integer id) {
		Optional<Consulta> consulta = repo.findById(id);
		return consulta.get();
	}
	
	@Transactional
	public Consulta inserir(Consulta obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public Consulta atualizar(Consulta obj) {
		Consulta consulta = listarPorId(obj.getId());
		update(consulta, obj);
		repo.save(consulta);
		return consulta;
	}
	
	public void update (Consulta consultaNew, Consulta consulta) {
		consultaNew.setId(consulta.getId());
		consultaNew.setData(consulta.getData());
		consultaNew.setDiagnostico(consulta.getDiagnostico());
		consultaNew.setEstado(consulta.getEstado());
		consultaNew.setReceita(consulta.getReceita());
		Cliente cli = listarClientePorId(consulta.getCliente().getId());
		consultaNew.setCliente(cli);
		MedicoVeterinario med = listarMedicoPorId(consulta.getMedico().getId());
		consultaNew.setMedico(med);
	}
	
	public void deletar(Integer id) {
		repo.deleteById(id);
	}
	
	public Consulta fromDto(ConsultaDTO obj) {
		Cliente cli = listarClientePorId(obj.getIdCliente());
		MedicoVeterinario med = listarMedicoPorId(obj.getIdMedico());
		Consulta cons = new Consulta(obj.getId(), obj.getData(), obj.getDiagnostico(), obj.getReceita(), obj.getEstado(),cli,med);
		return cons;
	}
	
	public Cliente listarClientePorId(Integer id){
		Optional<Cliente> cliente = repoCli.findById(id);
		
		return cliente.get();
	}
	
	public MedicoVeterinario listarMedicoPorId(Integer id){
		Optional<MedicoVeterinario> med = repoMed.findById(id);
		return med.get();
	}
	
	
		
}
