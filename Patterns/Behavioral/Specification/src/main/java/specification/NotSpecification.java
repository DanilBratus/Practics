package specification;

public class NotSpecification extends CompositeSpecification {
    private final Specification Wrapped;

    public NotSpecification(Specification x) {
        Wrapped = x;
    }
    @Override
    public boolean IsSatisfiedBy(Object candidate) {
        return !Wrapped.IsSatisfiedBy(candidate);
    }
}
