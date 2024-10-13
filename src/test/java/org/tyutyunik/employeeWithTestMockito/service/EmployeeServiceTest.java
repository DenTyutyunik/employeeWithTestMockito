package org.tyutyunik.employeeWithTestMockito.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.tyutyunik.employeeWithTestMockito.exceptions.*;
import org.tyutyunik.employeeWithTestMockito.model.Employee;

import java.util.List;

class EmployeeServiceTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void getData_shouldReturnEmpty() {
        List<Employee> result = employeeService.getData();
        assertTrue(result.isEmpty());
    }

    @Test
    void addEmployee_shouldReturnSuccess() {
        Employee employee = employeeService.addEmployee("John", "Doe", 1, 50000.0);
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals(1, employee.getDepartmentId());
        assertEquals(50000.0, employee.getSalary());
        assertEquals(1, employeeService.getData().size());
    }

    @Test
    void addEmployee_shouldReturnExceptionEmployeeStorageIsFull() {
        for (int i = 0; i < EmployeeService.EMPLOYEES_MAX; i++) {
            employeeService.addEmployee("Employee", "Test" + i, 1, 10000.0);
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> {
            employeeService.addEmployee("New", "Employee", 1, 10000.0);
        });
    }

    @Test
    void addEmployee_shouldReturnExceptionEmployeeAlreadyAdded() {
        Employee employee = employeeService.addEmployee("John", "Doe", 1, 50000.0);
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.addEmployee("John", "Doe", 1, 50000.0);
        });
    }

    @Test
    void removeEmployee_shouldReturnSuccess() {
        employeeService.addEmployee("John", "Doe", 1, 50000.0);
        employeeService.removeEmployee("John", "Doe", 1);
        assertTrue(employeeService.getData().isEmpty());
    }

    @Test
    void removeEmployee_shouldReturnExceptionEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.removeEmployee("John", "Doe", 1);
        });
    }

    @Test
    void findEmployee_shouldReturnSuccess() {
        employeeService.addEmployee("John", "Doe", 1, 50000.0);
        Employee foundEmployee = employeeService.findEmployee("John", "Doe", 1);
        assertNotNull(foundEmployee);
        assertEquals("John", foundEmployee.getFirstName());
        assertEquals("Doe", foundEmployee.getLastName());
        assertEquals(1, foundEmployee.getDepartmentId());
        assertEquals(50000.0, foundEmployee.getSalary());
    }

    @Test
    void findEmployee_shouldReturnExceptionEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployee("John", "Doe", 1);
        });
    }
}
