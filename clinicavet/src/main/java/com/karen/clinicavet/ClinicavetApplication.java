package com.karen.clinicavet;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.common.serialization.StringDeserializer;

import org.apache.kafka.common.serialization.StringSerializer;


@SpringBootApplication
public class ClinicavetApplication implements CommandLineRunner{


	
	public static void main(String[] args) {
		SpringApplication.run(ClinicavetApplication.class, args);
		
		
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo1");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		
		
		try(KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(properties)){
			consumer.subscribe(Arrays.asList("testejava"));
			
			while(true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
				
				for(ConsumerRecord<String,String> record : records) {
					System.out.println(record.value());
				}
				
			}
		}
		
	}
	
	public void run(String... args) throws Exception {		
	}

}
