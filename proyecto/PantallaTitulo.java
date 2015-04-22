import greenfoot.*;

/**
 * Escribe una descrición de la clase Muro aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class PantallaTitulo extends World
{

    /**
     * Constructor para objetos de clase Muro.
     * 
     */
    public PantallaTitulo()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(960, 544, 1); 
        //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");
        titulo t=new titulo();
        Boton b=new Inicio();
        Boton a=new Ayuda();
        addObject(a,600,300);
        addObject(b,300,300);
        addObject(t,450,100);
    }
}
