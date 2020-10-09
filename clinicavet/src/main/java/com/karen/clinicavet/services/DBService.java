package com.karen.clinicavet.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.clinicavet.domain.Cidade;
import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.domain.Endereco;
import com.karen.clinicavet.domain.Estado;
import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.domain.enums.EstadoConsulta;
import com.karen.clinicavet.repository.CidadeRepository;
import com.karen.clinicavet.repository.ClienteRepository;
import com.karen.clinicavet.repository.ConsultaRepository;
import com.karen.clinicavet.repository.EnderecoRepository;
import com.karen.clinicavet.repository.EstadoRepository;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@Service
public class DBService {

	@Autowired
	ClienteRepository cliente;
	
	@Autowired
	MedicoVeterinarioRepository medico;
	
	@Autowired
	ConsultaRepository con;
	
	@Autowired
	EstadoRepository est;
	
	@Autowired
	CidadeRepository cida;
	
	@Autowired
	EnderecoRepository ende;
	
	public void instatiateTestDatabase() throws ParseException {
	
		List endereco = new ArrayList();
		List consul = new ArrayList();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("23/11/2015");
		Cliente c1 = new Cliente(1,"Karen", 18, "karenadf", "Thor", "Vira lata",2, data, "Premium", "12345","123456");
		cliente.save(c1);
		Estado es = new Estado(1, "São Paulo");
		est.save(es);
		Cidade cid = new Cidade (1,"São Paulo",es);
		cida.save(cid);
		Endereco end = new Endereco(1, "Av. Raimundo Pereira de Magalhães", "2500","Torre 1","Jardim Íris", "05145-000",c1,cid);
		ende.save(end);
		endereco.add(end);
		c1.setEndereco(endereco);
		data = formato.parse("13/09/2020");
		MedicoVeterinario m1 = new MedicoVeterinario(1, "Arthur", 25, "arthuradf", "Dermatologista", data, 1.000, "12344", "14622");
		medico.save(m1);
		m1.setEnderecos(endereco);
		medico.save(m1);
		data = formato.parse("13/09/2020");
		EstadoConsulta consulta = null;
		Consulta co1 = new Consulta(1, data, "Febre", "Dipirona", consulta.AGENDADA,c1,m1);
		con.save(co1);
		consul.add(co1);
		c1.setConsultas(consul);
		cliente.save(c1);
	}
}
