package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeApp {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Create 10 Hourly Employees
        for (int i = 0; i < 10; i++) {
            employees.add(new HourlyEmployee());
        }

        // Create 10 Salaried Employees
        for (int i = 0; i < 10; i++) {
            employees.add(new SalariedEmployee());
        }

        // Create 10 Managers
        for (int i = 0; i < 10; i++) {
            employees.add(new Manager());
        }

        return employees;
    }
}
