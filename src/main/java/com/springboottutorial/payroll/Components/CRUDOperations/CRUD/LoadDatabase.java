package com.springboottutorial.payroll.Components.CRUDOperations.CRUD;

import com.springboottutorial.payroll.Components.CRUDOperations.DAO.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Configuration
public class LoadDatabase {
    private static final Logger myLogger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository myRepository){
        return (args) ->{
            myLogger.info("Preloading\n" + myRepository.save(new Employee("Tom", "Developer")));
            myLogger.info("Preloading\n" + myRepository.save(new Employee("Sam", "Developer2")));
        };
    }
}
