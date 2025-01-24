package com.bhautik.bsm.service;

import com.bhautik.bsm.entitys.Hospital;
import com.bhautik.bsm.requestdto.HospitalRequest;
import com.bhautik.bsm.responsedto.HospitalResponse;

public interface HospitalService {
    Hospital add(Hospital hospital);

    Hospital findHospital(int hospitalId);

    HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId);
}
