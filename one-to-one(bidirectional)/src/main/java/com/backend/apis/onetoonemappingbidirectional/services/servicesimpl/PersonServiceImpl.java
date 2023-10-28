package com.backend.apis.onetoonemappingbidirectional.services.servicesimpl;
import com.backend.apis.onetoonemappingbidirectional.dtos.PassportDTO;
import com.backend.apis.onetoonemappingbidirectional.dtos.PersonDTO;
import com.backend.apis.onetoonemappingbidirectional.entities.Passport;
import com.backend.apis.onetoonemappingbidirectional.entities.Person;
import com.backend.apis.onetoonemappingbidirectional.exceptions.ResourceNotFoundException;
import com.backend.apis.onetoonemappingbidirectional.repositories.PassportRepository;
import com.backend.apis.onetoonemappingbidirectional.repositories.PersonRepository;
import com.backend.apis.onetoonemappingbidirectional.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final PassportRepository passportRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,ModelMapper modelMapper,PassportRepository passportRepository) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
        this.passportRepository = passportRepository;
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO,Person.class);
        Person person1 = personRepository.save(person);
        return modelMapper.map(person1,PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(person -> modelMapper.map(person,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person "," id" , id));
        return modelMapper.map(person,PersonDTO.class);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person "," id" , id));
        personRepository.delete(person);
    }

    @Override
    public PassportDTO getPassportByPersonSecretKey(String secretKey) {
        Passport passport =  personRepository.findPassportBySecretKey(secretKey).orElseThrow(() -> new ResourceNotFoundException("Passport "," secret key",secretKey));
        return modelMapper.map(passport,PassportDTO.class);

    }
}