package com.viktorkuts.cardealershipws.humanressourcessubdomain.dataaccesslayer.department;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Position {
    @Column(name = "title")
    public String title;
    @Column(name = "code")
    public String code;

    public Position(@NotNull String title, @NotNull String code) {
        this.title = title;
        this.code = code;
    }
}
