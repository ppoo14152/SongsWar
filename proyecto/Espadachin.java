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
    private int DanoRes;
    private int Def;
    private int band;
    private int band2;
    private int i;
    private LinkedList<GreenfootImage> HAtk;
    private GreenfootImage Atk01;
    private GreenfootImage Atk02;
    private GreenfootImage Atk03;
    private GreenfootImage Def01;
    private Vida v;
    private long seg;
    private boolean Desaparece;
    private int band3;
    private World w;
    

    public Espadachin()
    {
        Ataque=20;
        DanoRes=0;
        Def=50;
        band=0;
        band2=0;
        i=0;
        band3=0;
        v=new Vida(800);
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
        w=getWorld();
        band=super.setCom();

        if(super.getComando()==1){  
            band2=Ataque();
            band3=0;
            super.getTouch();}
        if(band2==1){
            setReg(true);
            band2=0;}

        if(super.getComando()==2){
            band3=1;
            Def();
        }
        if(super.getComando()==3){

            Regreso();
        }
        if(this.isTouching(Enemigo.class) && band3!=1){
        DanoRes=super.restaSalud(Def);
        Desaparece=v.reduce(DanoRes,v.getImage(),1);
        super.setDano(0);
        //System.out.println(DanoRes);
        }
        if(Desaparece==false)
        w.addObject(v,100,100);
        else if(Desaparece==true){
            w.removeObject(v);
            w.removeObject(this);
        }     
        
    }
    public int getAtk()
    {
        return Ataque;
    }

    public int Ataque()
    {  
        int x=getX();
        if(seg>1 && x<450){
            seg=System.currentTimeMillis();

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

