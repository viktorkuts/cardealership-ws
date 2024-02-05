package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee.EmployeeService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeRequestModel;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponseModel>> getAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseModel> getById(@PathVariable String employeeId){
        return ResponseEntity.ok().body(employeeService.getEmployee(employeeId));
    }
    @PostMapping()
    public ResponseEntity<EmployeeResponseModel> add(@RequestBody EmployeeRequestModel employeeRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeRequestModel));
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseModel> update(@PathVariable String employeeId, @RequestBody EmployeeRequestModel employeeRequestModel){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeId, employeeRequestModel));
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
