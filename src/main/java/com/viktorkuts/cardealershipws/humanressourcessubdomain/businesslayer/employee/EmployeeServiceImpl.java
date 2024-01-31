package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.Employee;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;
import com.viktorkuts.cardealershipws.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    public EmployeeResponseDTO getEmployee(String employeeId){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier(new EmployeeIdentifier(employeeId));
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        BeanUtils.copyProperties(foundEmployee, dto);
        return dto;
    }

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDTO, employee);
        employee.setEmployeeIdentifier(new EmployeeIdentifier());
        employeeRepository.save(employee);
        EmployeeResponseDTO resDTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(employee, resDTO);
        return resDTO;
    }

    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeRequestDTO employeeRequestDTO){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier(new EmployeeIdentifier(employeeId));
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        BeanUtils.copyProperties(employeeRequestDTO, foundEmployee);
        employeeRepository.save(foundEmployee);
        EmployeeResponseDTO resDTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(foundEmployee, resDTO);
        return resDTO;
    }
    public void deleteEmployee(String employeeId){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier(new EmployeeIdentifier(employeeId));
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        employeeRepository.delete(foundEmployee);
    }
}