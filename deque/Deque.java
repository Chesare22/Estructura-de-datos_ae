package deque;

public interface Deque {

    public int size();

    public boolean isEmpty();

    public void insertLast(Object o);

    public void insertFirst(Object o);

    public Object removeFirst();

    public Object removeLast();

    public Object first();

    public Object last();

}
