import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.*;
import java.awt.GridLayout;
import javax.sound.sampled.*;

//The drum-machine part of the project
public class DrumCanvas extends JPanel{
  
  //This Arraylist keeps track of all the SoundCells
  ArrayList<ArrayList<SoundCell>> boxes = new ArrayList<ArrayList<SoundCell>>(6);
  public DrumCanvas()
  {
    setPreferredSize(new Dimension(1300, 500));
    setMaximumSize(new Dimension(1300, 500));
    setMinimumSize(new Dimension(1300, 500));
    setBackground(Color.WHITE);
    setBorder(new LineBorder(Color.BLACK, 5));
    //This loop and the nested one fill up boxes with SoundCells. Depending on which iteration of i the loop
    //is on, it will make a differen SoundCell.
    for (int i = 0; i <6; i++)
    {
      ArrayList<SoundCell> temp = new ArrayList<SoundCell>();
      for(int j = 1; j<17; j++)
      {
        int b = 12*i+j; //I added b to "Button" tp print out the boxes
        if (i==0)
          temp.add(new SoundCell("Button" + b, "hihat"));
        if (i==1)
          temp.add(new SoundCell("Button" + b, "snare"));
        if (i==2)
          temp.add(new SoundCell("Button" + b, "kick"));
        if (i==3)
          temp.add(new SoundCell("Button" + b, "guitar"));
        if(i==4)
          temp.add(new SoundCell("Button" + b, "clap"));
        if(i==5)
          temp.add(new SoundCell("Button" + b, "bleep"));
      }
      boxes.add(temp);
    }
    
    setLayout(new GridLayout(6,16));
    //Adds the SoundCells from boxes to the JPanel
    for (int i = 0; i <6; i++)
    {
      for(int j = 0; j<16; j++)
      {
        SoundCell temp = boxes.get(i).get(j);
        temp.setForeground(Color.BLUE);
        add(temp);
      }
    }
    SoundCell.makeSounds();
  }
  
  //I included this method to check if I was making boxes correctly or not.
  //I left it in so you could see boxes printed out not using DrumApp
  public void printboxes()
  {
    for (ArrayList<SoundCell> first : boxes)
    {
      for (SoundCell s : first)
      {
        System.out.println(s);
      }
    }
  }
  
  //This ArrayList is created to keep track of which SoundCells in boxes will be played
  ArrayList<ArrayList<SoundCell>> playing = new ArrayList<ArrayList<SoundCell>>();
  
  //This method is called when they playbutton is pressed
  public void play()
  {
    ArrayList<ArrayList<SoundCell>> playingLocal = new ArrayList<ArrayList<SoundCell>>();
    playing = playingLocal;
    
    if (!playing.isEmpty())
    {
      playing.clear();
      System.out.println("If this prints, thats bad");
    }
    //This call to makeSounds() makes the ArrayList of Clips in the class SoundCell that SoundCell
    //objects can then reference
    
    //Goes through boxes and checks each SoundCell to see if it is activated. If it is,
    //it is added to playing
    for(int i = 0; i<16; i++)
    {
      ArrayList<SoundCell> playtemp = new ArrayList<SoundCell>();
      for(int j = 0; j<6; j++)
      {
        if(boxes.get(j).get(i).isActivated())
          playtemp.add(boxes.get(j).get(i));
      }
      playing.add(playtemp);
    }
    //Goes through each ArrayList in playing and plays each sound, then pauses, then plays the next ArrayList
    for (int p = 0; p<3; p++)
    {
      for (ArrayList<SoundCell> first : playing)
      {
        for (SoundCell s : first)
        {
          s.play();
        }
        try
        {
          //Change this number to change the tempo the beat is played at
          Thread.sleep(250);
        }
        catch (Exception e)
        {
          throw new RuntimeException(e);
        }
      }
    }
  }
  
  //This method is called when the resetbutton is pressed
  public void reset()
  {
    //Goes through playing, deactivates every cell in it, making all cells in boxes deactivated, and then
    //clears playing so the program can start anew.
    for (ArrayList<SoundCell> first : playing)
    {
      for (SoundCell s : first)
      {
        s.deactivate();
      }
    }
    playing.clear(); 
  }
  
  //A test to see that the ArrayList boxes is correct
  public static void main(String[] args)
  {
    DrumCanvas test = new DrumCanvas();
    test.printboxes();
  }
}
