package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department.DepartmentService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentResponseDTO>> getAll(){
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }
}
