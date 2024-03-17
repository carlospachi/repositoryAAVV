package Main;

import java.util.HashMap;

//Clase para pasar de HashMap a un objeto de la clase ActaIncidenciaAll
public class Hash_Incidencia {
  private Constantes constantes;
  
  public HashMap<String,String> deIncidencia_a_HashMap(ActaIncidenciasAll miincidencia){
    HashMap<String,String> mihash=new HashMap<>();
    constantes=new Constantes();
    
    mihash.put(constantes.INCIDENCIA, miincidencia.getIncidenciaAll());
    mihash.put(constantes.ASUNTO,miincidencia.getAsuntoAll());
    mihash.put(constantes.FECHA, miincidencia.getFechaAll());
    mihash.put(constantes.NOMBRE, miincidencia.getNombreAll());
    mihash.put(constantes.APELLIDO1, miincidencia.getAppellido_1All());
    mihash.put(constantes.APELLIDO2, miincidencia.getApellido_2());
    mihash.put(constantes.NIF_NIE, miincidencia.getNif_nie_All());
    mihash.put(constantes.ENTIDAD, miincidencia.getEntidadAll());
    mihash.put(constantes.DESCRIPCION, miincidencia.getDescripAll());
    mihash.put(constantes.AREA_TRABAJO, miincidencia.getAreaTrabajoAll());
    mihash.put(constantes.SOLICITUD, miincidencia.getSolicitudAll());
    mihash.put(constantes.DIRIGIDO, miincidencia.getDirigidoAll());
    mihash.put(constantes.GALERIA1, miincidencia.getGaleria1());
    mihash.put(constantes.GALERIA2, miincidencia.getGaleria2());
    mihash.put(constantes.GALERIA3, miincidencia.getGaleria3());
    mihash.put(constantes.GALERIA4, miincidencia.getGaleria4());
    mihash.put(constantes.GEOLOCALIZACION1, miincidencia.getGeo1());
    mihash.put(constantes.GEOLOCALIZACION2, miincidencia.getGeo2());
    mihash.put(constantes.GEOLOCALIZACION3, miincidencia.getGeo3());
    mihash.put(constantes.GEOLOCALIZACION4, miincidencia.getGeo4());
    mihash.put(constantes.ANEXO1, miincidencia.getAnexos1All());
    mihash.put(constantes.ANEXO2, miincidencia.getAnexos2All());
    
    
    
    return mihash;
  }
  
  public ActaIncidenciasAll deHashMAp_a_ActaIncidenciaAll(HashMap<String,String> mihash) {
    String str_asuntoAll="", str_fechaAll="", str_nombreAll="", str_apellido_1All="", str_apellido_2All="",  str_nif_nie_All="",
    str_entidadAll="", str_descripAll="", str_areaTrabajoAll="", str_solicitudAll="", str_dirigidoAll="", str_galeria1="", str_galeria2="",
    str_galeria3="",str_galeria4="",str_geo1="",str_geo2="",str_geo3="",str_geo4="",str_anexos1All="",str_anexos2All="",str_incidenciaAll="";
    ActaIncidenciasAll miacta;
    constantes=new Constantes();
    
    for(String str:mihash.keySet()) {
      String valor=mihash.get(str);
      if(str.equals(constantes.ASUNTO)) {
        str_asuntoAll=valor;
      }else if(str.equals(constantes.FECHA)){
        str_fechaAll=valor;
      }else if(str.equals(constantes.NOMBRE)){
        str_nombreAll=valor;
      }else if(str.equals(constantes.APELLIDO1)){
        str_apellido_1All=valor;
      }else if(str.equals(constantes.APELLIDO2)){
        str_apellido_2All=valor;
      }else if(str.equals(constantes.NIF_NIE)){
        str_nif_nie_All=valor;
      }else if(str.equals(constantes.ENTIDAD)){
        str_entidadAll=valor;
      }else if(str.equals(constantes.DESCRIPCION)){
        str_descripAll=valor;
      }else if(str.equals(constantes.AREA_TRABAJO)){
        str_areaTrabajoAll=valor;
      }else if(str.equals(constantes.SOLICITUD)){
        str_solicitudAll=valor;
      }else if(str.equals(constantes.DIRIGIDO)){
        str_dirigidoAll=valor;
      }else if(str.equals(constantes.GALERIA1)){
        str_galeria1=valor;
      }else if(str.equals(constantes.GALERIA2)){
        str_galeria2=valor;
      }else if(str.equals(constantes.GALERIA3)){
        str_galeria3=valor;
      }else if(str.equals(constantes.GALERIA4)){
        str_galeria4=valor;
      }else if(str.equals(constantes.GEOLOCALIZACION1)){
        str_geo1=valor;
      }else if(str.equals(constantes.GEOLOCALIZACION2)){
        str_geo2=valor;
      }else if(str.equals(constantes.GEOLOCALIZACION3)){
        str_geo3=valor;
      }else if(str.equals(constantes.GEOLOCALIZACION4)){
        str_geo4=valor;
      }else if(str.equals(constantes.ANEXO1)){
        str_anexos1All=valor;
      }else if(str.equals(constantes.ANEXO2)){
        str_anexos2All=valor;
      }else if(str.equals(constantes.INCIDENCIA)){
        str_incidenciaAll=valor;
      }
      
    }
    miacta=new ActaIncidenciasAll(str_incidenciaAll,str_asuntoAll, str_fechaAll, str_nombreAll, str_apellido_1All,
        str_apellido_2All, str_nif_nie_All, str_entidadAll, str_descripAll, str_areaTrabajoAll, str_solicitudAll,
        str_dirigidoAll, str_galeria1, str_galeria2, str_galeria3, str_galeria4, str_geo1, str_geo2, str_geo3,
        str_geo4, str_anexos1All, str_anexos2All);
    return miacta;
  }

}
