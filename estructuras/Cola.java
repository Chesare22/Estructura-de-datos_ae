package estructuras;

import listas.ListaDoble;

public class Cola extends Pila{
  @Override
  public Object pop(){
    if(isEmpty()){
      throw new EmptyStructureException("La cola esta vacia");
    }
    return lista.eliminaFinal();
  }

  @Override
  public Object peek(){
    if(isEmpty()){
      throw new EmptyStructureException("La cola esta vacia");
    }
    return lista.lastDatum();
  }
}
