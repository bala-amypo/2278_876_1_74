package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Expected by FraudDetectionServiceImpl
    private boolean isFraudulent;

    private String triggeredRuleName;

    private String rejectionReason;

    @OneToOne(mappedBy = "fraudCheckResult")
    private Claim claim;

    public FraudCheckResult() {
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    // 🔥 REQUIRED BY SERVICE
    public void setIsFraudulent(boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }

    public String getTriggeredRuleName() {
        return triggeredRuleName;
    }

    // 🔥 REQUIRED BY SERVICE
    public void setTriggeredRuleName(String triggeredRuleName) {
        this.triggeredRuleName = triggeredRuleName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    // 🔥 REQUIRED BY SERVICE
    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
