package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.models;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Position;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentResponseModel {
    private String departmentId;
    private String name;
    private Integer headCount;
    private List<Position> positions;
}
