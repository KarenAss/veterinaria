package com.karen.clinicavet.deserializer;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karen.clinicavet.domain.Cliente;

public class ClienteDeserializer implements Deserializer<Cliente>{

	@Override
	public Cliente deserialize(String topic, byte[] cliente) {
		try {
			return new ObjectMapper().readValue(cliente, Cliente.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
