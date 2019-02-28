package aeropuerto;

import javax.swing.JFrame;

public class Main{
  public static void main(String[] args) {
    VentanaPrincipal ventana = new VentanaPrincipal();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.pack();
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
  }
}
