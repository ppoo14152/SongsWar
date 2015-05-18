import greenfoot.*;


/**
 * En esta clase se añanade todo lo que tiene  el Mundo del Nivel 2 
 * Heroe con esta clase declaramos a los tres Heroes que podremos controlar
 * Flecha esta clase usa el ataque del Heroe -Arquero para causar daño
 * Puntos con esta clase se añaden llos puntos en el mundo para que podamos llevar la cuenta y el tiempo que tardemos 
 * @autor Omar Agustin Valadez Hernandez 
 * @versión Mayo de 2015
 */
public class Nivel3 extends World
{

    /**
     * Constructor para objetos de clase Nivel3.
     * 
     */
    private GreenfootSound music;
    public Nivel3()
    {    
       super(800, 600, 1); 
        
       
        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Heroe ar=new Arquero();
        Muro t=new Torreon();
        Flecha f=new Flecha();
        Comando com=new Comando();
        Enemigo d=new Dragon();
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);
         Puntos p=new Puntos();
        addObject(ar,150,500);
        addObject(f,150,500);        
        addObject(p,100,200);
        addObject(d,800,300);
        addObject(com,550,100);
        addObject(t,550,500);
        addObject(cab,200,500);
        addObject(es,250,500);
    }
}
