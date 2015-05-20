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
 * @see java.util.*; para poder hacer uso de listas para animar al Actor
 * @autor Omar Agustin Valadez Hernandez
 * @versión Mayo 2015
 */
public class Dragon extends Enemigo
{
    private GreenfootImage dragon1;//imagen
    private GreenfootImage dragon2;
    private GreenfootImage dragon3;
    private GreenfootImage dragon4;

    private LinkedList<GreenfootImage> imgReposo;//lista para la animacion en reposo

    private Garra garra;
    private Llama llama;
    private World world;//mundo para obetener actores de el
    
    private Vida vida;//vida
    private Heroe heroe;//heroe
    private long segundo;
    private boolean band;//banderas
    private boolean bandLugar;
    
    private boolean bandAtaque;
    private boolean desaparece;
    private int identificadorI;//contadores o indices para la animcaion
    private int identificadorJ;
    private int identificadorK;
    private int dano;
    private int ataque;
    private int defensa;//defensa
    private List muro;//listas para guardar actores
    private List llamaList;
    private List heroeLista;
    private Flecha flecha;//flecha
    private GreenfootSound SonidoAtk;
    /**
     * Constructor Dragon en el se definen el ataque la defensa y se 
     * cargan en las listas las imagenes que serviran para la animacion
     * se coloca la vida 
     * y se usa un sonido que se escuchar cuando se toque con otro acctor
     */
    public Dragon()
    {
        ataque=1;
        defensa=150;
        dano=0;
        vida=new Vida(2000);
        heroe=new Heroe();
        flecha=new Flecha();
        llama=new Llama();
        imgReposo=new LinkedList<GreenfootImage>();
        garra=new Garra();
        imgReposo.add(dragon1=new GreenfootImage("Dragon01.png"));
        imgReposo.add(dragon2=new GreenfootImage("Dragon01.png"));
        imgReposo.add(dragon3=new GreenfootImage("Dragon02.png"));
        imgReposo.add(dragon4=new GreenfootImage("Dragon02.png"));
        identificadorI=0;
        identificadorJ=0;
        identificadorK=0;
        SonidoAtk=new GreenfootSound("golpear_7.mp3");
        segundo=System.currentTimeMillis();

    }

    public void act() 
    {
        world=getWorld();
        heroeLista=world.getObjects(Heroe.class);
      
        int y=getY();
        int x=getX();

        muro=world.getObjects(Muro.class);
        llamaList=world.getObjects(Llama.class);
        int bandRegreso=heroe.setCom();
        if(heroeLista.isEmpty()){

        
            World gameO=new GameOver();
            Greenfoot.setWorld(gameO);
        }
        if(segundo>1 ){
            segundo=System.currentTimeMillis();
            setImage(imgReposo.get(identificadorI));
            identificadorI++;

            if(identificadorI==4)
                identificadorI=0;}
        if(muro.isEmpty()==false);
        else if(muro.isEmpty()){
            if(y<500){
                y=y+5;

                setLocation(getX(),y);
            }
            bandAtaque=ataque();
        }
        if(this.isTouching(Flecha.class)){
            bandAtaque=true;
           }
        else
            bandAtaque=false;
        if(bandAtaque==true){
            ///Dano=super.restaSalud(Def);
            desaparece=vida.reduce(dano,vida.getImage(),1);}
        else if(this.isTouching(Heroe.class) ){
            SonidoAtk.play(); 
            if(bandRegreso==1){
                dano=super.restaSalud(defensa);
                desaparece=vida.reduce(dano,vida.getImage(),1);
            }
            if(!this.isTouching(Heroe.class))
                SonidoAtk.stop();
        }       

        segundo=System.currentTimeMillis();
        if(desaparece==false)
            world.addObject(vida,500,600);
        else if(desaparece==true){
            world.removeObject(vida);
            world.removeObject(this);
            world.removeObject(llama);
            world.removeObject(garra);
            World nivel=new Puntaje();
            Greenfoot.setWorld(nivel);}
        y++;

    }  

    /**
     * Este metodo selecciona el tipo de ataque que este enemigo 
     * ejecutara por medio de un numero aleatorio
     * regresa una bandera que el enemigo usara para saber si esta tocando una flecha o no 
     * 
     * */
    public boolean ataque()
    {
        int num=Greenfoot.getRandomNumber(15);
        switch(num)
        {
            case 1: bandLugar=ataqueGarra();
            if(bandLugar==true){
                setLocation(600,500);
                bandLugar=false;}
            break;
            case 8: bandLugar=ataqueLlama();
            if(bandLugar==true){
                setLocation(600,500);
                bandLugar=false;}
            default:

        }
        return bandLugar;
    }

    /**
     * Este metodo se ejecutara segun lo seleccione el metodo "Ataque" , este metodo
     * añanadira un objeto llama , y movera al enemigo.
     * cuando la x tenga cierto  valor se eliminara la llama del mundo
     * regresara una bandera para que el enemigo pudea ajustar su posicion en el mundo 
     * @return band2 regresa una bandera para podern regresar al enemigo a su posicion original
     *
     */

    public boolean ataqueLlama()
    {     if(getY()==500){
            world.addObject(llama,300,getY());
            llama.setLocation(300,getY());
           
            move(-70);
            llama.move(-50);
            int x=getX();

            if(x<500){

                world.removeObject(llama);
                return true;
            }}
        return false;
    }

    /**
     * Este metodo añanadira un objeto Garra la cual la colocara y la movera para alcanzar a los heroes 
     * segun el numeero de x , se removera del mundo este objeto
     * regresara una bandera para que el enemigo pueda ajustar su posicion
     * @return band2 regresa una bandera para podern regresar al enemigo a su posicion original
     *
     */

    public boolean ataqueGarra()
    {
        if(getY()==500){
            world.addObject(garra,300,getY());
            garra.setLocation(300,getY());
            move(-70);
            int x=getX();
            System.out.println(x);
            if(x<500){

                world.removeObject(garra);
                return true;
            }}
        return false;

    }

    /**
     * @return Atk regresa el ataque de este enemigo
     */
    public int getAtk()
    {
        return ataque;
    }

}
