@Entity
public class Claim {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Policy policy;

    private LocalDate claimDate;
    private double claimAmount;
    private String description;
    private String status;

    @ManyToMany
    private Set<FraudRule> suspectedRules = new HashSet<>();

    public Claim() {}

    public Claim(Policy policy, LocalDate claimDate,
                 double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    }

    // getters + setters
}
