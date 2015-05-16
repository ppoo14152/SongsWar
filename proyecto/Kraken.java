import greenfoot.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Kraken aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Kraken extends Enemigo
{
   private GreenfootImage Kraken1;
   private GreenfootImage Kraken2;
   private GreenfootImage Kraken3;
   private GreenfootImage KrakenAtk1;
   private GreenfootImage KrakenAtk2;
   private GreenfootImage KrakenAtk3;
   private LinkedList<GreenfootImage> imgRep;
   private LinkedList<GreenfootImage> imgAtk;
   private World w;
   private Vida v;
   private Heroe h;
   private long seg;
   private boolean band;
   private boolean Desaparece;
   private int i;
   private int j;
   private int Dano;
   private int num;
   private int Ataque;
   private int Defensa;
   private List M;
   
   public Kraken()
   {
       Ataque=40;
       Defensa=100;
       Dano=0;
       v=new Vida(2000);
       h=new Heroe();
       imgRep=new LinkedList<GreenfootImage>();
       imgAtk=new LinkedList<GreenfootImage>();
       //imgRep.add(Kraken1=new GreenfootImage("Kraken01.png"));
       imgRep.add(Kraken2=new GreenfootImage("Kraken02.png"));
       imgRep.add(Kraken3=new GreenfootImage("Kraken03.png"));
       imgAtk.add(KrakenAtk1=new GreenfootImage("KrakenAtk01.png"));
       imgAtk.add(KrakenAtk2=new GreenfootImage("KrakenAtk02.png"));
       imgAtk.add(KrakenAtk3=new GreenfootImage("KrakenAtk03.png"));
       i=0;  
       j=0;
       num=0;
       seg=System.currentTimeMillis();
    }
   
    public void act() 
    {
        w=getWorld();
        int bandR=h.setCom();
        if(seg>1 && band==false){
            seg=System.currentTimeMillis();
            setImage(imgRep.get(i));
            setLocation(680,500);
            i++;
            }
            if(i==2)
            i=0;    
        else
        {   seg=System.currentTimeMillis();
            band=Ataque();
            if(this.isTouching(Heroe.class)){
                if(bandR==1){
                    Dano=super.restaSalud(Defensa);
                    Desaparece=v.reduce(Dano,v.getImage(),1);
               }
                }
            
        }
        num=Greenfoot.getRandomNumber(10);
        if(num==1){
            band=true;
        }
        if(Desaparece==false)
        w.addObject(v,500,600);
        else if(Desaparece==true){
            
            w.removeObject(v);
            w.removeObject(this);}
            
            
       // System.out.println(num);
}
public boolean Ataque()
{ 
    int num=Greenfoot.getRandomNumber(5);
    if(seg>1 && num==1){
    seg=System.currentTimeMillis();
    setImage(imgAtk.get(j));
    setLocation(200,500);
    
    band=true; 
    if(j==2){
    j=0;
   }
   }
   else{
    band=false;
    }
   return band;
}
public int getAtk()
{
    return Ataque;
}
}