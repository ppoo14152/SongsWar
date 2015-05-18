import greenfoot.*;

/**
 * Esta clase sirve para iniciar el juego al precionarlo
 * se le pasa porparametro unn nivel al mundo que obtiene la variable w
 * @autor Omar Agustin Valadez Hernanddez
 * @versión Mayo  2015
 */
public class Inicio extends Boton
{
    /**
     * Act - hace lo que Inicio quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    World w=getWorld();
    private GreenfootSound music;
    public Inicio()
    {
        music=new GreenfootSound("17 Starfleet.mp3");
    }
       
    public void act() 
    { 
        if(Greenfoot.mouseClicked(this))
        {
            w=new PantallaEspera(1,0);
            Greenfoot.setWorld(w);
            music=new GreenfootSound("17 Starfleet.mp3");
            music.play();
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("boton2.png");

        }
        else if(Greenfoot.mouseMoved(w))
        {
            setImage("boton.png");
        }
    }    
}
