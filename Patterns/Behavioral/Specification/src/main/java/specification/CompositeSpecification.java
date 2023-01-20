package specification;

public abstract class CompositeSpecification implements Specification {
    @Override
    public abstract boolean IsSatisfiedBy(Object candidate);

    @Override
    public Specification And(Specification other) {
        return new AndSpecification(this, other);
    }
    @Override
    public Specification Or(Specification other) {
        return new OrSpecification(this, other);
    }
    @Override
    public Specification Not() {
        return new NotSpecification(this);
    }
}
