package specification;

public class OrSpecification extends CompositeSpecification {
    private final Specification One;
    private final Specification Other;

    public OrSpecification(Specification x, Specification y) {
        One = x;
        Other = y;
    }

    @Override
    public boolean IsSatisfiedBy(Object candidate) {
        return One.IsSatisfiedBy(candidate) || Other.IsSatisfiedBy(candidate);
    }
}
