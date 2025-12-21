package com.example.demo.util;

import com.example.demo.model.Claim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return entityManager.createQuery(
                "FROM Claim c WHERE LOWER(c.description) LIKE LOWER(:k)",
                Claim.class
        ).setParameter("k", "%" + keyword + "%")
         .getResultList();
    }

    public List<Claim> findHighValueClaims(Double minAmount) {
        return entityManager.createQuery(
                "FROM Claim c WHERE c.claimAmount > :a",
                Claim.class
        ).setParameter("a", minAmount)
         .getResultList();
    }
}
