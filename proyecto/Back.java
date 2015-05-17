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
    World w=getWorld();
    public void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            w=new PantallaTitulo();
            Greenfoot.setWorld(w);
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("back.png");
        }
        else if(Greenfoot.mouseMoved(w))
       {
            setImage("back.png");
       }
    }    
}
