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
    private int a=0;
    private int b=0;
    private int c=0;
    private int Atk;
    private Comando imgCom;
    private World w;
    
    private int i;
    private Actor eneAtk;
    private int Dano;
    private int DanoTotal;
    private boolean Reg;
    private int band;
    private boolean band2;
    private int Resistencia;
    private List H;
    /**
     * Constructor de Heroe  
     * aqui se definen las variables principales como el comando 
     * banderas booleanas el daño y la resistencia
     */
    public void Heroe()
    { 
        comando=0;
        imgCom=new Comando();
        Reg=false;
        eneAtk=new Enemigo();
        Dano=0;
        Resistencia=0;

        i=0;
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
        String Tecla;
        Tecla=Greenfoot.getKey();
        if(Greenfoot.isKeyDown("q"))
            a=1;
        if(a==1){
            if(Greenfoot.isKeyDown("w"))
                b=1;
            if(Greenfoot.isKeyDown("e"))
                c=1;
            if(a==1 && b==0 && c==1){
                if(Greenfoot.isKeyDown("r"))

                    comando=1;
                band=1;
                a=0;
                b=0;
                c=0;

            }}                
        if(Greenfoot.isKeyDown("w")){
            b=2;
            if(b==2){
                if(Greenfoot.isKeyDown("r")){
                    c=2;
                    a=2;}
                if(Greenfoot.isKeyDown("e"))
                    a=0;
                if(Greenfoot.isKeyDown("q"))

                    comando=2;
                a=0;
                b=0;
                c=0;
            }}
        if(Greenfoot.isKeyDown("space")){
            comando=5;
            a=0;
            b=0;
            c=0;

        }

        if(!Greenfoot.isKeyDown("r")){
            band=3;
        }

        if(Reg==true){
            comando=3;
            Reg=false;}
        return band;

    }

    /**
     * Este metodo recibe como parametro la resistencia del enemigo la cual
     * se contrarrestara para hacer un menor daño 
     * se captura el nombre de la clse que se intersecciona y de acuerdo a el se añande un daño 
     * el cual se restara
     * @param Resistencia
     * @return DaanoTotal
     */
    public int restaSalud(int Resistencia)
    {
        String NombreClass;
        eneAtk=getOneIntersectingObject(Enemigo.class);
        NombreClass=eneAtk.getClass().getName();
        if(NombreClass== "Coloso"){
            Dano=((Coloso)eneAtk).getAtk();}

        if(NombreClass=="Kraken"){
            Dano=((Kraken)eneAtk).getAtk();
        }   

        DanoTotal=Resistencia-Dano;        
        return DanoTotal;
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
        return Reg;
    }

    /**
     *@param R se coloca una nueva bandera
     */
    public void setReg(boolean R)
    {
        Reg=R;
    }
    /**
     * @return band regresa una bandera
     */
    public int getBand()
    {
        return band;
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
        DanoTotal=d;
    }


}
