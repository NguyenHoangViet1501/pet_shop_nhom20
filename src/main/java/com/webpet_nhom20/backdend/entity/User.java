package com.webpet_nhom20.backdend.entity;


import com.webpet_nhom20.backdend.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "email" , unique = true , nullable = false , length = 100 )
    String email;

    @Column(name = "password" ,nullable = false , length = 100)
    String password;

    @Column(name = "username" , unique = true , nullable = false , length = 100)
    String username;

    @Column(name = "full_name" , nullable = false , length = 100)
    String fullName;

    @Column(name = "phone" , nullable = false , length = 100)
    String phone;

    @Column(name = "role")
    String roles;

    @Column(name = "is_deleted", length = 1)
    String isDeleted;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    Date createdDate;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    Date updatedDate;





}
