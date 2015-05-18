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
    
    
    public PantallaEspera(int Nivel,int p)
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(800, 600, 1);
        continuar=new Continuar(Nivel,p);
        showText("Da click para continuar",400,300);
        addObject(continuar,400,350);
        
        
        
    }
}
