package org.tyutyunik.employeeWithTestMockito.controller;

import org.springframework.web.bind.annotation.*;
import org.tyutyunik.employeeWithTestMockito.model.Employee;
import org.tyutyunik.employeeWithTestMockito.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String standardAnswer() {
        return employeeService.standardAnswer();
    }

    @GetMapping("/get/all")
    public List<Employee> getData() {
        return employeeService.getData();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam Integer departmentId,
                        @RequestParam Double salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Integer departmentId) {
        return employeeService.removeEmployee(firstName, lastName, departmentId);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam Integer departmentId) {
        return employeeService.findEmployee(firstName, lastName, departmentId);
    }
}