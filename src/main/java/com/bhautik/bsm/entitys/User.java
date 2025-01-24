package com.bhautik.bsm.entitys;

import com.bhautik.bsm.enums.BloodGroup;
import com.bhautik.bsm.enums.Gender;
import com.bhautik.bsm.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private BloodGroup bloodGroup;
    private LocalDate lastDonatedAt;
    private int age;
    private Gender gender;
    private String availableCity;
    private boolean verified;
    private UserRole userRole;

    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private Admin admin;

}
