package estructuras;

import listas.ListaDoble;

public class Pila implements EstructuraQueImplementaListas{

  protected ListaDoble lista;

  public Pila(){
    lista = new ListaDoble();
  }

  @Override
  public void push(Object o){
    lista.insertaInicio(o);
  }

  @Override
  public Object pop(){
    if(isEmpty()){
      throw new EmptyStructureException("La pila esta vacia");
    }
    return lista.eliminaInicio();
  }

  @Override
  public Object peek(){
    if(isEmpty()){
      throw new EmptyStructureException("La pila esta vacia");
    }
    return lista.firstDatum();
  }

  @Override
  public int size(){
    return lista.size();
  }

  @Override
  public boolean isEmpty(){
    return lista.vacio();
  }
}
