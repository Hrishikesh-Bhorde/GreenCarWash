package com.greencarwash.OrderService.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "wash_orders") 
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private LocalDateTime date;
    private String location;
    private String note;
    private double basePrice;
    private double total_cost;
    
    private Long client;
    private Long car;
    private Long washer;
    
    @OneToMany(cascade = CascadeType.MERGE)  
    @JoinColumn(name = "order_id")  
    private List<AddOns> addOns = new ArrayList<>();    

    public enum Status {
        PENDING,
        ACCEPTED,
        ACTIVE,
        COMPLETED
    }
}
