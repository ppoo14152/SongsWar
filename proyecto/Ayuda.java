import greenfoot.*;

/**
 * Escribe una descrición de la clase Ayuda aquí.
 * 
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
