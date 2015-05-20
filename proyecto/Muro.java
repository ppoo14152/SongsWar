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
    private int resistencia;
    private int danoTotal;
    private int dano;
    private Actor heroAtaque;
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
        resistencia=0; 
        danoTotal=0;
        dano=0;
        heroAtaque=new Heroe();
    }    

    /**
     * Este metodo recibe como parametro la resistencia del enemigo la cual
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     * @return DanoTotal regresa el daño que se restara a la resistencia del muro
     */
    public int restaSalud()
    {
        String NombreClass;

        //V.reduceVid(DanoTotal);
        heroAtaque=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtaque.getClass().getName();
        if(NombreClass== "Espadachin"){
            dano=((Espadachin)heroAtaque).getAtk();
            NombreClass=null;
        }
        if(NombreClass=="Caballero"){
            dano=((Caballero)heroAtaque).getAtk();
            NombreClass=null;}
        if(NombreClass=="Flecha"){
            dano=((Arquero)heroAtaque).getAtk();
            NombreClass=null;}
        danoTotal=resistencia-dano;

        return danoTotal;
    }

    /**
     * este metodo coloca el nuevo daño 
     * @param dano recibe un nuevo daño
     */
    public void setDano(int dano)
    {
        danoTotal=dano;
    }

    /**
     * Este metodo coloca la nueva resistenciaa 
     */
    public  void setRes(int r)
    {
        resistencia=r;
    }
}
