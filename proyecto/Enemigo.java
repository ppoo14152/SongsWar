import greenfoot.*;

/**
 *En esta clase se definen los metodos que todos los enemigos usaran 
 *se declaran las variables de instancia que son para el daño que se les restara a los enemigos
 *resta la salud de los enemigos 
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Enemigo extends Actor
{
    private Actor heroAtaque;
    private int danoEspadachin;
    private int danoCaballero;
    private int danoTotal;
    private int resistencia;
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
    } 

    /**
     * Constructor de clase Enemigo 
     * Se definen las  variables de instanci
     * inicializando todas en cero
     * exepto heroAtk que se tiene que declarar un Actor
     */

    public Enemigo()
    {

        heroAtaque=new Heroe();
        danoEspadachin=0;
        danoCaballero=0;
        danoTotal=0;
        resistencia=0;
    }

    /**
     * @param Resistencia Este metodo recibe como parametro la resistencia del enemigo la cual
     * @return DanoTotal es el daño total que se tendra que restar a la vida
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     */
    public int restaSalud(int resistencia)
    {
        String NombreClass;

        heroAtaque=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtaque.getClass().getName();

        if(NombreClass== "Espadachin"){
            danoEspadachin=((Espadachin)heroAtaque).getAtk();

        }
        if(NombreClass=="Caballero"){
            danoCaballero=((Caballero)heroAtaque).getAtk();
        }
        danoTotal=resistencia-danoEspadachin-danoCaballero;        
        System.out.println(NombreClass);
        return danoTotal;
    }

    /**
     * Este metodo coloca una resistencia x al enemigo
     * @param Resibe com parametro una ueva resistencia
     */

    public void setResistencia(int res)
    {
        resistencia=res;
    }
}
