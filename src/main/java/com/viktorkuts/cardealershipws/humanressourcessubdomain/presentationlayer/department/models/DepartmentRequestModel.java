package com.viktorkuts.cardealershipws.humanressourcessubdomain.presentationlayer.department.models;

import com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestModel {
    private String name;
    private Integer headCount;
    private List<Position> positions;
}
