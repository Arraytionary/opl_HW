import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Alternate<E> implements Iterable<E>{
    Iterator<E> crr;
    Iterator<E> next;


    public Alternate(Iterable<E> it1, Iterable<E> it2){

        crr = it1.iterator();
        next = it2.iterator();
    }

    public static void main(String[] args){
        List<Integer> it1 = Arrays.asList(3,9,11,24,81,99,108);
        List<Integer> it2 = Arrays.asList(4,6,9,2);
//        for(Integer e : new Alternate<>(it1, it2)) {
//            System.out.println(e);
//        }
        for(Iterator i = new Alternate(it1,it2).iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new GenericListIterator();
    }

    private class GenericListIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return crr.hasNext() || next.hasNext();
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
                return crr.next();
            }
            return null;
        }
    }
}
