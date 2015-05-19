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
    private GreenfootImage Kraken1;//imagen
    private GreenfootImage Kraken2;
    private GreenfootImage Kraken3;
    private GreenfootImage KrakenAtk1;
    private GreenfootImage KrakenAtk2;
    private GreenfootImage KrakenAtk3;
    private LinkedList<GreenfootImage> imgRep;//lista para animacion de reposo
    private LinkedList<GreenfootImage> imgAtk;//lista para animacion de ataque
    private World w;//mundo para obtener actores de el
    private World n;//mundo para crear niveles 
    private World g;//mundo para dar game over
    private Vida v;//vida
    private Heroe h;//heroe
    private List P;
    private long seg;
    private boolean band;//banderas
    private boolean Desaparece;
    private int i;//contadores o indices
    private int j;
    private int Dano;//daño
    private int num;
    private int Ataque;
    private int Defensa;
    private List M;//lista para guardar actores 
    private List H;
    private GreenfootSound SonidoAtk;

    /**
     * Este es el Constructor del Enemigo, en el se definira  las variables de instancia y 
     * cargaran en la s listas ,las imagenes para la  animacion del enemigo 
     * se define el sonido para cuando el enemigo toca a un heroe y una
     * variable de tiempo para poder animar al enemigo
     */
    public Kraken()
    {
        Ataque=40;
        Defensa=100;
        Dano=0;
        v=new Vida(900);
        h=new Heroe();
        imgRep=new LinkedList<GreenfootImage>();
        imgAtk=new LinkedList<GreenfootImage>();
        //imgRep.add(Kraken1=new GreenfootImage("Kraken01.png"));
        imgRep.add(Kraken2=new GreenfootImage("Kraken02.png"));
        imgRep.add(Kraken3=new GreenfootImage("Kraken03.png"));
        imgAtk.add(KrakenAtk1=new GreenfootImage("KrakenAtk01.png"));
        imgAtk.add(KrakenAtk2=new GreenfootImage("KrakenAtk02.png"));
        imgAtk.add(KrakenAtk3=new GreenfootImage("KrakenAtk03.png"));
        i=0;  
        j=0;
        num=0;
        seg=System.currentTimeMillis();
        SonidoAtk= new GreenfootSound("golpear_7.mp3");
    }

    public void act() 
    {
        w=getWorld();
        
        g=new GameOver();
        H=w.getObjects(Heroe.class);
        int bandR=h.setCom();
        if(H.isEmpty())
            Greenfoot.setWorld(g);
        if(seg>1 && band==false){
            seg=System.currentTimeMillis();
            setImage(imgRep.get(i));
            setLocation(680,500);
            i++;

            if(i==2)
                i=0; }   
        else
        {   seg=System.currentTimeMillis();
            band=Ataque();
            if(this.isTouching(Heroe.class)){
                SonidoAtk.play();
                if(bandR==1){
                    Dano=super.restaSalud(Defensa);
                    Desaparece=v.reduce(Dano,v.getImage(),1);
                }
                if(!this.isTouching(Heroe.class))
                    SonidoAtk.stop();
            }
        }

        num=Greenfoot.getRandomNumber(5);
        if(num==1){
            band=true;
        }
        if(Desaparece==false)
            w.addObject(v,500,600);

        else if(Desaparece==true){
            P=w.getObjects(Puntos.class);
            Object p=P.get(0);
            int punt=((Puntos)p).getPuntos();
            w.removeObject(v);
            w.removeObject(this);
            n=new PantallaEspera(3,punt);
            Greenfoot.setWorld(n);}

        // System.out.println(num);
    }

    /**
     * Este metodo se utiliza para que el enemigo puedda atacar a los heroes 
     * en el se usa el metodo setImage para cambiar la imagen,por la de ataque y
     * asi poder tocar a los heroes 
     * @return band regresa una bandera para poder ponerse en estado de reposo 
     * 
     */
    public boolean Ataque()
    { 
        int num=Greenfoot.getRandomNumber(5);
        if(seg>1 && num==1){
            seg=System.currentTimeMillis();
            setImage(imgAtk.get(j));
            setLocation(200,500);

            band=true; 
            if(j==2){
                j=0;
            }
        }
        else{
            band=false;
        }
        return band;
    }

    /**
     * @Ataque regresa el ataque de este enemigo 
     */
    public int getAtk()
    {
        return Ataque;
    }
}