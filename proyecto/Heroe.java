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
    private Comando imgCom;
    private World w;
    private String Regreso;
    private Scanner entrada;
    
    public void Heroes()
    {
          comando=0;
          entrada=new Scanner(System.in);
          imgCom=new Comando();
          
    }
        
        
    public void act() 
    {
       
        
    }  
    
    
    public int setCom()
    { 
        //Comando ataque qer
        String r;
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
                 c=0;
                
            }}                
         else if(Greenfoot.isKeyDown("j")){
              comando=2;
             }
           
            if(!Greenfoot.isKeyDown("r"))
            comando=3;
        
       return comando;
        
    }
    public boolean getTouch()
    {
        if(this.isTouching(Muro.class))
        return true;
        else
        return false;
    }
    
   
   
}
