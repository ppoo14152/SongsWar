import greenfoot.*;
import java.util.Timer;
import java.util.*;

/**
 * Esta clase indica el estado del comando que el jugador intrude para hacer actuar a los heroes 
 * la lista imgRep,añanade en ella las imgenes cuando el jugador no esta precionando ningun comando 
 * la Lista img Atk, añanade en ella las imagenes cuando el jugador esta precionando el comando Ataque 
 * que envia la variable de instacia Heroe comHeroe
 * @see java.util.*; para poder hacer uso de las listas 
 * @see java.util.Timer para poder hacer uso de las variables de tiempo
 * @autor Omar Agustin Valadez
 * @versión Abril 2015
 */
public class Comando extends Actor 
{
    private GreenfootImage Reposo1;
    private GreenfootImage Reposo2;
    private GreenfootImage Reposo3;
    private GreenfootImage Reposo4;

    private GreenfootImage Ataque1;
    private GreenfootImage Ataque2;
    private GreenfootImage Ataque3;
    private LinkedList<GreenfootImage> imgRep;
    private LinkedList<GreenfootImage> imgAtk;
    private Heroe comHeroe;
    protected int comando;
    private int com;
    private int count;
    private long seg;
    private int i;
    private boolean Reg;
    /**
     * Constructor de la clase Comando
     * en el se declaran todas las lista y se cargan imagenes en ella
     * Las banderas a utilizar y los indices de las imagenes que son:
     * i,count
     */
    public Comando ()
    {

        imgAtk=new LinkedList<GreenfootImage> ();
        imgRep=new LinkedList<GreenfootImage>();

        imgRep.add(Reposo1=new GreenfootImage("Reposo01.png"));
        imgRep.add(Reposo2=new GreenfootImage("Reposo02.png"));
        imgRep.add(Reposo3=new GreenfootImage("Reposo03.png"));
        imgRep.add(Reposo4=new GreenfootImage("Reposo01.png"));

        imgAtk.add(Ataque1=new GreenfootImage("ComAtk01.png"));
        imgAtk.add(Ataque2=new GreenfootImage("ComAtk02.png"));
        imgAtk.add(Ataque3=new GreenfootImage("ComAtk03.png"));

        comHeroe=new Heroe();
        comando=0;
        seg=System.currentTimeMillis();
        i=0;
        Reg=true;
        count=0;

    }

    public void act() 
    {

        comando=comHeroe.setCom();

        if(comando==1 && comHeroe.getBand()==1)
        {
            if(seg>1){
                seg=System.currentTimeMillis();
                setImage(imgAtk.get(i));
                i++;}
            if(i==2)
                i=0;
        }
        else if(comando==3 || comando==0){
            if(seg>1){
                seg=System.currentTimeMillis();       
                setImage(imgRep.get(count));
                count++;       
            }
            if(comando==2 )
                setImage("Defensa.png");
            if(count==3)
                count=0;
        }
        comando=0;
    }

            
}
    

