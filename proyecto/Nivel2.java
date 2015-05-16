import greenfoot.*;

/**
 * Escribe una descrición de la clase Nivel2 aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Nivel2 extends World
{

    /**
     * Constructor para objetos de clase Nivel2.
     * 
     */
    public Nivel2()
    {    
      super(990, 660, 1); 
        //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");

        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Muro a=new Atalaya();
        Enemigo kr=new Kraken();
        Comando com=new Comando();
        Puntos p=new Puntos();
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);
        
        addObject(p,100,200);
        addObject(com,550,100);
        addObject(a,500,450);
        addObject(kr,680,500);
        addObject(cab,200,500);
        addObject(es,250,500);  
    }
}
