package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    public List<DepartmentResponseDTO> getAllDepartments();
}