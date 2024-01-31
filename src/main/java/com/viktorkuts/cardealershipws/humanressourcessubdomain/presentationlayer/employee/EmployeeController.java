package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee.EmployeeService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeRequestDTO;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;
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
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable String employeeId){
        return ResponseEntity.ok().body(employeeService.getEmployee(employeeId));
    }
    @PostMapping()
    public ResponseEntity<EmployeeResponseDTO> add(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeRequestDTO));
    }
    @PutMapping()
    public ResponseEntity<EmployeeResponseDTO> update(String employeeId, @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeId, employeeRequestDTO));
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
