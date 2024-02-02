package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    public List<DepartmentResponseDTO> getAllDepartments();
    public DepartmentResponseDTO getDepartment(String departmentId);
    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequestDTO);
    public DepartmentResponseDTO updateDepartment(String departmentId, DepartmentRequestDTO departmentRequestDTO);
    public void deleteDepartment(String departmentId);
}
