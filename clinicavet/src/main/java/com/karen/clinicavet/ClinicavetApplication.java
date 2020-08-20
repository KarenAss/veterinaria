package com.karen.clinicavet;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.resources.ClienteResource;

@SpringBootApplication
public class ClinicavetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicavetApplication.class, args);
		Cliente c1 = new Cliente(1,"Karen Assunção", 19, "karenadf", "Cliente", "Thor", "Vira lata", 2,new Date(System.currentTimeMillis()), "Premium");
		Cliente c2 = new Cliente(1,"Arthur Assunção", 10, "arthurf", "Cliente", "July", "Lhasa Apso", 2,new Date(System.currentTimeMillis()), "Premium");
	
		System.out.println(c1.getNome());
		System.out.println(c1.getPetNome());
		System.out.println(c2.getNome());
		System.out.println(c2.getPetNome());
		
	}

}
