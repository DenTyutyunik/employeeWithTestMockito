package org.tyutyunik.employeeWithTestMockito.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private Double salary;

    public Employee(String firstName, String lastName, Integer departmentId, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Employee name = [" + this.getFullName() + "]," + "departmentId = [" + this.departmentId + "]," + "salary = [" + this.salary + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId);
    }
}
