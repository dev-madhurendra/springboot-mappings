package com.one.to.one.unidirectional.mapping.dtos;

import com.one.to.one.unidirectional.mapping.utils.AppConstants;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    @Size(min = 6,max = 6,message = "Passport number should be of 6 character")
    private String secretKey = AppConstants.generateRandomString(6);
    private PassportDTO passport;

}
