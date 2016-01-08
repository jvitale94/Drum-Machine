import java.io.*;
import sun.audio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import javax.sound.sampled.*;

//The main part of my project. This sublcass of JButton is what makes the sounds play
public class SoundCell extends JButton implements ActionListener
{
  //Three simple variables that keep track of information about SoundCell
  String name;
  String file;
  boolean activated;
  
  //This ArrayList keeps track of all 6 sounds that can be played
  static ArrayList<Clip> sounds = new ArrayList<Clip>(6);
  
  //Simple constructor
  public SoundCell(String n, String f)
  {
    super (f);
    name = n;
    file =f;
    activated = false;
    addActionListener(this);
  }
  
  //This static methods fills up sounds with the correct sound in each slot
  public static void makeSounds()
  {
    if(!(sounds.isEmpty()))
    {
      sounds.clear();
      System.out.println("makeSounds() was not empty and it cleared");
    }
    for(int i = 0; i<6; i++)
    {
      String s;
      if(i==0)
        s = "hihat";
      else if(i==1)
        s = "snare";
      else if(i==2)
        s = "kick";
      else if(i==3)
        s = "guitar";
      else if(i==4)
        s = "clap";
      else
        s = "bleep";
      try
      {
        //This is a somewhat compliacted process to open a .wav file. The clip eventually opens the file 
        //and then clip associated with the open file is added to sounds.
        //Change the parameter in file's initialization to match the pathway on your computer
        File file = new File("/Users/jakevitale/Documents/Comp Sci/Final Zip/Sounds/"+s+".wav");
        Clip noise = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        noise.open(ais);
        sounds.add(noise);
      }
      catch (Exception e)
      {
        System.out.println("makeSounds() ERROR");
        throw new RuntimeException(e);
      }
    }
  }
      
  //Plays the correct sounds based on the SoundButton's file
  public void play()
  {
    int index;
    if(file=="hihat")
      index = 0;
    else if(file=="snare")
      index = 1;
    else if(file=="kick")
      index = 2;
    else if(file=="guitar")
      index = 3;
    else if(file=="clap")
      index = 4;
    else
      index = 5;
    try
    {
      //These lines access the correct Clip in sounds, starts it over, and then plays it
      sounds.get(index).setFramePosition(0);
      sounds.get(index).start();
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  
  //Sets the activated boolean to false and changes the color back to blue
  public void deactivate()
  {
    activated = false;
    setForeground(Color.BLUE);
    setBackground(Color.WHITE);
    setOpaque(false);
  }
  
  //When a SoundButton is pressed, the activated boolean alternates between true and false and the
  //colors associated with different truth values also changes. Blue is deactivated and rred with green
  //is activated
  public void actionPerformed (ActionEvent e) {
    if (e.getSource().equals(this)) {
      if (activated == true)
      {
        setForeground(Color.BLUE);
        setBackground(Color.WHITE);
        setOpaque(false);
        activated = false;
      }
      else
      {
        setForeground(Color.RED);
        setBackground(Color.GREEN);
        setOpaque(true);
        activated = true;
      }
    }
  }
  
  //The next two methods are self-explanatory
  public boolean isActivated()
  {
    return activated;
  }
  
  public String toString()
  {
    return (name + " has sound " + file);
  }
  
  //A check to see a SoundCell with a guitar sound works
  public static void main(String[] args)
  {
    SoundCell sample = new SoundCell("A", "snare");
    makeSounds();
    sample.play();
  }
}
