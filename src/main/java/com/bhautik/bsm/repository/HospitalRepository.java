package com.bhautik.bsm.repository;

import com.bhautik.bsm.entitys.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
