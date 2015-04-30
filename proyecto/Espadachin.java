import greenfoot.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Espadachin aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Espadachin extends Heroe 
{
    private int Ataque;
    private int DañoRes;
    private int Def;
    private int band;
    private int band2;
    private int i;
    private LinkedList<GreenfootImage> HAtk;
    private GreenfootImage Atk01;
    private GreenfootImage Atk02;
    private GreenfootImage Atk03;
    private GreenfootImage Def01;
    private long seg;
    
    
    public Espadachin()
    {
        Ataque=20;
        DañoRes=0;
        Def=100;
        band=0;
        band2=0;
        i=0;
        HAtk=new LinkedList<GreenfootImage>();
        HAtk.add(Atk01=new GreenfootImage("Atack01.png"));
        HAtk.add( Atk02=new GreenfootImage("Atack02.png"));
        HAtk.add(Atk03=new GreenfootImage("Atack03.png"));
        Def01=new GreenfootImage("Def01.png");
        seg=System.currentTimeMillis();
        
        
    }
   public void act() 
    {
        // Agrega tus códigos de acción aquí.
        
       band=super.setCom();
       
      
       if(comando==1){  
         
        band2=Ataque();
        super.getTouch();}
         if(band2==1){
         Reg=true;
         band2=0;}
           
       if(comando==2){
            Def();
      }
      if(comando==3){
      
        Regreso();
       }
        
        
       
        
        
        
    }
    public int getAtk()
    {
        return Ataque;
    }
    
    public int Ataque()
    {  
        int x=getX();
       // System.out.println(x);
        //Greenfoot.delay(20);
             if(seg>1 && x<450){
                 seg=System.currentTimeMillis();
                 
                 
                 setImage(HAtk.get(i));
                 move(20);
                 
                 setImage(HAtk.get(i));
                  move(20);
                        i++;
                        if(i==2)
                            i=0;
                            x++;
                        }
                            else
                            {
                            setImage(HAtk.get(2));
                            move(0);
                             band2=1;                 
                            }
                            
              return band2;
       
        
    }
    
    public void Def()
    {
        setImage(Def01);
    }
    public void Regreso()
    {   
       
       setLocation(250,500);
        setImage(Atk01);
        
        
    }
}
  
