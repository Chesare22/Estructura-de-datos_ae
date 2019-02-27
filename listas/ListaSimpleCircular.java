package listas;

public class ListaSimpleCircular extends Lista{

  @Override
  public void imprimir(){
  Nodo actual = inicio;
    while(actual!=ultimo){
        System.out.print(actual.getDato() + "->");
        actual = actual.getSiguiente();
    }
  }

  @Override
  public void insertaInicio(Object dato){
    if(inicio == null){
      inicio = new Nodo(dato);
      ultimo = inicio;
    }else{
      inicio = new Nodo(dato, inicio);
    }
    ultimo.setSiguiente(inicio);
  }

  @Override
  public void insertaFinal(Object dato){
    if(ultimo == null){
      this.insertaInicio(dato);
    }else{
      Nodo nuevo = new Nodo(dato,inicio);
      ultimo.setSiguiente(nuevo);
      ultimo = nuevo;
    }
  }

  @Override
  public Object eliminaInicio() {
      Object eliminado = null;
      if(vacio()){
        System.out.println("La lista está vacía.");
      }else if(inicio != ultimo){
        eliminado = inicio.getDato();
        inicio = inicio.getSiguiente();
        ultimo.setSiguiente(inicio);
      }else{
        eliminado = inicio.getDato();
        inicio = null;
        eliminado = null;
      }
      return eliminado;
  }

  @Override
  public Object eliminaFinal(){
    Object eliminado = null;
    if(vacio())
      System.out.println("La lista está vacía.");
    else{
      Nodo penultimo = inicio;
      eliminado = ultimo.getDato();
      while(penultimo.getSiguiente()!=ultimo){
        penultimo = penultimo.getSiguiente();
      }
      penultimo.setSiguiente(inicio);
      ultimo = penultimo;
    }
    return eliminado;
  }
}
