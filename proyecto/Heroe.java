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
    private int comando;
    private int a=0;
    private int b=0;
    private int c=0;
    private int Atk;
    private Comando imgCom;
    private World w;
    private Actor eneAtk;
    private int DanoCol;
    private int DanoKra;
    private int DanoTotal;
    private boolean Reg;
    private int band;
    private int Resistencia;
    
    public void Heroes()
    { 
          comando=0;
          imgCom=new Comando();
          Reg=false;
          eneAtk=new Enemigo();
          DanoCol=0;
          DanoKra=0;
          DanoTotal=0;
          Resistencia=0;
    }
        
        
    public void act() 
    {
       
        
    }  
    
    
    public int setCom()
    { 
        //Comando ataque qer
        String Tecla;
        Tecla=Greenfoot.getKey();
        if(Greenfoot.isKeyDown("q"))
        a=1;
        if(a==1){
            if(Greenfoot.isKeyDown("w"))
                b=1;
                if(Greenfoot.isKeyDown("e"))
                c=1;
                if(a==1 && b==0 && c==1){
                if(Greenfoot.isKeyDown("r"))

                comando=1;
                band=1;
                 a=0;
                 b=0;
                 c=0;
                
            }}                
        if(Greenfoot.isKeyDown("w")){
            b=2;
            if(b==2){
                if(Greenfoot.isKeyDown("r")){
                c=2;
                a=2;}
                if(Greenfoot.isKeyDown("e"))
                a=0;
                if(Greenfoot.isKeyDown("q"))
                
              comando=2;
              a=0;
              b=0;
              c=0;
             }}
           
         if(!Greenfoot.isKeyDown("r")){
          band=3;
            }
            
            if(Reg==true){
            comando=3;
            Reg=false;}
       return band;
        
    }
    public int restaSalud(int Resistencia)
    {
        String NombreClass;
        eneAtk=getOneIntersectingObject(Enemigo.class);
        NombreClass=eneAtk.getClass().getName();
        if(NombreClass== "Coloso"){
            DanoCol=((Coloso)eneAtk).getAtk();
            
        }
        if(NombreClass=="Kraken"){
           DanoKra=((Kraken)eneAtk).getAtk();
        }
        
        DanoTotal=Resistencia-(DanoCol-DanoKra);        
        System.out.println(DanoTotal);
        return DanoTotal;
    }
    public boolean getTouch()
    {
        if(this.isTouching(Muro.class))
        return true;
        else
        return false;
    }
    public boolean getReg()
    {
        return Reg;
    }
    public void setReg(boolean R)
    {
        Reg=R;
    }
    public int getBand()
    {
        return band;
    }
    public int getComando()
    {
        return comando;
    }
   public void setDano(int d)
   {
       DanoTotal=d;
    }
   
}
