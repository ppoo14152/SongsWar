import greenfoot.*;
import java.util.*;
/**
 * Esta clase es un caballero es unos de lo heroes que actuaran 
 * conforme se halla establecido un comando y eindiceJecutara una animacion 
 * aqui se declaran el ataque ,la defensa las lista con imagenes para la animacion
 * variables de mundo para poder eliminar a este heroe 
 * movimiento sirve para darle un numero para que alcance a los enemigos mas facil  
 * @see indiceJavva.util.*; se usa para poder acceder a las listas para realizar animaciones
 * @autor Omar Agustin Valadez Hernandes 
 * @versión 3.0 Mayo 2015
 */
public class Caballero extends Heroe
{
    private int ataque;
    private int defensa;
    private int bandComando;
    private int bandAtaque;
    private int bandDano;
    private long segundo;
    private int coorX;
    private int movimiento;
    private int indiceJ;
    private int danoResibido;
    private boolean desaparece;
    private Vida vida;
    private List muroList;
    private World world;//mundo para obtener obindiceJetos de el
    private LinkedList<GreenfootImage> heroeCaballero;//lista de animacion
    private GreenfootImage cabataque01;//imagen de ataque
    private GreenfootImage cabataque02;
    private GreenfootImage cabataque03;
    /**
     * Constructor de Caballero 
     * aqui se definen el ataque la defensa ,y las banderas que ayudan a eindiceJecutar las acciones
     * ademas de cargar las listas con imagenes para la animacion
     */
    public Caballero()
    {
        ataque=35;
        danoResibido=0;
        defensa=50;
        bandComando=0;
        bandAtaque=0;
        bandDano=0;
        vida=new Vida(800);
        indiceJ=0;
        coorX=450;
        movimiento=20;
        heroeCaballero=new LinkedList<GreenfootImage>();
        heroeCaballero.add(cabataque01=new GreenfootImage("CabAtack01.png"));
        heroeCaballero.add(cabataque02=new GreenfootImage("CabAtack02.png"));
        heroeCaballero.add(cabataque03=new GreenfootImage("CabAtack03.png"));
        // Def01=new GreenfootImage("Def01.png");
        segundo=System.currentTimeMillis();
    }

    public void act() 
    {
        world=getWorld();
        bandComando=super.setCom();
        muroList=world.getObjects(Muro.class);
        if(super.getComando()==1){           
            bandAtaque=ataque(); 
            bandDano=0;}
        //super.getTouch();}}
        if(bandAtaque==1){
            super.setReg(true);
            bandAtaque=0;}

        if(super.getComando()==2){
            bandDano=1; 
            defensa();}
        if(super.getComando()==3){
            regreso();
        }
       /* if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            band3=0;}
        else
            band3=1;*/
        if(this.isTouching(Enemigo.class) && bandDano!=1){
            danoResibido=super.restaSalud(defensa);
            desaparece=vida.reduce(danoResibido,vida.getImage(),2);
            super.setDano(0);
            //System.out.println(DanoRes);
        }
        if(desaparece==false)
            world.addObject(vida,100,200);
        else if(desaparece==true){
            world.removeObject(vida);
            world.removeObject(this);
        } 
        if(muroList.isEmpty())
        {
            movimiento=40;   
            coorX=600;
        }
    }    

    /**
     * en este metodo se utiliza para poder hacer la animacio de movimiento y que se eindiceJecute 
     * el movimiento hacia el enmmigo, las animaciones de hiran poniendo de forma automatica segun
     * vaya avanzando
     * @return bandAtaque
     */
    public int ataque()
    {  
        int x2=getX();

        // System.out.println(x);
        //Greenfoot.delay(20);
        if(segundo>1 &&  x2<coorX){
            segundo=System.currentTimeMillis();

            setImage(heroeCaballero.get(indiceJ));
            move(22);

            setImage(heroeCaballero.get(indiceJ));
            move(22);
            indiceJ++;
            if(indiceJ==2)
                indiceJ=0;
            x2++;
        }
        else
        {
            setImage(heroeCaballero.get(2));
            //move(0);
            bandAtaque=1;                 
        }

        return bandAtaque;

        
    }
    /**
     * @return ataque regresa el ataque de este heroe
     */
    public int getAtk()
    {
        return ataque;
    }

    /**
     * coloca a su posicion original este heroe
     */
    public void regreso()
    {       
        setLocation(200,500); 
        setImage("CabAtack01.png");

    }
    /**
     * coloca la imagen para la defensa 
     */
    public void defensa()
    {
        setImage("DefCab01.png");
    }
}
