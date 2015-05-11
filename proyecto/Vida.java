import greenfoot.*;
import java.awt.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Vida aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Vida extends Actor
{
   private boolean band;
   private Vida V;
   
    public void act() 
    {
        
    }   
    public Vida(int size)
    {
      
       GreenfootImage vida=new GreenfootImage(size,10);
       vida.setColor(Color.GREEN);
       vida.fill();
       setImage(vida);
       
    }
    
    public boolean reduce(int dano,GreenfootImage img)
    {   
        int vid=(img.getWidth())-dano;
            if(vid>0){
                System.out.println(vid);
            GreenfootImage vida =new GreenfootImage(vid, 10);
            vida.setColor(Color.GREEN);
            vida.fill();
            setImage(vida);
            return false;}
            else
            return true;
    }
      
   
}
