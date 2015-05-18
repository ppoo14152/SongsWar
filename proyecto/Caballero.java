import greenfoot.*;
import java.util.*;
/**
 * Esta clase es un caballero es unos de lo heroes que actuaran 
 * conforme se halla establecido un comando y ejecutara una animacion 
 * aqui se declaran el ataque ,la defensa las lista con imagenes para la animacion
 * variables de mundo para poder eliminar a este heroe 
 * movimiento sirve para darle un numero para que alcance a los enemigos mas facil  
 * 
 * @autor Omar Agustin Valadez Hernandes 
 * @versión 3.0 Mayo 2015
 */
public class Caballero extends Heroe
{
    private int Ataque;
    private int Def;
    private int band;
    private int band2;
    private int band3;
    private long seg;
    private int CoorX;
    private int movimiento;
    private int j;
    private int DanoRes;
    private boolean Desaparece;
    private Vida v;
    private List M;
    private World w;
    private LinkedList<GreenfootImage> HCab;
    private GreenfootImage CabAtk01;
    private GreenfootImage CabAtk02;
    private GreenfootImage CabAtk03;
    /**
     * Constructor de Caballero 
     * aqui se definen el ataque la defensa ,y las banderas que ayudan a ejecutar las acciones
     * ademas de cargar las listas con imagenes para la animacion
     */
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
        CoorX=450;
        movimiento=20;
        HCab=new LinkedList<GreenfootImage>();
        HCab.add(CabAtk01=new GreenfootImage("CabAtack01.png"));
        HCab.add(CabAtk02=new GreenfootImage("CabAtack02.png"));
        HCab.add(CabAtk03=new GreenfootImage("CabAtack03.png"));
        // Def01=new GreenfootImage("Def01.png");
        seg=System.currentTimeMillis();
    }

    public void act() 
    {
        w=getWorld();
        band=super.setCom();
        M=w.getObjects(Muro.class);
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
       /* if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            band3=0;}
        else
            band3=1;*/
        if(this.isTouching(Enemigo.class) && band3!=1){
            DanoRes=super.restaSalud(Def);
            Desaparece=v.reduce(DanoRes,v.getImage(),2);
            super.setDano(0);
            //System.out.println(DanoRes);
        }
        if(Desaparece==false)
            w.addObject(v,100,200);
        else if(Desaparece==true){
            w.removeObject(v);
            w.removeObject(this);
        } 
        if(M.isEmpty())
        {
            movimiento=40;   
            CoorX=600;
        }
    }    

    /**
     * en este metodo se utiliza para poder hacer la animacio de movimiento y que se ejecute 
     * el movimiento hacia el enmmigo, las animaciones de hiran poniendo de forma automatica segun
     * vaya avanzando
     */
    public int Ataque()
    {  
        int x2=getX();

        // System.out.println(x);
        //Greenfoot.delay(20);
        if(seg>1 &&  x2<CoorX){
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
    /**
     * regresa el ataque de este heroe
     */
    public int getAtk()
    {
        return Ataque;
    }

    /**
     * coloca a su posicion original este heroe
     */
    public void Regreso()
    {       
        setLocation(200,500); 
        setImage("CabAtack01.png");

    }
    /**
     * coloca la imagen para la defensa 
     */
    public void Def()
    {
        setImage("DefCab01.png");
    }
}
