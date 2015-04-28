import greenfoot.*;

/**
 * Escribe una descrición de la clase Inicio aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Inicio extends Boton
{
    /**
     * Act - hace lo que Inicio quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
      World w=getWorld();
      
    public void act() 
    { 
       if(Greenfoot.mouseClicked(this))
       {
           w=new Nivel1();
           Greenfoot.setWorld(w);
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
