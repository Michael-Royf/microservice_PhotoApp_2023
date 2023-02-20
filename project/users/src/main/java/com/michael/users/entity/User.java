package com.michael.users.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = -2731425678149216053L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @Column(name = "user_id", nullable = false, updatable = false, unique = true)
    private String userId;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false)
    @JsonIgnore
    private String encryptedPassword;
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @CreationTimestamp
    @Column(updatable = false, name = "registration_date")
    private LocalDateTime registrationDate;
    @UpdateTimestamp
    @Column(updatable = true, name = "updated_date")
    private LocalDateTime updateDate;
}
