package com.karen.clinicavet.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.serializer.ClienteSerializer;

public class Producer {

	public static void main(Cliente cli)  throws InterruptedException{
		
		Properties propertiesProducer = new Properties();
		propertiesProducer.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		propertiesProducer.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		propertiesProducer.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ClienteSerializer.class.getName());
		
		try(KafkaProducer<String, Cliente> producer =new KafkaProducer<>(propertiesProducer)){
			

			ProducerRecord<String, Cliente> record = new ProducerRecord<String, Cliente>("veterinaria",cli);
			producer.send(record);
			
		}
	
	}
	
	
}
