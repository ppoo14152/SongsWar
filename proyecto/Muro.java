import greenfoot.*;

/**
 * Esta clase sirve para ejecutar los metodos  para reducir la vida de todos
 * los muros en el mundo 
 * aqui se definen la resistencia y el daño final que se colocaran a los muros existentes 
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión 1.0 Abril 2015
 */
public class Muro extends Actor
{
    private int Resistencia;
    private int DanoTotal;
    private int Dano;
    private Actor heroAtk;
    public void act() 
    {
        // Agrega tus códigos de acción aquí.

    }  

    /**
     * Constructor del Muro, aqui se definen  las variables de instacia y se declara un heroe
     * para sabber su nombre y si esta tocando a un muro 
     */
    public Muro ()
    {
        Resistencia=0; 
        DanoTotal=0;
        Dano=0;
        heroAtk=new Heroe();
    }    

    /**
     * Este metodo recibe como parametro la resistencia del enemigo la cual
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     */
    public int restaSalud()
    {
        String NombreClass;

        //V.reduceVid(DanoTotal);
        heroAtk=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtk.getClass().getName();
        if(NombreClass== "Espadachin"){
            Dano=((Espadachin)heroAtk).getAtk();
            NombreClass=null;
        }
        if(NombreClass=="Caballero"){
            Dano=((Caballero)heroAtk).getAtk();
            NombreClass=null;}
        if(NombreClass=="Flecha"){
            Dano=((Arquero)heroAtk).getAtk();
            NombreClass=null;}
        DanoTotal=Resistencia-Dano;

        return DanoTotal;
    }

    /**
     * este metodo coloca el nuevo daño 
     */
    public void setDano(int Dano)
    {
        DanoTotal=Dano;
    }

    /**
     * Este metodo coloca la nueva resistenciaa 
     */
    public  void setRes(int R)
    {
        Resistencia=R;
    }
}
