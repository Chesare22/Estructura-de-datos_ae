/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public abstract class Lista {
    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;

    public Lista(){
    this("lista");
    }

    public Lista(String nombre){
    this.nombre = nombre;
    inicio = ultimo = null;
    }

    public boolean vacio(){
     return inicio == null;
    }

    public void imprimir(){
    Nodo actual = inicio;
    while(actual!=null){
        System.out.print(actual.getDato() + "->");
        actual = actual.getSiguiente();
    }
    }

    public int size(){
      int s = 0;
      Nodo soporte = inicio;
      if(inicio == null){
        return s;
      }
      do{
        s++;
        soporte = soporte.getSiguiente();
      }while(soporte != null);
      return s;
    }

    public Object[] toArray(){
      Object[] data = new Object[this.size()];
      Nodo actual = inicio;
      int i = 0;
      do{
        data[i] = actual.getDato();
        i++;
        actual = actual.getSiguiente();
      }while(actual != null);
      return data;
    }

    public abstract void insertaInicio(Object dato);
    public abstract void insertaFinal(Object dato);
    public abstract Object eliminaInicio();
    public abstract Object eliminaFinal();

    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
