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
private boolean B;
    /**
     * Constructor para objetos de clase esenario.
     * 
     */
    public Nivel1()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(990, 657, 1); 
        //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");

        Espadachin es=new Espadachin();
        Heroe cab=new Caballero();
        Muro p=new Pared(100,A,B);
        B=es.getTouch();
        A=es.getAtk();
        System.out.print(A);
        addObject(p,550,500);
        addObject(cab,200,500);
        addObject(es,250,500);
        
        
    }

}