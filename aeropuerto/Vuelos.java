package aeropuerto;

import estructuras.Deque;
import estructuras.Pila;
import estructuras.EmptyStructureException;

import java.lang.RuntimeException;
import java.util.Random;
//import java.util.Scanner;

public class Vuelos{
  private Deque vuelos;

  public Vuelos(){
    vuelos = new Deque();
  }

  public Vuelos(int numeroDeVuelos){
    vuelos = new Deque();
    this.introducirVuelos(numeroDeVuelos);
  }

  public void introducirVuelos(int numeroDeVuelos){
    int[] vuelosID = generarVuelosAleatoriosSinRepeticion(0,numeroDeVuelos*50, numeroDeVuelos);
    for(int i = 0; i<numeroDeVuelos;i++){
      vuelos.insertFirst(vuelosID[i]);
    }
  }

  private int[] generarVuelosAleatoriosSinRepeticion(
  int valorMinimo,
  int valorMaximo,
  int numeroDeElementos)
  throws RuntimeException{
    if(valorMaximo-valorMinimo<numeroDeElementos || numeroDeElementos<=0){
      throw new RuntimeException("Cantidad de vuelos no valida");
    }
    int[] elementos = new int[numeroDeElementos];
    Random ran = new Random();
    int valorAleatorio, j, k;
    elementos[0] = valorMinimo+ran.nextInt(valorMaximo-valorMinimo+1);
    for(int i = 1;i<numeroDeElementos;i++){
      j=0;
      valorAleatorio = valorMinimo+ran.nextInt(valorMaximo-valorMinimo+1);
      //Checo que el elemento no se haya repetido en los vuelos existentes
      do{
        if(valorAleatorio == elementos[j]){
          //Si ya se repitió el elemento, genero uno nuevo
          j=0;
          valorAleatorio = valorMinimo+ran.nextInt(valorMaximo-valorMinimo+1);
        }else{
          //Si no se ha repetido, sigo buscando
          j++;
        }
      }while(j<i);
      elementos[i] = valorAleatorio;
    }
    return elementos;
  }
/*  public void imprimirVuelos(){
    vuelos.imprimir();
  }*/
  public Object sacarSiguienteVuelo(){
    return vuelos.removeLast();
  }
  public Object[] obtenerVuelos(){
    return vuelos.toArray();
  }
  public boolean isEmpty(){
    return vuelos.isEmpty();
  }

  //Si no se encuentra el vuelo, no hace nada
  public void eliminarVueloEspecifico(Object vuelo){
    Pila respaldoDeVuelos = new Pila();
    Object siguienteVuelo;
    while(vuelos.isEmpty() == false){
      siguienteVuelo = vuelos.removeFirst();
      if(vuelo.equals(siguienteVuelo)){
        break;
      }
      //Guardo todos los vuelos que no sean los que busco
      respaldoDeVuelos.push(siguienteVuelo);
    }
    while(respaldoDeVuelos.isEmpty()==false){
      vuelos.insertFirst(respaldoDeVuelos.pop());
    }
  }
/*
  public static void imprimirArray(Object[] ar){
    for(int i = 0;i<ar.length-1;i++){
      System.out.print(String.valueOf(ar[i]).concat(", "));
    }
    System.out.println(ar[ar.length-1]);
  }

  public static void main(String[] args) {
    Vuelos s = new Vuelos(15);
    imprimirArray(s.obtenerVuelos());

    System.out.println(s.sacarSiguienteVuelo());

    imprimirArray(s.obtenerVuelos());
    System.out.println("Que elemento desea sacar?");
    Scanner teclado = new Scanner(System.in);
    int vuelo = teclado.nextInt();
    s.eliminarVueloEspecifico(vuelo);
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    s.imprimirVuelos();
    System.out.println("");
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());
    imprimirArray(s.obtenerVuelos());

    s.imprimirVuelos();

    //Nota: este experimento nos demuestra que los vuelos se guardan como enteros, no como Strings
  }*/
}
