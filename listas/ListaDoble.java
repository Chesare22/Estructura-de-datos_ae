package listas;

import java.lang.Comparable;

public class ListaDoble extends ListaD{

    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
           inicio = new NodoDoble(dato);
           ultimo = inicio;
        }
        else{
          NodoDoble nuevo = new NodoDoble(dato,inicio,null);
          inicio.setAnterior(nuevo);
          inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object dato) {
      if (vacio()){
         inicio = new NodoDoble(dato);
         ultimo = inicio;
      }
      else{
        NodoDoble nuevo = new NodoDoble(dato,null,ultimo);
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
      }
    }

    @Override
    public Object eliminaInicio() {
      Object eliminado = null;
      if(vacio())
          System.out.println("Lista vacía");
      else{
        if (inicio == ultimo){
          eliminado = inicio.getDato();
          inicio = ultimo = null;
        }
        else{
          eliminado = inicio.getDato();
          inicio = inicio.getSiguiente();
          inicio.setAnterior(null);
        }
      }
      return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if(vacio())
            System.out.println("Lista vacía");
        else{
          if (inicio == ultimo){
            eliminado = inicio.getDato();
            inicio = ultimo = null;
          }
          else{
            eliminado = ultimo.getDato();
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
          }
        }
        return eliminado;
    }

    public void insertaEnOrden(Comparable dato ){
      if(vacio()){
        insertaInicio(dato);
      }
      else
        if (inicio == ultimo){//Solo hay un dato en la lista
           if (dato.compareTo(ultimo.getDato()) < 0)
               insertaInicio(dato);
           else
               insertaFinal(dato);
        }
        else{
        NodoDoble antes = null, despues = inicio;
        while(despues!=null && dato.compareTo(despues.getDato()) > 0){
          antes = despues;
          despues = despues.getSiguiente();
        }
        if(antes==null)
            insertaInicio(dato);
        else
           if(despues==null)
               insertaFinal(dato);
           else{
             NodoDoble nuevo = new NodoDoble(dato,despues, antes);
             antes.setSiguiente(nuevo);
             despues.setAnterior(nuevo);
           }
        }
      }

      public Object lastDatum(){return ultimo.getDato();}

      public Object firstDatum(){return inicio.getDato();}

    public static void main(String[] args) {
      ListaDoble listaDoble = new ListaDoble();

      listaDoble.insertaEnOrden(new Alumno("Juan","Gomez","Hernandez"));
      listaDoble.insertaEnOrden(new Alumno("Miguel","Miguel","Miguel"));
      System.out.println("");
      listaDoble.imprimir();
      listaDoble.insertaEnOrden(new Alumno("Gonzalo","Gonzalez","Gonzalez"));
      listaDoble.insertaEnOrden(new Alumno("Cuco","Gonzalez","Gonzalez"));
      System.out.println("");
      listaDoble.imprimir();
      System.out.println("");


    }

}
