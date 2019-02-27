/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaSimple extends Lista {

    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
           inicio = ultimo = new Nodo(dato);
        }
        else{
         inicio = new Nodo(dato,inicio);
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
          inicio = ultimo = new Nodo(dato);
        }
        else
         {
         Nodo temp = new Nodo(dato);
         ultimo.setSiguiente(temp);
         ultimo = temp;
         }
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if(vacio())
          System.out.println("La lista está vacía.");
        else
          {
           eliminado = inicio.getDato();
           inicio = inicio.getSiguiente();
          }
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
       Object eliminado = null;
       if (vacio())
            System.out.println("La lista está vacía.");
       else{
         if(inicio == ultimo){
           eliminado = inicio.getDato();
           inicio = ultimo = null;
         }
         else{
           Nodo actual = inicio;
           while(actual.getSiguiente()!= ultimo)
               actual = actual.getSiguiente();
         eliminado = ultimo.getDato();
         actual.setSiguiente(null);
         ultimo = actual;
         }
       }
       return eliminado ;
    }

    /*public void insertaOrdenado(Object algo){
      NodoPrioridad obj = (NodoPrioridad)algo;
      int prioridad = obj.getPrioridad();
      if(vacio()){
        insertaInicio(algo);
      }
      else
        if (inicio == ultimo){//Solo hay un dato en la lista
           if (prioridad < ((NodoPrioridad)inicio.getDato()).getPrioridad())
               insertaInicio(algo);
           else
               insertaFinal(algo);
        }
        else{
        Nodo antes = null, despues = inicio;
        while(despues!=null && prioridad> ((NodoPrioridad)despues.getDato()).getPrioridad()){
          antes = despues;
          despues = despues.getSiguiente();
        }
        if(antes==null)
            insertaInicio(algo);
        else
           if(despues==null)
               insertaFinal(algo);
           else{
             Nodo nuevo = new Nodo(algo,despues);
             antes.setSiguiente(nuevo);
           }
        } }*/


    public void insertaEnOrden(int dato ){
      if(vacio()){
        insertaInicio(dato);
      }
      else
        if (inicio == ultimo){//Solo hay un dato en la lista
           if (dato < (Integer)inicio.getDato())
               insertaInicio(dato);
           else
               insertaFinal(dato);
        }
        else{
        Nodo antes = null, despues = inicio;
        while(despues!=null && dato > (Integer)despues.getDato()){
          antes = despues;
          despues = despues.getSiguiente();
        }
        if(antes==null)
            insertaInicio(dato);
        else
           if(despues==null)
               insertaFinal(dato);
           else{
             Nodo nuevo = new Nodo(dato,despues);
             antes.setSiguiente(nuevo);
           }
        }
      }

    public static void main(String[] args) {
        ListaSimple listasimple = new ListaSimple();
        /*listasimple.insertaInicio(34);
        listasimple.insertaInicio("perro");
        listasimple.insertaInicio(455.6);
        listasimple.insertaInicio("Otro dato");*/
        /*listasimple.insertaFinal(34);
        listasimple.insertaFinal("perro");
        listasimple.insertaFinal(455.6);
        listasimple.insertaFinal("Otro dato");
        listasimple.imprimir();
        System.out.println("Eliminando ahora al primer elemento de la lista");
        System.out.println("El elemento eliminado es: " +
                listasimple.eliminaInicio());
        listasimple.imprimir();
        System.out.println("Eliminando ahora al ultimo elemento de la lista");
        System.out.println("El elemento eliminado es: "+
                listasimple.eliminaFinal());*/
        listasimple.insertaEnOrden(34);
        listasimple.insertaEnOrden(20);
        listasimple.insertaEnOrden(50);
        listasimple.insertaEnOrden(23);
        listasimple.imprimir();
    }

}
