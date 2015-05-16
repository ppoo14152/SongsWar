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
    private int Def;
    private int band;
    private int band2;
    private int band3;
    private long seg;
    private int j;
    private int DanoRes;
    private boolean Desaparece;
    private Vida v;
    private World w;
    private LinkedList<GreenfootImage> HCab;
    private GreenfootImage CabAtk01;
    private GreenfootImage CabAtk02;
    private GreenfootImage CabAtk03;
    public Caballero()
    {
        Ataque=35;
        DanoRes=0;
        Def=50;
        band=0;
        band2=0;
        band3=0;
        v=new Vida(800);
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
        w=getWorld();
       band=super.setCom();
       
      if(super.getComando()==1){           
        band2=Ataque(); 
        band3=0;}
        //super.getTouch();}}
        if(band2==1){
            super.setReg(true);
         band2=0;}
         
       if(super.getComando()==2){
           band3=1; 
           Def();}
       if(super.getComando()==3){
       Regreso();
       }
       if(this.isTouching(Enemigo.class) && band3!=1){
        DanoRes=super.restaSalud(Def);
        Desaparece=v.reduce(DanoRes,v.getImage(),2);
        super.setDano(0);
        //System.out.println(DanoRes);
        }
        if(Desaparece==false)
        w.addObject(v,100,70);
        else if(Desaparece==true){
            w.removeObject(v);
            w.removeObject(this);
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
