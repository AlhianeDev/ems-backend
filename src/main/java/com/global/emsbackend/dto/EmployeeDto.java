package com.global.emsbackend.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "First Name Can't Be Null Or Even Blank!")
    private String firstName;

    @NotBlank(message = "Last Name Can't Be Null Or Even Blank!")
    private String lastName;

    @NotBlank(message = "Email Can't Be Null Or Even Blank!")
    @Pattern(
        regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
        message = "Invalid Email Address!"
    )
    private String email;

}
