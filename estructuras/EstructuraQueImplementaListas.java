package estructuras;

public interface EstructuraQueImplementaListas{
  public void push(Object o);
  public Object pop() throws EmptyStructureException;
  public Object peek() throws EmptyStructureException;
  public int size();
  public boolean isEmpty();
}
