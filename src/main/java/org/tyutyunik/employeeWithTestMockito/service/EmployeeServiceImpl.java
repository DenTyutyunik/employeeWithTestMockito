package org.tyutyunik.employeeWithTestMockito.service;

import org.springframework.stereotype.Service;
import org.tyutyunik.employeeWithTestMockito.model.Employee;
import org.tyutyunik.employeeWithTestMockito.exceptions.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String standardAnswer() {
        return "Добро пожаловать в менеджер сотрудников";
    }

    @Override
    public List<Employee> getData() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Double salary) {
        if (employees.size() >= EMPLOYEES_MAX) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, departmentId);
        boolean removed = employees.remove(employee);
        if (!removed) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer departmentId) {
        Employee employee = new Employee(firstName, lastName, departmentId);
        int i = employees.indexOf(employee);
        if (i == -1) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(i);
    }
}
