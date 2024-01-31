package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.businesslayer.employee.EmployeeService;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.dto.EmployeeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
