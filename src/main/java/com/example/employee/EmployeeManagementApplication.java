package com.example.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Alice", "Developer", "alice@example.com"));
            repository.save(new Employee("Bob", "QA", "bob@example.com"));
        };
    }
}
