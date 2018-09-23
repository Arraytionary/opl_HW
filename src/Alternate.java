import java.util.Iterator;

public class Alternate<E> implements Iterable<E>{

    public Alternate(Iterable<E> it1, Iterable<E> it2){
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Override
    public Iterator<E> iterator() {
        return new GenericListIterator();
    }

    private class GenericListIterator<T> implements Iterator<T>{
        private T[] gList;
        private int size;
        private int crrPosition = 0;

        public GenericListIterator(T[] gList){
            this.gList = gList;
            this.size = gList.length;
        }

        @Override
        public boolean hasNext() {
            return crrPosition < size;
        }

        @Override
        public Object next() {
            return gList[crrPosition++];
        }
    }
}
