package com.bhautik.bsm.repository;

import com.bhautik.bsm.entitys.User;
import com.bhautik.bsm.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByEmail(String email);
    public Optional<User> findByPhoneNumber(String phoneNumber);
    public List<User> findByUserNameContaining(String name);
    public List<User> findByBloodGroup(BloodGroup bloodGroup);
    public List<User> findByVerifiedTrue();
}
