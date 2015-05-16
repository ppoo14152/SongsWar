import greenfoot.*;

/**
 * Escribe una descrición de la clase puntaje aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class puntaje extends World
{

    /**
     * Constructor para objetos de clase puntaje.
     * 
     */
    public puntaje()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(1280, 720, 1); 
        ScoreBoard sp=new ScoreBoard(500,300);
        addObject(sp,553,304);
    }
}
