package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private String policyHolderName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String policyType;

    // 🔹 Relationship with User (needed for setUser())
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 🔹 Relationship with Claim
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private Set<Claim> claims = new HashSet<>();

    public Policy() {
    }

    public Policy(String policyNumber, String policyHolderName,
                  LocalDate startDate, LocalDate endDate, String policyType) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.policyType = policyType;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    // ✅ REQUIRED BY PolicyServiceImpl
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Claim> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }
}
