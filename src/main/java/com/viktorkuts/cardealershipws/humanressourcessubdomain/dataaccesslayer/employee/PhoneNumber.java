package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class PhoneNumber {
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PhoneType type;
    @Column(name = "number")
    private String number;

    public PhoneNumber(@NotNull PhoneType type, @NotNull String number) {
        this.type = type;
        this.number = number;
    }
}
