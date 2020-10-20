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

import com.karen.clinicavet.deserializer.MedicoDeserializer;
import com.karen.clinicavet.domain.MedicoVeterinario;
import com.karen.clinicavet.services.MedicoVeterinarioService;


public class ConsumerMedico {

	
	
	public static void main() {
		
		
		MedicoVeterinarioService serv = new MedicoVeterinarioService();
		
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MedicoDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo1");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		
		try(KafkaConsumer<String,MedicoVeterinario> consumer = new KafkaConsumer<>(properties)){
			consumer.subscribe(Arrays.asList("veterinariamedico"));
			
			
				ConsumerRecords<String, MedicoVeterinario> records = consumer.poll(Duration.ofSeconds(1));
				
				for(ConsumerRecord<String,MedicoVeterinario> record : records) {
					MedicoVeterinario med = record.value();
					System.out.println(med);
					
				}
				
			}
		}
		
	}

