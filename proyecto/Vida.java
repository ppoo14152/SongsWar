import greenfoot.*;
import java.awt.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Vida aquí.
 * @see java.awt.*; para poder hacer uso de la clase color para darle color a la vida
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
   */
public class Vida extends Actor
{
   
   private Vida vida;
   private Color color;
   
    public void act() 
    {
        
    }   
    /**
     * Constructor de Vida
     * @param size recibe el tamaño de la nueva vida
     */
    public Vida(int size)
    {
      
       GreenfootImage vida=new GreenfootImage(size,10);
       vida.setColor(Color.GREEN);
       vida.fill();
       setImage(vida);
       
    }
    /**
     * Coloca una nueva imagen con un tamaño nuevo para poder hacer que se reduca la vida 
     * @param dano se usa para darle un nuevvo  tamaño a la vida
     * @param img recibe la imagen a la cual se va a redefinir 
     * @param num el un indice para colocar el color
     * @return boolean regresa  un booleano para indicar si se debe de remover este objeto o no
     */
    public boolean reduce(int dano,GreenfootImage img,int num )
    {   
        int vitalidad=(img.getWidth())-dano;
        if(num==1)
        color=Color.GREEN;
        if(num==2)
        color=Color.YELLOW;
            if(vitalidad>0){
            GreenfootImage vida =new GreenfootImage(vitalidad, 10);
            vida.setColor(color);
            vida.fill();
            setImage(vida);
            return false;
        }
            else
            return true;
    }
      
   
}
