/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class Nodo {
    protected Object dato;
    protected Nodo siguiente;

    public Nodo(){}
    
    public Nodo(Object dato){
      this.dato = dato;
      this.siguiente = null;
    }
    
    public Nodo(Object dato, Nodo siguiente){
    this.dato = dato;
    this.siguiente = siguiente;
    }
    
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
