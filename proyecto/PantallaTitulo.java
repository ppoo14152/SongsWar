import greenfoot.*;

/**
 *Este Mundo es la pantalla principal que se muestra al iniciar el proyeccto
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión 3.0 Mayo 2015
 */
public class PantallaTitulo extends World
{

    /**
     * Constructor para objetos de clase Muro.
     *GreenfootSound music se usa para reproducir la musica que se reproducira
     *en el juego
     */
    private GreenfootSound music;
    public PantallaTitulo()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(800, 600, 1); 
       //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");
       
       //music.setVolume(20);
        titulo t=new titulo();
        Boton b=new Inicio();
        Boton a=new Ayuda();
        Boton r=new Recods();
        addObject(r,380,270);
        addObject(a,490,310);
        addObject(b,270,300);
        addObject(t,350,100);
    }
}
