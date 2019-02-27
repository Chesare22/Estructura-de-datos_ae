/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public abstract class ListaD extends Lista{
 protected NodoDoble inicio;
 protected NodoDoble ultimo;
 
 public boolean vacio(){
 return inicio == null;
 } 
 
 public void imprimir(){
 super.setInicio(inicio);
 super.imprimir();
 }
 
 public void imprimirAlReves(){
 NodoDoble actual = ultimo;
 while(actual != null){
     System.out.print(actual.getDato()+ "->");
     actual = actual.getAnterior();
 }
 
 }
 
 
}
