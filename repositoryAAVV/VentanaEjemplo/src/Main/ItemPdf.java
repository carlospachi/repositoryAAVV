package Main;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ItemPdf {
  
  private File mifile;
  private JLabel milabel;
  private JButton miboton;  
  
  public ItemPdf(String str_file, String str_label) {
    mifile=new File(str_file);
    milabel=new JLabel(str_label);
    miboton=new JButton("Abrir");
    
  }

  public File getMifile() {
    return mifile;
  }

  public JLabel getMilabel() {
    return milabel;
  }

  public JButton getMiboton() {
    return miboton;
  }
 
}
