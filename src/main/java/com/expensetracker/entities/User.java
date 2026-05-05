package com.expensetracker.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name", nullable = false)
    private String name;
 
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
 
    @NotBlank(message = "Password is required")
    @Column(name = "password", nullable = false)
    private String password;
 
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
 
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public User() {
    }

}
