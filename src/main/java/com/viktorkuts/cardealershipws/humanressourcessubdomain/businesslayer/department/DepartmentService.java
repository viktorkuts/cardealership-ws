package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseModel;

import java.util.List;

public interface DepartmentService {
    public List<DepartmentResponseModel> getAllDepartments();
    public DepartmentResponseModel getDepartment(String departmentId);
    public DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);
    public DepartmentResponseModel updateDepartment(String departmentId, DepartmentRequestModel departmentRequestModel);
    public void deleteDepartment(String departmentId);
}
