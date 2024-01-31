package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.dto;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Position;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentResponseDTO {
    private DepartmentIdentifier departmentIdentifier;
    private String name;
    private Integer headCount;
    private List<Position> positions;
}
