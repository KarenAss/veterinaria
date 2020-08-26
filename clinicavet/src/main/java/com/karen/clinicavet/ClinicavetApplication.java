package com.karen.clinicavet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.domain.Consulta;
import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.domain.enums.EstadoConsulta;
import com.karen.clinicavet.repository.ClienteRepository;
import com.karen.clinicavet.repository.ConsultaRepository;
import com.karen.clinicavet.repository.MedicoVeterinarioRepository;

@SpringBootApplication
public class ClinicavetApplication implements CommandLineRunner{

	@Autowired
	ClienteRepository cliente;
	
	@Autowired
	MedicoVeterinarioRepository medico;
	
	@Autowired
	ConsultaRepository con;
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ClinicavetApplication.class, args);
		
	}
	
	public void run (String... args) throws Exception{
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("23/11/2015");
		Cliente c1 = new Cliente(1,"Karen", 18, "karenadf", "Thor", "Vira lata",2, data, "Premium");
		cliente.save(c1);
		data = formato.parse("13/09/2020");
		MedicoVeterinario m1 = new MedicoVeterinario(1, "Arthur", 25, "arthuradf", "Dermatologista", data, 1.000);
		medico.save(m1);
		data = formato.parse("13/09/2020");
		EstadoConsulta consulta = null;
		Consulta co1 = new Consulta(1, 1,1, data, "Febre", "Dipirona", consulta.AGENDADA);
		con.save(co1);
	}

}
