package com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Department;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentRepository;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseModel;
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

    public List<DepartmentResponseModel> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseModel> departmentResponseModels = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentResponseModel resDTO = new DepartmentResponseModel();
            BeanUtils.copyProperties(department, resDTO);
            resDTO.setDepartmentId(department.getDepartmentIdentifier().getDepartmentId());
            departmentResponseModels.add(resDTO);
        });
        return departmentResponseModels;
    }

    public DepartmentResponseModel getDepartment(String departmentId){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier_DepartmentId(departmentId);
        DepartmentResponseModel resDTO = new DepartmentResponseModel();
        resDTO.setDepartmentId(foundDepartment.getDepartmentIdentifier().getDepartmentId());
        BeanUtils.copyProperties(foundDepartment, resDTO);
        return resDTO;
    }

    public DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel){
        Department department = new Department();
        department.setDepartmentIdentifier(new DepartmentIdentifier());
        BeanUtils.copyProperties(departmentRequestModel, department);
        departmentRepository.save(department);
        DepartmentResponseModel resDTO = new DepartmentResponseModel();
        resDTO.setDepartmentId(department.getDepartmentIdentifier().getDepartmentId());
        BeanUtils.copyProperties(department, resDTO);
        return resDTO;
    }

    public DepartmentResponseModel updateDepartment(String departmentId, DepartmentRequestModel departmentRequestModel){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier_DepartmentId(departmentId);
        if(foundDepartment == null){
            throw new NotFoundException("Unknown departmentId " + departmentId);
        }
        BeanUtils.copyProperties(departmentRequestModel, foundDepartment);
        departmentRepository.save(foundDepartment);
        DepartmentResponseModel resDTO = new DepartmentResponseModel();
        resDTO.setDepartmentId(foundDepartment.getDepartmentIdentifier().getDepartmentId());
        BeanUtils.copyProperties(foundDepartment, resDTO);
        return resDTO;
    }

    public void deleteDepartment(String departmentId){
        Department foundDepartment = departmentRepository.getDepartmentByDepartmentIdentifier_DepartmentId(departmentId);
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
