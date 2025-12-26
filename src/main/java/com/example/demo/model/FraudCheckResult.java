package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean fraudDetected;

    private String riskLevel;

    private String message;

    @OneToOne(mappedBy = "fraudCheckResult")
    private Claim claim;

    public FraudCheckResult() {
    }

    public FraudCheckResult(boolean fraudDetected, String riskLevel, String message) {
        this.fraudDetected = fraudDetected;
        this.riskLevel = riskLevel;
        this.message = message;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public boolean isFraudDetected() {
        return fraudDetected;
    }

    public void setFraudDetected(boolean fraudDetected) {
        this.fraudDetected = fraudDetected;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
