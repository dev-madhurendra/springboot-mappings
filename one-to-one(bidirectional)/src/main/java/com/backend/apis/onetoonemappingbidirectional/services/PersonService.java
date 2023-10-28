package com.backend.apis.onetoonemappingbidirectional.services;

import com.backend.apis.onetoonemappingbidirectional.dtos.PassportDTO;
import com.backend.apis.onetoonemappingbidirectional.dtos.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(PersonDTO personDTO);
    List<PersonDTO> getAllPerson();
    PersonDTO getPersonById(Long id);
    void deletePerson(Long id);
    PassportDTO getPassportByPersonSecretKey(String secretKey);

}