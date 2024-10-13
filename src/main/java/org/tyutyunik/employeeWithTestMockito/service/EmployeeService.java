package org.tyutyunik.employeeWithTestMockito.service;

import org.tyutyunik.employeeWithTestMockito.model.Employee;

import java.util.List;

public interface EmployeeService {
    static final int EMPLOYEES_MAX = 10;

    String standardAnswer();

    List<Employee> getData();

    Employee addEmployee(String firstName, String lastName, Integer departmentId, Double salary);

    Employee removeEmployee(String firstName, String lastName, Integer departmentId);

    Employee findEmployee(String firstName, String lastName, Integer departmentId);
}
