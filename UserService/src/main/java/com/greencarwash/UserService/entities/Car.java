package com.greencarwash.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Registration number cannot be null")
    private String registrationNo;

    @NotNull(message = "Car name cannot be null")
    private String name;

    @NotNull(message = "Car type cannot be null")
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;
}
