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
    private LinkedList<GreenfootImage> imgReposo;
    private LinkedList<GreenfootImage> imgAtaque;
    private Heroe comandoHeroe;
    protected int comando;
    private int contador;
    private long segundo;
    private int indice;

    /**
     * Constructor de la clase Comando
     * en el se declaran todas las lista y se cargan imagenes en ella
     * Las banderas a utilizar y los indices de las imagenes que son:
     * indice,contador
     */
    public Comando ()
    {

        imgAtaque=new LinkedList<GreenfootImage> ();
        imgReposo=new LinkedList<GreenfootImage>();

        imgReposo.add(Reposo1=new GreenfootImage("Reposo01.png"));
        imgReposo.add(Reposo2=new GreenfootImage("Reposo02.png"));
        imgReposo.add(Reposo3=new GreenfootImage("Reposo03.png"));
        imgReposo.add(Reposo4=new GreenfootImage("Reposo01.png"));

        imgAtaque.add(Ataque1=new GreenfootImage("ComAtk01.png"));
        imgAtaque.add(Ataque2=new GreenfootImage("ComAtk02.png"));
        imgAtaque.add(Ataque3=new GreenfootImage("ComAtk03.png"));

        comandoHeroe=new Heroe();
        comando=0;
        segundo=System.currentTimeMillis();
        indice=0;
        contador=0;

    }

    public void act() 
    {

        comando=comandoHeroe.setCom();

        if(comando==1 && comandoHeroe.getBand()==1)
        {
            if(segundo>1){
                segundo=System.currentTimeMillis();
                setImage(imgAtaque.get(indice));
                indice++;}
            if(indice==2)
                indice=0;
        }
        else if(comando==3 || comando==0){
            if(segundo>1){
                segundo=System.currentTimeMillis();       
                setImage(imgReposo.get(contador));
                contador++;       
            }
            if(comando==2 )
                setImage("Defensa.png");
            if(contador==3)
                contador=0;
        }
        comando=0;
    }

}

