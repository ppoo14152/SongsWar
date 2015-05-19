import greenfoot.*;


/**
 * En este Mundo se encuentran los records del jugador 
 * 
 * Se añanade a un Boton de Regreso para poder volver a la pantalla de titulo
 * 
 * @autor Omar Agustin Valadez Hernandez 
 * @versión Mayo de 2015
 */
public class puntaje extends World
{

    /**
     * Constructor para objetos de clase puntaje.
     * Se declara un score board  y se añanade al mundo
     */
    private Boton back;
    public puntaje()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(800, 600, 1); 
        ScoreBoard sp=new ScoreBoard(500,300);
        back=new Back();
        addObject(back,600,600);
        addObject(sp,400,300);
    }
}
