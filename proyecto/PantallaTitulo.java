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
        super(960, 544, 1); 
       //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");
       music=new GreenfootSound("17 Starfleet.mp3");
       music.play();
       music.setVolume(15);
        titulo t=new titulo();
        Boton b=new Inicio();
        Boton a=new Ayuda();
        Boton r=new Recods();
        addObject(r,450,260);
        addObject(a,600,300);
        addObject(b,300,300);
        addObject(t,450,100);
    }
}
