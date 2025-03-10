package com.bhautik.bsm.repository;

import com.bhautik.bsm.entitys.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
