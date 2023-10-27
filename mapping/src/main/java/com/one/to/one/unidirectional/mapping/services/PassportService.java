package com.one.to.one.unidirectional.mapping.services;

import com.one.to.one.unidirectional.mapping.dtos.PassportDTO;

import java.util.List;
public interface PassportService {
    PassportDTO createPassport(PassportDTO passportDTO);
    List<PassportDTO> getAllPassport();
    void deletePassport(Long id);
    PassportDTO getPassportById(Long id);
}
