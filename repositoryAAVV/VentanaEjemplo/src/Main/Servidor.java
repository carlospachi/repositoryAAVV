package Main;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

public class Servidor {
  
  private HashMap<String,String> hashRecibido;
  private HashMap<String,String> hashEnviado;
  private static final int PUERTO = 5000;

  public Servidor() {
    ServerSocket miserver;
    hashRecibido=new HashMap<>();
    hashEnviado=new HashMap<>();
    try {
      miserver = new ServerSocket(PUERTO);
      System.out.println("Esperando a conectar el cliente.");
      while (true) {
        Socket mienchufe = miserver.accept();
        System.out.println("Conexion realizada con éxito");

        
        RecibirHash(hashRecibido,mienchufe);

        mienchufe.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("FIN DE SERVIDOR");
  }

  
  
  private void RecibirHash(HashMap<String, String> hashRecibido, Socket mienchufe) throws IOException {
    this.hashRecibido=hashRecibido;
    hashRecibido.clear();
    hashEnviado.clear();
    InputStream inputEntrada=(mienchufe.getInputStream());
    ObjectInputStream flujoEntrada=new ObjectInputStream(inputEntrada);
    
    OutputStream outputSalida=mienchufe.getOutputStream();
    ObjectOutputStream flujoSalida=new ObjectOutputStream(outputSalida);
    System.out.println("Creados los Stream, Servidor");
    
    try {
      
      hashRecibido=(HashMap)flujoEntrada.readObject();
      System.out.println("Se recibio el HashMap");
      for(Entry<String, String> s:hashRecibido.entrySet()) {
        System.out.println("Desde Servidor: "+s.getKey()+" Valor:"+s.getValue());
      }
      ////
      //HACER EL SELECT SOBRE LA BASE DE DATOS
      System.out.println("HACER EL SELECT SOBRE LA BASE DE DATOS");
      
      //String nuevaIncidencia=mibase.ConsultarPrimaryKeyPorPrefijo(null);
      //hashMapRecibido.clear();
      hashEnviado=opcionesHashMap(hashRecibido);
      //hashMapRecibido.put("Servidor dice", " Se manda algo desde el servidor.");
      ////
      
      flujoSalida.writeObject(hashEnviado);
      hashEnviado.clear();
      
      
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  
    
  }
  
  //Método para ver las distintas opciones de nuestro hashMap
  private HashMap<String,String> opcionesHashMap(HashMap<String,String> mihash) {
    boolean verdad=true;
    
    hashEnviado.clear();
    Hash_Incidencia micambio=new Hash_Incidencia();
    ActaIncidenciasAll miactaAll;
    BBDD mibase=new BBDD();
    String nuevaIncidencia="";
    for(Entry<String, String> s:mihash.entrySet()) {
      System.out.println("Desde Servidor: "+s.getKey()+" Valor:"+s.getValue());
      //Aqui ponenos las distintas opciones que nos manda nuestro hashmap
      
      //si la key es PrimayKey que es para saber la primary key mas alta de nuestra base de datos
      if (s.getKey().equals("PrimayKey")) {
        nuevaIncidencia=mibase.ConsultarPrimaryKeyPorPrefijo(s.getValue());
        hashEnviado.put("PrimayKey", nuevaIncidencia);
      
        //Si recibimos un Insert en nuestra base de datos  
      }else if(s.getKey().equals("INSERT")&&s.getValue().equals("ALL")) {
        miactaAll=micambio.deHashMAp_a_ActaIncidenciaAll(mihash);
        mibase.InsertarDatos(miactaAll);
        hashEnviado.put("INSERT", "OK");
      }
    }
    
    
    return hashEnviado;
  }

}
