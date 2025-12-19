package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public Claim submitClaim(@RequestBody Claim claim) {
        return claimService.createClaim(claim);
    }

    @GetMapping("/{id}")
    public Claim getClaim(@PathVariable Long id) {
        return claimService.getClaim(id);
    }
}
