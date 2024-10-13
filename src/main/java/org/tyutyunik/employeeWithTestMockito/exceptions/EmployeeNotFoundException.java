package org.tyutyunik.employeeWithTestMockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee Not Found Exception")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Employee Not Found Exception");
    }
}
