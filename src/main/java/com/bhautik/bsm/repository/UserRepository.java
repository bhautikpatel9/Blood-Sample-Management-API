package com.bhautik.bsm.repository;

import com.bhautik.bsm.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
