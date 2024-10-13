package org.tyutyunik.employeeWithTestMockito.service;

import org.springframework.stereotype.Service;
import org.tyutyunik.employeeWithTestMockito.exceptions.DepartmentNotFoundException;
import org.tyutyunik.employeeWithTestMockito.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String standardAnswer() {
        return "Добро пожаловать в менеджер сотрудников";
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getData());

        for (Employee employee : employees) {
            if (Objects.equals(employee.getDepartmentId(), departmentId)) {
                return employeeService.getData()
                        .stream()
                        .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                        .collect(Collectors.toList());
            }
        }
        throw new DepartmentNotFoundException();
    }

    @Override
    public Double getSumSalariesByDepartmentId(Integer departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getData());

        for (Employee employee : employees) {
            if (Objects.equals(employee.getDepartmentId(), departmentId)) {
                return employeeService.getData()
                        .stream()
                        .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                        .mapToDouble(Employee::getSalary).sum();
            }
        }
        throw new DepartmentNotFoundException();
    }

    @Override
    public Double getMaxSalaryByDepartmentId(Integer departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getData());

        for (Employee employee : employees) {
            if (Objects.equals(employee.getDepartmentId(), departmentId)) {
                return employeeService.getData()
                        .stream()
                        .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                        .map(Employee::getSalary)
                        .max(Double::compare)
                        .orElseThrow(DepartmentNotFoundException::new);
            }
        }
        throw new DepartmentNotFoundException();
    }

    @Override
    public Double getMinSalaryByDepartmentId(Integer departmentId) {
        List<Employee> employees = new ArrayList<>(employeeService.getData());

        for (Employee employee : employees) {
            if (Objects.equals(employee.getDepartmentId(), departmentId)) {
                return employeeService.getData()
                        .stream()
                        .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                        .map(Employee::getSalary)
                        .min(Double::compare)
                        .orElseThrow(DepartmentNotFoundException::new);
            }
        }
        throw new DepartmentNotFoundException();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartment() {
        return employeeService.getData()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
