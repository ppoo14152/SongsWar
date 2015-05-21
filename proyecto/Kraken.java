import greenfoot.*;
import java.util.*;
/**
 * Esta clase es el Enemigo del segundo Nivel
 * se declaran su Ataque
 * defensa
 * una serie de bandera booleanas para  ejecutar ciertas acciones
 * vida la cual sirve para poder eliminar el enemigo
 * Una lista para ejecutar la animacion del enemigo
 * listas para saber que actores ya no exsisten en el mundo
 * una variable de tiempo para poder animar al enemigo
 * @see java.util.*; para hacer uso de listas para hacer la animacion del Actor
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Kraken extends Enemigo
{
    private GreenfootImage kraken1;//imagen
    private GreenfootImage kraken2;
    private GreenfootImage kraken3;
    private GreenfootImage krakenAtk1;
    private GreenfootImage krakenAtk2;
    private GreenfootImage krakenAtk3;
    private LinkedList<GreenfootImage> imgReposo;//lista para animacion de reposo
    private LinkedList<GreenfootImage> imgAtaque;//lista para animacion de ataque
    private World world;//mundo para obtener actores de el
    private Vida vida;//vida
    private Heroe heroe;//heroe
    private List puntos;
    private long segundo;
    private boolean bandAnimacion;//banderas
    private boolean desaparece;
    private int identificadorI;//contadores o indices
    private int identificadorJ;
    private int dano;//daño
    private int num;
    private int ataque;
    private int defensa;
    private List muroList;//lista para guardar actores 
    private List heroeList;
    private GreenfootSound SonidoAtk;

    /**
     * Este es el Constructor del Enemigo, en el se definira  las variables de instancia y 
     * cargaran en la s listas ,las imagenes para la  animacion del enemigo 
     * se define el sonido para cuando el enemigo toca a un heroe y una
     * variable de tiempo para poder animar al enemigo
     */
    public Kraken()
    {
        ataque=40;
        defensa=100;
        dano=0;
        vida=new Vida(900);
        heroe=new Heroe();
        imgReposo=new LinkedList<GreenfootImage>();
        imgAtaque=new LinkedList<GreenfootImage>();
        //imgRep.add(Kraken1=new GreenfootImage("Kraken01.png"));
        imgReposo.add(kraken2=new GreenfootImage("Kraken02.png"));
        imgReposo.add(kraken3=new GreenfootImage("Kraken03.png"));
        imgAtaque.add(krakenAtk1=new GreenfootImage("KrakenAtk01.png"));
        imgAtaque.add(krakenAtk2=new GreenfootImage("KrakenAtk02.png"));
        imgAtaque.add(krakenAtk3=new GreenfootImage("KrakenAtk03.png"));
        identificadorI=0;  
        identificadorJ=0;
        bandAnimacion=false;
        num=0;
        segundo=System.currentTimeMillis();
        SonidoAtk= new GreenfootSound("golpear_7.mp3");
    }

    public void act() 
    {
        world=getWorld();
        
        
        heroeList=world.getObjects(Heroe.class);
        int bandRegreso=heroe.setCom();
        
            
        if(heroeList.isEmpty()){
            World gameO=new GameOver();
            Greenfoot.setWorld(gameO);
        }
        if(segundo>1 && bandAnimacion==false){
            segundo=System.currentTimeMillis();
            setImage(imgReposo.get(identificadorI));
           setLocation(680,500);
            identificadorI++;


            if(identificadorI==2)
                identificadorI=0; }   
        else
        {   segundo=System.currentTimeMillis();
            bandAnimacion=ataque();
            if(this.isTouching(Heroe.class)){
                SonidoAtk.play();
                if(bandRegreso==1){
                    dano=super.restaSalud(defensa);
                    desaparece=vida.reduce(dano,vida.getImage(),1);
                }
                if(!this.isTouching(Heroe.class))
                    SonidoAtk.stop();
            }
        }

        num=Greenfoot.getRandomNumber(5);
        if(num==1){
            bandAnimacion=true;
        }
        if(desaparece==false)
            world.addObject(vida,500,600);

        else if(desaparece==true){
            puntos=world.getObjects(Puntos.class);
            Object puntuacion=puntos.get(0);
            int punt=((Puntos)puntuacion).getPuntos();
            world.removeObject(vida);
            world.removeObject(this);
            
            World nivel=new PantallaEspera(3,punt);
            Greenfoot.setWorld(nivel);}

        // System.out.println(num);
    }

    /**
     * Este metodo se utiliza para que el enemigo puedda atacar a los heroes 
     * en el se usa el metodo setImage para cambiar la imagen,por la de ataque y
     * asi poder tocar a los heroes 
     * @return band regresa una bandera para poder ponerse en estado de reposo 
     * 
     */
    public boolean ataque()
    { 
        int num=Greenfoot.getRandomNumber(5);
        if(segundo>1 && num==1){
            segundo=System.currentTimeMillis();
            setImage(imgAtaque.get(identificadorJ));
            setLocation(200,500);
            if(identificadorJ==2){
                identificadorJ=0;
            }
            return true; 
            
        }
        else{
            return false;
        }
       
    }

    /**
     * @Ataque regresa el ataque de este enemigo 
     */
    public int getAtk()
    {
        return ataque;
    }
}