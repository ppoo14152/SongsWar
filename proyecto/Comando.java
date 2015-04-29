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
   private LinkedList<GreenfootImage> imgRep;
   private LinkedList<GreenfootImage> imgAtk;
   
   private int count;
   private long seg;
   private int i;
    public Comando ()
    {
      imgRep=new LinkedList<GreenfootImage> ();
      imgAtk=new LinkedList<GreenfootImage> ();
      
      imgRep.add(Reposo1=new GreenfootImage("Reposo01.png"));
      imgAtk.add(Ataque1=new GreenfootImage("ComAtk01.png"));
      imgAtk.add(Ataque2=new GreenfootImage("ComAtk02.png"));
      imgAtk.add(Ataque3=new GreenfootImage("ComAtk03.png"));
      seg=System.currentTimeMillis();
      i=0;
      count=0;
    }
    public void act() 
    {
        
     if(seg>1){
       seg=System.currentTimeMillis();
      
       
       ///setImage(imgRep.get(0));
       setRotation(i);
       i=i+15;
        }
        if(count==2)
        count=0;
        
    }
    
    
            
    
}
    
    
    

