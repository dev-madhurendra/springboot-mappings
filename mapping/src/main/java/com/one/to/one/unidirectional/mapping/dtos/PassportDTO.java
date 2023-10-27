package com.one.to.one.unidirectional.mapping.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportDTO {
    private Long id;
    @Size(min = 8,max = 8,message = "Passport number should be of 8 character")
    private String passportNumber;
}
