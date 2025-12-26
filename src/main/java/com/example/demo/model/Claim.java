package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    private LocalDate claimDate;

    private Double claimAmount;

    private String description;

    private String status;

    @ManyToMany(mappedBy = "claims")
    private Set<FraudRule> suspectedRules = new HashSet<>();

    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private FraudCheckResult fraudCheckResult;

    public Claim() {
    }

    public Claim(Policy policy, LocalDate claimDate,
                 Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.status = "PENDING";
    }

    // getters and setters
}
