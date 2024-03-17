package Main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDD {
  
  private Constantes misconst;
  
  public BBDD() {
    misconst=new Constantes();
    
    File mifile=new File(misconst.NOMBRE_BBDD);
    if(!mifile.exists()) {
      CrearBBDD();
    }
    
  }
  
  
  //Hacer un insert de la base de datos
  public boolean InsertarDatos(ActaIncidenciasAll miacta) {
    try {
      Class.forName("org.sqlite.JDBC");
      
      Connection miconexion = DriverManager.getConnection("jdbc:sqlite:" + misconst.NOMBRE_BBDD);
      //PreparedStatement preparedStatement;

      
      String insertSQL = "INSERT INTO " + misconst.NOMBRE_TABLA + "(" +
          misconst.INCIDENCIA + ", "+
          misconst.FECHA + ", " +
          misconst.ASUNTO + ", " +
          misconst.NOMBRE + ", " +
          misconst.APELLIDO1 + ", "+
          misconst.APELLIDO2 + ", " +
          misconst.NIF_NIE + ", " +
          misconst.ENTIDAD + ", " +
          misconst.DESCRIPCION + ", "+
          misconst.DIRIGIDO + ", " +
          misconst.AREA_TRABAJO + ", "+
          misconst.SOLICITUD + ", "+
          misconst.GALERIA1 + ", " +
          misconst.GEOLOCALIZACION1 + ", "+
          misconst.GALERIA2 + ", "+
          misconst.GEOLOCALIZACION2 + ", " +
          misconst.GALERIA3 + ", "+
          misconst.GEOLOCALIZACION3 + ", " +
          misconst.GALERIA4 + ", "+
          misconst.GEOLOCALIZACION4 + ", "+
          misconst.ANEXO1 + ", " +
          misconst.ANEXO2 + ") VALUES ('"+
          miacta.getIncidenciaAll()+"','"+
          miacta.getFechaAll()+"','"+
          miacta.getAsuntoAll()+"','"+
          miacta.getNombreAll()+"','"+
          miacta.getAppellido_1All()+"','"+
          miacta.getApellido_2()+"','"+
          miacta.getNif_nie_All()+"','"+
          miacta.getEntidadAll()+"','"+
          miacta.getDescripAll()+"','"+
          miacta.getDirigidoAll()+"','"+
          miacta.getAreaTrabajoAll()+"','"+
          miacta.getSolicitudAll()+"','"+
          miacta.getGaleria1()+"','"+
          miacta.getGeo1()+"','"+
          miacta.getGaleria2()+"','"+
          miacta.getGeo2()+"','"+
          miacta.getGaleria3()+"','"+
          miacta.getGeo3()+"','"+
          miacta.getGaleria4()+"','"+
          miacta.getGeo4()+"','"+
          miacta.getAnexos1All()+"','"+
          miacta.getAnexos2All()+"'); "; 
       System.out.println(""+insertSQL);
        Statement misentencia=miconexion.createStatement();
        int int_result=misentencia.executeUpdate(insertSQL);
        misentencia.close();
        //miconexion.commit(); 
        
        System.out.println("Datos insertados correctamente.");
        
        miconexion.close();
        
        return true;
      
        
      
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  //Método donde variamos los datos de nuestra base de datos 
  public boolean UpdateDatos(ActaIncidenciasAll miacta) {
    try {
        Class.forName("org.sqlite.JDBC");

        Connection miconexion = DriverManager.getConnection("jdbc:sqlite:" + misconst.NOMBRE_BBDD);

        String updateSQL = "UPDATE " + misconst.NOMBRE_TABLA + " SET " +
                misconst.FECHA + " = ?, " +
                misconst.ASUNTO + " = ?, " +
                misconst.NOMBRE + " = ?, " +
                misconst.APELLIDO1 + " = ?, " +
                misconst.APELLIDO2 + " = ?, " +
                misconst.NIF_NIE + " = ?, " +
                misconst.ENTIDAD + " = ?, " +
                misconst.DESCRIPCION + " = ?, " +
                misconst.DIRIGIDO + " = ?, " +
                misconst.AREA_TRABAJO + " = ?, " +
                misconst.SOLICITUD + " = ?, " +
                misconst.GALERIA1 + " = ?, " +
                misconst.GEOLOCALIZACION1 + " = ?, " +
                misconst.GALERIA2 + " = ?, " +
                misconst.GEOLOCALIZACION2 + " = ?, " +
                misconst.GALERIA3 + " = ?, " +
                misconst.GEOLOCALIZACION3 + " = ?, " +
                misconst.GALERIA4 + " = ?, " +
                misconst.GEOLOCALIZACION4 + " = ?, " +
                misconst.ANEXO1 + " = ?, " +
                misconst.ANEXO2 + " = ? WHERE " +
                misconst.INCIDENCIA + " = ?";

        PreparedStatement preparedStatement = miconexion.prepareStatement(updateSQL);
        preparedStatement.setString(1, miacta.getFechaAll());
        preparedStatement.setString(2, miacta.getAsuntoAll());
        preparedStatement.setString(3, miacta.getNombreAll());
        preparedStatement.setString(4, miacta.getAppellido_1All());
        preparedStatement.setString(5, miacta.getApellido_2());
        preparedStatement.setString(6, miacta.getNif_nie_All());
        preparedStatement.setString(7, miacta.getEntidadAll());
        preparedStatement.setString(8, miacta.getDescripAll());
        preparedStatement.setString(9, miacta.getDirigidoAll());
        preparedStatement.setString(10, miacta.getAreaTrabajoAll());
        preparedStatement.setString(11, miacta.getSolicitudAll());
        preparedStatement.setString(12, miacta.getGaleria1());
        preparedStatement.setString(13, miacta.getGeo1());
        preparedStatement.setString(14, miacta.getGaleria2());
        preparedStatement.setString(15, miacta.getGeo2());
        preparedStatement.setString(16, miacta.getGaleria3());
        preparedStatement.setString(17, miacta.getGeo3());
        preparedStatement.setString(18, miacta.getGaleria4());
        preparedStatement.setString(19, miacta.getGeo4());
        preparedStatement.setString(20, miacta.getAnexos1All());
        preparedStatement.setString(21, miacta.getAnexos2All());
        preparedStatement.setString(22, miacta.getIncidenciaAll());

        int rowsUpdated = preparedStatement.executeUpdate();

        preparedStatement.close();
        miconexion.close();

        if (rowsUpdated > 0) {
            System.out.println("Datos actualizados correctamente.");
            return true;
        } else {
            System.out.println("No se encontró ningún registro para actualizar.");
            return false;
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return false;
    }
  }

  //Metodo donde creamos la base de datos si es necesario
  public boolean CrearBBDD() {
   // Constantes misconst=new Constantes();
    try {
      // Cargar el controlador JDBC para SQLite
      Class.forName("org.sqlite.JDBC");

      // Establecer la conexión con la base de datos
      Connection connection = DriverManager.getConnection("jdbc:sqlite:"+misconst.NOMBRE_BBDD);

      // Crear una declaración
      Statement statement = connection.createStatement();

      // Crear la tabla (aquí se puede personalizar según tus necesidades)
      String createTableSQL = "CREATE TABLE IF NOT EXISTS "+ misconst.NOMBRE_TABLA+" (" +
          misconst.INCIDENCIA+" TEXT PRIMARY KEY ," +
          misconst.FECHA+" TEXT ," +
          misconst.ASUNTO+" TEXT, "+
          misconst.NOMBRE+" TEXT, "+
          misconst.APELLIDO1+" TEXT, "+
          misconst.APELLIDO2+" TEXT, "+
          misconst.NIF_NIE+" TEXT, "+
          misconst.ENTIDAD+ " TEXT, "+
          misconst.DESCRIPCION+" TEXT, "+
          misconst.DIRIGIDO+" TEXT, "+
          misconst.AREA_TRABAJO+ " TEXT, "+
          misconst.SOLICITUD+" TEXT, "+
          misconst.GALERIA1+ " TEXT, "+
          misconst.GEOLOCALIZACION1+ " TEXT, "+
          misconst.GALERIA2+ " TEXT, "+
          misconst.GEOLOCALIZACION2+ " TEXT, "+
          misconst.GALERIA3+ " TEXT, "+
          misconst.GEOLOCALIZACION3+ " TEXT, "+
          misconst.GALERIA4+ " TEXT, "+
          misconst.GEOLOCALIZACION4+ " TEXT, "+
          misconst.ANEXO1+" TEXT, "+
          misconst.ANEXO2+" TEXT)";
      statement.executeUpdate(createTableSQL);
      //statement.executeUpdate(createTableSQL);

      // Cerrar la conexión y la declaración
      statement.close();
      connection.close();

      System.out.println("Base de datos creada correctamente.");
      return true;

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  //Metodo donde conseguimos la primaryKey mas alta que viene dado por el prefijo '202402'
  public String ConsultarPrimaryKeyPorPrefijo(String prefijo) {
    try {
      Class.forName("org.sqlite.JDBC");
  
      Connection miconexion = DriverManager.getConnection("jdbc:sqlite:" + misconst.NOMBRE_BBDD);
  
      String selectSQL = "SELECT " + misconst.INCIDENCIA + " FROM " + misconst.NOMBRE_TABLA +
              " WHERE " + misconst.INCIDENCIA + " LIKE ? ORDER BY " + misconst.INCIDENCIA + " DESC LIMIT 1";
  
      
      PreparedStatement preparedStatement = miconexion.prepareStatement(selectSQL);
      preparedStatement.setString(1, prefijo + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String primaryKey = resultSet.getString(misconst.INCIDENCIA);
        System.out.println("Primary Key más alta con el prefijo '" + prefijo + "': " + primaryKey);
        miconexion.close();
        return primaryKey;
      } else {
        System.out.println("No hay Primary Keys con el prefijo '" + prefijo + "'.");
        miconexion.close();
        return null;
      }
      
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        
        return null;
    }
}
  
  
  
  //Hacer un SELECT con el valor del incidente
  public ActaIncidenciasAll SelectPorPrimaryKey(String primaryKey) {
    ActaIncidenciasAll miactaAll;
    try {
      Class.forName("org.sqlite.JDBC");

      Connection miconexion = DriverManager.getConnection("jdbc:sqlite:" + misconst.NOMBRE_BBDD);

      String selectSQL = "SELECT * FROM " + misconst.NOMBRE_TABLA + " WHERE " + misconst.INCIDENCIA + " = ?";

      
        PreparedStatement preparedStatement = miconexion.prepareStatement(selectSQL);
        preparedStatement.setString(1, primaryKey);

        ResultSet resultSet = preparedStatement.executeQuery();
        ActaIncidenciaId miacta=new ActaIncidenciaId(primaryKey);

        if (resultSet.next()) {
          // Obtener los datos del resultado
          String incidenciaAll  = resultSet.getString(misconst.INCIDENCIA);          
          String fechaAll = resultSet.getString(misconst.FECHA);          
          String asuntoAll = resultSet.getString(misconst.ASUNTO);
          String nombreAll = resultSet.getString(misconst.NOMBRE);
          String appellido_1All = resultSet.getString(misconst.APELLIDO1);
          String apellido_2 = resultSet.getString(misconst.APELLIDO2);
          String nif_nie_All = resultSet.getString(misconst.NIF_NIE);
          String entidadAll = resultSet.getString(misconst.ENTIDAD);
          String descripAll = resultSet.getString(misconst.DESCRIPCION);
          String dirigidoAll = resultSet.getString(misconst.DIRIGIDO);
          String areaTrabajoAll = resultSet.getString(misconst.AREA_TRABAJO);
          String solicitudAll = resultSet.getString(misconst.SOLICITUD);
          String galeria1=resultSet.getString(misconst.GALERIA1);
          String geo1=resultSet.getString(misconst.GEOLOCALIZACION1);
          String galeria2=resultSet.getString(misconst.GALERIA2);
          String geo2=resultSet.getString(misconst.GEOLOCALIZACION2);
          String galeria3=resultSet.getString(misconst.GALERIA3);
          String geo3=resultSet.getString(misconst.GEOLOCALIZACION3);
          String galeria4=resultSet.getString(misconst.GALERIA4);
          String geo4=resultSet.getString(misconst.GEOLOCALIZACION4);
          String anexos1All=resultSet.getString(misconst.ANEXO1);
          String anexos2All=resultSet.getString(misconst.ANEXO2);
         
          miactaAll=miacta.rellenarActaAll(incidenciaAll, asuntoAll, fechaAll, nombreAll, appellido_1All, apellido_2, nif_nie_All, entidadAll, descripAll, areaTrabajoAll, solicitudAll, dirigidoAll, galeria1, galeria2, galeria3, galeria4, geo1, geo2, geo3, geo4, anexos1All, anexos2All);
          
          miconexion.close();
          return miactaAll;
/*
String incidenciaAll,String asuntoAll, String fechaAll, String nombreAll,
      String appellido_1All, String apellido_2, String nif_nie_All, String entidadAll, String descripAll, String areaTrabajoAll,
      String solicitudAll, String dirigidoAll, String galeria1, String galeria2,String galeria3, String galeria4,
      String geo1, String geo2, String geo3, String geo4, String anexos1All,String anexos2All          
*/        
        } else {
            System.out.println("No se encontró ninguna fila con la clave primaria proporcionada.");
            return null;
        }
      

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  

  public boolean BorrarBBDD(String Database_URL) {
    try {
      Class.forName("org.sqlite.JDBC");
      
      File baseDatos=new File(Database_URL);
      if(baseDatos.exists()) {
        if(baseDatos.delete()) {
          System.out.println("Base de datos eliminada correctamente");
          return true;
        }else {
          System.out.println("Error al eliminar la base de datos");
          return false;
        }
      }else {
        System.out.println("La base de datos no existe");
        return true;
      }
            
      }catch(ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    }
    
  }
}
