package com.bhautik.bsm.serviceimpl;

import com.bhautik.bsm.exception.HospitalNotFoundByIdException;
import com.bhautik.bsm.entitys.Hospital;
import com.bhautik.bsm.service.HospitalService;
import com.bhautik.bsm.repository.HospitalRepository;
import com.bhautik.bsm.requestdto.HospitalRequest;
import com.bhautik.bsm.responsedto.HospitalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public Hospital add(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital findHospital(int hospitalId) {
        Optional<Hospital> optional = hospitalRepository.findById(hospitalId);

        if (optional.isEmpty())
            throw new HospitalNotFoundByIdException("Failed to find Hospital");

        return optional.get();
    }

    @Override
    public HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId) {
        return null;
    }
}
