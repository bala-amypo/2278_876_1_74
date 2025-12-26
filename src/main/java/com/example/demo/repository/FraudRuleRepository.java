package com.example.demo.repository;

import com.example.demo.model.FraudRule;

import java.util.Optional;

public interface FraudRuleRepository {
    Optional<FraudRule> findByRuleName(String ruleName);
    FraudRule save(FraudRule rule);
}
