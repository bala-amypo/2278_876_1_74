package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Policy policy;

    private LocalDate claimDate;

    private Double claimAmount;

    private String description;

    private String status = "PENDING";

    public Claim() {}

    public Long getId() {
        return id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
