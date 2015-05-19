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
    private Actor heroAtk;
    private int DanoEs;
    private int DanoCab;
    private int DanoAr;
    private int DanoTotal;
    private int Resistencia;
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

        heroAtk=new Heroe();
        DanoEs=0;
        DanoCab=0;
        DanoAr=0;
        DanoTotal=0;
        Resistencia=0;
    }

    /**
     * @param Resistencia Este metodo recibe como parametro la resistencia del enemigo la cual
     * @return DanoTotal es el daño total que se tendra que restar a la vida
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     */
    public int restaSalud(int Resistencia)
    {
        String NombreClass;

        heroAtk=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtk.getClass().getName();

        if(NombreClass== "Espadachin"){
            DanoEs=((Espadachin)heroAtk).getAtk();

        }
        if(NombreClass=="Caballero"){
            DanoCab=((Caballero)heroAtk).getAtk();
        }
        DanoTotal=Resistencia-DanoEs-DanoCab;        
        System.out.println(NombreClass);
        return DanoTotal;
    }

    /**
     * Este metodo coloca una resistencia x al enemigo
     * @param Resibe com parametro una ueva resistencia
     */

    public void setResistencia(int Res)
    {
        Resistencia=Res;
    }
}
