import greenfoot.*;
import java.util.*;
/**
 * Esta clase es un Espadachin es unos de lo heroes que actuaran 
 * conforme se halla establecido un comando y ejecutara una animacion 
 * aqui se declaran el ataque ,la defensa las lista con imagenes para la animacion
 * variables de mundo para poder eliminar a este heroe 
 * movimiento sirve para darle un numero para que alcance a los enemigos mas facil  
 * 
 * @autor Omar Agustin Valadez Hernandes 
 * @versión 3.0 Mayo 2015
 */
public class Espadachin extends Heroe 
{
    private int Ataque;
    private int DanoRes;
    private int Def;
    private int band;
    private int band2;
    private int i;
    private int bandG;
    private LinkedList<GreenfootImage> HAtk;
    private GreenfootImage Atk01;
    private GreenfootImage Atk02;
    private GreenfootImage Atk03;
    private GreenfootImage Def01;
    private Vida v;
    private long seg;
    private int CoorX;
    private int movimiento;
    private boolean Desaparece;
    private int band3;
    private World w;
    private GreenfootSound Golpe;

    private List M;

    /**
     * Constructor de Espadachin 
     * aqui se definen las variables como las lista y se cargan sus respectivas
     * imagenes 
     * ademas de definir el ataque la defensa y la serie de banderas
     */
    public Espadachin()
    {
        Ataque=20;
        DanoRes=0;
        Def=50;
        band=0;
        band2=0;
        i=0;
        bandG=0;
        band3=0;
        CoorX=450;
        movimiento=20;
        v=new Vida(800);
        HAtk=new LinkedList<GreenfootImage>();
        HAtk.add(Atk01=new GreenfootImage("Atack01.png"));
        HAtk.add( Atk02=new GreenfootImage("Atack02.png"));
        HAtk.add(Atk03=new GreenfootImage("Atack03.png"));
        Def01=new GreenfootImage("Def01.png");
        Golpe=new GreenfootSound("golpe_A_Heroe.mp3");
        seg=System.currentTimeMillis();

    }

    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        w=getWorld();

        band=super.setCom();
        M=w.getObjects(Muro.class);
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
        /*if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            band3=0;}
        else
            band3=1;*/

        if(this.isTouching(Enemigo.class) && band3!=1){
            Golpe.play();
            DanoRes=super.restaSalud(Def);
            Desaparece=v.reduce(DanoRes,v.getImage(),1);
            super.setDano(0);
            //System.out.println(DanoRes);
        }
        if(!this.isTouching(Enemigo.class));
        Golpe.stop();
        if(Desaparece==false)
            w.addObject(v,100,220);
        else
        if(Desaparece==true)
            System.out.println(bandG);
        if(Desaparece==true){
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
     * regresa el ataque de este heroe
     */
    public int getAtk()
    {
        return Ataque;
    }

    /**
     * este metodo sirve para poder ejecutar la animacion de ataque y ademas causarle daño
     * al enemigo
     * usa las listas y un indice 
     * para poder ir cambiando las imagenes
     * ademas de regresar una bandera para poder regresar al heroe a sus estado original
     */
    public int Ataque()
    {  
        int x=getX();
        if(seg>1 && x<CoorX){
            seg=System.currentTimeMillis();

            setImage(HAtk.get(i));
            move(movimiento);
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

    /**
     * coloca la imagen para la defensa
     */
    public void Def()
    {
        setImage(Def01);
    }

    /**
     * este metodo regresa al heroe a su posicion original
     */

    public void Regreso()
    {   

        setLocation(250,500);
        setImage(Atk01);

    }
}

