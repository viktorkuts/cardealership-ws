package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Department;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentResponseDTO> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseDTO> departmentResponseDTOs = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentResponseDTO resDTO = new DepartmentResponseDTO();
            BeanUtils.copyProperties(department, resDTO);
            departmentResponseDTOs.add(resDTO);
        });
        return departmentResponseDTOs;
    }

}
