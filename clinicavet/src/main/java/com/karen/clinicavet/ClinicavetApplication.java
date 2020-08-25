package com.karen.clinicavet;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.resources.ClienteResource;

@SpringBootApplication
public class ClinicavetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicavetApplication.class, args);
		
		
	}

}
