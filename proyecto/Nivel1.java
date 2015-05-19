import greenfoot.*;
import java.util.*;

/**
 * En esta clase se añanade todo lo que tiene  el Mundo del Nivel 1
 * Heroe con esta clase declaramos a los tres Heroes que podremos controlar
 * Flecha esta clase usa el ataque del Heroe -Arquero para causar daño
 * Puntos con esta clase se añaden llos puntos en el mundo para que podamos llevar la cuenta y el tiempo que tardemos 
 * @autor Omar Agustin Valadez Hernandez 
 * @versión Mayo de 2015
 */
public class Nivel1 extends World
{
private GreenfootSound music;
    /**
     * Constructor para objetos de clase Nivel 1 
     * en ella se colocan todos lo elementos que estaran en el mundo en el nivel 1
     * @param score recibe como parametro la puntuacion acumulada
     */
    private int score;
    public Nivel1(int score)
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(900, 700, 1); 
        
        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Heroe ar=new Arquero();
        Muro p=new Pared();
        Flecha f=new Flecha();
              
        Enemigo enem=new Coloso();
        Comando com=new Comando();
        Puntos punt=new Puntos(score);
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);
        score=punt.getPuntos();
        
        
        addObject(f,150,500);        
        addObject(punt,100,200);
        addObject(com,550,100);
        addObject(p,550,500);
        addObject(cab,200,500);
        addObject(es,250,500);
        addObject(ar,150,500);
        addObject(enem,750,500);
        
       
        
        
    }
  
    
       

}