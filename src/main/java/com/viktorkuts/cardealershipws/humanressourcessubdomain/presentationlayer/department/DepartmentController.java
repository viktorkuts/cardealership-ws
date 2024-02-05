package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.department.DepartmentService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.models.DepartmentRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.models.DepartmentResponseModel;
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
    public ResponseEntity<List<DepartmentResponseModel>> getAll(){
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseModel> get(@PathVariable String departmentId){
        return ResponseEntity.ok().body(departmentService.getDepartment(departmentId));
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseModel> add(@RequestBody DepartmentRequestModel departmentRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestModel));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResponseModel> update(@PathVariable String departmentId, @RequestBody DepartmentRequestModel departmentRequestModel){
        return ResponseEntity.ok().body(departmentService.updateDepartment(departmentId, departmentRequestModel));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> delete(@PathVariable String departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
