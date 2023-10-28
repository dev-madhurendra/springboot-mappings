package com.backend.apis.onetoonemappingbidirectional.dtos;

import com.backend.apis.onetoonemappingbidirectional.utils.AppConstants;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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