import greenfoot.*;
import java.util.*;

/**
 * Esta clase define los metodos que usaran todos los heroes, como reducir su vida y 
 * colocar un comando para que los heroes actuen 
 * se declaran una serie de bandras para ejecutar ciertas acciones y definir 
 * los comandos
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión 1.0 abril 2015
   */
public class Heroe extends Actor 
{
    private int comando;
    private int condicionA=0;
    private int condicionB=0;
    private int condicionC=0;
    private int ataque;
    private Comando imgComando;
    private World world;
    private Actor eneAtaque;
    private int dano;
    private int danoTotal;
    private boolean regreso;
    private int bandComando;
    private int resistencia;
   
    /**
     * Constructor de Heroe  
     * aqui se definen las variables principales como el comando 
     * banderas booleanas el daño y la resistencia
     */
    public void Heroe()
    { 
        comando=0;
        regreso=false;
        eneAtaque=new Enemigo();
        dano=0;
        resistencia=0;
    }

    public void act() 
    {

    }  

    /**
     * Este metodo se usa para colocar el metodo que los heroes ejecutaran , se coloca segun 
     * la entrada del teclado , y se redifinira el comando y las banderas para que las animaciones 
     * de los heroes puedan ejecutarse de una manera mas facil
     */
    public int setCom()
    { 
        //Comando ataque qer
        if(Greenfoot.isKeyDown("q"))
            condicionA=1;
        if(condicionA==1){
            if(Greenfoot.isKeyDown("w"))
                condicionB=1;
            if(Greenfoot.isKeyDown("e"))
                condicionC=1;
            if(condicionA==1 && condicionB==0 && condicionC==1){
                if(Greenfoot.isKeyDown("r"))

                    comando=1;
                bandComando=1;
                condicionA=0;
                condicionB=0;
                condicionC=0;

            }
        }                
        if(Greenfoot.isKeyDown("w")){
            condicionB=2;
            if(condicionB==2){
                if(Greenfoot.isKeyDown("r")){
                    condicionC=2;
                    condicionA=2;}
                if(Greenfoot.isKeyDown("e"))
                    condicionA=0;
                if(Greenfoot.isKeyDown("q"))

                    comando=2;
                condicionA=0;
                condicionB=0;
                condicionC=0;
            }}
        if(Greenfoot.isKeyDown("space")){
            comando=5;
            condicionA=0;
            condicionB=0;
            condicionC=0;

        }

        if(!Greenfoot.isKeyDown("r")){
            bandComando=3;
        }

        if(regreso==true){
            comando=3;
            regreso=false;
        }
        return bandComando;

    }

    /**
     * Este metodo recibe como parametro la resistencia del enemigo la cual
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     * @param Resistencia
     * @return DaanoTotal
     */
    public int restaSalud(int resistencia)
    {
        String NombreClass;
        eneAtaque=getOneIntersectingObject(Enemigo.class);
        NombreClass=eneAtaque.getClass().getName();
        if(NombreClass== "Coloso"){
            dano=((Coloso)eneAtaque).getAtk();}

        if(NombreClass=="Kraken"){
            dano=((Kraken)eneAtaque).getAtk();
        }   

        danoTotal=resistencia-dano;        
        return danoTotal;
    }

    /**
     * Regresa cierto o falso si se toca con otro actor
     */

    public boolean getTouch()
    {
        if(this.isTouching(Muro.class))
            return true;
        else
            return false;
    }

    /**
     *@return Reg regresa una bandera para poder activar una animacion de los heroes
     */
    public boolean getReg()
    {
        return regreso;
    }

    /**
     *@param R se coloca una nueva bandera
     */
    public void setReg(boolean r)
    {
        regreso=r;
    }
    /**
     * @return band regresa una bandera
     */
    public int getBand()
    {
        return bandComando;
    }
    /**
     * @return comando regresa el comando establecido
     */
    public int getComando()
    {
        return comando;
    }
    /**
     * @param recibe como parametro un nuevo daño
     */
    public void setDano(int d)
    {
        danoTotal=d;
    }


}
