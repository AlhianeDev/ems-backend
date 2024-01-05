package com.global.emsbackend.controller;

import com.global.emsbackend.dto.EmployeeDto;

import com.global.emsbackend.service.EmployeeService;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(

        @RequestBody @Valid EmployeeDto employeeDto

    ) {

        return new ResponseEntity<EmployeeDto>(

            employeeService.createEmployee(employeeDto),

            HttpStatus.CREATED

        );

    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));

    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getEmployees() {

        return ResponseEntity.ok(employeeService.getEmployees());

    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(

        @PathVariable("id") Long employeeId, @RequestBody @Valid EmployeeDto employeeDto

    ) {

        return ResponseEntity.ok(

            employeeService.updateEmployeeById(employeeId, employeeDto)

        );

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(

        @PathVariable("id") Long employeeId

    ) {

        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok(

            "Employee with id = " + employeeId + " has been deleted successfully."

        );

    }

}
