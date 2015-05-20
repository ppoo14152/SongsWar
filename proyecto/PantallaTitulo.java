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
     * Constructor para objetos de clase PantallaTitulo.
     *Se declaran principalmente botones que nos serviran para acceder al juego 
     *u otras caracteristicas
     */
 
    public PantallaTitulo()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(800, 600, 1); 
       //Greenfoot.playSound("Lindsey Stirling - Elements.mp3");
       
       //music.setVolume(20);
        titulo titulo=new titulo();
        Boton iniciar=new Inicio();
        Boton ayuda=new Ayuda();
        Boton record=new Recod();
        addObject(record,380,270);
        addObject(ayuda,490,310);
        addObject(iniciar,270,300);
        addObject(titulo,350,100);
    }
}
