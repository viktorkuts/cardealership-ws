package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class EmployeeIdentifier {
    @Column(name = "employee_id")
    private String employeeId;

    public EmployeeIdentifier(){
        this.employeeId = UUID.randomUUID().toString();
    }

}
