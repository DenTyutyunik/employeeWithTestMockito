package org.tyutyunik.employeeWithTestMockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee Not Found Exception")
public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException() {
        super("Department Not Found Exception");
    }
}