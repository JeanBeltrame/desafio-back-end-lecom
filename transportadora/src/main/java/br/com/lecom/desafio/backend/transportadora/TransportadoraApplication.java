package br.com.lecom.desafio.backend.transportadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportadoraApplication {

	public static void main(String[] args) {
		System.setProperty("spring.cloud.bootstrap.enabled","true");
		SpringApplication.run(TransportadoraApplication.class, args);
	}

}
