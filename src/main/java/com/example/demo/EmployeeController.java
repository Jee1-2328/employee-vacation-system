package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    public EmployeeController() {
        employees = EmployeeApp.createEmployees(); // Creating employees on startup
    }

    @GetMapping("/vacation-days")
    public String getVacationDays() {
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < employees.size(); i++) {
            response.append("Employee ").append(i).append(" Vacation Days: ")
                    .append(employees.get(i).getVacationDays()).append("\n");
        }
        return response.toString();
    }

    @PostMapping("/work")
    public String work(@RequestParam int employeeId, @RequestParam int daysWorked) {
        try {
            Employee employee = employees.get(employeeId);
            employee.work(daysWorked);
            return "Employee " + employeeId + " worked for " + daysWorked + " days.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/take-vacation")
    public String takeVacation(@RequestParam int employeeId, @RequestParam float daysTaken) {
        try {
            Employee employee = employees.get(employeeId);
            employee.takeVacation(daysTaken);
            return "Employee " + employeeId + " took " + daysTaken + " vacation days.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
