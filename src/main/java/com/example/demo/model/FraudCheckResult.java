package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "claim_id", unique = true)
    private Claim claim;

    private boolean fraudulent;

    private String reason;

    private LocalDateTime checkedAt;

    public FraudCheckResult() {
    }

    // ---------- GETTERS ----------

    public Long getId() {
        return id;
    }

    public Claim getClaim() {
        return claim;
    }

    public boolean isFraudulent() {
        return fraudulent;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    // ---------- SETTERS ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public void setFraudulent(boolean fraudulent) {
        this.fraudulent = fraudulent;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }

    // ---------- AUTO TIMESTAMP ----------

    @PrePersist
    public void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }
}
