package com.global.emsbackend.service;

import com.global.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getEmployees();

    EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

}
