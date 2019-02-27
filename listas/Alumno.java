package listas;
public class Alumno implements Field<Field>{
  private String nombre;
  private String apellido1;
  private String apellido2;
  public Alumno(String nombre, String apellido1, String apellido2){
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
  }
  @Override
  public int compareTo(Field other) {
    return this.toString().compareTo(other.toString());
  }

  @Override
  public String getName(){return apellido1.concat(" ").concat(apellido2).concat(" ").concat(nombre);}

  public String toString(){return this.getName();}

}
