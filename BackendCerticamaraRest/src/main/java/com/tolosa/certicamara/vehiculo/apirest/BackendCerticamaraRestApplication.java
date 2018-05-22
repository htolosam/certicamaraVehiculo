package com.tolosa.certicamara.vehiculo.apirest;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@ComponentScan(basePackages= {"com.tolosa.certicamara.vehiculo.apirest"}) //to scan packages mentioned
//@EnableMongoRepositories("com.tolosa.certicamara.vehiculo.apirest.models") //to activate MongoDB repositories
public class BackendCerticamaraRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCerticamaraRestApplication.class, args);
	}
}
