package Main;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map.Entry;

//import Ventana.VentanaAbrir;

public class Cliente {
  
  private static final String SERVIDOR_IP = "127.0.0.1";
  private static final int PUERTO = 5000;

  private Socket mienchufe;
  private OutputStream outputSalida;
  private ObjectOutputStream flujoSalida;
  private InputStream inputEntrada;
  private ObjectInputStream flujoEntrada;
  private  HashMap<String,String> mihash;
  private HashMap<String,String> miHashRecibido;
  
  
  public Cliente() {
  
  }

  public HashMap<String, String> enviarHashMapAlServidor(HashMap<String, String> miHash) {
   /*
    for(String s:miHash.keySet()) {
      System.out.println(s+"-"+miHash.get(s));
    }
    */
    try {
      mienchufe = new Socket(SERVIDOR_IP, PUERTO);
      System.out.println(SERVIDOR_IP+":"+PUERTO);
      outputSalida=mienchufe.getOutputStream();
      flujoSalida=new ObjectOutputStream(outputSalida);
       
     inputEntrada=mienchufe.getInputStream();
      flujoEntrada=new ObjectInputStream(inputEntrada);
 

     System.out.println("Creados los Stream, Cliente");
    
     flujoSalida.writeObject(miHash);
     System.out.println("Mensja envido");
     
     miHashRecibido=(HashMap)flujoEntrada.readObject();
     mienchufe.close();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Error al enviar HashMap al Servidor");
    }
    
    return miHashRecibido;
    
  }
  
}
