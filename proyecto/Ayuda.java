import greenfoot.*;

/**
 *Esta clase sirve para poder ir a la pantalla de ayuda 
 *para poder consultar informacion acerca del juego 
 * @autor Omar Agustin Valadez Hernandez
 * @versión 3.0 Mayo 2015 
 */
public class Ayuda extends Boton
{
  
    World world=getWorld();
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        if(Greenfoot.mouseClicked(this))
        {
            world=new AyudaP();
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("botonA2.png");
        }
        else if(Greenfoot.mouseMoved(world))
       {
            setImage("botonA.png");
       }
    }  
}
