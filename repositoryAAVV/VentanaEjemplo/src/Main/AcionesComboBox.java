package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class AcionesComboBox implements ActionListener {
  
  private VentanaBuilder ventanaBuilder;
  private JComboBox micombo;
  private int maxDias;
  
  public AcionesComboBox(VentanaBuilder ventanaBuilder) {
    this.ventanaBuilder=ventanaBuilder;
  }
  
  public void rellenar(JComboBox micombo) {
    this.micombo=micombo;
    //Si es AAVV
    if(micombo==ventanaBuilder.getcomboBoxAAVV()) {      
      rellenarAAVV();
    //Si es AreaTrabajo  
    }else if(micombo==ventanaBuilder.getcomboBoxAreaTrabajo()) {
      rellenarAreaTrabajo();
    //Si es Dirigido a..  
    }else if(micombo==ventanaBuilder.getcomboBoxDirigido()) {
      rellenarDirigido();
    //Si es el Año  
    }else if(micombo==ventanaBuilder.getcomboBoxAnio()) {
      rellenarAnio();
    //Si es el Mes  
    }else if(micombo==ventanaBuilder.getcomboBoxMes()) {
      rellenarMes();
    //Si es el Día
    }else if(micombo==ventanaBuilder.getcomboBoxHora()) {
      rellenarHora();
    }else if(micombo==ventanaBuilder.getcomboBoxDia()) {
      rellenarDia();
    }
  }
  
  //Ponemos a la escucha el mes y el año para saber los dias del mes y lo añadimos al comboBoxDia
  public void actionPerformed(ActionEvent e) {
    micombo = (JComboBox) e.getSource();

    if (micombo == ventanaBuilder.getcomboBoxMes() ) {
      maxDias=obtenerCantidadDiasEnMes();
      ventanaBuilder.setcomboBoxDia(maxDias);

    }else if (micombo == ventanaBuilder.getcomboBoxAnio()) {
      maxDias=obtenerCantidadDiasEnMes();
      ventanaBuilder.setcomboBoxDia(maxDias);

    }
  }
  
  //Método para añadir elementos del dia
  private void rellenarDia() {
    int max=obtenerCantidadDiasEnMes();
    for(int i=1;i<=max;i++) {
      micombo.addItem(i);
    }
    
    //Cambiar de color el boton al cambiar la opción
    JButton miboton=ventanaBuilder.getBtnFecha();
    comboListenerButton(micombo, miboton);
    
  }
  
  //Método para añadir elementos Hora
  private void rellenarHora() {
    micombo.removeAllItems();
    String str;
    for(int i=1;i<=24;i++) {
      
      if(i<10) {
        str="0"+i;
      }else {
        str=""+i;
      }
      
      micombo.addItem(str+"H");    
    }
    // Obtener la hora actual y seleccionarla por defecto
    LocalTime horaActual = LocalTime.now();
    int horaActualInt = horaActual.getHour();
    if(horaActualInt<10) {
      str="0"+horaActualInt;
    }else {
      str=""+horaActualInt;
    }
    micombo.setSelectedItem(str + "H");
    
    //Cambiar de color el boton al cambiar la opción
    JButton miboton=ventanaBuilder.getBtnFecha();
    comboListenerButton(micombo, miboton);
  }
  
  //Metodo para saber los maximos dias que tiene un mes y año determinado
  private int obtenerCantidadDiasEnMes() {
    int anio = Integer.parseInt(ventanaBuilder.getcomboBoxAnio().getSelectedItem().toString());
    
    String mes =  ventanaBuilder.getcomboBoxMes().getSelectedItem().toString();
    Calendar calendar = new GregorianCalendar(anio, obtenerIndiceMes(mes), 1);
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  }
  
  //Método para obtener la cifra del mes Enero=1....Diciembre=12
  private int obtenerIndiceMes(String nombreMes) {
    String[] meses = new DateFormatSymbols().getMonths();
    for (int i = 0; i < meses.length; i++) {
      if (meses[i].equalsIgnoreCase(nombreMes)) {
        return i;
      }
    }
    return -1; // En caso de no encontrar el mes
  }
  
  //Método para añadir elementos Mes
  private void rellenarMes() {
    
    micombo.removeAllItems();

    // Array con los nombres de los meses
    String[] meses = new DateFormatSymbols().getMonths();

    // Agregar los nombres de los meses al JComboBox
    for (String mes : meses) {
      micombo.addItem(mes);
    }

    // Obtener el mes actual y seleccionarlo por defecto
    int mesActual = Calendar.getInstance().get(Calendar.MONTH);
    micombo.setSelectedItem(meses[mesActual]);
    
    //Cambiar de color el boton al cambiar la opción
    JButton miboton=ventanaBuilder.getBtnFecha();
    comboListenerButton(micombo, miboton);
    
  }
  
  //Método para añadir elementos Año
  private void rellenarAnio() {
    micombo.removeAllItems();
    //Rellenar el año actual el siguiente y el anterior
    int anioActual=Calendar.getInstance().get(Calendar.YEAR);
    for(int i=-1;i<2;i++) {
      
      micombo.addItem(String.valueOf(anioActual + i));
    }
    micombo.setSelectedItem(String.valueOf(anioActual));
    
    //Cambiar de color el boton al cambiar la opción
    JButton miboton=ventanaBuilder.getBtnFecha();
    comboListenerButton(micombo, miboton);
  }
  
  //Método para añador elementos a Dirigido a...
  private void rellenarDirigido() {
    micombo.removeAllItems();
    micombo.addItem(" ");
    
    ArrayList<String> arrayDirigido=leerArchivo("ListaDirigido.txt",StandardCharsets.UTF_8);
    for(String s:arrayDirigido) {
      micombo.addItem(s);
    }
    //Cambiar de color el boton al cambiar la opción
    JButton miboton=ventanaBuilder.getBtnDirigido();
    comboListenerButton(micombo, miboton);
  }
  
  //Método para añadir elementos al Area de Trabajo
  private void rellenarAreaTrabajo() {
    micombo.removeAllItems();
    micombo.addItem(" ");
    
    ArrayList<String> arrayArea=leerArchivo("ListaAreaTrabajo.txt",StandardCharsets.UTF_8);
    for(String s:arrayArea) {
      micombo.addItem(s);
    }
    
    // Cambiar de color el boton al cambiar la opción 
    JButton miboton=ventanaBuilder.getBtnAreaTrabajo();
    comboListenerButton(micombo,miboton);
  }
  
  //Metodo para añadir elementos a entidad
  private void rellenarAAVV() {
    micombo.removeAllItems();
    micombo.addItem(" ");
    
    ArrayList<String> arrayAAVV=leerArchivo("ListaAAVV.txt",StandardCharsets.UTF_8);
    for(String s: arrayAAVV) {
      micombo.addItem(s);
    }
    
    // Cambiar de color el boton al cambiar la opción     
    JButton miboton=ventanaBuilder.getBtnEntidad();
    comboListenerButton(micombo,miboton);
    
  }
  
  //Agregar al Comobox un ItemListener, para mofificar el boton cuando cambia y validar
  private void comboListenerButton(JComboBox micombo, JButton miboton) {
    this.micombo=micombo;
    
    micombo.addItemListener(new ItemListener() {      
      @Override
      public void itemStateChanged(ItemEvent e) {
        
        // Verificar si el evento es de selección (ItemEvent.SELECTED)
        if (e.getStateChange() == ItemEvent.SELECTED) {
          miboton.setBackground(Color.RED);
          //ventanaBuilder.getBtnAceptar().setEnabled(false);
          ventanaBuilder.no_Envia_Pdf();
        }
        
      }
    });
    
  }
  
  
  //Leer archivo linea a linea añadimos codificacion UTF8 para solucionar las tildes 'StandardCharsets.UTF_8'
  private ArrayList<String> leerArchivo(String nomArchivo,java.nio.charset.Charset codificacion){
    ArrayList<String> str_array=new ArrayList<String>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(nomArchivo, codificacion))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        str_array.add(linea);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    
    return str_array;
  }
  
  

}
