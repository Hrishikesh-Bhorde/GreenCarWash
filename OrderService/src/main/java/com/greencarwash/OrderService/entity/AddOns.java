package com.greencarwash.OrderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddOns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addOnId;

    private String title;
    private String description;
    private double price;

}
