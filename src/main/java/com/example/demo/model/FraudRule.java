@Entity
public class FraudRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String conditionField;
    private String operator;
    private String value;
    private String severity;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    public FraudRule() {}

    public FraudRule(String ruleName, String conditionField,
                     String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // getters + setters
}
