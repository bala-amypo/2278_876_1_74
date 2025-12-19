package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Policy;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public Policy createPolicy(Policy policy) {

        if (policyRepository.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Duplicate policy number");
        }

        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepository.findByUserId(userId);
    }
}
