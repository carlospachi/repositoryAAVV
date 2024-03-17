package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class VentanaBuilder{

  private JFrame frame;
  private JTextField textFieldNombre, textFieldApellido1, textFieldNIF, textFieldTitulo,textFieldIncidencia; 
  private JLabel lb_Inf_Inf_Ayuda;
  private AccionesBotones accionesBotones;
  private AcionesComboBox accionesComboBox;
  private AccionesText accionesText;
  private JButton btnSalir, btnAceptar,btnEntidad,btnFecha,btnPersona,btnAsunto,btnDescripcion;
  private JButton btnEliminaGaleria_1,btnEliminaGaleria_2,btnEliminaGaleria_3,btnEliminaGaleria_4;
  private JButton btnSolicitud,btnDirigido,btnGaleriaFotos,btnAnexos,btnIncidencia,btnAgregaGaleria_4, btnListar, btnPDF;
  private JButton btnExpandirDesc,btnExpandirSolicitud,btnAreaTrabajo,btnAgregaGaleria_1,btnAgregaGaleria_2,btnAgregaGaleria_3;
  private JComboBox comboBoxAAVV,comboBoxAnio,comboBoxMes,comboBoxDia,comboBoxHora,comboBoxAreaTrabajo,comboBoxDirigido ;
  private JTextArea textAreaSolicitud,textAreaDescrip;
  private JTextField textFieldApellido2, textFieldGaleria_2, textFieldGeo_2;
  private JTextField textFieldGaleria_3, textFieldGeo_3,textFieldGaleria_4, textFieldGeo_4;
  private JTextField textFieldGeo_1,textFieldGaleria_1,textFieldAnexo1,textFieldAnexo2;
  private ImageIcon iconGIF;
  private final String str_IconPng="Imagenes/2023_LOGO_MULTISERVICIOS_TEXT0_VECTORIZADO.png";
  private final String str_IconGif="Imagenes/2023_LOGO_MULTISERVICIOS_GIF_SIMBOLO_480.gif";
  

  //private JPanel panelDere,panelCentral,panelBtnIncidencia;

  
  
  /**
   * Create the application.
   */
  public VentanaBuilder() {
    
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */

  private void initialize() {
    frame = new JFrame();
    colocarEnEsquina();
    
    
    //Ponemos los metodos de las Acciones de Boton
    accionesBotones=new AccionesBotones(this);
    //Ponemos los metodos las Acciones de los JComboBox
    accionesComboBox=new AcionesComboBox(this);
    //Ponemos los metodos de la Acciones de los JTextField y JTextArea(JComponent)
    accionesText=new AccionesText(this);
    
    //Poner icono en nuestro JFrame
    ImageIcon miIcono=new ImageIcon("Imagenes/2023_LOGO_MULTISERVICIOS_TEXT0_VECTORIZADO.png");
    frame.setIconImage(miIcono.getImage());
    
    //asignarListener();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));
    
  //Panel Superior//////////////////////////////////////////////////////////////////////////////////////////////////////////  
    JPanel panelSuperior = new JPanel();
    frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
    
    JPanel panelLabelTitulo = new JPanel();
    panelSuperior.add(panelLabelTitulo);
    
    JLabel lbTitulo = new JLabel("TITULO");
    lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
    panelLabelTitulo.add(lbTitulo);

    //Panel Inferior/////////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelInferior = new JPanel();
    frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
    panelInferior.setLayout(new BorderLayout(0, 0));
    
    JPanel panelBtonOkSalir = new JPanel();
    panelInferior.add(panelBtonOkSalir);
    
    btnAceptar = new JButton("Enviar");
    btnAceptar.setEnabled(false);
    btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnAceptar.addActionListener(accionesBotones);
    panelBtonOkSalir.add(btnAceptar);
    
    btnSalir = new JButton("Salir(Esc)");
    btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnSalir.addActionListener(accionesBotones);
    panelBtonOkSalir.add(btnSalir);
    
    JPanel panel_Abrir = new JPanel();
    panelInferior.add(panel_Abrir, BorderLayout.WEST);
    panel_Abrir.setLayout(new GridLayout(1, 2, 100, 10));
    
    JPanel panelMargenIzq = new JPanel();
    panel_Abrir.add(panelMargenIzq);
    
    btnListar = new JButton("Listar");
    btnListar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    panel_Abrir.add(btnListar);
    btnListar.addActionListener(accionesBotones);
    
    JPanel panel_PDF = new JPanel();
    panelInferior.add(panel_PDF, BorderLayout.EAST);
    panel_PDF.setLayout(new GridLayout(1, 2, 100, 10));
    
    btnPDF = new JButton("Generar PDF");
    btnPDF.setEnabled(false);
    panel_PDF.add(btnPDF);
    btnPDF.addActionListener(accionesBotones);
    
    JPanel panelMargenDere = new JPanel();
    panel_PDF.add(panelMargenDere);
    
    JPanel panelInferior_Inferior = new JPanel();
    panelInferior.add(panelInferior_Inferior, BorderLayout.SOUTH);
    panelInferior_Inferior.setLayout(new BorderLayout(0, 0));
    
    JPanel panelInf_Inf_West = new JPanel();
    panelInferior_Inferior.add(panelInf_Inf_West, BorderLayout.WEST);
    
    lb_Inf_Inf_Ayuda = new JLabel("ayuda");
    panelInf_Inf_West.add(lb_Inf_Inf_Ayuda);
    
    JPanel panelInf_Inf_East = new JPanel();
    panelInferior_Inferior.add(panelInf_Inf_East, BorderLayout.EAST);
    
    
    //Insetar el gif animado
    iconGIF=new ImageIcon(IconGif());
    Image miImageGIF=iconGIF.getImage();
    Image nuevaImageGIF=miImageGIF.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    ImageIcon nuevaIconGIF=new ImageIcon(nuevaImageGIF);
    JLabel lbIcon = new JLabel(nuevaIconGIF);
    
    lbIcon.setBounds(0,0,10,10);
    panelInf_Inf_East.add(lbIcon);
    
    //Panel Izquierda/////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelIzq = new JPanel();
    frame.getContentPane().add(panelIzq, BorderLayout.WEST);
    panelIzq.setLayout(new GridLayout(0, 1, 0, 0));
    
    JPanel panelLabelEntidad = new JPanel();
    panelIzq.add(panelLabelEntidad);
    panelLabelEntidad.setLayout(new BorderLayout(0, 0));
    
    JLabel lbEntidad = new JLabel("Entidad");
    lbEntidad.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelEntidad.add(lbEntidad, BorderLayout.CENTER);
    
    JPanel panel_i_1_1 = new JPanel();
    panelLabelEntidad.add(panel_i_1_1, BorderLayout.WEST);
    
    JPanel panel_i_1_2 = new JPanel();
    panelLabelEntidad.add(panel_i_1_2, BorderLayout.EAST);
    
    JPanel panelLabelFecha = new JPanel();
    panelIzq.add(panelLabelFecha);
    panelLabelFecha.setLayout(new BorderLayout(0, 0));
    
    JLabel lbFecha = new JLabel("Fecha");
    lbFecha.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelFecha.add(lbFecha, BorderLayout.CENTER);
    
    JPanel panel_2 = new JPanel();
    panelLabelFecha.add(panel_2, BorderLayout.WEST);
    
    JPanel panel_1_1 = new JPanel();
    panelLabelFecha.add(panel_1_1, BorderLayout.EAST);
    
    JPanel panelLabelPersona = new JPanel();
    panelIzq.add(panelLabelPersona);
    panelLabelPersona.setLayout(new BorderLayout(0, 0));
    
    JLabel lbPersona = new JLabel("Persona");
    lbPersona.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelPersona.add(lbPersona);
    
    JPanel panel_3 = new JPanel();
    panelLabelPersona.add(panel_3, BorderLayout.WEST);
    
    JPanel panel_1_2 = new JPanel();
    panelLabelPersona.add(panel_1_2, BorderLayout.EAST);
    
    JPanel panelLabelAsunto = new JPanel();
    panelIzq.add(panelLabelAsunto);
    panelLabelAsunto.setLayout(new BorderLayout(0, 0));
    
    JLabel labelAsunto = new JLabel("Asunto");
    labelAsunto.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelAsunto.add(labelAsunto);
    
    JPanel panel_4 = new JPanel();
    panelLabelAsunto.add(panel_4, BorderLayout.WEST);
    
    JPanel panel_1_3 = new JPanel();
    panelLabelAsunto.add(panel_1_3, BorderLayout.EAST);
    
    JPanel panelLabelDescripcion = new JPanel();
    panelIzq.add(panelLabelDescripcion);
    panelLabelDescripcion.setLayout(new BorderLayout(0, 0));
    
    JLabel label_2Descripcion = new JLabel("Descripcion");
    label_2Descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelDescripcion.add(label_2Descripcion, BorderLayout.CENTER);
    
    JPanel panel_5 = new JPanel();
    panelLabelDescripcion.add(panel_5, BorderLayout.WEST);
    
    JPanel panel_1_4 = new JPanel();
    panelLabelDescripcion.add(panel_1_4, BorderLayout.EAST);
    
    JPanel panelLabelAreaTrabajo = new JPanel();
    panelIzq.add(panelLabelAreaTrabajo);
    panelLabelAreaTrabajo.setLayout(new BorderLayout(0, 0));
    
    JLabel labelAreaTrabajo = new JLabel("\u00C1rea de Trabajo");
    labelAreaTrabajo.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelAreaTrabajo.add(labelAreaTrabajo, BorderLayout.CENTER);
    
    JPanel panel_6 = new JPanel();
    panelLabelAreaTrabajo.add(panel_6, BorderLayout.WEST);
    
    JPanel panel_1_5 = new JPanel();
    panelLabelAreaTrabajo.add(panel_1_5, BorderLayout.EAST);
    
    JPanel panelLabelSolicitud = new JPanel();
    panelIzq.add(panelLabelSolicitud);
    panelLabelSolicitud.setLayout(new BorderLayout(0, 0));
    
    JLabel lbSolicitud = new JLabel("Solicit\u00FAd");
    lbSolicitud.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelSolicitud.add(lbSolicitud, BorderLayout.CENTER);
    
    JPanel panel_7 = new JPanel();
    panelLabelSolicitud.add(panel_7, BorderLayout.WEST);
    
    JPanel panel_1_6 = new JPanel();
    panelLabelSolicitud.add(panel_1_6, BorderLayout.EAST);
    
    JPanel panelLabelDirigido = new JPanel();
    panelIzq.add(panelLabelDirigido);
    panelLabelDirigido.setLayout(new BorderLayout(0, 0));
    
    JLabel lbDrigido = new JLabel("Dirigido a...");
    lbDrigido.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelDirigido.add(lbDrigido);
    
    JPanel panel_8 = new JPanel();
    panelLabelDirigido.add(panel_8, BorderLayout.WEST);
    
    JPanel panel_1_7 = new JPanel();
    panelLabelDirigido.add(panel_1_7, BorderLayout.EAST);
    
    JPanel panelLabelGaleria = new JPanel();
    panelIzq.add(panelLabelGaleria);
    panelLabelGaleria.setLayout(new BorderLayout(0, 0));
    
    JLabel lbGaleriaFotos = new JLabel("Galer\u00EDa Fotos");
    lbGaleriaFotos.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelGaleria.add(lbGaleriaFotos);
    
    JPanel panel_9 = new JPanel();
    panelLabelGaleria.add(panel_9, BorderLayout.WEST);
    
    JPanel panel_1_8 = new JPanel();
    panelLabelGaleria.add(panel_1_8, BorderLayout.EAST);
    
    JPanel panelLabelAnexos = new JPanel();
    panelIzq.add(panelLabelAnexos);
    panelLabelAnexos.setLayout(new BorderLayout(0, 0));
    
    JLabel lbAnexos = new JLabel("Anexos");
    lbAnexos.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelAnexos.add(lbAnexos);
    
    JPanel panel_11 = new JPanel();
    panelLabelAnexos.add(panel_11, BorderLayout.WEST);
    
    JPanel panel_1_10 = new JPanel();
    panelLabelAnexos.add(panel_1_10, BorderLayout.EAST);
    
    JPanel panelLabelIncidencia = new JPanel();
    panelIzq.add(panelLabelIncidencia);
    panelLabelIncidencia.setLayout(new BorderLayout(0, 0));
    
    JLabel lbIncidencia = new JLabel("Incidencia");
    lbIncidencia.setHorizontalAlignment(SwingConstants.RIGHT);
    panelLabelIncidencia.add(lbIncidencia);
    
    
    //Panel Derecho///////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelDere = new JPanel();
    panelDere.setBorder(null);
    frame.getContentPane().add(panelDere, BorderLayout.EAST);
    panelDere.setLayout(new GridLayout(0, 1, 0, 0));
    
    JPanel panelBtnEntidad = new JPanel();
    panelDere.add(panelBtnEntidad);
    panelBtnEntidad.setLayout(new BoxLayout(panelBtnEntidad, BoxLayout.LINE_AXIS));
    
    JPanel panel_d_1_1 = new JPanel();
    panelBtnEntidad.add(panel_d_1_1);
    
    btnEntidad = new JButton("Valida Entidad");
    btnEntidad.addActionListener(accionesBotones);
    panelBtnEntidad.add(btnEntidad);
    
    JPanel panel_d_1_2 = new JPanel();
    FlowLayout fl_panel_d_1_2 = (FlowLayout) panel_d_1_2.getLayout();
    fl_panel_d_1_2.setAlignment(FlowLayout.RIGHT);
    panel_d_1_2.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelBtnEntidad.add(panel_d_1_2);
    
    JPanel panelBtnFecha = new JPanel();
    panelDere.add(panelBtnFecha);
    panelBtnFecha.setLayout(new BoxLayout(panelBtnFecha, BoxLayout.X_AXIS));
    
    JPanel panel_d_2_1 = new JPanel();
    panelBtnFecha.add(panel_d_2_1);
    
    btnFecha = new JButton("Valida Fecha");
    btnFecha.addActionListener(accionesBotones);
    panelBtnFecha.add(btnFecha);
    
    JPanel panel_d_2_2 = new JPanel();
    panel_d_2_2.setAlignmentX(0.0f);
    panelBtnFecha.add(panel_d_2_2);
    
    JPanel panelBtnPersona = new JPanel();
    panelDere.add(panelBtnPersona);
    panelBtnPersona.setLayout(new BoxLayout(panelBtnPersona, BoxLayout.X_AXIS));
    
    JPanel panel_d_3_1 = new JPanel();
    panelBtnPersona.add(panel_d_3_1);
   
    btnPersona = new JButton("Valida Persona");
    btnPersona.addActionListener(accionesBotones);
    panelBtnPersona.add(btnPersona);
    
    JPanel panel_d_3_2 = new JPanel();
    panel_d_3_2.setAlignmentX(0.0f);
    panelBtnPersona.add(panel_d_3_2);
    
    JPanel panelBtnAsunto = new JPanel();
    panelDere.add(panelBtnAsunto);
    panelBtnAsunto.setLayout(new BoxLayout(panelBtnAsunto, BoxLayout.X_AXIS));
    
    JPanel panel_d_4_1 = new JPanel();
    panel_d_4_1.setAlignmentX(0.0f);
    panelBtnAsunto.add(panel_d_4_1);
    
    btnAsunto = new JButton("Valida Asunto");
    btnAsunto.addActionListener(accionesBotones);
    panelBtnAsunto.add(btnAsunto);
    
    JPanel panel_d_4_2 = new JPanel();
    panelBtnAsunto.add(panel_d_4_2);
    
    JPanel panelBtnDescripcion = new JPanel();
    panelDere.add(panelBtnDescripcion);
    panelBtnDescripcion.setLayout(new BoxLayout(panelBtnDescripcion, BoxLayout.X_AXIS));
    
    JPanel panel_d_5_1 = new JPanel();
    panel_d_5_1.setAlignmentX(0.0f);
    panelBtnDescripcion.add(panel_d_5_1);
    
    btnDescripcion = new JButton("Valida Descripci\u00F3n");
    btnDescripcion.addActionListener(accionesBotones);
    panelBtnDescripcion.add(btnDescripcion);
    
    JPanel panel_d_5_2 = new JPanel();
    panelBtnDescripcion.add(panel_d_5_2);
    
    JPanel panelBtnAreaTrabajo = new JPanel();
    panelDere.add(panelBtnAreaTrabajo);
    panelBtnAreaTrabajo.setLayout(new BoxLayout(panelBtnAreaTrabajo, BoxLayout.X_AXIS));
    
    JPanel panel_d_6_1 = new JPanel();
    panel_d_6_1.setAlignmentX(0.0f);
    panelBtnAreaTrabajo.add(panel_d_6_1);

    btnAreaTrabajo = new JButton("Valida Area Trabajo");
    btnAreaTrabajo.addActionListener(accionesBotones);
    panelBtnAreaTrabajo.add(btnAreaTrabajo);
    
    JPanel panel_d_6_2 = new JPanel();
    panelBtnAreaTrabajo.add(panel_d_6_2);
    
    JPanel panelBtnSolicitud = new JPanel();
    panelDere.add(panelBtnSolicitud);
    panelBtnSolicitud.setLayout(new BoxLayout(panelBtnSolicitud, BoxLayout.X_AXIS));
    
    JPanel panel_d_7_1 = new JPanel();
    panel_d_7_1.setAlignmentX(0.0f);
    panelBtnSolicitud.add(panel_d_7_1);

    btnSolicitud = new JButton("Valida Solicitud");
    btnSolicitud.addActionListener(accionesBotones);
    panelBtnSolicitud.add(btnSolicitud);
    
    JPanel panel_d_7_2 = new JPanel();
    panelBtnSolicitud.add(panel_d_7_2);
    
    JPanel panelBtnDirigido = new JPanel();
    panelDere.add(panelBtnDirigido);
    panelBtnDirigido.setLayout(new BoxLayout(panelBtnDirigido, BoxLayout.X_AXIS));
    
    JPanel panel_d_8_1 = new JPanel();
    panel_d_8_1.setAlignmentX(0.0f);
    panelBtnDirigido.add(panel_d_8_1);
   
    btnDirigido = new JButton("Valida Dirigido");
    btnDirigido.addActionListener(accionesBotones);
    panelBtnDirigido.add(btnDirigido);
    
    JPanel panel_d_8_2 = new JPanel();
    panelBtnDirigido.add(panel_d_8_2);
    
    JPanel panelBtnGaleria = new JPanel();
    panelDere.add(panelBtnGaleria);
    panelBtnGaleria.setLayout(new BoxLayout(panelBtnGaleria, BoxLayout.X_AXIS));
    
    JPanel panel_d_9_1 = new JPanel();
    panel_d_9_1.setAlignmentX(0.0f);
    panelBtnGaleria.add(panel_d_9_1);
    
    btnGaleriaFotos = new JButton("Valida Galeria");
    btnGaleriaFotos.addActionListener(accionesBotones);
    panelBtnGaleria.add(btnGaleriaFotos);
    
    JPanel panel_d_9_2 = new JPanel();
    panelBtnGaleria.add(panel_d_9_2);
    
    JPanel panelBtnAnexos = new JPanel();
    panelDere.add(panelBtnAnexos);
    panelBtnAnexos.setLayout(new BoxLayout(panelBtnAnexos, BoxLayout.X_AXIS));
    
    JPanel panel_d_11_1 = new JPanel();
    panel_d_11_1.setAlignmentX(0.0f);
    panelBtnAnexos.add(panel_d_11_1);

    btnAnexos = new JButton("Valida Anexos");
    btnAnexos.addActionListener(accionesBotones);
    panelBtnAnexos.add(btnAnexos);
    
    JPanel panel_d_11_2 = new JPanel();
    panelBtnAnexos.add(panel_d_11_2);
    
    JPanel panelBtnIncidencia = new JPanel();
    panelDere.add(panelBtnIncidencia);
    panelBtnIncidencia.setLayout(new BoxLayout(panelBtnIncidencia, BoxLayout.X_AXIS));
    
    JPanel panel_d_12_1 = new JPanel();
    panel_d_12_1.setAlignmentX(0.0f);
    panelBtnIncidencia.add(panel_d_12_1);
    
    btnIncidencia = new JButton("Incidencia(Enter)");
    btnIncidencia.addActionListener(accionesBotones);
    panelBtnIncidencia.add(btnIncidencia);
    btnIncidencia.addActionListener(accionesBotones);
    
    JPanel panel_d_12_2 = new JPanel();
    panelBtnIncidencia.add(panel_d_12_2);
    
    
    //Panel Central////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelCentral = new JPanel();
    frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
    panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
    
    JPanel panelEntidad = new JPanel();
    panelEntidad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelEntidad);
    
    JLabel lbAAVV = new JLabel("AAVV");
    panelEntidad.add(lbAAVV);
    
    comboBoxAAVV = new JComboBox();
    accionesComboBox.rellenar(comboBoxAAVV);
    //Añadir lista de Asociaciones de Vecinos de toda Asturias 'ListaAAVV.txt'  //////////////////////////////////////////////////////////////////////////////////////////////////
    
    panelEntidad.add(comboBoxAAVV);
    
    JPanel panelFecha = new JPanel();
    panelFecha.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    FlowLayout flowLayout = (FlowLayout) panelFecha.getLayout();
    panelCentral.add(panelFecha);
    
    JLabel lbAnio = new JLabel("A\u00F1o");
    panelFecha.add(lbAnio);
////////////////////////////////////////////////////////////////////////////FECHA/////////////////////////////////////////////////////////
    comboBoxAnio = new JComboBox();
    accionesComboBox.rellenar(comboBoxAnio);
    comboBoxAnio.addActionListener( accionesComboBox);
    panelFecha.add(comboBoxAnio);
    
    JLabel lbMes = new JLabel("Mes");
    lbMes.setHorizontalAlignment(SwingConstants.CENTER);
    panelFecha.add(lbMes);
    
    comboBoxMes = new JComboBox();
    accionesComboBox.rellenar(comboBoxMes);
    comboBoxMes.addActionListener(accionesComboBox);
    panelFecha.add(comboBoxMes);
    
    JLabel lbDia = new JLabel("D\u00EDa");
    panelFecha.add(lbDia);
    
    comboBoxDia = new JComboBox();
    accionesComboBox.rellenar(comboBoxDia);
    //comboBoxDia.addActionListener(accionesComboBox);
    panelFecha.add(comboBoxDia);
    
    JLabel lbHora = new JLabel("Hora");
    panelFecha.add(lbHora);
    
    comboBoxHora = new JComboBox();
    accionesComboBox.rellenar(comboBoxHora);
    panelFecha.add(comboBoxHora);
////////////////////////////////////////////////////////////////////////////////Fecha//////////////////////////////////////////////////////////    
    JPanel panelPersona = new JPanel();
    panelPersona.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelPersona);
    panelPersona.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    JLabel lbNombre = new JLabel("Nombre");
    lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(lbNombre);
    
    textFieldNombre = new JTextField();
    textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(textFieldNombre);
    textFieldNombre.setColumns(10);
    //Mofificamos el color del boton btnPersona, al modificar el texto
    accionesText.textoListenerBoton(textFieldNombre, btnPersona);
    
    
    JLabel lbApellido1 = new JLabel("1\u00BAApellido");
    lbApellido1.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(lbApellido1);
    
    textFieldApellido1 = new JTextField();
    textFieldApellido1.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(textFieldApellido1);
    textFieldApellido1.setColumns(10);
    //Mofificamos el color del boton btnPersona, al modificar el texto
    accionesText.textoListenerBoton(textFieldApellido1, btnPersona);
    
    
    JLabel lbApellido2 = new JLabel("2\u00BAApellido");
    panelPersona.add(lbApellido2);
    
    textFieldApellido2 = new JTextField();    
    panelPersona.add(textFieldApellido2);
    textFieldApellido2.setColumns(10);
    //Mofificamos el color del boton btnPersona, al modificar el texto
    accionesText.textoListenerBoton(textFieldApellido2, btnPersona);
    
    JLabel lbNIF = new JLabel("NIF/NIe");
    lbNIF.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(lbNIF);
    
    textFieldNIF = new JTextField();
    textFieldNIF.setHorizontalAlignment(SwingConstants.CENTER);
    panelPersona.add(textFieldNIF);
    textFieldNIF.setColumns(10);
    //Mofificamos el color del boton btnPersona, al modificar el texto
    accionesText.textoListenerBoton(textFieldNIF, btnPersona);
    
    JPanel panelAsunto = new JPanel();
    panelAsunto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelAsunto);
    
    JLabel lbAsunto = new JLabel("Titulo");
    panelAsunto.add(lbAsunto);
    
    textFieldTitulo = new JTextField();
    panelAsunto.add(textFieldTitulo);
    textFieldTitulo.setColumns(20);
    //Mofificamos el color del boton btnAsunto, al modificar el texto 
    accionesText.textoListenerBoton(textFieldTitulo, btnAsunto);
    
    JPanel panelDescipcion = new JPanel();
    panelDescipcion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelDescipcion);
    panelDescipcion.setLayout(new BorderLayout(0, 0));
    
    textAreaDescrip = new JTextArea();
    textAreaDescrip.setRows(2);
    textAreaDescrip.setColumns(90);
    panelDescipcion.add(textAreaDescrip, BorderLayout.CENTER);
    //Mofificamos el color del boton btnDescripcion, al modificar el texto 
    accionesText.textoListenerBoton(textAreaDescrip, btnDescripcion);
    
    JPanel panelbtnExpandirDesc = new JPanel();
    panelDescipcion.add(panelbtnExpandirDesc, BorderLayout.EAST);
    
    btnExpandirDesc = new JButton("Expandir");
    panelbtnExpandirDesc.add(btnExpandirDesc);
    btnExpandirDesc.addActionListener(accionesBotones);
    
    JPanel panelAreaTrabajo = new JPanel();
    panelAreaTrabajo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelAreaTrabajo);
    
    comboBoxAreaTrabajo = new JComboBox();
    accionesComboBox.rellenar(comboBoxAreaTrabajo);
    panelAreaTrabajo.add(comboBoxAreaTrabajo);
    //Añadir lista de Asociaciones de Vecinos de toda Asturias 'ListaAreaTrabajo.txt'
    
    JPanel panelSolicitud = new JPanel();
    panelSolicitud.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelSolicitud);
    panelSolicitud.setLayout(new BorderLayout(0, 0));
    
    textAreaSolicitud = new JTextArea();
    textAreaSolicitud.setRows(2);
    textAreaSolicitud.setColumns(90);
    panelSolicitud.add(textAreaSolicitud);
    //Mofificamos el color del boton btnDescripcion, al modificar el texto 
    accionesText.textoListenerBoton(textAreaSolicitud, btnSolicitud);
    
    
    JPanel panelExpandirSolicitud = new JPanel();
    panelSolicitud.add(panelExpandirSolicitud, BorderLayout.EAST);
    
    btnExpandirSolicitud = new JButton("Expandir");
    panelExpandirSolicitud.add(btnExpandirSolicitud);
    btnExpandirSolicitud.addActionListener(accionesBotones);
    
    JPanel panelDrigido = new JPanel();
    panelDrigido.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelDrigido);
    
    comboBoxDirigido = new JComboBox();
    accionesComboBox.rellenar(comboBoxDirigido);
    panelDrigido.add(comboBoxDirigido);
    //Añadir lista de Asociaciones de Vecinos de toda Asturias 'ListaDirigido.txt'
    
    //Galeria//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelGaleria = new JPanel();
    panelGaleria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelGaleria.setLayout(new GridLayout(2, 2, 0, 0));
           
    JPanel panelGaleria1 = new JPanel();    
    
    textFieldGaleria_1 = new JTextField();
    textFieldGaleria_1.setEditable(false);
    textFieldGaleria_1.setColumns(15);
    panelGaleria1.add(textFieldGaleria_1);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGaleria_1, btnGaleriaFotos);
    
    btnAgregaGaleria_1 = new JButton("Agregar");
    panelGaleria1.add(btnAgregaGaleria_1);
    btnAgregaGaleria_1.addActionListener(accionesBotones);
    
    btnEliminaGaleria_1 = new JButton("Elimina");
    panelGaleria1.add(btnEliminaGaleria_1);
    btnEliminaGaleria_1.addActionListener(accionesBotones);
    
    JLabel lbGeoXY_1 = new JLabel("X,Y");
    panelGaleria1.add(lbGeoXY_1);
    
    textFieldGeo_1 = new JTextField();
    textFieldGeo_1.setColumns(8);
    panelGaleria1.add(textFieldGeo_1);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGeo_1, btnGaleriaFotos);
    
    panelGaleria.add(panelGaleria1);
    
    
    JPanel panelGaleria2 = new JPanel();    
    
    textFieldGaleria_2 = new JTextField();
    textFieldGaleria_2.setEditable(false);
    textFieldGaleria_2.setColumns(15);
    panelGaleria2.add(textFieldGaleria_2);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGaleria_2, btnGaleriaFotos);
    
    btnAgregaGaleria_2 = new JButton("Agregar");
    panelGaleria2.add(btnAgregaGaleria_2);
    btnAgregaGaleria_2.addActionListener(accionesBotones);
    
    btnEliminaGaleria_2 = new JButton("Elimina");
    panelGaleria2.add(btnEliminaGaleria_2);
    btnEliminaGaleria_2.addActionListener(accionesBotones);
    
    JLabel lbGeoXY_2 = new JLabel("X,Y");
    panelGaleria2.add(lbGeoXY_2);
    
    textFieldGeo_2 = new JTextField();
    textFieldGeo_2.setColumns(8);
    panelGaleria2.add(textFieldGeo_2);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGeo_2, btnGaleriaFotos);
   
    panelGaleria.add(panelGaleria2);
        
    JPanel panelGaleria3 = new JPanel();    
    
    textFieldGaleria_3 = new JTextField();
    textFieldGaleria_3.setEditable(false);
    textFieldGaleria_3.setColumns(15);
    panelGaleria3.add(textFieldGaleria_3);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGaleria_3, btnGaleriaFotos);
   
    
    btnAgregaGaleria_3 = new JButton("Agregar");
    panelGaleria3.add(btnAgregaGaleria_3);
    btnAgregaGaleria_3.addActionListener(accionesBotones);
    
    btnEliminaGaleria_3 = new JButton("Elimina");
    panelGaleria3.add(btnEliminaGaleria_3);
    btnEliminaGaleria_3.addActionListener(accionesBotones);
    
    JLabel lbGeoXY_3 = new JLabel("X,Y");
    panelGaleria3.add(lbGeoXY_3);
    
    textFieldGeo_3 = new JTextField();
    textFieldGeo_3.setColumns(8);
    panelGaleria3.add(textFieldGeo_3);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGeo_3, btnGaleriaFotos);
   
    panelGaleria.add(panelGaleria3);
    
    
    JPanel panelGaleria4 = new JPanel();
    
    textFieldGaleria_4 = new JTextField();
    textFieldGaleria_4.setEditable(false);
    textFieldGaleria_4.setColumns(15);
    panelGaleria4.add(textFieldGaleria_4);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto 
    accionesText.textoListenerBoton(textFieldGaleria_4, btnGaleriaFotos);
    
    btnAgregaGaleria_4 = new JButton("Agregar");
    panelGaleria4.add(btnAgregaGaleria_4);
    btnAgregaGaleria_4.addActionListener(accionesBotones);
    
    btnEliminaGaleria_4 = new JButton("Elimina");
    panelGaleria4.add(btnEliminaGaleria_4);
    btnEliminaGaleria_4.addActionListener(accionesBotones);
    
    JLabel lbGeoXY_4 = new JLabel("X,Y");
    panelGaleria4.add(lbGeoXY_4);
    
    textFieldGeo_4 = new JTextField();
    textFieldGeo_4.setColumns(8);
    panelGaleria4.add(textFieldGeo_4);
    //Mofificamos el color del boton btnGaleriaFotos, al modificar el texto
    accionesText.textoListenerBoton(textFieldGeo_4, btnGaleriaFotos);
    panelGaleria.add(panelGaleria4);    
        
    panelCentral.add(panelGaleria);
   


    
    //Anexos///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    JPanel panelAnexos = new JPanel();
    panelAnexos.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelAnexos);
    panelAnexos.setLayout(new GridLayout(2, 1, 0, 0));
    
    JPanel panelAnexo1 = new JPanel();
    panelAnexos.add(panelAnexo1);
    panelAnexo1.setLayout(new BorderLayout(0, 0));
    
    JLabel lbAnexo1 = new JLabel("Anexo1: ");
    lbAnexo1.setHorizontalAlignment(SwingConstants.CENTER);
    panelAnexo1.add(lbAnexo1, BorderLayout.WEST);
    
    textFieldAnexo1 = new JTextField();
    textFieldAnexo1.setColumns(140);
    panelAnexo1.add(textFieldAnexo1, BorderLayout.CENTER);
    accionesText.textoListenerBoton(textFieldAnexo1, btnAnexos);
    
    JPanel panelAnexo2 = new JPanel();
    panelAnexos.add(panelAnexo2);
    panelAnexo2.setLayout(new BorderLayout(0, 0));
    
    JLabel lbAnexo2 = new JLabel("Anexo 2:");
    panelAnexo2.add(lbAnexo2, BorderLayout.WEST);
    
    textFieldAnexo2 = new JTextField();
    textFieldAnexo2.setColumns(140);
    panelAnexo2.add(textFieldAnexo2);
    accionesText.textoListenerBoton(textFieldAnexo2, btnAnexos);
    
    JPanel panelIncidencia = new JPanel();
    panelIncidencia.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    panelCentral.add(panelIncidencia);
    panelIncidencia.setLayout(new BorderLayout(0, 0));
    
    textFieldIncidencia = new JTextField();
    textFieldIncidencia.setHorizontalAlignment(SwingConstants.CENTER);
    textFieldIncidencia.setEditable(false);
    panelIncidencia.add(textFieldIncidencia, BorderLayout.CENTER);
    textFieldIncidencia.setColumns(90);
    
    //Añadimos las teclas de atajo
    
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {
        // TODO Auto-generated method stub
        //Si tiene el foco de la ventana se cerrara 
        if(frame.isFocused()) {
          
          if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            
            btnSalir.doClick();
          }
          if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            btnIncidencia.doClick();
          }  
        
        }
        return false;
      }
      
    });
    cambiarFuente("Verdana",11);
    
  }
  


  
  //Metodos para getters el JButton
  public JButton getBtnSalir() {
    return btnSalir;
  }
  /*
  public JButton getBtnAgregaAnexo2() {
    return btnAgregaAnexo2;
  }
  */
  /*
  public JButton getBtnEliminarAnexo2() {
    return btnEliminarAnexo2;
  }
  */

  public JButton getBtnAceptar() {
    return btnAceptar;
  }

  public JButton getBtnEntidad() {
    return btnEntidad;
  }

  public JButton getBtnFecha() {
    return btnFecha;
  }

  public JButton getBtnPersona() {
    return btnPersona;
  }

  public JButton getBtnAsunto() {
    return btnAsunto;
  }

  public JButton getBtnDescripcion() {
    return btnDescripcion;
  }

  public JButton getBtnAreaTrabajo() {
    return btnAreaTrabajo;
  }

  public JButton getBtnAgregaGaleria_1() {
    return btnAgregaGaleria_1;
  }
  
  public JButton getBtnAgregaGaleria_2() {
    return btnAgregaGaleria_2;
  }
  
  public JButton getBtnAgregaGaleria_3() {
    return btnAgregaGaleria_3;
  }
  
  public JButton getBtnAgregaGaleria_4() {
    return btnAgregaGaleria_4;
  }

  public JButton getBtnEliminaGaleria_1() {
    return btnEliminaGaleria_1;
  }

  public JButton getBtnEliminaGaleria_2() {
    return btnEliminaGaleria_2;
  }

  public JButton getBtnEliminaGaleria_3() {
    return btnEliminaGaleria_3;
  }
 
  public JButton getBtnEliminaGaleria_4() {
    return btnEliminaGaleria_4;
  }

  public JButton getBtnSolicitud() {
    return btnSolicitud;
  }

  public JButton getBtnDirigido() {
    return btnDirigido;
  }

  public JButton getBtnGaleriaFotos() {
    return btnGaleriaFotos;
  }

  public JButton getBtnAnexos() {
    return btnAnexos;
  }

  public JButton getBtnIncidencia() {
    return btnIncidencia;
  }

  public JButton getBtnExpandirDesc() {
    return btnExpandirDesc;
  }

  public JButton getBtnExpandirSolicitud() {
    return btnExpandirSolicitud;
  }

  /*
  public JButton getBtnAgregaAnexo1() {
    return btnAgregaAnexo1;
  }
  */
  /*
  public JButton getBtnEliminarAnexo1() {
    return btnEliminarAnexo1;
  }
  */
  
  public JButton getBtnPDF() {
    return btnPDF;
  }
  
  public JButton getBtnListar() {
    return btnListar;
  }
  
  
  //Getters de TextField y TextFieldArea
  public JTextField getTextFieldNombre() {
    return textFieldNombre;
  }

  public void setTextFieldNombre(JTextField textFieldNombre) {
    this.textFieldNombre = textFieldNombre;
  }

  public JTextField getTextFieldApellido1() {
    return textFieldApellido1;
  }
  
  public JTextField getTextFieldApellido2() {
    return textFieldApellido2;
  }

  public JTextField getTextFieldNIF() {
    return textFieldNIF;
  }

  public JTextField getTextFieldTitulo() {
    return textFieldTitulo;
  }

  public JTextField getTextFieldAnexo1() {
    return textFieldAnexo1;
  }
  
  public JTextField getTextFieldAnexo2() {
    return textFieldAnexo2;
  }
  
  public JTextField getTextFieldGaleria_1() {
    return textFieldGaleria_1;
  }
  
  
  public JTextField getTextFieldGaleria_2() {
    return textFieldGaleria_2;
  }

  public JTextField getTextFieldGeo_2() {
    return textFieldGeo_2;
  }

  public JTextField getTextFieldGaleria_3() {
    return textFieldGaleria_3;
  }

  public JTextField getTextFieldGeo_3() {
    return textFieldGeo_3;
  }

  public JTextField getTextFieldGaleria_4() {
    return textFieldGaleria_4;
  }


  
  //Setter TextFieldGaleria.........................................
  
  
  public JTextField getTextFieldGeo_4() {
    return textFieldGeo_4;
  }  

  public void setTextFieldGaleria_1(String text) {
    textFieldGaleria_1.setText(text);
  }

  public void setTextFieldGaleria_2(String text) {
    textFieldGaleria_2.setText(text);
  }

  public void setTextFieldGaleria_3(String text) {
    textFieldGaleria_3.setText(text);
  }

  public void setTextFieldGaleria_4(String text) {
    textFieldGaleria_4.setText(text);
  }
  
  public void setTextFieldAnexos1(String text) {
    textFieldAnexo1.setText(text);
  }
  
  public void setTextFieldAnexos2(String text) {
    textFieldAnexo2.setText(text);
  }
  
  public void setTextFieldIncidencia(String text) {
    textFieldIncidencia.setText(text);
  }

  public JTextField getTextFieldGeo_1() {
    return textFieldGeo_1;
  }

  public JTextField getTextFieldIncidencia() {
    return textFieldIncidencia;
  }

  public JTextArea getTextAreaSolicitud() {
    return textAreaSolicitud;
  }

  public JTextArea getTextAreaDescrip() {
    return textAreaDescrip;
  }
  
//Getters de ComboBox
  
  public JComboBox getcomboBoxAAVV() {
    return comboBoxAAVV;
  }
  
  public JComboBox getcomboBoxAnio() {
    return comboBoxAnio;
  }
  
  public JComboBox getcomboBoxMes() {
    return comboBoxMes;
  }
  
  public JComboBox getcomboBoxDia() {
    return comboBoxDia;
  }
  
  //Metodo Set y Getter de nuestro Gif
  public ImageIcon getIconGIF() {
    return iconGIF;
  }

  private void setIconGIF(String str) {
    this.iconGIF=new ImageIcon(str);
    this.iconGIF = iconGIF;
  }
  
  public void setIconGIFGIF() {
    
    setIconGIF(IconGif());
  }
  
  public void setIconGIFPNG() {
    
    setIconGIF(IconPng());
  }
  
  
  private String IconPng() {
    //return str_IconGif;
    return str_IconPng;
  }
  
  private String IconGif() {
    return str_IconGif;
  }
  

  
  //Ponemos los dias del mes en funcion de los días maximos para un mes
  public void setcomboBoxDia(int maxDias) {
    comboBoxDia.removeAllItems();
    for (int dia = 1; dia <= maxDias; dia++) {
      comboBoxDia.addItem(String.valueOf(dia));
    }
  }
  
  public JComboBox getcomboBoxHora() {
    return comboBoxHora;
  }
  
  public JComboBox getcomboBoxAreaTrabajo() {
    return comboBoxAreaTrabajo;
  }
  
  public JComboBox getcomboBoxDirigido() {
    return comboBoxDirigido;
  }
  
  public JFrame getFrame() {
    return frame;
  }

  
  //Hacer visible la ventana
  public void inicio() {
    frame.setVisible(true);
  }
  
  public void cerrarVentana() {
    frame.dispose();
  }
  
  private void colocarEnEsquina() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int anchoPantalla = (int) screenSize.getWidth();
    int altoPantalla= (int) screenSize.getHeight();

    int anchoMargen = anchoPantalla / 5;
    int altoMargen = altoPantalla / 5;

    int x = anchoMargen;
    int y = altoMargen;
    int width = anchoPantalla - ( anchoMargen);
    int height = altoPantalla - ( altoMargen);

    frame.setBounds(0, 0, width, height);
  }
  
  public void si_envia_Acta() {
    btnAceptar.setEnabled(true);
    
  }
  
  public void si_envia_Pdf() {
    btnPDF.setEnabled(true);
  }
  
  public void no_Envia_Pdf() {
    btnAceptar.setEnabled(false);
    btnPDF.setEnabled(false);
  }
  
  public void setlb_Inf_Inf_Ayuda(String str) {
    lb_Inf_Inf_Ayuda.setText(str);
    
  }
  
  public JLabel getlb_Inf_Inf_Ayuda() {
    return lb_Inf_Inf_Ayuda;
  }


  
  private void asignarListener() {
    //Botones
    btnAceptar.addActionListener(accionesBotones);
    btnSalir.addActionListener(accionesBotones);
   
    btnEntidad.addActionListener(accionesBotones);
    btnFecha.addActionListener(accionesBotones);
    btnPersona.addActionListener(accionesBotones);
    btnAsunto.addActionListener(accionesBotones);
    btnDescripcion.addActionListener(accionesBotones);
    btnAreaTrabajo.addActionListener(accionesBotones);
    btnAgregaGaleria_1.addActionListener(accionesBotones);
    btnAgregaGaleria_2.addActionListener(accionesBotones);
    btnAgregaGaleria_3.addActionListener(accionesBotones);
    btnAgregaGaleria_4.addActionListener(accionesBotones);
    btnEliminaGaleria_1.addActionListener(accionesBotones);
    btnEliminaGaleria_2.addActionListener(accionesBotones);
    btnEliminaGaleria_3.addActionListener(accionesBotones);
    btnEliminaGaleria_4.addActionListener(accionesBotones);
    btnSolicitud.addActionListener(accionesBotones);
    btnDirigido.addActionListener(accionesBotones);
    btnGaleriaFotos.addActionListener(accionesBotones);    
    btnAnexos.addActionListener(accionesBotones);
    btnIncidencia.addActionListener(accionesBotones);
    btnExpandirDesc.addActionListener(accionesBotones);
    btnExpandirSolicitud.addActionListener(accionesBotones);
    //btnAgregaAnexo1.addActionListener(accionesBotones);
    //btnEliminarAnexo1.addActionListener(accionesBotones);
    //btnAgregaAnexo2.addActionListener(accionesBotones);
    //btnEliminarAnexo2.addActionListener(accionesBotones);
    btnPDF.addActionListener(accionesBotones);
    btnListar.addActionListener(accionesBotones);
    
    
  }
  
  
  
  
  private void cambiarFuente(String nombreFuente, int tamano) {
    //Fuentes disponibles en el equipo
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    // Obtener las fuentes disponibles
    String fuentefinal="";
    String[] fuentesDisponibles = ge.getAvailableFontFamilyNames();
      

    // Imprimir las fuentes disponibles
    System.out.println("Fuentes disponibles en el equipo:");
    for (String fuente : fuentesDisponibles) {
      if(fuente.equalsIgnoreCase(nombreFuente)) {
        fuentefinal=fuente;
        Font nuevaFuente =new Font(fuentefinal,Font.PLAIN,tamano);
        frame.setFont(nuevaFuente);
        System.out.println(fuentefinal);
        
        // Obtener todos los componentes del frame
        Component[] componentes = frame.getContentPane().getComponents();

          
        // Iterar sobre los componentes y establecer la nueva fuente
        for (Component componente : componentes) {
          if (componente instanceof JComponent) {
            ((JComponent) componente).setFont(nuevaFuente);
          }
          setFuenteRecursiva(componente, nuevaFuente);
        }

        // También puedes establecer la nueva fuente para el propio frame
        frame.setFont(nuevaFuente);
        
        SwingUtilities.updateComponentTreeUI(frame);
        }
          
      }
   
  }
  
  
  //Metodo de manera recursiva para cambiar la fuente de nuestra ventana
  private void setFuenteRecursiva(Component componente, Font nuevaFuente) {
    if (componente instanceof JComponent) {      
      ((JComponent) componente).setFont(nuevaFuente);
    }
    
    ///Aqui modificamos el tamano de algunos elementos
    if (componente instanceof JButton) {
      JButton boton = (JButton) componente;
      ///Aqui modificamos el tamano de algunos elementos(GALERIA), para hacerlos mas pequeños
      if ("Agregar".equals(boton.getText()) || "Elimina".equals(boton.getText())) {
        // Ajustar la fuente solo para los botones específicos
        Font fuenteBoton = new Font(nuevaFuente.getFontName(), nuevaFuente.getStyle(), nuevaFuente.getSize() - 2);
        boton.setFont(fuenteBoton);
      }
    }
  
    if (componente instanceof JTextField) {
      JTextField textField = (JTextField) componente;
      ///Aqui modificamos el tamano de algunos elementos(GALERIA), para hacerlos mas pequeños
      if (textField.getName() != null && textField.getName().startsWith("textFieldGaleria")) {
        // Ajustar la fuente solo para los JTextField específicos
        Font fuenteTexto = new Font(nuevaFuente.getFontName(), nuevaFuente.getStyle(), nuevaFuente.getSize() - 2);
        textField.setFont(fuenteTexto);
      }
    }
  
    if (componente instanceof JLabel) {
      JLabel etiqueta = (JLabel) componente;
    ///Aqui modificamos el tamano de algunos elementos(GALERIA), para hacerlos mas pequeños
      if ("X,Y".equals(etiqueta.getText())) {
        // Ajustar la fuente solo para las etiquetas específicas
        Font fuenteEtiqueta = new Font(nuevaFuente.getFontName(), Font.BOLD, nuevaFuente.getSize() - 2);
        etiqueta.setFont(fuenteEtiqueta);
      }
    }


    if (componente instanceof Container) {
      Component[] componentesInternos = ((Container) componente).getComponents();
      for (Component componenteInterno : componentesInternos) {
        setFuenteRecursiva(componenteInterno, nuevaFuente);
      }
    }
  }


}
