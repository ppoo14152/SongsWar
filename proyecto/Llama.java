import greenfoot.*;
import java.util.*;
/**
 * Esta clase es uso de la clase Dragon 
 * ejecuta una animacion y tiene guardad en una lista las imagenes correspondientes
 * para esta
 * 
 * @autor Omar Agustin Valadez Hernandes
 * @versión Mayo 2015
 */
public class Llama extends Actor
{
    /**
     * Act - hace lo que Llama quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    private LinkedList<GreenfootImage> imgAtkLlama;
    private GreenfootImage Llama1;
    private GreenfootImage Llama2;
    private GreenfootImage Llama3;
    private GreenfootImage Llama4;
    private int i;
    private boolean band;
    private long seg;  
    private World w;
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        w=getWorld();
    } 

    /**
     * constructor de Llama 
     * aqui se cargan las lista con sus respectivas imagenes 
     */
    public Llama()
    {
        imgAtkLlama=new LinkedList<GreenfootImage>();
        imgAtkLlama.add(Llama1=new GreenfootImage("llama04.png"));
        imgAtkLlama.add(Llama2=new GreenfootImage("llama03.png"));
        imgAtkLlama.add(Llama3=new GreenfootImage("llama04.png"));
        imgAtkLlama.add(Llama4=new GreenfootImage("llama04.png"));
        seg=System.currentTimeMillis();
        i=0;
    }

    /**
     * seleccionea 
     * las imagenes para la animacion
     */
    public void Image()
    {
        int y=getY();

        this.setImage(imgAtkLlama.get(i));
        i++;
        this.setLocation(getX(),y);
        y++;
        if(i==4)
            i=0;
    }
}

