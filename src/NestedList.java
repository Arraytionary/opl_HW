import java.util.List;
public interface NestedList<E> {
    boolean isBase();
    // is this a base-case value
// returns the base value if isBase() holds; otherwise throws an
// IllegalStateException exception.
    E getBaseValue();
    // returns the list of nested lists if isBase() is false; otherwise throws
// an IllegalStateException exception
    List<NestedList<E>> getList();
}