package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.employee.models;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.Address;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeResponseModel {
    private String employeeId;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Double commissionRate;
}
