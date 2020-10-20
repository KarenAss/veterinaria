package com.karen.clinicavet.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.karen.clinicavet.deserializer.ClienteDeserializer;
import com.karen.clinicavet.domain.Cliente;
import com.karen.clinicavet.services.ClienteService;

public class ConsumerCliente {

	
	
	public static void main() {
		
		
		ClienteService serv = new ClienteService();
		
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ClienteDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo1");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		
		try(KafkaConsumer<String,Cliente> consumer = new KafkaConsumer<>(properties)){
			consumer.subscribe(Arrays.asList("veterinaria"));
			
			
				ConsumerRecords<String, Cliente> records = consumer.poll(Duration.ofSeconds(1));
				
				for(ConsumerRecord<String,Cliente> record : records) {
					Cliente cli = record.value();
					System.out.println(cli);
					
				}
				
			}
		}
		
	}

