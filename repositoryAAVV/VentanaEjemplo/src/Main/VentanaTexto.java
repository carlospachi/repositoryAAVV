package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaTexto {
  
  private JTextArea  textAreaNueva;
  private String textoIngresado;
  private JFrame miframe;

  
  public VentanaTexto( JTextArea textArea) {
    
    
    textoIngresado=textArea.getText().toString();
    miframe = new JFrame();
  
    
    // Establece el tamaño de la ventana al 50% del tamaño de la pantalla
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) (screenSize.getWidth() / 2);
    int height = (int) (screenSize.getHeight() / 2);
    miframe.setSize(width, height);
    
    //miframe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    miframe.setLocationRelativeTo(null); // Centra la ventana en la pantalla
    miframe.setVisible(true);

    JPanel panel = new JPanel();
    miframe.getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(new BorderLayout());

    textAreaNueva = new JTextArea(textoIngresado);
    
    panel.add(textAreaNueva, BorderLayout.CENTER);

    JButton btnAceptar = new JButton("Aceptar(Alt+A)");
    JButton btnCancelar = new JButton("Cancelar(Alt+Q)");

    // Ajusta la disposición de los botones en la parte inferior
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(btnCancelar);
    buttonPanel.add(btnAceptar);

    btnAceptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Al hacer clic en "Aceptar", cierra la ventana emergente y guarda el texto ingresado
        System.out.println("Aceotar:"+textoIngresado);
        textArea.setText(textAreaNueva.getText());
        miframe.dispose();
      }
    });

    btnCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Al hacer clic en "Cancelar", cierra la ventana emergente sin guardar el texto
        textoIngresado = null;
        
        miframe.dispose();
        
      }
    });

    panel.add(buttonPanel, BorderLayout.SOUTH);
    
 // Agrega un DocumentListener para detectar cambios en el contenido del JTextArea
    textArea.getDocument().addDocumentListener(new DocumentListener() {
        
        @Override
        public void insertUpdate(DocumentEvent e) {
          // TODO Auto-generated method stub
          //System.out.println("Texto insertado: " + textAreaNueva.getText());
          textoIngresado=textAreaNueva.getText();
          
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          // TODO Auto-generated method stub
          //System.out.println("Texto eliminado: " + textAreaNueva.getText());
          textoIngresado=textAreaNueva.getText();
          
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          // TODO Auto-generated method stub
          
        }
    });
    
    //Ponemos tambien a la eschucha si pulsamos el Enter
    textAreaNueva.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_A) {
          btnAceptar.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_Q) {
         
          e.consume();          
          btnCancelar.doClick();
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
      }
      
    });
    
    
  }
  

}
