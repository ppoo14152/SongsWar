import greenfoot.*;
import java.util.*;
/**
 * Escribe una descrición de la clase Coloso aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Coloso extends Enemigo
{
    private int ideAtk;
    private int Ataque;
    private int Defensa;
    private int Dano;
    private int i;
    private boolean band;
    private int Com;
    private World w;
    private Vida v;
    private LinkedList<GreenfootImage> Enem;
    private GreenfootImage Coloso1;
    private GreenfootImage Coloso2;
    private GreenfootImage Coloso3;
    private long seg;
    public Coloso()
    {
        Ataque=100;
        Defensa=500;
        Dano=0;
        ideAtk=0;
        i=0;
        Com=1;
        band=false;
        Enem=new LinkedList<GreenfootImage>();
        Enem.add(Coloso1=new GreenfootImage("Coloso01.png"));
        Enem.add(Coloso2=new GreenfootImage("Coloso02.png"));
        Enem.add(Coloso3=new GreenfootImage("Coloso03.png"));
        seg=System.currentTimeMillis();
        
        
    }
    public void act() 
    {
        
        if(Com==1 && band==false )
            Ataque();
            
            if(band==true){
                Regreso();
                //
                Com=0;                
            }
        int Band2=Greenfoot.getRandomNumber(10);
        if(Band2==1)
        Com=1;
        System.out.println(Band2);
    }    
    public void Ataque()
    {
        int x=getX();
        if(seg>1 && x>150)
        {
            seg=System.currentTimeMillis();
            setImage(Enem.get(i));
            move(-50);
            i++;
            if(i==2)
            i=0;
            x++;
        }
        if(x==150)
        band=true;
        
            
        
    }
    public void Regreso()
    {
        int x=getX();
        if(seg>1 && x<750 && band)
        {
            
            setImage(Enem.get(0));
            move(100);
            x++;
        }
        else{
        setImage(Enem.get(0));
        move(0);
        band=false;
        }
    }
}
