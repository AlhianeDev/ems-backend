package com.global.emsbackend.repositories;

import com.global.emsbackend.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
