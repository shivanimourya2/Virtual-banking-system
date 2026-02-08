package com.vbs.demo.models;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ✅ SETTERS (IMPORTANT)
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    private String insuranceType;
    @Setter
    private double amount;
    @Setter
    private String status;
    @Setter
    private LocalDate appliedDate;

    // ✅ GETTERS
    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

}
