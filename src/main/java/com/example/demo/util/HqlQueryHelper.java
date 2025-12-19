@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return entityManager.createQuery(
            "FROM Claim c WHERE LOWER(c.description) LIKE LOWER(:k)",
            Claim.class
        ).setParameter("k", "%" + keyword + "%").getResultList();
    }

    public List<Claim> findHighValueClaims(Double minAmount) {
        return entityManager.createQuery(
            "FROM Claim c WHERE c.claimAmount > :a",
            Claim.class
        ).setParameter("a", minAmount).getResultList();
    }
}
