import javax.swing.*;

//A class that extends JFrame to hold everything. Nothing special here
public class DrumApp extends JFrame {
  
  private DrumApp() {
    
    super("Drum Machine");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setContentPane(new DrumPanel());
    pack();
    setVisible(true);
  }
  
  public static void main (String[] args) {
    new DrumApp();
  }
}
