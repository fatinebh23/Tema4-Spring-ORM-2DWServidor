package org.example.springapirest;

import org.apache.catalina.core.ApplicationContext;
import org.example.springapirest.model.Manufacturer;
import org.example.springapirest.repository.ManufacturerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(App.class, args);
		var repo= context.getBean(ManufacturerRepository.class);
		repo.save(new Manufacturer(null,"manufacrurer 1",1000,1990));

}
}
