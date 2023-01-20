package specification;

public class AndSpecification extends CompositeSpecification {
    private final Specification One;
    private final Specification Other;

    public AndSpecification(Specification x, Specification y) {
        One = x;
        Other = y;
    }

    @Override
    public boolean IsSatisfiedBy(Object candidate) {
        return One.IsSatisfiedBy(candidate) && Other.IsSatisfiedBy(candidate);
    }
}

