import javafx.util.Pair;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GenericNested<E> implements NestedList<E>, Iterable<Pair<E, Integer>>{
    private boolean isBase = false;
    private E base;
    private List<NestedList<E>> list;

    private BlockingQueue<Pair<E,Integer>> queue = new ArrayBlockingQueue<>(1);

    public GenericNested(List<NestedList<E>> list){
        this.list = list;
    }

    public GenericNested(E base){
        this.base = base;
        isBase = true;
    }

    @Override
    public boolean isBase() {
        return isBase;
    }

    @Override
    public E getBaseValue() {
        if (isBase()){
            return this.base;
        }
        throw  new IllegalStateException();
    }

    @Override
    public List<NestedList<E>> getList() {
        if (! isBase()){
            return this.list;
        }
        throw  new IllegalStateException();
    }

    @Override
    public Iterator<Pair<E, Integer>> iterator() {
        return  new GenericNestedWalk();
    }
    private class GenericNestedWalk implements Iterator{
        Walk w = new Walk();
        Thread t = new Thread(w);

        @Override
        public boolean hasNext() {
            return ! w.isFinish || ! queue.isEmpty();
        }

        @Override
        public Pair<E,Integer> next() {
            if (! w.isStart){
                t.start();
            }
            try {
                return queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private class Walk implements Runnable {
        boolean isStart = false;
        boolean isFinish = false;

        public void walk(NestedList<E> list, int depth) throws InterruptedException {
            if(list.isBase()){
                queue.put(new Pair(list.getBaseValue(),depth));
            }
            else{
                for (NestedList<E> mem : list.getList()){
                    walk(mem,depth+1);
                }
            }
        }

        @Override
        public void run() {
            isStart = true;
            for (NestedList<E> elm : list){
                try {
                    walk(elm,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isFinish = true;
        }
    }

    public static void main(String[] args) {
        GenericNested one = new GenericNested(1);
        GenericNested two = new GenericNested(2);
        GenericNested three = new GenericNested(3);
        GenericNested four = new GenericNested(4);
        List<GenericNested> listg = Arrays.asList(three,four);
        GenericNested glist = new GenericNested(listg);
        List<GenericNested> Glist = Arrays.asList(glist,four);
        glist = new GenericNested(Glist);
        List<GenericNested> prepList = Arrays.asList(one, glist, two, glist);
        GenericNested testList = new GenericNested(prepList);
        for (Iterator i = testList.iterator(); i.hasNext();){
            System.out.println(i.next().toString());
        }
        }
    }
