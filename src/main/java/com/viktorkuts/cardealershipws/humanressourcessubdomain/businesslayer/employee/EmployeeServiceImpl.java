package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.Employee;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.EmployeeIdentifier;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseModel;
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

    public List<EmployeeResponseModel> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseModel> employeeResponseModels = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeResponseModel resDTO = new EmployeeResponseModel();
            BeanUtils.copyProperties(employee, resDTO);
            resDTO.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
            employeeResponseModels.add(resDTO);
        });
        return employeeResponseModels;
    }

    public EmployeeResponseModel getEmployee(String employeeId){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier_EmployeeId(employeeId);
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        EmployeeResponseModel dto = new EmployeeResponseModel();
        dto.setEmployeeId(foundEmployee.getEmployeeIdentifier().getEmployeeId());
        BeanUtils.copyProperties(foundEmployee, dto);
        return dto;
    }

    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestModel, employee);
        employee.setEmployeeIdentifier(new EmployeeIdentifier());
        employeeRepository.save(employee);
        EmployeeResponseModel resDTO = new EmployeeResponseModel();
        resDTO.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
        BeanUtils.copyProperties(employee, resDTO);
        return resDTO;
    }

    public EmployeeResponseModel updateEmployee(String employeeId, EmployeeRequestModel employeeRequestModel){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier_EmployeeId(employeeId);
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        BeanUtils.copyProperties(employeeRequestModel, foundEmployee);
        employeeRepository.save(foundEmployee);
        EmployeeResponseModel resDTO = new EmployeeResponseModel();
        resDTO.setEmployeeId(foundEmployee.getEmployeeIdentifier().getEmployeeId());
        BeanUtils.copyProperties(foundEmployee, resDTO);
        return resDTO;
    }
    public void deleteEmployee(String employeeId){
        Employee foundEmployee = employeeRepository.getEmployeeByEmployeeIdentifier_EmployeeId(employeeId);
        if(foundEmployee == null){
            throw new NotFoundException("Unknown employeeId " + employeeId);
        }
        employeeRepository.delete(foundEmployee);
    }
}