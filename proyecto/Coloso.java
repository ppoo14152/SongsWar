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
    private World w;//mundo  para obetenr objetos de el
    private World n;//mundo para crear niveles
    private World g;//mundo para dar un game over
    private Vida v;//vida
    private Heroe h;//heroe
    private Actor heroAtk;
    private LinkedList<GreenfootImage> Enem;//lista de animacion enemigo
    private GreenfootImage Coloso1;//imagen
    private GreenfootImage Coloso2;//imagen
    private GreenfootImage Coloso3;//imagen
    private List M;//lista para guargar actores del mundo
    private List H;
    private List P;
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
                 P=w.getObjects(Puntos.class);
                 Object p=P.get(0);
                 int punt=((Puntos)p).getPuntos();
                 w.removeObject(v);
                 w.removeObject(this);
                 n=new PantallaEspera(2,punt);
                 
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
     * Este metodo regresa el ataque de este Enemigo
     * @return Atk ataque del enemigo
     */
    public int getAtk()
    {
        return Atk;
    }

    
}
