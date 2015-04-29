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
   private GreenfootImage Reposo4;
   
   private GreenfootImage Ataque1;
   private GreenfootImage Ataque2;
   private GreenfootImage Ataque3;
   private LinkedList<GreenfootImage> imgRep;
   private LinkedList<GreenfootImage> imgAtk;
   private Heroe comHeroe;
   private int comando;
   private int count;
   private long seg;
   private int i;
   private SimpleTimer tiempo;
    public Comando ()
    {
      
      imgAtk=new LinkedList<GreenfootImage> ();
      imgRep=new LinkedList<GreenfootImage>();
      
      
      imgRep.add(Reposo1=new GreenfootImage("Reposo01.png"));
      imgRep.add(Reposo2=new GreenfootImage("Reposo02.png"));
      imgRep.add(Reposo3=new GreenfootImage("Reposo03.png"));
      imgRep.add(Reposo4=new GreenfootImage("Reposo01.png"));
      
      imgAtk.add(Ataque1=new GreenfootImage("ComAtk01.png"));
      imgAtk.add(Ataque2=new GreenfootImage("ComAtk02.png"));
      imgAtk.add(Ataque3=new GreenfootImage("ComAtk03.png"));
      
      comHeroe=new Heroe();
      comando=0;
      seg=System.currentTimeMillis();
      i=0;
      count=0;
      tiempo=new SimpleTimer();
    }
    public void act() 
    {
       
     comando=comHeroe.setCom();
     
     if(comando==1)
     {
         if(seg>1){
            seg=System.currentTimeMillis();
            setImage(imgAtk.get(i));
            i++;}
                 if(i==2)
                 i=0;
     }
     else if(comando==0 || comando==3){
     if(seg>1){
       seg=System.currentTimeMillis();       
       setImage(imgRep.get(count));
       count++;       
        }
        if(count==3)
        count=0;
    }
}
    
    
            
    
}
    
    
    

