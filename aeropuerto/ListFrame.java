package aeropuerto;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

// Organización de los componentes.
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

public class ListFrame extends JFrame{

  private JList vuelos;

  public ListFrame(Object[] data){
    super("Lista de vuelos");
    //Inicio la lista
    vuelos = new JList(data);

    //Configuro la vista de la lista
    vuelos.setLayoutOrientation(JList.VERTICAL);
    vuelos.setVisibleRowCount(-1);

    //Meto la lista a un JScrollPane
    JScrollPane listScroller = new JScrollPane(vuelos);
    listScroller.setPreferredSize(new Dimension(200, 150));

    //Añado el Pane al frame
    add(listScroller);
  }
}
