package com.karen.clinicavet.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.serializer.MedicoSerializer;

public class ProducerMedicoVeterinario {

	public static void main(MedicoVeterinario medico) {
		Properties propertiesProducer = new Properties();
		propertiesProducer.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		propertiesProducer.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		propertiesProducer.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MedicoSerializer.class.getName());
		
		try(KafkaProducer<String, MedicoVeterinario> producer =new KafkaProducer<>(propertiesProducer)){
			

			ProducerRecord<String, MedicoVeterinario> record = new ProducerRecord<String, MedicoVeterinario>("veterinariamedico",medico);
			producer.send(record);
			
		}
	
	}
}
