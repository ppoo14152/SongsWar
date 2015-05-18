import greenfoot.*;

/**
 * En esta clase se añanade todo lo que tiene  el Mundo del Nivel 2 
 * Heroe con esta clase declaramos a los tres Heroes que podremos controlar
 * Flecha esta clase usa el ataque del Heroe -Arquero para causar daño
 * Puntos con esta clase se añaden llos puntos en el mundo para que podamos llevar la cuenta y el tiempo que tardemos 
 * @autor Omar Agustin Valadez Hernandez 
 * @versión Mayo de 2015
 */
public class Nivel2 extends World
{

    /**
     * Constructor para objetos de clase Nivel2.
     * 
     */
    private GreenfootSound music;
    
    public Nivel2(int score)
    {    
        super(800, 600, 1); 

        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Heroe ar=new Arquero();
        Flecha f=new Flecha();
        Muro a=new Atalaya();
        Enemigo kr=new Kraken();
        Comando com=new Comando();
        Puntos p=new Puntos(score);
        score=p.getPuntos();
        System.out.println(score);
        addObject(f,150,500);    
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);

        addObject(p,100,200);
        addObject(com,550,100);
        addObject(a,500,450);
        addObject(kr,600,500);
        addObject(cab,200,500);
        addObject(es,250,500);  
        addObject(ar,150,500);

    }
}
