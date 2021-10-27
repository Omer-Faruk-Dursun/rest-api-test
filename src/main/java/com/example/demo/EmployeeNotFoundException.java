package com.example.demo;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}
