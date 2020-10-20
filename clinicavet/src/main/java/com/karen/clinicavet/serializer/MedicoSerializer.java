package com.karen.clinicavet.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.domain.MedicoVeterinario;

public class MedicoSerializer implements Serializer<MedicoVeterinario>{

	@Override
	public byte[] serialize(String topic, MedicoVeterinario medico) {
		
		try {
			return new ObjectMapper().writeValueAsBytes(medico);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
