import greenfoot.*;

/**
 * Escribe una descrición de la clase esenario aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Nivel1 extends World
{
private GreenfootSound music;
    /**
     * Constructor para objetos de clase esenario.
     * 
     */
    public Nivel1()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(990, 660, 1); 
        music=new GreenfootSound("sounds/Future_World_Music_Pulse_of_Life-Larger_Than_Life(www.mp3vip.org).mp3");
        music.play();
        Heroe es=new Espadachin();
        Heroe cab=new Caballero();
        Muro p=new Pared();
        Enemigo enem=new Coloso();
        Comando com=new Comando();
        Puntos punt=new Puntos();
        showText("Ataque",50,50);
        showText("Q-E-R",50,70);
        showText("Defensa",50,100);
        showText("W-E-Q",50,120);
        addObject(punt,100,200);
        addObject(com,550,100);
        addObject(p,550,500);
        addObject(cab,200,500);
        addObject(es,250,500);
        addObject(enem,750,500);
        
        
    }
    public void Remueve(Actor a)
    {
        removeObject(a);
    }
    
       

}