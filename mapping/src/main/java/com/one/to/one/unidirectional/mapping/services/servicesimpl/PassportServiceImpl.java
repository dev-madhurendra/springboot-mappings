package com.one.to.one.unidirectional.mapping.services.servicesimpl;

import com.one.to.one.unidirectional.mapping.dtos.PassportDTO;
import com.one.to.one.unidirectional.mapping.entities.Passport;
import com.one.to.one.unidirectional.mapping.exceptions.ResourceNotFoundException;
import com.one.to.one.unidirectional.mapping.repositories.PassportRepository;
import com.one.to.one.unidirectional.mapping.services.PassportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final ModelMapper modelMapper;

    @Autowired
    PassportServiceImpl(PassportRepository passportRepository,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.passportRepository = passportRepository;
    }

    @Override
    public PassportDTO createPassport(PassportDTO passportDTO) {
        Passport passport = passportRepository.save(modelMapper.map(passportDTO, Passport.class));
        return modelMapper.map(passport, PassportDTO.class);
    }

    @Override
    public List<PassportDTO> getAllPassport() {
        List<Passport> passports = passportRepository.findAll();
        return passports.stream().map(passport -> modelMapper.map(passport, PassportDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePassport(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passport "," id",id));
        passportRepository.delete(passport);
    }

    @Override
    public PassportDTO getPassportById(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passport "," id",id));
        return modelMapper.map(passport, PassportDTO.class);
    }



}
