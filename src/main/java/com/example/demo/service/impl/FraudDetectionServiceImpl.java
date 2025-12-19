package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.service.FraudDetectionService;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final ClaimRepository claimRepository;
    private final FraudCheckResultRepository fraudCheckResultRepository;

    public FraudDetectionServiceImpl(ClaimRepository claimRepository,
                                     FraudCheckResultRepository fraudCheckResultRepository) {
        this.claimRepository = claimRepository;
        this.fraudCheckResultRepository = fraudCheckResultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);

        // Simple fraud rule (example required by tests)
        if (claim.getAmount() > 100000) {
            result.setFraudulent(true);
            result.setReason("High claim amount");
        } else {
            result.setFraudulent(false);
            result.setReason("No fraud detected");
        }

        return fraudCheckResultRepository.save(result);
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {

        FraudCheckResult result =
                fraudCheckResultRepository.findByClaimId(claimId);

        if (result == null) {
            throw new ResourceNotFoundException("Fraud result not found");
        }

        return result;
    }
}
