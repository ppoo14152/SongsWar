import greenfoot.*;

/**
 * Escribe una descrición de la clase AyudaP aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class AyudaP extends World
{
    /**
     * Act - hace lo que AyudaP quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public AyudaP() 
    {super(800,600,1);
                // Agrega tus códigos de acción aquí.
           Boton B=new Back();
           addObject(B,600,500);
    }    
}
