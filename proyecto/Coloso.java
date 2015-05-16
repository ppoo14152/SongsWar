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
    private int Atk;
    private int Defensa;
    private int Dano;
    private int i;
    private boolean band;
    private boolean Desaparece;
    private int Com;
    private World w;
    private World n;
    private Vida v;
    private Heroe h;
    private Actor heroAtk;
    private LinkedList<GreenfootImage> Enem;
    private GreenfootImage Coloso1;
    private GreenfootImage Coloso2;
    private GreenfootImage Coloso3;
    private List M;
    private long seg;
    public Coloso()
    {
        Atk=20;
        Defensa=200;
        Dano=0;
        ideAtk=0;
        i=0;
        Com=1;
        band=false;        
        heroAtk=new Heroe();
        h=new Heroe();
        v=new Vida(1000);    
        Enem=new LinkedList<GreenfootImage>();
        Enem.add(Coloso1=new GreenfootImage("Coloso01.png"));
        Enem.add(Coloso2=new GreenfootImage("Coloso02.png"));
        Enem.add(Coloso3=new GreenfootImage("Coloso03.png"));
        seg=System.currentTimeMillis();

    }
    public void act() 
    {
        w=getWorld();
        n=new Nivel2();
        M=w.getObjects(Muro.class);
        int bandR=h.setCom();
       
        if(M.isEmpty()){
            if(Com==1 && band==false)
                Ataque();
            
             if(this.isTouching(Heroe.class)){
                 if( bandR==1){
                Dano=super.restaSalud(Defensa);
                Desaparece=v.reduce(Dano,v.getImage(),1);
            }
            
                }
                if(Desaparece==false)
                w.addObject(v,500,600);
                else if(Desaparece==true) {
                 w.removeObject(v);
                 w.removeObject(this);
                 
                 Greenfoot.setWorld(n);}
            if(band==true && Desaparece==false){
                Regreso();
                Com=0;                
            }
            int Band2=Greenfoot.getRandomNumber(50);
            if(Band2==1 || Band2==25)
                Com=1;
           
    }}    

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
    public int getAtk()
    {
        return Atk;
    }

    
}
