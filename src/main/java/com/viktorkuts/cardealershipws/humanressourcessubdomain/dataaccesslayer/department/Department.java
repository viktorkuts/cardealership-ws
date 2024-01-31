package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private DepartmentIdentifier departmentIdentifier;
    @Column(name = "name")
    private String name;
    @Column(name = "head_count")
    private Integer headCount;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "department_positions", joinColumns = @JoinColumn(name = "department_id"))
    private List<Position> positions;

    public Department(@NotNull String name, @NotNull Integer headCount, @NotNull List<Position> positions){
        this.name = name;
        this.headCount = headCount;
        this.positions = positions;
    }

}
