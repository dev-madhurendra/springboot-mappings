package com.backend.apis.onetoonemappingbidirectional.controllers;

import com.backend.apis.onetoonemappingbidirectional.dtos.PassportDTO;
import com.backend.apis.onetoonemappingbidirectional.dtos.PersonDTO;
import com.backend.apis.onetoonemappingbidirectional.payloads.ApiResponse;
import com.backend.apis.onetoonemappingbidirectional.services.servicesimpl.PersonServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        PersonDTO personDTO1 = personService.createPerson(personDTO);
        return new ResponseEntity<>(personDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<PersonDTO> personDTOS = personService.getAllPerson();
        return new ResponseEntity<>(personDTOS,HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long personId) {
        PersonDTO personDTO = personService.getPersonById(personId);
        return new ResponseEntity<>(personDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<ApiResponse> deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return new ResponseEntity<>(new ApiResponse("Person deleted successfully !",true),HttpStatus.OK);
    }

    @GetMapping("/passport")
    public ResponseEntity<PassportDTO> getPassportBySecretKey(@RequestParam String secretKey) {
        PassportDTO passportDTO = personService.getPassportByPersonSecretKey(secretKey);
        return new ResponseEntity<>(passportDTO,HttpStatus.OK);
    }
}
