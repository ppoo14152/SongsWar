import greenfoot.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Caballero aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Caballero extends Heroe
{
    private int Ataque;
    private int DañoRes;
    private int Def;
    private int band;
    private int band2;
    
    private long seg;
    private int j;
    private LinkedList<GreenfootImage> HCab;
    private GreenfootImage CabAtk01;
    private GreenfootImage CabAtk02;
    private GreenfootImage CabAtk03;
    public Caballero()
    {
        Ataque=35;
        DañoRes=0;
        Def=100;
        band=0;
        band2=0;
        j=0;
        HCab=new LinkedList<GreenfootImage>();
        HCab.add(CabAtk01=new GreenfootImage("CabAtack01.png"));
        HCab.add(CabAtk02=new GreenfootImage("CabAtack02.png"));
        HCab.add(CabAtk03=new GreenfootImage("CabAtack03.png"));
       // Def01=new GreenfootImage("Def01.png");
        seg=System.currentTimeMillis();
    }
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        
       band=super.setCom();
       
      if(super.getComando()==1){           
        band2=Ataque(); }
        //super.getTouch();}}
        if(band2==1){
            super.setReg(true);
         band2=0;}
         
       if(super.getComando()==2){
            Def();}
       if(super.getComando()==3){
       Regreso();
       }
    }    
     public int Ataque()
    {  
        int x2=getX();
        
       // System.out.println(x);
        //Greenfoot.delay(20);
             if(seg>1 &&  x2<450){
                seg=System.currentTimeMillis();
                 
                 setImage(HCab.get(j));
                   move(22);
                 
                 setImage(HCab.get(j));
                  move(22);
                        j++;
                        if(j==2)
                            j=0;
                            x2++;
                        }
                            else
                            {
                            setImage(HCab.get(2));
                            //move(0);
                             band2=1;                 
                            }
                            
              return band2;
                 
              
        
        
    }
    public int getAtk()
    {
        return Ataque;
    }
    public void Regreso()
    {       
       setLocation(200,500); 
        setImage("CabAtack01.png");
        
        
    }
    public void Def()
    {
        setImage("DefCab01.png");
    }
}
