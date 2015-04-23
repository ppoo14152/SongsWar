import greenfoot.*;

/**
 * Escribe una descrición de la clase esenario aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Nivel1 extends World
{
private int A;
private int D;

    /**
     * Constructor para objetos de clase esenario.
     * 
     */
    public Nivel1()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(990, 657, 1); 
        Greenfoot.playSound("Lindsey Stirling - Elements.mp3");
        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        addObject(cab,200,500);
        addObject(es,250,500);
        
    }

}