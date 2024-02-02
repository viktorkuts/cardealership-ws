package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department getDepartmentByDepartmentIdentifier(DepartmentIdentifier departmentIdentifier);
}
