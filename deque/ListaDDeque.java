package deque;

import listas.ListaDoble;
import listas.NodoDoble;

public class ListaDDeque implements Deque{

  private ListaDoble lista;

  public ListaDDeque(){
    lista = new ListaDoble();
  }

  @Override
  public int size(){
    return lista.size();
  }
	@Override
  public boolean isEmpty(){
    return lista.vacio();
  }
	@Override
  public void insertFirst(Object o){
    lista.insertaInicio(o);
  }
	@Override
  public void insertLast(Object o){
    lista.insertaFinal(o);
  }
  @Override
  public Object removeFirst(){
    return lista.eliminaInicio();
  }
  @Override
  public Object removeLast(){
    return lista.eliminaFinal();
  }
  @Override
  public Object first(){
    return lista.firstDatum();
  }
  @Override
  public Object last(){
    return lista.lastDatum();
  }
  public void imprimir(){
    lista.imprimir();
  }
  public Object[] toArray(){
    return lista.toArray();
  }
  public static void main(String[] args) {
    ListaDDeque deque = new ListaDDeque();
    deque.insertFirst(7);
    deque.insertFirst(8);
    deque.insertLast(9);
    deque.insertFirst(3);
    deque.insertLast(10);
    deque.insertFirst(33);
    deque.removeFirst();
    deque.imprimir();
    System.out.println("");
    System.out.println(deque.first());
    System.out.println(deque.last());
  }
}
