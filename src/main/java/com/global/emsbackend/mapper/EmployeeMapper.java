package com.global.emsbackend.mapper;

import com.global.emsbackend.dto.EmployeeDto;

import com.global.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToDto(Employee employee) {

        return new EmployeeDto(

            employee.getId(),

            employee.getFirstName(),

            employee.getLastName(),

            employee.getEmail()

        );

    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        return new Employee(

            employeeDto.getId(),

            employeeDto.getFirstName(),

            employeeDto.getLastName(),

            employeeDto.getEmail()

        );

    }

}

