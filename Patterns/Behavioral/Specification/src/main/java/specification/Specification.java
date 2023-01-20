package specification;

public interface Specification {
    boolean IsSatisfiedBy(Object candidate);
    Specification And(Specification other);
    Specification Or(Specification other);
    Specification Not();
}
