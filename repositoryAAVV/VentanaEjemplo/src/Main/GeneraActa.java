package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

//Metodo donde generamos el Acta desde el cliente(NO SERVIDOR)
public class GeneraActa {
  
  private VentanaBuilder miventana;
  private Cliente micliente;
  private ActaIncidenciasAll miacta;
  private HashMap<String,String> hashEnviado;
  private HashMap<String,String> hashRecibido;
  private Hash_Incidencia micambio;
 
  //En el constructor asociamos el valor de nuestar Primary Key haciendo una consulta a la base de datos
  public GeneraActa(VentanaBuilder miventana ){
    this.miventana=miventana;
    miventana.setIconGIFGIF();
    
    
      micliente=new Cliente();
      hashEnviado=new HashMap<>();
      String str_incidencia=dameFecha();
      hashEnviado.put("PrimayKey",str_incidencia);
      hashRecibido=micliente.enviarHashMapAlServidor(hashEnviado);
      for(Entry<String, String> s:hashRecibido.entrySet()) {
        System.out.println("Desde Servidor: "+s.getKey()+" Valor:"+s.getValue());
        if (s.getKey().equals("PrimayKey")) {
          //Si no tenemos ningun valor con la fecha mandada lo iniciamos con /001
          if(s.getValue()==null) {
            str_incidencia=str_incidencia+"/001";
            //AutoIncremento
          }else {
            str_incidencia=IncrementarIncidencia(s.getValue());
          }
        }
      }
      //Ponemos nuestro nuevo valor en nuestra aplicacion    
      miventana.setTextFieldIncidencia(str_incidencia);
      //Se considera que a partir de aqui ya se puede realmente generar un Acta y habilitamos el boton de enviar
      miventana.si_envia_Acta();
      
    
    
    
    
  }

  //Forma parte de nuestra Primary Key de la BBDD que esta en la variable incidencia(incidenciaAll o str_incidencia)
  private String dameFecha() {
    String str;
    LocalDate fechaActual = LocalDate.now();

    // Formatear la fecha como un String en el formato deseado (año y mes)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
    str = fechaActual.format(formatter);
    
    return str;
  }
  
  //Implementar incidencia autoincrementando el valor en una unidad
  //depaso comprobamos que el valor sea correcto yyyyMM//iii
  public String IncrementarIncidencia(String incidencia) {
    // Verificar que la incidencia tiene el formato esperado
    if (incidencia.matches("\\d{6}/\\d{3}")) {
        // Dividir la incidencia en parte de año y número
        String[] partes = incidencia.split("/");
        int numero = Integer.parseInt(partes[1]);

        // Incrementar el número en una unidad
        numero++;

        // Formatear la nueva incidencia
        String nuevaIncidencia = String.format("%s/%03d", partes[0], numero);
        System.out.println("Nueva PrimaryKey 'incidencia':"+nuevaIncidencia);
        return nuevaIncidencia;
    } else {
        System.out.println("Formato de incidencia no válido.");
        return null;
    }
  }  
  
  //Método para rellenar un elemento de la Acta con todos sus valores, si no se rellena quedara con un String="" , NO NULL!!
  public ActaIncidenciasAll rellenarActaIncidenciaAll(VentanaBuilder miventana) {
    this.miventana=miventana;
    String str_incidenciaAll=dameFecha();
    String str_asuntoAll, str_fechaAll, str_nombreAll, str_appellido_1All, str_apellido_2All,  str_nif_nie_All,
    str_entidadAll, str_descripAll, str_areaTrabajoAll, str_solicitudAll, str_dirigidoAll, str_galeria1, str_galeria2, str_galeria3,
    str_galeria4, str_geo1, str_geo2, str_geo3, str_geo4, str_anexos1All, str_anexos2All;
    
    try {
      str_incidenciaAll=miventana.getTextFieldIncidencia().getText().toString();
    }catch(Exception e) {
      System.out.println(str_incidenciaAll="");
    }
    try {
      str_asuntoAll=miventana.getTextFieldTitulo().getText().toString();
    }catch(Exception e) {
      System.out.println(str_asuntoAll="");
    }
    
    try {
      str_fechaAll="";
      String str_fechaAnio=miventana.getcomboBoxAnio().getSelectedItem().toString();
      String str_fechaMes=miventana.getcomboBoxMes().getSelectedItem().toString();
      String str_fechaDia=miventana.getcomboBoxDia().getSelectedItem().toString();
      String str_fechaHora=miventana.getcomboBoxHora().getSelectedItem().toString();
      if(str_fechaDia.length()==1) {
        str_fechaDia="0"+str_fechaDia;
      }
      if(str_fechaMes.length()==1) {
        str_fechaMes+="0";
      }
      str_fechaAll=str_fechaAnio+str_fechaMes+str_fechaDia+str_fechaHora;
    }catch(Exception e) {
      System.out.println(str_fechaAll=""); 
    }
    try {
      str_nombreAll=miventana.getTextFieldNombre().getText().toString();
    }catch(Exception e) {
      System.out.println(str_nombreAll="");
    }
    try {
      str_appellido_1All=miventana.getTextFieldApellido1().getText().toString();
    }catch(Exception e) {
      System.out.println(str_appellido_1All="");
    }
    try {
      str_apellido_2All=miventana.getTextFieldApellido2().getText().toString();
    }catch(Exception e) {
      System.out.println(str_apellido_2All="");
    }
    try {
      str_nif_nie_All=miventana.getTextFieldNIF().getText().toString();
    }catch(Exception e) {
      System.out.println(str_nif_nie_All="");
    }
    try {
      str_entidadAll=miventana.getcomboBoxAAVV().getSelectedItem().toString();
    }catch(Exception e) {
      System.out.println(str_entidadAll="");
    }
    try {
      str_descripAll=miventana.getTextAreaDescrip().getText().toString();
    }catch(Exception e) {
      System.out.println(str_descripAll="");
    }
    try {
      str_areaTrabajoAll=miventana.getcomboBoxAreaTrabajo().getSelectedItem().toString();
    }catch(Exception e) {
      System.out.println(str_areaTrabajoAll="");
    }
    try {
      str_solicitudAll=miventana.getTextAreaSolicitud().getText().toString();
    }catch(Exception e) {
      System.out.println(str_solicitudAll="");
    }
    try {
      str_dirigidoAll=miventana.getcomboBoxDirigido().getSelectedItem().toString();
    }catch(Exception e) {
      System.out.println(str_dirigidoAll="");
    }
    try {
      str_galeria1=miventana.getTextFieldGaleria_1().getText().toString();
    }catch(Exception e) {
      System.out.println(str_galeria1="");
    }
    try {
      str_galeria2=miventana.getTextFieldGaleria_2().getText().toString();
    }catch(Exception e) {
      System.out.println(str_galeria2="");
    }
    try {
      str_galeria3=miventana.getTextFieldGaleria_3().getText().toString();
    }catch(Exception e) {
      System.out.println(str_galeria3="");
    }
    try {
      str_galeria4=miventana.getTextFieldGaleria_4().getText().toString();
    }catch(Exception e) {
      System.out.println(str_galeria4="");
    }
    try {
      str_geo1=miventana.getTextFieldGeo_1().getText().toString();
    }catch(Exception e) {
      System.out.println(str_geo1="");
    }
    try {
      str_geo2=miventana.getTextFieldGeo_2().getText().toString();
    }catch(Exception e) {
      System.out.println(str_geo2="");
    }
    try {
      str_geo3=miventana.getTextFieldGeo_3().getText().toString();
    }catch(Exception e) {
      System.out.println(str_geo3="");
    }
    try {
      str_geo4=miventana.getTextFieldGeo_4().getText().toString();
    }catch(Exception e) {
      System.out.println(str_geo4="");
    }
    try {
      str_anexos1All=miventana.getTextFieldAnexo1().getText().toString();
    }catch(Exception e) {
      System.out.println(str_anexos1All="");
    }
    try {
      str_anexos2All=miventana.getTextFieldAnexo2().getText().toString();
    }catch(Exception e) {
      System.out.println(str_anexos2All="");
    }
 
    
    miacta=new ActaIncidenciasAll(str_incidenciaAll,str_asuntoAll, str_fechaAll, str_nombreAll, str_appellido_1All,
        str_apellido_2All, str_nif_nie_All, str_entidadAll, str_descripAll, str_areaTrabajoAll, str_solicitudAll,
        str_dirigidoAll, str_galeria1, str_galeria2, str_galeria3, str_galeria4, str_geo1, str_geo2, str_geo3,
        str_geo4, str_anexos1All, str_anexos2All);
    
    System.out.println(str_incidenciaAll+str_asuntoAll+ str_fechaAll+ str_nombreAll+ str_appellido_1All+
        str_apellido_2All+ str_nif_nie_All+ str_entidadAll+ str_descripAll+ str_areaTrabajoAll+ str_solicitudAll+
        str_dirigidoAll+ str_galeria1+ str_galeria2+ str_galeria3+ str_galeria4+ str_geo1+ str_geo2+ str_geo3+
        str_geo4+ str_anexos1All+ str_anexos2All);
    return miacta;
    
  }
  
  //Enviamos los datos al servidor y recibimos la respuesta correspondiente
  public HashMap<String, String> enviar_recibir(VentanaBuilder miventana){
    this.miventana=miventana;
    miventana.setIconGIFGIF();
    int opcion=JOptionPane.showConfirmDialog(null, "Si desea generar un acta ya no lo podrá modificar\n"
        + "¿Desea continuar?", "Confirmar",JOptionPane.YES_NO_OPTION);
    
    if(opcion==JOptionPane.YES_OPTION) {
      hashEnviado=new HashMap<>();
      hashRecibido=new HashMap<>();
      hashEnviado.clear();
      hashRecibido.clear();
      Cliente micliente=new Cliente();
      
      ActaIncidenciasAll miacta=rellenarActaIncidenciaAll(miventana);
      Hash_Incidencia micambio=new Hash_Incidencia();
      hashEnviado=micambio.deIncidencia_a_HashMap(miacta);
      hashEnviado.put("INSERT", "ALL");
      hashRecibido= micliente.enviarHashMapAlServidor(hashEnviado);
      
    }else {
      miventana.setlb_Inf_Inf_Ayuda("Se ha cancelado la generación del acta.");
      miventana.no_Envia_Pdf();
    }  
    miventana.setIconGIFPNG();
    return hashRecibido;
    
  }
}
