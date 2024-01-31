package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee getEmployeeByEmployeeIdentifier(EmployeeIdentifier employeeIdentifier);
}
