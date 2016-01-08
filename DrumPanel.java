import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.GridLayout;
import javax.sound.sampled.*;

//Simple class that creates two JPanels, one with buttons and the other a DrumCanvas
public class DrumPanel extends JPanel implements ActionListener
{
  private DrumCanvas canvas;
  private JButton playButton, resetButton, toggleButton;
  
  //A subclass that makes a playbutton and resetbutton to control the SoundCells.
  private class ButtonPanel extends JPanel {
    ButtonPanel() {
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      playButton = new JButton("Play");
      playButton.setFocusable(false);
      add(playButton);
      add(Box.createHorizontalStrut(50));
      resetButton = new JButton("Reset");
      //resetButton.setEnabled(false);
      resetButton.setFocusable(false);
      add(resetButton);
      add(Box.createHorizontalStrut(50));
      setBorder(new EmptyBorder(50, 0, 0, 0));
    }
  }
  
  //Constructor that adds a DrumCanvas and ButtonPanel and allows playButton and resetButton to be clicked
  public DrumPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(canvas = new DrumCanvas());
    add(new ButtonPanel());
    playButton.addActionListener(this);
    resetButton.addActionListener(this);
    setBorder(new EmptyBorder(50,50,50,50));
    
  }
  
  //When playButton is pressed, the sounds play. When resetButton is pressed, the program starts fresh
  public void actionPerformed (ActionEvent e) {
    if (e.getSource().equals(playButton))
    {
      canvas.play();
      resetButton.setEnabled(true);
    }
    else if (e.getSource().equals(resetButton))
    {
      canvas.reset();
      resetButton.setEnabled(true);
    }
  }
}
