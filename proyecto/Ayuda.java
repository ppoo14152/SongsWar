import greenfoot.*;

/**
 *Esta clase sirve para poder ir a la pantalla de ayuda 
 *para poder consultar informacion acerca del juego 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Ayuda extends Boton
{
  
    World w=getWorld();
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        if(Greenfoot.mouseClicked(this))
        {
            w=new AyudaP();
            Greenfoot.setWorld(w);
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("botonA2.png");
        }
        else if(Greenfoot.mouseMoved(w))
       {
            setImage("botonA.png");
       }
    }  
}
