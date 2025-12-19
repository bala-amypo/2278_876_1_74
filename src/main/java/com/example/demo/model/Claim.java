package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate claimDate;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    public Claim() {
    }

    // -------- GETTERS --------

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public Policy getPolicy() {
        return policy;
    }

    // -------- SETTERS --------

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
