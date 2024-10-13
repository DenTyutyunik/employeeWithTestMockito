package org.tyutyunik.employeeWithTestMockito.service;

import org.tyutyunik.employeeWithTestMockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    String standardAnswer();

    List<Employee> getEmployeesByDepartmentId(Integer id);

    Double getSumSalariesByDepartmentId(Integer id);

    Double getMaxSalaryByDepartmentId(Integer id);

    Double getMinSalaryByDepartmentId(Integer id);

    Map<Integer, List<Employee>> getEmployeesGroupByDepartment();
}
