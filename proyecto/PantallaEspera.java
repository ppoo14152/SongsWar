import greenfoot.*;

/**
 * Este mundo se llama cada vez que pasamos a otro nivel 
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class PantallaEspera extends World
{

    /**
     * Constructor para objetos de clase PantallaEspera.
     * El constructor Recibe como parametro un Entero el cual sera el nivel que seguira a colocar
     */
    
    private Boton continuar;
    
    public PantallaEspera(int Nivel)
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(600, 400, 1);
        continuar=new Continuar(Nivel);
        showText("Da click para continuar",300,100);
        addObject(continuar,300,200);
        
        
        
    }
}
