package aeropuerto;

// Componentes GUI.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JOptionPane;

// Organización de los componentes.
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;

// Administración de eventos.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
  private Vuelos vuelos = new Vuelos();

  private JButton introducirVuelos;
  private JButton imprimirVuelos;
  private JButton sacarVueloEspecifico;
  private JButton sacarSiguienteVuelo;

  public VentanaPrincipal(){
    super("Ventana Principal");
    // Organización de los componentes.
    setLayout(new FlowLayout());

    //Inicio los botones
    introducirVuelos = new JButton("1. Introducir cantidad de vuelos a generar.");
    imprimirVuelos = new JButton("2.	Imprimir la cola de vuelos.");
    sacarVueloEspecifico = new JButton("3.	Sacar un vuelo en espec\u00edfico.");
    sacarSiguienteVuelo = new JButton("4. Sacar el siguiente vuelo.");

    //Centro los botones
    introducirVuelos.setAlignmentX(Component.CENTER_ALIGNMENT);
    imprimirVuelos.setAlignmentX(Component.CENTER_ALIGNMENT);
    sacarVueloEspecifico.setAlignmentX(Component.CENTER_ALIGNMENT);
    sacarSiguienteVuelo.setAlignmentX(Component.CENTER_ALIGNMENT);

    //Añado manejador de eventos a cada botón
    introducirVuelos.addActionListener(new HandlerIntroducir());
    imprimirVuelos.addActionListener(new HandlerImprimir());
    sacarVueloEspecifico.addActionListener(new HandlerSacarEspecifico());
    sacarSiguienteVuelo.addActionListener(new HandlerSacarSiguiente());

    //Configuro el panel
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    //Añado los botones al panel
    panel.add(introducirVuelos);
    panel.add(imprimirVuelos);
    panel.add(sacarVueloEspecifico);
    panel.add(sacarSiguienteVuelo);

    //Añado el panel al frame
    add(panel);
  }

  //------------------Clases para manejar eventos---------------

  private class HandlerIntroducir implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      String numeroDeVuelos = JOptionPane.showInputDialog(null, "Ingresar cantidad de vuelos");
      try{
        int n = Integer.valueOf(numeroDeVuelos);
        if(n>0){
          vuelos = new Vuelos(n);
          introducirVuelos.setVisible(false);
        }else{
          JOptionPane.showMessageDialog(null,"Se debe ingresar un valor mayor a cero");
        }
      }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"Lo que se ingresó no fue un entero");
      }
    }
  }

  private class HandlerImprimir implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if(vuelos.isEmpty()){
        JOptionPane.showMessageDialog(null,"No hay vuelos");
      }else{
        ListFrame list = new ListFrame(vuelos.obtenerVuelos());
        list.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        list.pack();
        list.setLocationRelativeTo(null);
        list.setVisible(true);
      }
    }
  }

  private class HandlerSacarEspecifico implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if(vuelos.isEmpty()){
        JOptionPane.showMessageDialog(null,"No hay vuelos");
      }else{
        try{
          vuelos.eliminarVueloEspecifico(Integer.valueOf(JOptionPane.showInputDialog(null,"Ingresar vuelo a eliminar")));
        }catch(NumberFormatException ex){
          JOptionPane.showMessageDialog(null,"Lo que se ingresó no fue un entero");
        }
      }
    }
  }

  private class HandlerSacarSiguiente implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if(vuelos.isEmpty()){
        JOptionPane.showMessageDialog(null,"No hay vuelos");
      }else{
        vuelos.sacarSiguienteVuelo();
      }
    }
  }
}
