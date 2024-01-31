package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponseDTO> getAllEmployees();
}
