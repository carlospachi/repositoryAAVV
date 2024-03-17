package Main;

import java.awt.Color;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;

public class AccionesText  {
  private VentanaBuilder ventanaBuilder;
  private JButton miboton;
  private JTextComponent micomponente;
  private JTextField mitext;
  private JTextArea miarea;
  
  public AccionesText(VentanaBuilder ventanaBuilder) {
    this.ventanaBuilder=ventanaBuilder;
  }
  
  public void textoListenerBoton(JTextComponent micomponente, JButton miboton) {
    this.micomponente=micomponente;
    this.miboton=miboton;
    
    micomponente.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
          // Acciones al insertar texto cambiar el color del botón
          miboton.setBackground(Color.RED);
          //ventanaBuilder.getBtnAceptar().setEnabled(false);
          ventanaBuilder.no_Envia_Pdf();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        // Acciones al borrar texto cambiar el color del botón
        //miboton.setBackground(Color.GREEN);
        miboton.setBackground(Color.RED);
        //ventanaBuilder.getBtnAceptar().setEnabled(false);
        ventanaBuilder.no_Envia_Pdf();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
          // Este método se llama cuando hay un cambio que no afecta al texto
          // Puedes agregar lógica adicional si es necesario
      }
  });
  }

  

}
