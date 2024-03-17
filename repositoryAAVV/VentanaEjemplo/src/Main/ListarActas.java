package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class ListarActas {
  
  //creamos la variable que crea en una misma linea con el JTextField y un JButton
  private ArrayList<ItemPdf> listaItem;
  private ItemPdf miItem;
  
  private String str_carpeta1,str_carpeta2,str_pdf;
  private String str_path[]= {str_carpeta1,str_carpeta2,str_pdf};
  
  public ListarActas() {
    listaItem=new ArrayList<>();
    str_carpeta1="";
    str_carpeta2="";
    str_pdf="";
    /*
    str_path[0]=str_carpeta1;
    str_path[1]=str_carpeta2;
    str_path [2]=str_pdf;
    */
    buscarPdf();
    abrirVentana();
    
  }
  
  
  //Ventana que abre los ficheros PDF de nuesta lista
  private void abrirVentana() {
    JFrame miframe=new JFrame("Lista de Actas");
    
    JPanel mipanelContenido=new JPanel();
    mipanelContenido.setLayout(new BoxLayout(mipanelContenido, BoxLayout.Y_AXIS));
    
    // Agregar cada línea con JLabel y JButton al JPanel
    for(ItemPdf miItem:listaItem) {
      JLabel milabel=new JLabel("Acta: "+miItem.getMilabel().getText().toString());
      JButton miboton=new JButton("Abrir");
      miboton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          abrirPDF(miItem.getMifile().getAbsolutePath());
          miframe.dispose();
        }
      });
      
      JPanel panelLinea=new JPanel();
     
      panelLinea.add(milabel);
      panelLinea.add(miboton);
      mipanelContenido.add(panelLinea, BorderLayout.NORTH);
    }   
      
    //Creamos el Scroll probar si tenemos suficientes pdf´s
    JScrollPane miScroll=new JScrollPane(mipanelContenido);
    
    miframe.add(miScroll, BorderLayout.CENTER);
    
    
    //Botont de cancelar y salir de esa ventana
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            miframe.dispose(); 
        }
    });
    
    mipanelContenido.add(btnCancelar,BorderLayout.SOUTH);
    
    miframe.setSize(500, 400);
    //miframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Hacer visible la ventana
    miframe.setVisible(true);
    
  
    
  
  }
  
  //Método donde abrirmos el PDF
  private void abrirPDF(String filePath) {
    // Abrir el archivo PDF con el visor de PDF predeterminado
    try {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "start", "\"\"", filePath);
        processBuilder.start();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
  }
  
  
  //Metodo donde buscamos un archivo PDF con dos carpetas de 6 digitos y otro de 3
  private void buscarPdf () {
   // ItemPdf miItem;
    
    String rutaActual=System.getProperty("user.dir");
    System.out.println(rutaActual);
    File fileInicial=new File(rutaActual);
    
    File listaFile[]=fileInicial.listFiles();
        
    for(File f1:listaFile) {
      
      if(f1.isDirectory()&&f1.getName().matches("\\d{6}")) {
        //System.out.println("Es un directorio1: "+f1.getName());
        
        File listaCarpeta1[]=f1.listFiles();
        
        for(File f2:listaCarpeta1) {
          
          if(f2.isDirectory()&&f2.getName().matches("\\d{3}")) {
            //System.out.println("Es un directorio2: "+f2.getName());
            File listaCarpeta2[]=f2.listFiles();
            
            for(File pdf:listaCarpeta2) {
              //String str_file=
              
              if(pdf.getName().contains(".pdf")) {
                System.out.println("Es un PDF: "+pdf.getName()+" Con la clave: "+f1.getName()+"/"+f2.getName());
                miItem=new ItemPdf(""+pdf.getAbsolutePath(),f1.getName()+"/"+f2.getName());
                listaItem.add(miItem);
              }
            }
            
          }       
        
      }
    }
    
    
    }
    
    
    
    
    
  }

}
