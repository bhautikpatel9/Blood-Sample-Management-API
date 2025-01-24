package com.bhautik.bsm.entitys;

import com.bhautik.bsm.enums.AdminType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @OneToOne
    private User user;

    @ManyToOne
    private Hospital hospital;

    private AdminType adminType;
}
