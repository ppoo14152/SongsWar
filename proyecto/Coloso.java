import greenfoot.*;
import java.util.*;

/**
 * Esta clase es el Enemigo del primer Nivel
 * se declaran su Ataque
 * defensa
 * una serie de bandera booleanas para  ejecutar ciertas acciones
 * vida la cual sirve para poder eliminar el enemigo
 * Una lista para ejecutar la animacion del enemigo
 * listas para saber que actores ya no exsisten en el mundo
 * una variable de tiempo para poder animar al enemigo
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Coloso extends Enemigo
{
    private int ideAtaque;
    private int ataque;
    private int defensa;
    private int dano;
    private int indice;
    private boolean bandAtaque;
    private boolean desaparece;
    private int comando;
    private World world;//mundo  para obetenr objetos de el
    private Vida vida;//vida
    private Heroe heroe;//heroe
    private Actor heroAtaque;
    private LinkedList<GreenfootImage> enemigo;//lista de animacion enemigo
    private GreenfootImage Coloso1;//imagen
    private GreenfootImage Coloso2;//imagen
    private GreenfootImage Coloso3;//imagen
    private List muro;//lista para guargar actores del mundo
    private List heroeLista;
    private List puntos;
    private long segundo;
    private GreenfootSound SonidoAtk;
    /**
     * Es el constructor , en se declara todas las variables de intancia ya 
     * mencionadas arriba
     * se carga en las lista las imagenes y se definen los valores de 
     * las demas variables
     */
    public Coloso()
    {
        ataque=20;
        defensa=200;
        dano=0;
        ideAtaque=0;
        indice=0;
        comando=1;

        bandAtaque=false;        
        heroAtaque=new Heroe();
        heroe=new Heroe();
        vida=new Vida(1000);    
        enemigo=new LinkedList<GreenfootImage>();
        enemigo.add(Coloso1=new GreenfootImage("Coloso01.png"));
        enemigo.add(Coloso2=new GreenfootImage("Coloso02.png"));
        enemigo.add(Coloso3=new GreenfootImage("Coloso03.png"));
        segundo=System.currentTimeMillis();

        SonidoAtk= new GreenfootSound("golpear_7.mp3");
    }

    public void act() 
    {
        world=getWorld();

        muro=world.getObjects(Muro.class);
        heroeLista=world.getObjects(Heroe.class);

        int bandRegreso=heroe.setCom();
        if(heroeLista.isEmpty()){
            World gameO=new GameOver();//mundo para dar un game over
            Greenfoot.setWorld(gameO);
        }
        if(muro.isEmpty()){
            if(comando==1 && bandAtaque==false)
                ataque();

            if(this.isTouching(Heroe.class)){
                SonidoAtk.play();
                if( bandRegreso==1){
                    dano=super.restaSalud(defensa);
                    desaparece=vida.reduce(dano,vida.getImage(),1);
                }
                if(!this.isTouching(Heroe.class))
                    SonidoAtk.stop();
            }
            if(desaparece==false)
                world.addObject(vida,500,600);
            else if(desaparece==true) {
                puntos=world.getObjects(Puntos.class);
                Object puntuacion=puntos.get(0);
                int punt=((Puntos)puntuacion).getPuntos();
                world.removeObject(vida);
                world.removeObject(this);
                World nivel=new PantallaEspera(2,punt);

                Greenfoot.setWorld(nivel);
            }
            if(bandAtaque==true && desaparece==false){
                regreso();
                comando=0;                
            }
            int numero=Greenfoot.getRandomNumber(50);
            if(numero==1 || numero==25)
                comando=1;

        }}    
    /**
     * Este metodo sirve para que  el enimgo pueda atacar 
     * este enemigo usa animacionn al atacar 
     * utiliza un indice el cual ira cambiando las imagenes que estan guardadas
     * en la lista para animar 
     * y utila un move para poder moverse
     * regresa una bandera para que el enemigo pueda regreasar a su posicion original
     */
    public void ataque()
    {
        int x=getX();
        if(segundo>1 && x>150)
        {
            segundo=System.currentTimeMillis();
            setImage(enemigo.get(indice));
            move(-50);
            indice++;
            if(indice==2)
                indice=0;
            x++;
        }
        if(x==150)
            bandAtaque=true; 
    }

    /**
     * Este metodo pone en la posicion original a este enemigo
     */

    public void regreso()
    {
        int x=getX();
        if(segundo>1 && x<750 && bandAtaque)
        {

            setImage(enemigo.get(0));
            move(100);
            x++;
        }
        else{
            setImage(enemigo.get(0));
            move(0);
            bandAtaque=false;
        }
    }

    /**
     * Este metodo regresa el ataque de este Enemigo
     * @return Atk ataque del enemigo
     */
    public int getAtk()
    {
        return ataque;
    }

}
