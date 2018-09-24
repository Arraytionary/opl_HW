import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Alternate<E> implements Iterable<E>{
    Iterator<E> crr;
    Iterator<E> next;
    Iterator<E> i1;
    Iterator<E> i2;

    public Alternate(Iterable<E> it1, Iterable<E> it2){
        i1 = it1.iterator();
        i2 = it2.iterator();
        crr = i1;
        next = i2;
    }

    public static void main(String[] args){
        List<Integer> it1 = Arrays.asList(3,9,11,24,81);
        List<Integer> it2 = Arrays.asList(4);
        for(Integer e : new Alternate<>(it1, it2)) {
            System.out.println(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new GenericListIterator();
    }

    private class GenericListIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return crr.hasNext();
        }

        @Override
        public E next() {
            if (crr.hasNext()){
                E temp = crr.next();
                Iterator t = crr;
                crr = next.hasNext()?next:crr;
                next = t;
                return temp;
            }
            else if (next.hasNext()){
                crr = next;
                next = crr;
                return crr.next();
            }
            return null;
        }
    }
}
