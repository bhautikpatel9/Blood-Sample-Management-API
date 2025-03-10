package com.bhautik.bsm.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")  // Foreign Key in Address Table
    private User user;
}
