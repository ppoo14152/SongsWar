import greenfoot.*;

/**
 * Escribe una descrición de la clase Recods aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Recods extends Boton
{
    /**
     * Act - hace lo que Recods quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
       World w=getWorld();
      
       
       if(Greenfoot.mouseClicked(this))
       {
           w=new puntaje();
           Greenfoot.setWorld(w);
       
       }
        if(Greenfoot.mouseMoved(this))
        {
            setImage("botonR2.png");
        }
        else if(Greenfoot.mouseMoved(w))
       {
            setImage("botonR.png");
       }
      
    }  
    }    

