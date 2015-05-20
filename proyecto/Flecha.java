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
    private Arquero arquero;
    private Heroe heroe;
    private int ataque;
    private int comando;
    private List arqueroList;
    private World world;
    /**
     * Constructor de Flecha , define las variables de instancia
     */
    public Flecha()
    {
        arquero=new Arquero();
        heroe=new Heroe();
        ataque=0;
        comando=0;
    }
    public void act() 
    {
        world=getWorld();
        arqueroList=world.getObjects(Arquero.class);
        int x=getX();
       comando=heroe.setCom();
       if(comando==1)
       {    ataque=arquero.getAtk();
            move(250);
            
        }
        if(x>750)
        setLocation(150,500);
        x++;
        if(arqueroList.isEmpty())
        world.removeObject(this);
    }   
    /**
     * @return Atk regresa el ataque del arquero
     */
    public int getAtk()
    {
        return ataque;
    }
}
