import greenfoot.*;

/**
 * Escribe una descrición de la clase Muro aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Muro extends Actor
{
    private int Resistencia;
    private int DanoTotal;
    private int DanoEs;
    private int DanoCab;
    private int DanoArq;
    private Actor heroAtk;
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        
    }    
    public Muro ()
    {
        Resistencia=0; 
        DanoTotal=0;
        DanoEs=0;
        DanoCab=0;
        DanoArq=0;
        heroAtk=new Heroe();
    }    
    public int restaSalud()
    {
        String NombreClass;
        

        //V.reduceVid(DanoTotal);

        heroAtk=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtk.getClass().getName();
        if(NombreClass== "Espadachin"){
            DanoEs=((Espadachin)heroAtk).getAtk();
            NombreClass=null;
        }
        if(NombreClass=="Caballero"){
            DanoCab=((Caballero)heroAtk).getAtk();
              NombreClass=null;}
        DanoTotal=Resistencia-DanoEs-DanoCab;
        
        
        return DanoTotal;
    }
    public void setDano(int Dano)
    {
        DanoTotal=Dano;
    }
    public  void setRes(int R)
    {
        Resistencia=R;
    }
}
