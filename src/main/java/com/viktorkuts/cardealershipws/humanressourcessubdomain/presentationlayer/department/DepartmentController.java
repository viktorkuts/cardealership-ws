package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department.DepartmentService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto.DepartmentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> get(@PathVariable String departmentId){
        return ResponseEntity.ok().body(departmentService.getDepartment(departmentId));
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseDTO> add(@RequestBody DepartmentRequestDTO departmentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestDTO));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable String departmentId, @RequestBody DepartmentRequestDTO departmentRequestDTO){
        return ResponseEntity.ok().body(departmentService.updateDepartment(departmentId, departmentRequestDTO));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> delete(@PathVariable String departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
