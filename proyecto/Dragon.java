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
 * ademas este enemigo usa una clase llamada grras y llamas 
 * la cual utiliza para poder atacar
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Dragon extends Enemigo
{
    private GreenfootImage Dragon1;
    private GreenfootImage Dragon2;
    private GreenfootImage Dragon3;
    private GreenfootImage Dragon4;

    private LinkedList<GreenfootImage> imgRep;

    private Garra garra;
    private Llama llama;
    private World w;
    private World g;
    private World n;
    private Vida v;
    private Heroe h;
    private long seg;
    private boolean band;
    private boolean band2;
    private boolean band3;
    private boolean band4;
    private boolean Desaparece;
    private int i;
    private int j;
    private int k;
    private int Dano;
    private int Atk;
    private int Def;
    private List M;
    private List l;
    private List H;
    private Flecha f;
    private GreenfootSound SonidoAtk;
    /**
     * Constructor Dragon en el se definen el ataque la defensa y se 
     * cargan en las listas las imagenes que serviran para la animacion
     * se coloca la vida 
     * y se usa un sonido que se escuchar cuando se toque con otro acctor
     */
    public Dragon()
    {
        Atk=1;
        Def=150;
        Dano=0;
        v=new Vida(2000);
        h=new Heroe();
        f=new Flecha();
        llama=new Llama();
        imgRep=new LinkedList<GreenfootImage>();
        garra=new Garra();
        imgRep.add(Dragon1=new GreenfootImage("Dragon01.png"));
        imgRep.add(Dragon2=new GreenfootImage("Dragon01.png"));
        imgRep.add(Dragon3=new GreenfootImage("Dragon02.png"));
        imgRep.add(Dragon4=new GreenfootImage("Dragon02.png"));
        i=0;
        j=0;
        k=0;
        SonidoAtk=new GreenfootSound("golpear_7.mp3");
        seg=System.currentTimeMillis();

    }

    public void act() 
    {
        w=getWorld();
        H=w.getObjects(Heroe.class);
        g=new GameOver();
        int y=getY();
        int x=getX();

        M=w.getObjects(Muro.class);
        l=w.getObjects(Llama.class);
        int bandR=h.setCom();
        if(H.isEmpty())
            Greenfoot.setWorld(g);
        if(seg>1 ){
            seg=System.currentTimeMillis();
            setImage(imgRep.get(i));
            i++;

            if(i==4)
                i=0;}
        if(M.isEmpty()==false);
        else if(M.isEmpty()){
            if(y<500){
                y=y+5;

                setLocation(getX(),y);
            }
            band4=Ataque();
        }
        if(this.isTouching(Flecha.class)){
            band4=true;
            System.out.println(band4);}
        else
            band4=false;
        if(band4==true){
            ///Dano=super.restaSalud(Def);
            Desaparece=v.reduce(Dano,v.getImage(),1);}
        else if(this.isTouching(Heroe.class) ){
            SonidoAtk.play(); 
            if(bandR==1){
                Dano=super.restaSalud(Def);
                Desaparece=v.reduce(Dano,v.getImage(),1);
            }
            if(!this.isTouching(Heroe.class))
                SonidoAtk.stop();
        }       

        seg=System.currentTimeMillis();
        if(Desaparece==false)
            w.addObject(v,500,600);
        else if(Desaparece==true){
            w.removeObject(v);
            w.removeObject(this);
            w.removeObject(llama);
            w.removeObject(garra);
            n=new puntaje();
            Greenfoot.setWorld(n);}
        y++;

    }  

    /**
     * Este metodo selecciona el tipo de ataque que este enemigo 
     * ejecutara por medio de un numero aleatorio
     * regresa una bandera que el enemigo usara para saber si esta tocando una flecha o no 
     * 
     */
    public boolean Ataque()
    {
        int num=Greenfoot.getRandomNumber(15);
        switch(num)
        {
            case 1: band2=AtaqueGarra();
            if(band2==true){
                setLocation(600,500);
                band2=false;}
            break;
            case 8: band2=AtaqueLlama();
            if(band2==true){
                setLocation(600,500);
                band2=false;}
            default:

        }
        return band2;
    }

    /**
     * Este metodo se ejecutara segun lo seleccione el metodo "Ataque" , este metodo
     * añanadira un objeto llama , y movera al enemigo.
     * cuando la x tenga cierto  valor se eliminara la llama del mundo
     * regresara una bandera para que el enemigo pudea ajustar su posicion en el mundo 
     */

    public boolean AtaqueLlama()
    {     if(getY()==500){
            w.addObject(llama,300,getY());
            llama.setLocation(300,getY());
            llama.Image();
            move(-70);
            llama.move(-50);
            int x=getX();

            if(x<500){

                w.removeObject(llama);
                return true;
            }}
        return false;
    }

    /**
     * Este metodo añanadira un objeto Garra la cual la colocara y la movera para alcanzar a los heroes 
     * segun el numeero de x , se removera del mundo este objeto
     * regresara una bandera para que el enemigo pueda ajustar su posicion
     */

    public boolean AtaqueGarra()
    {
        if(getY()==500){
            w.addObject(garra,300,getY());
            garra.setLocation(300,getY());
            move(-70);
            int x=getX();
            System.out.println(x);
            if(x<500){

                w.removeObject(garra);
                return true;
            }}
        return false;

    }

    /**
     * regresa el ataque de este enemigo
     */
    public int getAtk()
    {
        return Atk;
    }

}
