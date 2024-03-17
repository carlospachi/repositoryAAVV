package Main;


//Clase para todos los elementos necesarios para el parte de incidentes
public class ActaIncidenciasAll {
  
  private String asuntoAll;
  private String fechaAll;
  private String nombreAll,appellido_1All,apellido_2,nif_nie_All;
  private String entidadAll;
  private String descripAll;
  private String areaTrabajoAll;
  private String solicitudAll;
  private String dirigidoAll;
  private String galeria1,galeria2,galeria3,galeria4;
  private String geo1,geo2,geo3,geo4;
  private String anexos1All;
  private String anexos2All;
  //La incidencia no tendra ninguan setter, pero si un getter ya que es el PK de la base de datos
  private String incidenciaAll;
  
  //Constructor donde generaremos los elementos minimos para generar una incidencia
  private ActaIncidenciasAll(String incidenciaAll,String entidadAll, String fechaAll, String descripAll, String dirigidoAll) {
    this.entidadAll=entidadAll;
    this.fechaAll=fechaAll;
    this.descripAll=descripAll;
    this.dirigidoAll=dirigidoAll;
    this.incidenciaAll=incidenciaAll;
  }
  
  
  //Constructor con todos los elementos
  public ActaIncidenciasAll(String incidenciaAll,String asuntoAll, String fechaAll, String nombreAll,
      String appellido_1All, String apellido_2, String nif_nie_All,
      String entidadAll, String descripAll, String areaTrabajoAll,
      String solicitudAll, String dirigidoAll, String galeria1, String galeria2,
      String galeria3, String galeria4, String geo1, String geo2, String geo3,
      String geo4, String anexos1All, String anexos2All) {    
    this.asuntoAll = asuntoAll;
    this.fechaAll = fechaAll;
    this.nombreAll = nombreAll;
    this.appellido_1All = appellido_1All;
    this.apellido_2 = apellido_2;
    this.nif_nie_All = nif_nie_All;
    this.entidadAll = entidadAll;
    this.descripAll = descripAll;
    this.areaTrabajoAll = areaTrabajoAll;
    this.solicitudAll = solicitudAll;
    this.dirigidoAll = dirigidoAll;
    this.galeria1 = galeria1;
    this.galeria2 = galeria2;
    this.galeria3 = galeria3;
    this.galeria4 = galeria4;
    this.geo1 = geo1;
    this.geo2 = geo2;
    this.geo3 = geo3;
    this.geo4 = geo4;
    this.anexos1All = anexos1All;
    this.anexos2All = anexos2All;
    this.incidenciaAll = incidenciaAll;
  }

  //Setters y getters 
  public String getEntidadAll() {
    return entidadAll;
  }

  public void setEntidadAll(String entidadAll) {
    this.entidadAll = entidadAll;
  }

  public String getIncidenciaAll() {
    return incidenciaAll;
  }
  
  public String getAsuntoAll() {
    return asuntoAll;
  }
  
  public void setIncidenciaAll(String incidenciaAll) {
    incidenciaAll=incidenciaAll;
  }
  public void setAsuntoAll(String asuntoAll) {
    asuntoAll = asuntoAll;
  }
  public String getFechaAll() {
    return fechaAll;
  }
  public void setFechaAll(String fechaAll) {
    fechaAll = fechaAll;
  }
  public String getNombreAll() {
    return nombreAll;
  }
  public void setNombreAll(String nombreAll) {
    nombreAll = nombreAll;
  }
  public String getAppellido_1All() {
    return appellido_1All;
  }
  public void setAppellido_1All(String appellido_1All) {
    appellido_1All = appellido_1All;
  }
  public String getApellido_2() {
    return apellido_2;
  }
  public void setApellido_2(String apellido_2) {
    apellido_2 = apellido_2;
  }
  public String getNif_nie_All() {
    return nif_nie_All;
  }
  public void setNif_nie_All(String nif_nie_All) {
    this.nif_nie_All = nif_nie_All;
  }
  public String getAsociacionAll() {
    return entidadAll;
  }
  public void setAsociacionAll(String asociacionAll) {
    this.entidadAll = asociacionAll;
  }
  public String getDescripAll() {
    return descripAll;
  }
  public void setDescripAll(String descripAll) {
    descripAll = descripAll;
  }
  public String getAreaTrabajoAll() {
    return areaTrabajoAll;
  }
  public void setAreaTrabajoAll(String areaTrabajoAll) {
    this.areaTrabajoAll = areaTrabajoAll;
  }
  public String getSolicitudAll() {
    return solicitudAll;
  }
  public void setSolicitudAll(String solicitudAll) {
    this.solicitudAll = solicitudAll;
  }
  public String getDirigidoAll() {
    return dirigidoAll;
  }
  public void setDirigidoAll(String dirigidoAll) {
    this.dirigidoAll = dirigidoAll;
  }
 
  public void setGaleria1(String galeria1) {
    this.galeria1 = galeria1;
  }
  
  public String getGaleria1() {
    return galeria1;
  }

  public String getGaleria2() {
    return galeria2;
  }

  public void setGaleria2(String galeria2) {
    this.galeria2 = galeria2;
  }

  public String getGaleria3() {
    return galeria3;
  }

  public void setGaleria3(String galeria3) {
    this.galeria3 = galeria3;
  }

  public String getGaleria4() {
    return galeria4;
  }

  public void setGaleria4(String galeria4) {
    this.galeria4 = galeria4;
  }

  public String getGeo1() {
    return geo1;
  }

  public void setGeo1(String geo1) {
    this.geo1 = geo1;
  }

  public String getGeo2() {
    return geo2;
  }

  public void setGeo2(String geo2) {
    this.geo2 = geo2;
  }

  public String getGeo3() {
    return geo3;
  }

  public void setGeo3(String geo3) {
    this.geo3 = geo3;
  }

  public String getGeo4() {
    return geo4;
  }

  public void setGeo4(String geo4) {
    this.geo4 = geo4;
  }

  public String getAnexos1All() {
    return anexos1All;
  }
  public void setAnexos1All(String anexos1All) {
    this.anexos1All = anexos1All;
  }
  
  public String getAnexos2All() {
    return anexos2All;
  }
  public void setAnexos2All(String anexos2All) {
    this.anexos2All = anexos2All;
  }
    

}
