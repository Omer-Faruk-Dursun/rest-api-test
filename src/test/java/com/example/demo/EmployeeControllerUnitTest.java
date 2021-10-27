package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerUnitTest {

    @Mock
    EmployeeRepository employeeRepository;

    EmployeeController employeeController;


    @BeforeEach
    void setUp(){
        this.employeeController = new EmployeeController(employeeRepository);

    }

    @Test
    void one() {
        Employee dummyEmployee = new Employee("Omer","Killer");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(dummyEmployee));
        assertAll(
                () -> assertEquals("Omer",employeeController.one(1).getName()),
                () -> assertEquals("Killer",employeeController.one(1).getRole())
        );

    }
}