package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.Employee;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponseDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOs = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeResponseDTO resDTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee, resDTO);
            employeeResponseDTOs.add(resDTO);
        });
        return employeeResponseDTOs;
    }
}