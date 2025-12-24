@Entity
public class FraudCheckResult {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Claim claim;

    private boolean isFraudulent;
    private String matchedRules;
    private String rejectionReason;
    private LocalDateTime checkedAt;

    public FraudCheckResult() {}

    @PrePersist
    public void onCreate() {
        checkedAt = LocalDateTime.now();
    }

    // getters + setters
}
