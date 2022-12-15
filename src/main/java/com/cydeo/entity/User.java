package com.cydeo.entity;
import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Long phoneNumber;
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;


}
