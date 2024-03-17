package Main;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AccionesBotones implements ActionListener {
  
  private VentanaBuilder ventanaBuilder;
  private JButton miboton;
  private GeneraActa miacta;
  
  public AccionesBotones(VentanaBuilder ventanaBuilder) {
    this.ventanaBuilder=ventanaBuilder;
  }
  
  public void actionPerformed(ActionEvent e) {
    //animacion del gif
    ventanaBuilder.setIconGIFGIF();
    
    JButton miboton= (JButton) e.getSource();
    
    //Si pulsamos el boton de Enviar
    if(miboton==ventanaBuilder.getBtnAceptar()) {
      //System.out.println("has dado al boton de Aceotar");
      accionEnviarActa(miboton);
      
    }else if(miboton==ventanaBuilder.getBtnSalir()) {
      
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Saliendo...");
      ventanaBuilder.cerrarVentana();
      System.exit(0);
    
      //Si pulsamos el boton de Validar Entidad  
    }else if(miboton==ventanaBuilder.getBtnEntidad()) {
      accionValidarEntidad(miboton);
      
      //Si pulsamos el boton de Validar Fecha
    }else if(miboton==ventanaBuilder.getBtnFecha()) {
      accionValidarFecha(miboton);
      
      //Si pulsamos el boton de validar Persona
    }else if(miboton==ventanaBuilder.getBtnPersona()){      
      accionValidarPersona(miboton);
      
    //Si pulsamos el boton de validar Asunto/Titulo
    }else if(miboton==ventanaBuilder.getBtnAsunto()){
      accionValidarAsunto(miboton);
      
    //Si pulsamos el boton de validar Descripcion  
    }else if(miboton==ventanaBuilder.getBtnDescripcion()){      
      accionValidarDescripcion(miboton);
     
      //Si pulsamos expandir Descripcion
    }else if(miboton==ventanaBuilder.getBtnExpandirDesc()){
      accionExpandirDescripcion(miboton);
      
    //si pulsamos el boton de validar Area de Trabajo
    }else if(miboton==ventanaBuilder.getBtnAreaTrabajo()){
      accionValidarArea(miboton);
      //System.out.println("Bton valida Area de Trabajo");
      
    //Si pulsamos el boton de validar Solicitud  
    }else if(miboton==ventanaBuilder.getBtnSolicitud()){
      
      accionValidarSolicitud(miboton);  
    
      //Si pulsamos expandir Solicitud
    }else if(miboton==ventanaBuilder.getBtnExpandirSolicitud()){      
      accionExpandirSolicitud(miboton);
      
    //Si pulsamos al boton de validar Dirigido  
    }else if(miboton==ventanaBuilder.getBtnDirigido()){
      accionValidarDirigido(miboton);
      
    //Si pulsamos el boton de Galeria de fotos  
    }else if(miboton==ventanaBuilder.getBtnGaleriaFotos()){
      System.out.println("Bton valida galeria fotos");
      accionValidarFotos(miboton);
    
      //Si pulsamos el boton de agregar galeria1  
    }else if(miboton==ventanaBuilder.getBtnAgregaGaleria_1()){
      accionAgregarFotos1(miboton);
      
    //Si pulsamos el boton de agregar galeria2  
    }else if(miboton==ventanaBuilder.getBtnAgregaGaleria_2()){
      accionAgregarFotos2(miboton);  
      
    //Si pulsamos el boton de agregar galeria3  
    }else if(miboton==ventanaBuilder.getBtnAgregaGaleria_3()){
      accionAgregarFotos3(miboton);  
      
    //Si pulsamos el boton de agregar galeria4  
    }else if(miboton==ventanaBuilder.getBtnAgregaGaleria_4()){      
      accionAgregarFotos4(miboton);  
    
    //Si pulsamos el boton de eliminar galeria1
    }else if(miboton==ventanaBuilder.getBtnEliminaGaleria_1()) {
      accionEliminarFotos1(miboton);
      
    //Si pulsamos el boton de eliminar galeria1
    }else if(miboton==ventanaBuilder.getBtnEliminaGaleria_2()) {
      accionEliminarFotos2(miboton);
     
    //Si pulsamos el boton de eliminar galeria1
    }else if(miboton==ventanaBuilder.getBtnEliminaGaleria_3()) {
      accionEliminarFotos3(miboton);
    
    //Si pulsamos el boton de eliminar galeria1
    }else if(miboton==ventanaBuilder.getBtnEliminaGaleria_4()) {
      accionEliminarFotos4(miboton);
       
    //Si pulsamos el boton  anexos  
    }else if(miboton==ventanaBuilder.getBtnAnexos()){
      //System.out.println("Bton valida anexos");
      accionValidarAnexos(miboton);
    
      //Esto es para agregar fichero ajenos de cualquier tipo lo comentamos pero lo dejamos escrito asi como las funciones asociadas
      //pero deberia de colocarse dos botones uno para agrear ficheros y otro para eliminar ficheros, ademas de TextField en disable
    //Si pulsamos el boton de agregar Anexo1  
    }/*else if(miboton==ventanaBuilder.getBtnAgregaAnexo1()){      
      accionAgregaAnexo1(miboton);
      
    //Si pulsamos el boton de eliminar Anexo1 
    }*//*else if(miboton==ventanaBuilder.getBtnEliminarAnexo1()) {
      accionEliminarAnexo1(miboton);
    
    
    //Si pulsamos el boton de agregar Anexo2  
    }*//*else if(miboton==ventanaBuilder.getBtnAgregaAnexo2()){      
      accionAgregaAnexo2(miboton);
      
    //Si pulsamos el boton de eliminar Anexo2 
    }*//*else if(miboton==ventanaBuilder.getBtnEliminarAnexo2()) {
      accionEliminarAnexo2(miboton);
    
    //Si pulsamos el boton de elimnar Incidencia  
    }*/else if(miboton==ventanaBuilder.getBtnIncidencia()){     
      accionValidarIncidencia(miboton);
      
    //Si pulsamos el boton de Generar PDF  
    }else if(miboton==ventanaBuilder.getBtnPDF()) {
      accionBtnPDF(miboton);
    }else if(miboton==ventanaBuilder.getBtnListar()) {
      accionBtnListar(miboton);
    }
    
   //Quitamos la animacion GIF a un PNG
    
    
    ventanaBuilder.setIconGIFPNG();
  }
  
  //Accion para listar nuestra base de datos mediante el numero de incidente(abrir PDF)
  private void accionBtnListar(JButton miboton) {
    //System.out.println("ABRIR LISTAR INCIDENCIAS");
    ventanaBuilder.setlb_Inf_Inf_Ayuda("ABRIR LISTAR INCIDENCIAS");
    ListarActas milista=new ListarActas();
  }
  
  //Accion para generar nuestro PDF
  private void accionBtnPDF(JButton miboton) {
    GenerarPDF miPDF=new GenerarPDF(ventanaBuilder);
    ventanaBuilder.setlb_Inf_Inf_Ayuda("Generando PDF");
    miPDF.genenerarPdf();
  }
 
  //Accion para enviar nuestro acta a la base de datos mediante el servidor
  private void accionEnviarActa(JButton miboton) {
    
    miacta.enviar_recibir(ventanaBuilder);
    if(ventanaBuilder.getBtnAceptar().isEnabled()) {
      ventanaBuilder.si_envia_Pdf();
    }else {
      ventanaBuilder.no_Envia_Pdf();
    }
    
    
  }

  //Accion para saber si comenzamos a validar el Acta y generacion del Numero de incidencia
  private void accionValidarIncidencia(JButton miboton) {
    boolean verdeEntidad,verdeFecha,verdeDecripcion,verdeDirigido;
    String str_final="",str_entidad="",str_fecha="",str_descrip="",str_diri="";
    Color colorVerde=Color.GREEN;
    //Miramos el color de los botones minimos para generar un Acta(Asunto, fecha, Descripcion y Dirigido
    if(ventanaBuilder.getBtnEntidad().getBackground().equals(colorVerde)) {
      verdeEntidad=true;
    }else {
      verdeEntidad=false;
      str_entidad="Falta Entidad. ";
      //ventanaBuilder.getBtnAceptar().setEnabled(false);
      ventanaBuilder.no_Envia_Pdf();
    }
    if(ventanaBuilder.getBtnFecha().getBackground().equals(colorVerde)) {
      verdeFecha=true;
    }else {
      verdeFecha=false;
      str_fecha="Falta Fecha. "; 
      //ventanaBuilder.getBtnAceptar().setEnabled(false);
      ventanaBuilder.no_Envia_Pdf();
    }
    if(ventanaBuilder.getBtnDescripcion().getBackground().equals(colorVerde)) {
      verdeDecripcion=true;
    }else {
      verdeDecripcion=false;
      str_descrip="Falta Descripción. "; 
      //ventanaBuilder.getBtnAceptar().setEnabled(false);
      ventanaBuilder.no_Envia_Pdf();
    }
    if(ventanaBuilder.getBtnDirigido().getBackground().equals(colorVerde)) {
      verdeDirigido=true;
    }else {
      verdeDirigido=false;
      str_diri="Falta Dirigido. ";
      //ventanaBuilder.getBtnAceptar().setEnabled(false);
      ventanaBuilder.no_Envia_Pdf();
    }
    str_final=str_entidad+str_fecha+str_descrip+str_diri;
    if(str_final.length()>1) {
      ventanaBuilder.setTextFieldIncidencia(str_final);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Falta validar los campos Entidad o Dirigio o Fecha o Descripcion.");
    }else {
      ventanaBuilder.setIconGIFGIF();
      ventanaBuilder.setTextFieldIncidencia("Generando Nueva Acta ");
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Nueva Acta Ok");
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      miacta=new GeneraActa(ventanaBuilder);
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    
  }
  
  //Accion para validar los archivox anexos(solo existe o no existe)
  private void accionValidarAnexos(JButton miboton) {
    this.miboton=miboton;
    boolean verdad1=false, verdad2=false;
    String str1,str2;
    //Si no lo rellenamos no da un error, asi que controlamos el error
    try {
      str1=ventanaBuilder.getTextFieldAnexo1().getText().toString();
    }catch(Exception e) {
      str1="";
    }
    
    try {
      str2=ventanaBuilder.getTextFieldAnexo2().getText().toString();
    }catch(Exception e) {
      str2="";
    }
    //System.out.println(str1+"-"+str2);
    if((str1.length()>1&&str1.length()<122)) {
      verdad1=true;
    }
    if((str2.length()>1&&str2.length()<122)) {
      verdad2=true;
    }
    if(str1.equals(str2)&&str1.equals("")||(str2.length()>122||str1.length()>122)) {
      verdad1=false;
      verdad2=false;
    }
    
    
    if(verdad1||verdad2) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Anexo/s correcto/s.");
    }else {
      String str_ayuda="";
      miboton.setBackground(Color.RED);
      if(!verdad1) {
        str_ayuda+=" Anexo 1 ";
      }
      if(!verdad2) {
        str_ayuda+= " Anexo 2 ";
      }
      ventanaBuilder.setlb_Inf_Inf_Ayuda(str_ayuda+" incorrecto/s.");
    }
    
  }
  
  /*
  //Accion de eliminar archivos del anexo2
  private void accionEliminarAnexo2(JButton miboton) {
    ventanaBuilder.setTextFieldAnexos2("");
  }
  */
  
  /*
  //Accion de agregar archivos anexo
  private void accionAgregaAnexo2(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    
    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldAnexos2(selectedFile.getAbsolutePath());
    }
  }
  */
  /*
  //Accion de eliminar archivos del anexo1
  private void accionEliminarAnexo1(JButton miboton) {
    ventanaBuilder.setTextFieldAnexos1("");
  }
  */
  /*
  //Accion de agregar archivos anexo
  private void accionAgregaAnexo1(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    
    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldAnexos1(selectedFile.getAbsolutePath());
    }
    
  }
  */
  //Accion para eliminar direcion de la imagena la Galeria 1
  private void accionEliminarFotos1(JButton miboton) {
    this.miboton=miboton;
    ventanaBuilder.setTextFieldGaleria_1("");
  }
  
  //Accion para eliminar direcion de la imagena la Galeria 1
  private void accionEliminarFotos2(JButton miboton) {
    this.miboton=miboton;
    ventanaBuilder.setTextFieldGaleria_2("");
  }
  
  //Accion para eliminar direcion de la imagena la Galeria 1
  private void accionEliminarFotos3(JButton miboton) {
    this.miboton=miboton;
    ventanaBuilder.setTextFieldGaleria_3("");
  }
  
  //Accion para eliminar direcion de la imagena la Galeria 1
  private void accionEliminarFotos4(JButton miboton) {
    this.miboton=miboton;
    ventanaBuilder.setTextFieldGaleria_4("");
  }
  
  
  //Accion para agregar direccion de la imagen a Galeria 1
  private void accionAgregarFotos1(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imágenes", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      //System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldGaleria_1(selectedFile.getAbsolutePath());
    }
  }
  
//Accion para agregar direccion de la imagen a Galeria 2
  private void accionAgregarFotos2(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imágenes", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      //System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldGaleria_2(selectedFile.getAbsolutePath());
    }
  }
  
  //Accion para agregar direccion de la imagen a Galeria 3
  private void accionAgregarFotos3(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imágenes", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      //System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldGaleria_3(selectedFile.getAbsolutePath());
    }
  }
  
  //Accion para agregar direccion de la imagen a Galeria 4
  private void accionAgregarFotos4(JButton miboton) {
    this.miboton=miboton;
    
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imágenes", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(ventanaBuilder.getFrame());

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      // Aquí puedes realizar acciones con el archivo seleccionado
      //System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
      ventanaBuilder.setTextFieldGaleria_4(selectedFile.getAbsolutePath());
    }
  }
  
  
  //Accion de Expandir Descripcion
  private void accionExpandirDescripcion(JButton miboton) {
    this.miboton=miboton;
    String str=ventanaBuilder.getTextAreaDescrip().getText().toString();
    VentanaTexto mitexto=new VentanaTexto(ventanaBuilder.getTextAreaDescrip());
    
  }
  
  //Accion de Validar Fotos
  private void accionValidarFotos(JButton miboton) {
    this.miboton=miboton;
    String str_foto1,str_foto2,str_foto3,str_foto4;
    String str_geo1,str_geo2,str_geo3,str_geo4;
    boolean verdad1,verdad2,verdad3,verdad4;
    //Asociamos cada texto con cada cuadro de texto, si esta vacio nos da un error que cogemos con un try/catch
    try {
      str_foto1=ventanaBuilder.getTextFieldGaleria_1().getText().toString();
    }catch(Exception e) {
      str_foto1="";
    }
    try {
      str_foto2=ventanaBuilder.getTextFieldGaleria_2().getText().toString();
    }catch(Exception e) {
      str_foto2="";
    }
    try {
      str_foto3=ventanaBuilder.getTextFieldGaleria_3().getText().toString();
    }catch(Exception e) {
      str_foto3="";
    }
    try {
      str_foto4=ventanaBuilder.getTextFieldGaleria_4().getText().toString();
    }catch(Exception e) {
      str_foto4="";
    }    
    str_geo1=ventanaBuilder.getTextFieldGeo_1().getText();
    str_geo2=ventanaBuilder.getTextFieldGeo_2().getText();
    str_geo3=ventanaBuilder.getTextFieldGeo_3().getText(); 
    str_geo4=ventanaBuilder.getTextFieldGeo_4().getText();
    
    verdad1=vaciodeTextos(str_foto1,str_geo1);
    verdad2=vaciodeTextos(str_foto2,str_geo2);
    verdad3=vaciodeTextos(str_foto3,str_geo3);
    verdad4=vaciodeTextos(str_foto4,str_geo4);
    
    if(verdad1&&verdad2&&verdad3&&verdad4/*&&(str_geo1.length()>0&&str_geo2.length()>0&&str_geo3.length()>0&&str_geo4.length()>0)*/) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Galeria correcta.");
    }else {
      miboton.setBackground(Color.RED);  
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Galeria incorrecta.");
    }
    
  }
  
  //Método para compobar si tiene texto o no dos textos
  private boolean vaciodeTextos(String str1,String str2) {
    boolean verdad=false;
    if(str1==null||str1.length()==0) {
      if(str2==null||str2.length()==0) {
        verdad= true;
      }      
    }else if(str1.length()>1&&str2.length()>1) {
      verdad= true;
    }
    
    
    return verdad;
  }
  
  
  //Accion de Expandir Solicitud
  private void accionExpandirSolicitud(JButton miboton) {
    this.miboton=miboton;
    String str=ventanaBuilder.getTextAreaSolicitud().getText().toString();
    VentanaTexto mitexto=new VentanaTexto(ventanaBuilder.getTextAreaSolicitud());
    
  }
  
  //Accion de Validar la Fecha
  private void accionValidarFecha(JButton miboton) {
    this.miboton=miboton;
    String str_anio,str_mes,str_dia,str_hora;
    str_anio=ventanaBuilder.getcomboBoxAnio().getSelectedItem().toString();
    str_mes=ventanaBuilder.getcomboBoxMes().getSelectedItem().toString();
    try {
    str_dia=ventanaBuilder.getcomboBoxDia().getSelectedItem().toString();
    }catch(Exception e) {
      str_dia="";
    }
    str_hora=ventanaBuilder.getcomboBoxHora().getSelectedItem().toString();
    if(str_anio.length()>3&&str_mes.length()>3&&str_dia.length()>0&&str_hora.length()>2) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Fecha correcta.");
    }else {
      miboton.setBackground(Color.RED);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Fecha incorrecta.");
      ventanaBuilder.no_Envia_Pdf();
    }
  }
  
  //Accion de validar Dirigido
  private void accionValidarDirigido(JButton miboton) {
    this.miboton=miboton;
    String str_entidad=ventanaBuilder.getcomboBoxDirigido().getSelectedItem().toString();
    //System.out.println(str_entidad+" - "+str_entidad.length());
    if(str_entidad.length()>1) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Dirigido correcto.");
    }else {
      miboton.setBackground(Color.RED);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Dirigido incorrecto.");
      ventanaBuilder.no_Envia_Pdf();
    }
  }
  
  //Acción de validar Area de Trabajo
  private void accionValidarArea(JButton miboton) {
    this.miboton=miboton;
    String str_entidad=ventanaBuilder.getcomboBoxAreaTrabajo().getSelectedItem().toString();
    //System.out.println(str_entidad+" - "+str_entidad.length());
    if(str_entidad.length()>1) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Area correcto.");
    }else {
      miboton.setBackground(Color.RED);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Area incorrecto.");
    }
  }
  
  
  //Acción de validar Entidad
  private void accionValidarEntidad(JButton miboton) {
    this.miboton=miboton;
    String str_entidad=ventanaBuilder.getcomboBoxAAVV().getSelectedItem().toString();
    
    if(str_entidad.length()>1) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Entidad correcto.");
    }else {
      miboton.setBackground(Color.RED);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Entidad Incorrecto.");
      ventanaBuilder.no_Envia_Pdf();
    }
  }  
  
  
  //Comprobar si se puede pasar de String s Double
  private boolean str_double(String str) {
    
    try {
      double d=Double.parseDouble(str);
      return true;
    }catch(Exception e) {
      return false;
    }
  }
  
  
  //Acción para validar la Solicitud
  private void accionValidarSolicitud(JButton miboton) {
    this.miboton=miboton;
    boolean booSolicitud=true;
    String str=ventanaBuilder.getTextAreaSolicitud().getText();
    booSolicitud=validarText(str,3,900); 
    if(booSolicitud) {
      booSolicitud=primeraMayusculas(str);
    }
    if(booSolicitud) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Solicitud correcto.");
    }else {
      miboton.setBackground(Color.RED);
      //Mensaje de ayuda de errores
      String str_ayuda="";
      if(!validarText(str,3,900)) {
        str_ayuda+=" Texto entre 3 y 900 caracteres ";
      }
      if(!primeraMayusculas(str)) {
        str_ayuda+=" Primera letra minusculas ";
      }
      
      ventanaBuilder.setlb_Inf_Inf_Ayuda(str_ayuda+" Incorrecto/s.");
    }
  }
  
  //Acción para validar la Descripcion
  private void accionValidarDescripcion(JButton miboton) {
    this.miboton=miboton;
    boolean booDes=true;
    String str=ventanaBuilder.getTextAreaDescrip().getText();
    booDes=validarText(str,3,900); 
    if(booDes) {
      booDes=primeraMayusculas(str);
    }
    if(booDes) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Descripción correcto.");
    }else {
      miboton.setBackground(Color.RED);
      //Mensaje de ayuda de errores
      String str_ayuda="";
      if(!validarText(str,3,900)) {
        str_ayuda+=" Texto entre 3 y 900 caracteres ";
      }
      if(primeraMayusculas(str)) {
        str_ayuda+=" Primera letra minusculas ";
      }
      
      ventanaBuilder.setlb_Inf_Inf_Ayuda(str_ayuda+" Incorrecto/s.");
      ventanaBuilder.no_Envia_Pdf();
    }
  }
  
  //Acción para validar el Asunto/Título
  private void accionValidarAsunto(JButton miboton) {
    this.miboton=miboton;
    boolean booAsunto=true;
    String str=ventanaBuilder.getTextFieldTitulo().getText();
    booAsunto=primeraMayusculas(str);
    if(booAsunto) {
      booAsunto=validarText(str,3,120);
    }
    if(booAsunto) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Asunto correcto.");
    }else {
      miboton.setBackground(Color.RED);
    //Mensaje de ayuda de errores
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Asunto incorrecto (primera mayuscula).");
    }
  }
  
  //Acción para Validar la Persona, Nombre, Apellidos y Nif
  private void accionValidarPersona(JButton miboton) {
    this.miboton=miboton;
    boolean booNombre, booApellido1,booApellido2,booNif;
    String str_nombre,str_apellido1,str_apellido2,str_nif;
    //Cogemos los valores del texto introducido en los campos correspondientes
    str_nombre=ventanaBuilder.getTextFieldNombre().getText();
    str_apellido1=ventanaBuilder.getTextFieldApellido1().getText();
    str_apellido2=ventanaBuilder.getTextFieldApellido2().getText();
    str_nif=ventanaBuilder.getTextFieldNIF().getText();
    //Comprobmos si los valores introducidos son correctos
    booNombre=validaNombre(str_nombre);
    booApellido1=validaApellido1(str_apellido1);
    booApellido2=validaApellido2(str_apellido2);
    booNif=validarNIF_Nie(str_nif);
    //Cambiamos de color los botones si es correcto o incorrecto
    if(booNombre&&booApellido1&&booApellido2&&booNif) {
      miboton.setBackground(Color.GREEN);
      ventanaBuilder.setlb_Inf_Inf_Ayuda("Persona validado.");
    }else {
      //Mensaje de ayuda de errores
      String str_ayuda="";
      miboton.setBackground(Color.RED);
      if(!booNombre) {
        str_ayuda+=" Nombre ";
      }
      if(!booApellido1) {
        str_ayuda+=" Apellido1 ";
      }
      if(!booApellido2) {
        str_ayuda+=" Apellido2 ";
      }
      if(!booNif) {
        str_ayuda+=" NIF/NIE ";
      }
      ventanaBuilder.setlb_Inf_Inf_Ayuda(str_ayuda+" Incorrecto/s.");
    } 
   
  }  
  
  //Validamos si es correcto los  Apellidos1 
  private boolean validaApellido1(String str) {
    boolean verdad=true;
    
    if(str!=null||str.length()>2) {     
      verdad=validaNombre(str);
    }else {
      verdad=false;
    }
    
    return verdad;
    
  }
  
  //Validamos si es correcta el Apellido2
  private boolean validaApellido2(String str) {
    if(str.length()>0) {
      return primeraMayusculas(str);
    }else {
      return true;
    }
    
  }
  
  //Validamos si el correcto el nombre
  private boolean validaNombre(String str) {
    boolean verdad=true;
    
    verdad=primeraMayusculas(str);
    if(verdad) {
      verdad=validarText(str,3,30);
    }
    return verdad;
  }
  
  //Comprobamos si la primera letra está en Mayusculas
  private boolean primeraMayusculas(String str) {
    boolean verdad=true;
    // Verifica si la cadena no está vacía
    if (str != null && !str.isEmpty()) {
        // Obtiene el primer carácter
        char primeraLetra = str.charAt(0);

        // Verifica si la primera letra está en mayúsculas
        verdad= Character.isUpperCase(primeraLetra);
    }

    // Devuelve falso si la cadena está vacía o es nula
    return verdad;
  }
  
  //Comprobamos el valor del texto, consideramos que menor de 3 no es correcto
  private  boolean validarText(String str,int min, int max) {
    boolean verdad=true;
    if(str.length()<min||str.length()>max) {
      verdad=false;
    }else {
      verdad=true;
    }
    return verdad;
  }
  
  //Validamos si es correcto el NIF_Nie
  private boolean validarNIF_Nie(String nif) {
    boolean verdad_nif,verdad_nie;
    verdad_nif=validarNIF(nif);
    verdad_nie=validarNIE(nif);
    if(verdad_nif||verdad_nie) {
      return true;
    }else {
      return false;
    }
  }
  
  //Validamos si es correcto el NIe
  public static boolean validarNIE(String nie) {
    // Expresión regular para validar el formato del NIE
    String patronNIE = "^[XYZ]\\d{7}[A-HJ-NP-TV-Z]$";
    Pattern pattern = Pattern.compile(patronNIE);
    Matcher matcher = pattern.matcher(nie);

    // Comprobar si el NIE coincide con el patrón
    return matcher.matches();
}
  
  //Validamos si es correcto el NIF
  private boolean validarNIF(String nif) {
    // Verificar la longitud del NIF
    if (nif == null || nif.length() != 9) {
        return false;
    }

    // Extraer el número y la letra del NIF
    String numeroStr = nif.substring(0, 8);
    String letra = nif.substring(8).toUpperCase();

    // Verificar que el número es un entero válido
    try {
        int numero = Integer.parseInt(numeroStr);
    } catch (NumberFormatException e) {
        return false;
    }

    // Calcular el dígito de control
    int resto = Integer.parseInt(numeroStr) % 23;
    char letraCalculada = obtenerLetraNIF(resto);

    // Comparar la letra calculada con la letra del NIF
    return letraCalculada == letra.charAt(0);
  }

  //Obtenemos la letra correspondiente al NIF
  private static char obtenerLetraNIF(int resto) {
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    return letras.charAt(resto);
  }
  

}
