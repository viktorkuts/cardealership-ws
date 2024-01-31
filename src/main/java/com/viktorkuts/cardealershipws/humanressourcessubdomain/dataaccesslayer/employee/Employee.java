package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers", joinColumns = @JoinColumn(name = "employee_id"))
    private List<PhoneNumber> phoneNumbers;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String email;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "commission_rate")
    private Double commissionRate;

    public Employee(@NotNull Address address, @NotNull List<PhoneNumber> phoneNumbers, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull Double salary, @NotNull Double commissionRate) {
        this.employeeIdentifier = new EmployeeIdentifier();
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.commissionRate = commissionRate;
    }
}
