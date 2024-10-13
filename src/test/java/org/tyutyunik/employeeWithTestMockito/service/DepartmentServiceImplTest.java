package org.tyutyunik.employeeWithTestMockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tyutyunik.employeeWithTestMockito.model.Employee;
import org.tyutyunik.employeeWithTestMockito.exceptions.*;

class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void standardAnswer_shouldReturnExpectedString() {
        String expected = "Добро пожаловать в менеджер сотрудников";
        String actual = departmentServiceImpl.standardAnswer();
        assertEquals(expected, actual);
    }

    @Test
    void getEmployeesByDepartmentId_shouldReturnCorrectEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Employee("John", "Doe", 1, 50000.0));
        expectedEmployees.add(new Employee("Jane", "Smith", 1, 60000.0));
        when(employeeService.getData()).thenReturn(expectedEmployees);
        List<Employee> actualEmployees = departmentServiceImpl.getEmployeesByDepartmentId(1);
        assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    void getEmployeesByDepartmentId_shouldThrowDepartmentNotFoundException() {
        List<Employee> emptyList = new ArrayList<>();
        when(employeeService.getData()).thenReturn(emptyList);
        assertThrows(DepartmentNotFoundException.class, () -> {
            departmentServiceImpl.getEmployeesByDepartmentId(1);
        });
    }

    @Test
    void getSumSalariesByDepartmentId_shouldReturnCorrectSum() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", 1, 50000.0));
        employees.add(new Employee("Jane", "Smith", 1, 60000.0));
        when(employeeService.getData()).thenReturn(employees);
        Double expectedSum = 110000.0;
        Double actualSum = departmentServiceImpl.getSumSalariesByDepartmentId(1);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void getSumSalariesByDepartmentId_shouldThrowDepartmentNotFoundException() {
        List<Employee> emptyList = new ArrayList<>();
        when(employeeService.getData()).thenReturn(emptyList);
        assertThrows(DepartmentNotFoundException.class, () -> {
            departmentServiceImpl.getSumSalariesByDepartmentId(1);
        });
    }

    @Test
    void getEmployeesGroupByDepartment_shouldReturnCorrectMap() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", 1, 50000.0));
        employees.add(new Employee("Jane", "Smith", 1, 60000.0));
        employees.add(new Employee("Mike", "Johnson", 2, 70000.0));
        when(employeeService.getData()).thenReturn(employees);
        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(1, List.of(employees.get(0), employees.get(1)));
        expectedMap.put(2, List.of(employees.get(2)));
        Map<Integer, List<Employee>> actualMap = departmentServiceImpl.getEmployeesGroupByDepartment();
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void getEmployeesGroupByDepartment_shouldReturnEmptyMapIfNoEmployees() {
        List<Employee> emptyList = new ArrayList<>();
        when(employeeService.getData()).thenReturn(emptyList);
        Map<Integer, List<Employee>> actualMap = departmentServiceImpl.getEmployeesGroupByDepartment();
        assertTrue(actualMap.isEmpty());
    }
}
