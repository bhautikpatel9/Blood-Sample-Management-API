package com.bhautik.bsm.repository;

import com.bhautik.bsm.enums.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
