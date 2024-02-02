package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Department;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;
import com.viktorkuts.cardealershipws.utils.exceptions.InUseException;
import com.viktorkuts.cardealershipws.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
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

    public DepartmentResponseDTO getDepartment(String departmentId){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier(new DepartmentIdentifier(departmentId));
        DepartmentResponseDTO resDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(foundDepartment, resDTO);
        return resDTO;
    }

    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequestDTO){
        Department department = new Department();
        department.setDepartmentIdentifier(new DepartmentIdentifier());
        BeanUtils.copyProperties(departmentRequestDTO, department);
        departmentRepository.save(department);
        DepartmentResponseDTO resDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(department, resDTO);
        return resDTO;
    }

    public DepartmentResponseDTO updateDepartment(String departmentId, DepartmentRequestDTO departmentRequestDTO){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier(new DepartmentIdentifier(departmentId));
        if(foundDepartment == null){
            throw new NotFoundException("Unknown departmentId " + departmentId);
        }
        BeanUtils.copyProperties(departmentRequestDTO, foundDepartment);
        departmentRepository.save(foundDepartment);
        DepartmentResponseDTO resDTO = new DepartmentResponseDTO();
        BeanUtils.copyProperties(foundDepartment, resDTO);
        return resDTO;
    }

    public void deleteDepartment(String departmentId){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier(new DepartmentIdentifier(departmentId));
        if(foundDepartment == null){
            throw new NotFoundException("Unknown departmentId " + departmentId);
        }
        try{
            departmentRepository.delete(foundDepartment);
        }catch (DataIntegrityViolationException exception){
            throw new InUseException("Department " + departmentId + " is in use, contains dependency Employee");
        }
    }

}
