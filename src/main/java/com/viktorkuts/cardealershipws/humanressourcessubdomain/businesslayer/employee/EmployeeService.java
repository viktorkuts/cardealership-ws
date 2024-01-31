package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponseDTO> getAllEmployees();
    public EmployeeResponseDTO getEmployee(String employeeId);
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);
    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeRequestDTO employeeRequestDTO);
    public void deleteEmployee(String employeeId);
}
