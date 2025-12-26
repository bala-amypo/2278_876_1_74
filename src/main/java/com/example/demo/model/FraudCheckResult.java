package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isFraudulent;

    private String triggeredRuleName;

    private String rejectionReason;

    public FraudCheckResult() {
    }

    public Long getId() {
        return id;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public void setIsFraudulent(boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }

    public String getTriggeredRuleName() {
        return triggeredRuleName;
    }

    public void setTriggeredRuleName(String triggeredRuleName) {
        this.triggeredRuleName = triggeredRuleName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
