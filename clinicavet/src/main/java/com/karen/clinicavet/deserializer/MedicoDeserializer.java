package com.karen.clinicavet.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karen.clinicavet.domain.MedicoVeterinario;

public class MedicoDeserializer implements Deserializer<MedicoVeterinario>{

	@Override
	public MedicoVeterinario deserialize(String topic, byte[] medico) {
		try {
			return new ObjectMapper().readValue(medico, MedicoVeterinario.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
