package org.example.spring_data_jpa;

import org.example.spring_data_jpa.model.Employee;
import org.example.spring_data_jpa.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(App.class, args);

		 var employeeRepository =context.getBean(EmployeeRepository.class);
		List<Employee> employees = List.of(
				new Employee(null,"employee1", LocalDate.now(),true),
				new Employee(null,"employee2", LocalDate.now(),false),
				new Employee(null,"employee3", LocalDate.now(),true),
				new Employee(null,"employee4", LocalDate.now(),false),
				new Employee(null,"employee5", LocalDate.now(),true)
		);
		employeeRepository.saveAll(employees);
		employeeRepository.findAllByMarriedTrue().forEach(System.out::println);
	}

}
