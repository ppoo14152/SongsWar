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
   private Color color;
   
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
    
    public boolean reduce(int dano,GreenfootImage img,int c )
    {   
        int vid=(img.getWidth())-dano;
        if(c==1)
        color=Color.GREEN;
        if(c==2)
        color=Color.YELLOW;
            if(vid>0){
                System.out.println(vid);
            GreenfootImage vida =new GreenfootImage(vid, 10);
            vida.setColor(color);
            vida.fill();
            setImage(vida);
            return false;}
            else
            return true;
    }
      
   
}
