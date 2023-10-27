package com.one.to.one.unidirectional.mapping.controllers;

import com.one.to.one.unidirectional.mapping.dtos.PassportDTO;
import com.one.to.one.unidirectional.mapping.payloads.ApiResponse;
import com.one.to.one.unidirectional.mapping.services.PassportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/passports")
public class PassportController {

    private final PassportService passportService;

    @Autowired
    PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping
    public ResponseEntity<PassportDTO> addPassport(@Valid @RequestBody PassportDTO passportDTO) {
        PassportDTO passportDTO1 = passportService.createPassport(passportDTO);
        return new ResponseEntity<>(passportDTO1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PassportDTO>> getAllPassports() {
        List<PassportDTO> passportDTOList = passportService.getAllPassport();
        return new ResponseEntity<>(passportDTOList,HttpStatus.OK);
    }

    @GetMapping("/{passportId}")
    public ResponseEntity<PassportDTO> getPassportById(@PathVariable Long passportId) {
        PassportDTO passportDTO = passportService.getPassportById(passportId);
        return new ResponseEntity<>(passportDTO,HttpStatus.OK);
    }

    @DeleteMapping("/passportId")
    public ResponseEntity<ApiResponse> deletePassport(@PathVariable Long passportId) {
        passportService.deletePassport(passportId);
        return new ResponseEntity<>(new ApiResponse("Passport delete successfully !",true),HttpStatus.OK);
    }
}
