package com.backend.apis.onetoonemappingbidirectional.services.servicesimpl;

import com.backend.apis.onetoonemappingbidirectional.dtos.PassportDTO;
import com.backend.apis.onetoonemappingbidirectional.entities.Passport;
import com.backend.apis.onetoonemappingbidirectional.entities.Person;
import com.backend.apis.onetoonemappingbidirectional.exceptions.ResourceNotFoundException;
import com.backend.apis.onetoonemappingbidirectional.repositories.PassportRepository;
import com.backend.apis.onetoonemappingbidirectional.repositories.PersonRepository;
import com.backend.apis.onetoonemappingbidirectional.services.PassportService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final ModelMapper modelMapper;
    private final PersonRepository personRepository;

    @Autowired
    PassportServiceImpl(PassportRepository passportRepository,ModelMapper modelMapper,PersonRepository personRepository) {
        this.modelMapper = modelMapper;
        this.passportRepository = passportRepository;
        this.personRepository = personRepository;
    }

    @Override
    public PassportDTO createPassport(PassportDTO passportDTO,Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person " , " id " , personId));
        Passport passport = passportRepository.save(modelMapper.map(passportDTO, Passport.class));
        passport.setPerson(person);
        return modelMapper.map(passport, PassportDTO.class);
    }

    @Override
    public List<PassportDTO> getAllPassport() {
        List<Passport> passports = passportRepository.findAll();
        return passports.stream().map(passport -> {
            Person person = personRepository.findById(passport.getPerson().getId()).orElseThrow(() -> new ResourceNotFoundException("Person " , " id " , passport.getPerson().getId()));
            passport.setPerson(person);
            return modelMapper.map(passport, PassportDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public void deletePassport(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passport "," id",id));
        passportRepository.delete(passport);
    }

    @Override
    public PassportDTO getPassportById(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passport "," id",id));
        Person person = personRepository.findById(passport.getPerson().getId()).orElseThrow(() -> new ResourceNotFoundException("Person " , " id " , passport.getPerson().getId()));
        passport.setPerson(person);
        return modelMapper.map(passport, PassportDTO.class);
    }



}