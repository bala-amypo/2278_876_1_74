package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double claimAmount;

    private String claimType;

    private String policyNumber;

    public Claim() {
    }

    public Claim(Double claimAmount, String claimType, String policyNumber) {
        this.claimAmount = claimAmount;
        this.claimType = claimType;
        this.policyNumber = policyNumber;
    }

    public Long getId() {
        return id;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}


// package com.example.demo.model;

// import java.time.LocalDate;
// import java.util.HashSet;
// import java.util.Set;

// public class Claim {

//     private Long id;
//     private Policy policy;
//     private LocalDate claimDate;
//     private double claimAmount;
//     private String description;

//     private Set<FraudRule> suspectedRules = new HashSet<>();

//     public Claim() {}

//     public Claim(Policy policy, LocalDate claimDate, double claimAmount, String description) {
//         this.policy = policy;
//         this.claimDate = claimDate;
//         this.claimAmount = claimAmount;
//         this.description = description;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Policy getPolicy() { return policy; }
//     public void setPolicy(Policy policy) { this.policy = policy; }

//     public LocalDate getClaimDate() { return claimDate; }
//     public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }

//     public double getClaimAmount() { return claimAmount; }
//     public void setClaimAmount(double claimAmount) { this.claimAmount = claimAmount; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public Set<FraudRule> getSuspectedRules() { return suspectedRules; }
//     public void setSuspectedRules(Set<FraudRule> suspectedRules) {
//         this.suspectedRules = suspectedRules;
//     }
// }
