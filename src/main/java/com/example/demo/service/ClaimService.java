package com.example.demo.service;

import com.example.demo.model.Claim;

import java.util.List;

public interface ClaimService {

    Claim createClaim(Claim claim);

    Claim getClaim(Long claimId);

    List<Claim> getAllClaims();
}
