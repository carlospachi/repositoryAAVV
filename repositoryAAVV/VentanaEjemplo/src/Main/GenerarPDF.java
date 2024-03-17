package Main;

import java.io.*;
import java.nio.file.StandardCopyOption;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class GenerarPDF {
  
  private VentanaBuilder miventana;
  private String str_barra="/";
  private final float  PADDINGTOP=20f;
  private PdfWriter pdfWrite;
  private Font font_normal;
  private Font font_bold;
  private String str_directory;
  
  
  public GenerarPDF(VentanaBuilder miventana) {
    this.miventana=miventana;
    font_normal=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL);
    font_bold=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
    
  }
  
  
  
//Genaramos el PDF
  public boolean genenerarPdf()  {
    
    boolean verdad=true;

    Document midocument=new Document();
    ActaIncidenciasAll inci=rellenaIncidenciaAll();
    
    String str_name_file=str_name_fecha();
    str_directory=str_carpeta();
    //String destino
    String str_full=str_directory+str_barra+str_name_file;
    
   
    try {
      File midirectory=new File(str_directory);
      if(!midirectory.exists()) {
        midirectory.mkdirs();
        
      }else {
        miventana.getBtnPDF().setEnabled(false);
        System.out.println("YA exite el directorio no se puede sobre escribir");
        return true;
        
      }
      if(midirectory.isDirectory()) {
        System.out.println("Se creo el directorio, "+str_directory);
      }else {
        System.out.println("No se creo el directorio, "+str_directory);
      }
      
      pdfWrite= PdfWriter.getInstance(midocument, new FileOutputStream(str_full));
      midocument.open();
    
      
      //Aqui vamos añadiendo elementos si existen a nuestro documento mediante metodos add_image, add_entidad.....
      
      //Si tiene entidad
      if(!inci.getEntidadAll().equals("")) {
        Paragraph p_entidad=add_entidad(inci.getEntidadAll());
        
        midocument.add(p_entidad);
      }
      
      //aqui intentaremos añadir la fecha mediante codigo de barras......
      //Si tiene entidad
      if(!inci.getFechaAll().equals("")) {
        Paragraph p_fecha=add_fecha(inci.getFechaAll());
        
        midocument.add(p_fecha);
      }
            
      //Si tiene nombre, apellido, y nif
      if(!inci.getNombreAll().equals("")) {
        Paragraph p_persona=add_persona(inci.getNombreAll(),inci.getAppellido_1All(),inci.getApellido_2(),inci.getNif_nie_All());
        
        midocument.add(p_persona);
      }
           
      // Si tiene Asunto
      if(!inci.getAsuntoAll().equals("")) {
        Paragraph p_asunto=add_asunto(inci.getAsuntoAll());
        
        midocument.add(p_asunto);
      }
      
      //Si tiene Descripcion
      if(!inci.getDescripAll().equals("")) {
        Paragraph p_descrip=add_descrip(inci.getDescripAll());
        
        midocument.add(p_descrip);
      }
      
      //Si tiene Area de Trabajo
      if(!inci.getAreaTrabajoAll().equals("")) {
        Paragraph p_area_trabajo=add_area_trabajo(inci.getAreaTrabajoAll());
        
        midocument.add(p_area_trabajo);
      }
      

      //Si tiene Solicitud
      if(!inci.getSolicitudAll().equals("")) {
        Paragraph p_solicitud=add_solicitud(inci.getSolicitudAll());
        
        midocument.add(p_solicitud);
      }
     

      //Si tiene Solicitud
      if(!inci.getDirigidoAll().equals("")) {
        Paragraph p_dirigido=add_dirigido(inci.getDirigidoAll());
        
        midocument.add(p_dirigido);
      }
        
     
      // Agregar imágenes a partir de las direcciones proporcionadas
      if (!inci.getGaleria1().equals("")) {
        PdfPTable parrafo1=add_imagen_coor(inci.getGaleria1(),inci.getGeo1());
       
        // Agregar el párrafo al documento
        midocument.add(parrafo1);
      }      

      if (!inci.getGaleria2().equals("")) {
        PdfPTable parrafo2=add_imagen_coor(inci.getGaleria2(),inci.getGeo2());
       
        // Agregar el párrafo al documento
        midocument.add(parrafo2);
      }     
      
      if (!inci.getGaleria3().equals("")) {
        PdfPTable parrafo3=add_imagen_coor(inci.getGaleria3(),inci.getGeo3());
        
        // Agregar el párrafo al documento
        midocument.add(parrafo3);
      }
            
      if (!inci.getGaleria4().equals("")) {
        PdfPTable parrafo4=add_imagen_coor(inci.getGaleria4(),inci.getGeo4());
        
        // Agregar el párrafo al documento
        midocument.add(parrafo4);
      }
              
      //Si tiene anexo
      if(!inci.getAnexos1All().equals("")) {
        Paragraph p_anexo1=add_anexo(inci.getAnexos1All());
        
        midocument.add(p_anexo1);
      }
      if(!inci.getAnexos2All().equals("")) {
        Paragraph p_anexo2=add_anexo(inci.getAnexos2All());
        
        midocument.add(p_anexo2);
      }
      
      
      //Si tiene INCIDENCIA
      if(!inci.getIncidenciaAll().equals("")) {
        Paragraph p_incidencia=add_incidencia(inci.getIncidenciaAll());
        
        midocument.add(p_incidencia);
      }
      //midocument.add(new Paragraph("Incidencia: " + inci.getIncidenciaAll()));
     
      
            
      midocument.close();
      
      System.out.println("Documento "+str_name_file+" creado");
      return true;
      
    } catch (Exception e ) {
        e.printStackTrace();
        return false;
    }    
  
  }
  
  
  //Metodo para los Anexos
  private Paragraph add_anexos(String str1,String str2) {
    Paragraph p=new Paragraph("Anexo/s:");
    
    return p;
  }
  
  //Metodo para Fecha
  private Paragraph add_fecha(String str) {
    Paragraph p=new Paragraph("Fecha:");
        
    Barcode128 barcode = new Barcode128();
    barcode.setCode(str);
    barcode.setCodeType(Barcode128.CODE128);
    Image code128Image = barcode.createImageWithBarcode(pdfWrite.getDirectContent(), null, null);
    
    // Ajustar tamaño del código de barras si es necesario
    code128Image.scalePercent(150f);
    code128Image.setAlignment(Element.ALIGN_CENTER);

    // Añadir el código de barras al párrafo
    p.add(code128Image);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  
  //Metodo para Incidencia
  private Paragraph add_incidencia(String str) {
    Paragraph p=new Paragraph("Nº Acta:"+str,font_bold);
    p.setAlignment(Element.ALIGN_RIGHT);
    
    p.setPaddingTop(PADDINGTOP);
    Barcode128 barcode = new Barcode128();
    barcode.setCode(str);
    barcode.setCodeType(Barcode128.CODE128);
    Image code128Image = barcode.createImageWithBarcode(pdfWrite.getDirectContent(), null, null);
    
    // Ajustar tamaño del código de barras si es necesario
    code128Image.scalePercent(150f);

    // Añadir el código de barras al párrafo
    p.add(code128Image);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }

  //Metodo par añadir Area Trabajo
  private Paragraph add_anexo(String str) {
    Paragraph p=new Paragraph("Se une al documento..."+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  


  //Metodo par añadir Area Trabajo
  private Paragraph add_dirigido(String str) {
    Paragraph p=new Paragraph("DIRIGIDO a:"+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  

  //Metodo par añadir Area Trabajo
  private Paragraph add_solicitud(String str) {
    Paragraph p=new Paragraph("Se solicita: ..."+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    
    return p;
  }
  

  
  
  //Metodo par añadir Area Trabajo
  private Paragraph add_area_trabajo(String str) {
    Paragraph p=new Paragraph("AREA DE TRABAJO\r "+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  
  
  //Metodo par añadir Asunto
  private Paragraph add_descrip(String str) {
    Paragraph p=new Paragraph("DESCRIPCION:\r "+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  
  
  
  //Metodo par añadir Asunto
  private Paragraph add_asunto(String str) {
    Paragraph p=new Paragraph("ASUNTO\r "+str);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  
  
  //Metodo par añadir Persona
  private Paragraph add_persona(String str_nombre,String str_apellido1, String str_apellido2, String str_nif) {
    Paragraph p=new Paragraph("PERSONA: \rNombre: "+str_nombre+
        " Apellido1: "+str_apellido1+
        " Apellido2: "+str_apellido2+
        " NIF/NIE: "+str_nif);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    
    return p;
  }
  
  //Metodo par añadir Entidad
  private Paragraph add_entidad(String str) {
    Paragraph p=new Paragraph("Entidad: "+str,font_bold);
    p.setAlignment(Element.ALIGN_CENTER);
    
    p.setPaddingTop(PADDINGTOP);
    p.setSpacingAfter(PADDINGTOP);
    return p;
  }
  
  
  //Metodo para añadir Imagen y coordenadas de leyenda
  private PdfPTable add_imagen_coor(String str_galeria,String str_geo) {
    
    //Copiamos el archivo de origen al archivo de destino y lo guardamos en la misma carpeta donde se genera el PDF
    //El problema reside en que Itext tambien tiene la clase File y genera confusion lo mismo para copiarlo
    boolean boo_copiar=false;
    java.io.File file_origen=new java.io.File(str_galeria);
    String str_file_origen=file_origen.getName();
    
    java.io.File file_destino=new java.io.File(str_directory+str_barra+str_file_origen);
    //Creamos el archivo si no existe, no puede haber dos archivo iguales
    if(!file_destino.exists()) {
      try {
        java.nio.file.Files.copy(file_origen.toPath(), file_destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
        boo_copiar=true;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Error no se puede copiar el archivo");
      }
    }
    
    // Crear un párrafo para contener la imagen y las coordenadas
    PdfPTable table = new PdfPTable(1);
    //System.out.println(str_galeria);
    
    // Imagen
    Image imagenGaleria;
    try {
      //Si lo hemos copiado creamos la imagen a partir de la copia , si no a partir del original
      if(boo_copiar) {
        imagenGaleria = Image.getInstance(file_destino.getAbsolutePath());
      }else {
        imagenGaleria = Image.getInstance(str_galeria);
      }
      imagenGaleria.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight() / 2); // Ajustar tamaño al 50% del ancho y alto del folio
      imagenGaleria.setAlignment(Element.ALIGN_CENTER);// Centrar el texto
      PdfPCell cell1 = new PdfPCell(imagenGaleria);
      table.addCell(cell1);
  
      // Coordenadas (leyenda)
      Paragraph coordenadas = new Paragraph("Coordenadas : " + str_geo);
      coordenadas.setAlignment(Element.ALIGN_CENTER); // Centrar el texto

      PdfPCell cell2 = new PdfPCell(coordenadas);

      table.addCell(cell2);

      // Establecer borde para la tabla
      table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
      
      table.setPaddingTop(PADDINGTOP);
      
    } catch (BadElementException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    
    return table;
  }
  
  
  
  //Nombre de la carpeta donde alogaremos el fichero
  private String str_carpeta() {
    String str;
    str=miventana.getTextFieldIncidencia().getText().toString();
    return str;
  }
  
  //Nombre del fichero en funcion de la fecha
  private String str_name_fecha() {
    String str;
    try {
      str="";
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
      str=str_fechaAnio+str_fechaMes+str_fechaDia+str_fechaHora+".pdf";
    }catch(Exception e) {
      System.out.println(str="Infinite.pdf"); 
    }
    
    
    return str;
    
  }
  

  //Recogemos los campos de la ventana de igual manera que en GenerarActa
  private ActaIncidenciasAll rellenaIncidenciaAll() {
    ActaIncidenciasAll miacta;
    String str_asuntoAll, str_fechaAll, str_nombreAll, str_appellido_1All, str_apellido_2All,  str_nif_nie_All,
    str_entidadAll, str_descripAll, str_areaTrabajoAll, str_solicitudAll, str_dirigidoAll, str_galeria1, str_galeria2, str_galeria3,
    str_galeria4, str_geo1, str_geo2, str_geo3, str_geo4, str_anexos1All, str_anexos2All,str_incidenciaAll;
    
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
   
    return miacta;    
 
  }
  
  
  

}
