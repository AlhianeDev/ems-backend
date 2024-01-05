package com.global.emsbackend.service;

import com.global.emsbackend.dto.EmployeeDto;

import com.global.emsbackend.entity.Employee;

import com.global.emsbackend.exception.ResourceNotFoundException;

import com.global.emsbackend.mapper.EmployeeMapper;

import com.global.emsbackend.repositories.EmployeeRepo;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee savedEmployee = employeeRepo.save(

            EmployeeMapper.mapToEmployee(employeeDto)

        );

        return EmployeeMapper.mapToDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow(

            () -> new ResourceNotFoundException(

                "Employee is not found with the given id " + employeeId

            )

        );

        return EmployeeMapper.mapToDto(employee);

    }

    @Override
    public List<EmployeeDto> getEmployees() {

        List<Employee> employees = employeeRepo.findAll();

        return employees.stream().map(EmployeeMapper::mapToDto).toList();

    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() ->

            new ResourceNotFoundException(

                "Employee is not found with given id " + employeeId

            )

        );

        employee.setFirstName(employeeDto.getFirstName());

        employee.setLastName(employeeDto.getLastName());

        employee.setEmail(employeeDto.getEmail());

        return EmployeeMapper.mapToDto(employeeRepo.save(employee));

    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Optional<Employee> employee = employeeRepo.findById(employeeId);

        if (employee.isPresent()) {

            employeeRepo.deleteById(employeeId);

        } else {

            throw new ResourceNotFoundException(

                "Employee is not found with given id " + employeeId + "!"

            );

        }

    }

}
