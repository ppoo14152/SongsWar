import greenfoot.*;

/**
 * Escribe una descrición de la clase Nivel3 aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Nivel3 extends World
{

    /**
     * Constructor para objetos de clase Nivel3.
     * 
     */
    public Nivel3()
    {    
       super(990, 657, 1); 
        //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");

        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Muro p=new Pared();
        Comando com=new Comando();
        
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);
        
        addObject(com,550,100);
        addObject(p,550,500);
        addObject(cab,200,500);
        addObject(es,250,500);
    }
}
