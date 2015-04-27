import greenfoot.*;
import java.util.*;
import java.util.Scanner;
/**
 * Escribe una descrición de la clase Heroes aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Heroe extends Actor 
{
    /**
     * Act - hace lo que Heroes quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public int comando;
    private int a=0;
    private int b=0;
    private int c=0;
    private int Atk;
    public void Heroes()
    {
          comando=0;
          
    }
        
        
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        
    }  
    
    
    public int setCom()
    { 
        //Comando ataque qer
        if(Greenfoot.isKeyDown("q"))
        a=1;
        if(a==1){
            if(Greenfoot.isKeyDown("w"))
                b=1;
                if(Greenfoot.isKeyDown("e"))
                c=1;
                if(c==1){
                if(Greenfoot.isKeyDown("r"))
                comando=1;
                 a=0;
                 b=0;
                 c=0;}}                
         else if(Greenfoot.isKeyDown("j"))
                  comando=2;
           
                //Comando Defensa wre
          /*      
          if(Greenfoot.isKeyDown("w"))
          a=2;
            if(a==2)
              if(Greenfoot.isKeyDown("q"))
                 b=2;
              if(Greenfoot.isKeyDown("r"))
              c=2;
                 if(c==2){
                     if(Greenfoot.isKeyDown("e"))
                     comando=2;
                     a=0;
                     b=0;
                     c=0;
                    }else if(b==2)
                    comando=0;
                 */   
                
                        
          /*
                   if(Greenfoot.isKeyDown("q")){
                        comando=1;
                    }
                    else
                    if(Greenfoot.isKeyDown("h")){
                        comando=8;
                    }else if(Greenfoot.isKeyDown("u")){
                        if(Greenfoot.isKeyDown("i"))
                            if(Greenfoot.isKeyDown("o"))
                        comando=6;}
                    
            else
            if(Greenfoot.isKeyDown("space"))
            comando=10;*/
            if(Greenfoot.isKeyDown("space"))
            comando=3;
        
       return comando;
        
    }
    
   
   
}
