import greenfoot.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Escribe una descrición de la clase Comando aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Comando extends Actor 
{
   private GreenfootImage Reposo1;
   private GreenfootImage Reposo2;
   private GreenfootImage Reposo3;
   private GreenfootImage Ataque1;
   private GreenfootImage Ataque2;
   private GreenfootImage Ataque3;
   private LinkedList<GreenfootImage> img;
   private Timer tm;
   private Timer ts;
   private int count;
   private long seg;
    public Comando ()
    {
      img=new LinkedList<GreenfootImage> ();
      
      img.add(Reposo1=new GreenfootImage("Reposo01.png"));
      img.add(Reposo2=new GreenfootImage("Reposo02.png"));
      img.add(Reposo3=new GreenfootImage("Reposo03.png"));
      //img.add(Ataque1=new GreenfootImage("ComAtk01.png"));
      //img.add(Ataque2=new GreenfootImage("ComAtk02.png"));
      //img.add(Ataque3=new GreenfootImage("ComAtk03.png"));
      //seg=System.currentTimeMillis();
     
      count=0;
    }
    public void act() 
    {
     if(System.currentTimeMillis()-seg>500){
         seg=System.currentTimeMillis();
      count++;
       setImage(img.get(count));
       
        }
        if(count==2)
        count=0;
        
    }
    
    public void run()
    {
        count=count+1;
                 switch(count)
                 {
                     case 0:setImage(Reposo1);
                     case 1:setImage(Reposo2);
                     case 2:setImage(Reposo3);
                     case 3:setImage(Reposo1);
             }
             if(count==3)
             count=0;
            }
            
    
}
    
    
    

