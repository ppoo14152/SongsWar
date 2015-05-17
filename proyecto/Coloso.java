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
    private int ideAtk;
    private int Atk;
    private int Defensa;
    private int Dano;
    private int i;
    private boolean band;
    private boolean Desaparece;
    private int Com;
    private World w;
    private World n;
    private World g;
    private Vida v;
    private Heroe h;
    private Actor heroAtk;
    private LinkedList<GreenfootImage> Enem;
    private GreenfootImage Coloso1;
    private GreenfootImage Coloso2;
    private GreenfootImage Coloso3;
    private List M;
    private List H;
    private long seg;
    private GreenfootSound SonidoAtk;
   /**
    * Es el constructor , en se declara todas las variables de intancia ya 
    * mencionadas arriba
    * se carga en las lista las imagenes y se definen los valores de 
    * las demas variables
    */
    public Coloso()
    {
        Atk=20;
        Defensa=200;
        Dano=0;
        ideAtk=0;
        i=0;
        Com=1;
        band=false;        
        heroAtk=new Heroe();
        h=new Heroe();
        v=new Vida(1000);    
        Enem=new LinkedList<GreenfootImage>();
        Enem.add(Coloso1=new GreenfootImage("Coloso01.png"));
        Enem.add(Coloso2=new GreenfootImage("Coloso02.png"));
        Enem.add(Coloso3=new GreenfootImage("Coloso03.png"));
        seg=System.currentTimeMillis();
      
         SonidoAtk= new GreenfootSound("golpear_7.mp3");
    }
    
    public void act() 
    {
        w=getWorld();
        
        g=new GameOver();
        M=w.getObjects(Muro.class);
        H=w.getObjects(Heroe.class);
        n=new PantallaEspera(2);
        int bandR=h.setCom();
       if(H.isEmpty()){
                Greenfoot.setWorld(g);}
        if(M.isEmpty()){
            if(Com==1 && band==false)
                Ataque();
            
             if(this.isTouching(Heroe.class)){
                 SonidoAtk.play();
                 if( bandR==1){
                Dano=super.restaSalud(Defensa);
                Desaparece=v.reduce(Dano,v.getImage(),1);
            }
            if(!this.isTouching(Heroe.class))
            SonidoAtk.stop();
                }
                if(Desaparece==false)
                w.addObject(v,500,600);
                else if(Desaparece==true) {
                 w.removeObject(v);
                 w.removeObject(this);
                 
                 Greenfoot.setWorld(n);
                }
            if(band==true && Desaparece==false){
                Regreso();
                Com=0;                
            }
            int Band2=Greenfoot.getRandomNumber(50);
            if(Band2==1 || Band2==25)
                Com=1;
                
           
    }}    
/**
 * Este metodo sirve para que  el enimgo pueda atacar 
 * este enemigo usa animacionn al atacar 
 * utiliza un indice el cual ira cambiando las imagenes que estan guardadas
 * en la lista para animar 
 * y utila un move para poder moverse
 * regresa una bandera para que el enemigo pueda regreasar a su posicion original
 */
    public void Ataque()
    {
        int x=getX();
        if(seg>1 && x>150)
        {
            seg=System.currentTimeMillis();
            setImage(Enem.get(i));
            move(-50);
            i++;
            if(i==2)
                i=0;
            x++;
        }
        if(x==150)
            band=true; 
    }
    /**
     * Este metodo pone en la posicion original a este enemigo
     */

    public void Regreso()
    {
        int x=getX();
        if(seg>1 && x<750 && band)
        {

            setImage(Enem.get(0));
            move(100);
            x++;
        }
        else{
            setImage(Enem.get(0));
            move(0);
            band=false;
        }
    }
    /**
     * este metodo regresa el ataque de este Enemigo
     */
    public int getAtk()
    {
        return Atk;
    }

    
}
