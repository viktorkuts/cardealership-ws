package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
public class DepartmentIdentifier {
    @Column(name = "department_id")
    private String departmentId;

    public DepartmentIdentifier(){
        this.departmentId = UUID.randomUUID().toString();
    }

    public DepartmentIdentifier(String departmentId){
        this.departmentId = departmentId;
    }
}
