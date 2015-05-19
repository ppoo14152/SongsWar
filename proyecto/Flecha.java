import greenfoot.*;
import java.util.*;
/**
 * Esta clase es usada por un arquero 
 * se declara un arquero nuevo para obtener asi su  ataque 
 * y una lista para checar si se intersecciona con otro objecto 
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Flecha extends Actor
{
    /**
     * Act - hace lo que Flecha quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    private Arquero h;
    private Heroe h1;
    private int Atk;
    private int Com;
    private List Arq;
    private World w;
    /**
     * Constructor de Flecha , define las variables de instancia
     */
    public Flecha()
    {
        h=new Arquero();
        h1=new Heroe();
        Atk=0;
        Com=0;
    }
    public void act() 
    {
        w=getWorld();
        Arq=w.getObjects(Arquero.class);
        int x=getX();
       Com=h1.setCom();
       if(Com==1)
       {    Atk=h.getAtk();
            move(250);
            
        }
        if(x>750)
        setLocation(150,500);
        x++;
        if(Arq.isEmpty())
        w.removeObject(this);
    }   
    /**
     * @return Atk regresa el ataque del arquero
     */
    public int getAtk()
    {
        return Atk;
    }
}
