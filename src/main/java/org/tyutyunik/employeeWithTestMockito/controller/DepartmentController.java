package org.tyutyunik.employeeWithTestMockito.controller;

import org.springframework.web.bind.annotation.*;
import org.tyutyunik.employeeWithTestMockito.model.Employee;
import org.tyutyunik.employeeWithTestMockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public String standardAnswer() {
        return departmentService.standardAnswer();
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getEmployeesByDepartmentId(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public Double getSumSalariesByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getSumSalariesByDepartmentId(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public Double getMaxSalaryByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMaxSalaryByDepartmentId(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Double getMinSalaryByDepartment(@PathVariable("id") int departmentId) {
        return departmentService.getMinSalaryByDepartmentId(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartment() {
        return departmentService.getEmployeesGroupByDepartment();
    }
}
