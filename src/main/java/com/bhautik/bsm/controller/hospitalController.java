package com.bhautik.bsm.controller;

import com.bhautik.bsm.entitys.Hospital;
import com.bhautik.bsm.service.HospitalService;
import com.bhautik.bsm.util.ResponseStructure;
import com.bhautik.bsm.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class hospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/hospital")
    public ResponseEntity<ResponseStructure<Hospital>> add(@RequestBody Hospital hospital){
        hospital = hospitalService.add(hospital);
        return responseBuilder.success(HttpStatus.CREATED,"Hospital created",hospital);
    }
   @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<ResponseStructure<Hospital>> findHospital(@PathVariable int hospitalId){
        Hospital hospital = hospitalService.findHospital(hospitalId);
        return responseBuilder.success(HttpStatus.FOUND, "Hospital Found",hospital);
    }
}
