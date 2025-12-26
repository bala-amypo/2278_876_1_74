package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class FraudRule {

    private Long id;
    private String ruleName;
    private String field;
    private String operator;
    private String value;
    private String severity;

    private Set<Claim> claims = new HashSet<>();

    public FraudRule() {}

    public FraudRule(String ruleName, String field, String operator,
                     String value, String severity) {
        this.ruleName = ruleName;
        this.field = field;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }

    public String getConditionField() {
    return field;
}

public String getOperator() {
    return operator;
}

public String getValue() {
    return value;
}

}
