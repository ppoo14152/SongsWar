import greenfoot.*;

/**
 * Esta clase sirve para poder revisar las puntuaciones del jugador
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Recod extends Boton
{
    /**
     * Act - hace lo que Recods quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
        World world=getWorld();

        if(Greenfoot.mouseClicked(this))
        {
            world=new Puntaje();
            Greenfoot.setWorld(world);

        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("botonR2.png");
        }
        else if(Greenfoot.mouseMoved(world))
        {
            setImage("botonR.png");
        }

    }  
}    

