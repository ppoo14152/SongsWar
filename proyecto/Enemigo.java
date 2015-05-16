import greenfoot.*;

/**
 * Escribe una descrición de la clase Enemigo aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Enemigo extends Actor
{
    private Actor heroAtk;
    private int DanoEs;
    private int DanoCab;
    private int DanoTotal;
    private int Resistencia;
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
    }    
    public Enemigo()
    {
        heroAtk=new Heroe();
        DanoEs=0;
        DanoCab=0;
        DanoTotal=0;
        Resistencia=0;
    }
    public int restaSalud(int Resistencia)
    {
        String NombreClass;
        heroAtk=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtk.getClass().getName();
        if(NombreClass== "Espadachin"){
            DanoEs=((Espadachin)heroAtk).getAtk();
            
        }
        else if(NombreClass=="Caballero"){
            DanoCab=((Caballero)heroAtk).getAtk();
        }
        DanoTotal=Resistencia-(DanoEs+DanoCab);        
        
        return DanoTotal;
    }
    public void setResistencia(int Res)
    {
        Resistencia=Res;
    }
}
