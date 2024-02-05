package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.models.EmployeeRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.models.EmployeeResponseModel;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponseModel> getAllEmployees();
    public EmployeeResponseModel getEmployee(String employeeId);
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);
    public EmployeeResponseModel updateEmployee(String employeeId, EmployeeRequestModel employeeRequestModel);
    public void deleteEmployee(String employeeId);
}
