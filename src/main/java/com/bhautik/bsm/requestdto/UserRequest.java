package com.bhautik.bsm.requestdto;

import com.bhautik.bsm.enums.BloodGroup;
import com.bhautik.bsm.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    private String userName;

    @NotNull
    @NotBlank
//    @Pattern(regexp = "^[a-z0-9]([a-z0-9])*@gmail\\.com$\n",message = "The first character must be a letter or a digit Matches zero or more occurrences of Must end with @gmail.com")
    private String email;

//    @NotNull
//    @NotBlank
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@^&#%])[A-Za-z@^&#%]{8,}$\n",message = "Password must be at least 8 characters loag and contain at least one uppercase letter, one lowercase letter and special character(@,^,&,#,%)")
    private String password;

//    @NotNull
//    @NotBlank
//    @Pattern(regexp = "^(\\+?[1-9][0-9]{0,2})? ?[6-9][0-9]{9}$\n",message = "Matches the optional country code and Allows an optional space after the country code then  Matches a 10-digit mobile number")
    private String phoneNumber;

//    @NotNull
//    @NotBlank
    private BloodGroup bloodGroup;

//    @NotNull
//    @NotBlank
//    @Pattern(regexp = "^(?:[1-9][0-9]?|1[0-4][0-9]|150|0)$\n",message = "Must be 1 to 3 digits")
    private int age;

//    @NotNull
//    @NotBlank
    private Gender gender;

//    @NotNull
//    @NotBlank
//    @Pattern(regexp = "^[A-Za-z]+(?:[\\s-][A-Za-z]+)*$\n",message = "Matches the first part of the city name (letters only, at least one character)")
    private String availableCity;
}
