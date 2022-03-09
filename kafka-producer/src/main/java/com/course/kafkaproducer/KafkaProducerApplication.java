package com.course.kafkaproducer;

import com.course.kafkaproducer.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.kafkaproducer.producer.HelloKafkaProducer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private KafkaKeyProducer kafkaKeyProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for(int i=0; i<30; i++ ){
			var key = "key-" + (i%4);
			var data = "data " + i + " with key " + key;
			kafkaKeyProducer.send(key, data);
		}
	}

}

/*@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}*/

/*
The below configuration is for HelloKafkaProducer. Disable @Service from there as well.
 */

/*@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloKafkaProducer helloKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloKafkaProducer.sendHello("AMBRISH " + Math.random());
	}

}*/


