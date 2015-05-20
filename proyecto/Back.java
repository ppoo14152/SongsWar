import greenfoot.*;

/**
 * Esta clase sirve para regresar a la pantalla de titulo
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Back extends Boton
{
    /**
     * Act - hace lo que Back quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    World world=getWorld();
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            world=new PantallaTitulo();
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("back.png");
        }
        else if(Greenfoot.mouseMoved(world))
       {
            setImage("back.png");
       }
    }    
}
