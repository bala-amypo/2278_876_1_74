package com.example.demo.model;

public class FraudCheckResult {

    private Long id;
    private String matchedRules;

    public FraudCheckResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatchedRules() { return matchedRules; }
    public void setMatchedRules(String matchedRules) {
        this.matchedRules = matchedRules;
    }
}
