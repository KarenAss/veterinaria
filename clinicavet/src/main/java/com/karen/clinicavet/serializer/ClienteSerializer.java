package com.karen.clinicavet.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karen.clinicavet.domain.Cliente;

public class ClienteSerializer implements Serializer<Cliente>{

	@Override
	public byte[] serialize(String topic, Cliente cliente) {
		
		try {
			return new ObjectMapper().writeValueAsBytes(cliente);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
