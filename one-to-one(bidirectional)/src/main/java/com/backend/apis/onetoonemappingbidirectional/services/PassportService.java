package com.backend.apis.onetoonemappingbidirectional.services;

import com.backend.apis.onetoonemappingbidirectional.dtos.PassportDTO;

import java.util.List;
public interface PassportService {
    PassportDTO createPassport(PassportDTO passportDTO,Long personId);
    List<PassportDTO> getAllPassport();
    void deletePassport(Long id);
    PassportDTO getPassportById(Long id);
}
