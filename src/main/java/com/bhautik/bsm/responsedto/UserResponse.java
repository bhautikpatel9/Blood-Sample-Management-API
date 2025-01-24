package com.bhautik.bsm.responsedto;

import com.bhautik.bsm.enums.BloodGroup;
import com.bhautik.bsm.enums.Gender;
import com.bhautik.bsm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String userName;
    private UserRole userRole;
    private BloodGroup bloodGroup;
    private LocalDate lastDonatedAt;
    private int age;
    private Gender gender;
    private String availableCity;
    private boolean verified;
}
