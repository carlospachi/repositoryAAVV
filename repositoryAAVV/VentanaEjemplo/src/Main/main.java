package Main;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("hola mundo");
        
    
      HiloServidor hs = new HiloServidor();
      hs.start();

      HiloCliente hc = new HiloCliente(hs);
      hc.start(); 
     
  }

}


class HiloServidor extends Thread {
  private volatile boolean detener = false;

  public HiloServidor() {
  }

  public void run() {
    this.setName("HS");
    Servidor miservidor = new Servidor();

    // Espera hasta que se le indique detener
    while (!detener) {
      // Realiza la lógica del servidor
      // ...
    }

    System.out.println("HiloServidor detenido.");
  }

  public void detenerHiloServidor() {
      detener = true;
  }
}

class HiloCliente extends Thread {
  private final HiloServidor hs;
  public HiloCliente(HiloServidor hs) {
    this.hs=hs;
  }

  public void run () {
    this.setName("HC");

    VentanaBuilder miventana = new VentanaBuilder();
    miventana.inicio();

    // Agrega un WindowListener para detectar el cierre de la ventana
    miventana.getFrame().addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // Detener el hilo del servidor cuando se cierra la ventana
        hs.detenerHiloServidor();
      }
    });

    Cliente micliente = new Cliente();
  }
}
 
