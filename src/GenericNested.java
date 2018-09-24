import java.util.List;

class GenericNestedList<E> implements NestedList<E>{

    @Override
    public boolean isBase() {
        return false;
    }

    @Override
    public E getBaseValue() {
        return null;
    }

    @Override
    public List<NestedList<E>> getList() {
        return null;
    }
}