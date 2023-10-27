package com.one.to.one.unidirectional.mapping.services;

import com.one.to.one.unidirectional.mapping.dtos.PassportDTO;
import com.one.to.one.unidirectional.mapping.dtos.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(PersonDTO personDTO,Long passportId);
    List<PersonDTO> getAllPerson();
    PersonDTO getPersonById(Long id);
    void deletePerson(Long id);
    PassportDTO getPassportByPersonSecretKey(String secretKey);

}
