import greenfoot.*;
import java.util.*;
/**
 * Esta clase es un Espadachin es unos de lo heroes que actuaran 
 * conforme se halla establecido un comando y ejecutara una animacion 
 * aqui se declaran el ataque ,la defensa las lista con imagenes para la animacion
 * variables de mundo para poder eliminar a este heroe 
 * movimiento sirve para darle un numero para que alcance a los enemigos mas facil  
 * 
 * @autor Omar Agustin Valadez Hernandes 
 * @versión 3.0 Mayo 2015
 */
public class Espadachin extends Heroe 
{
    private int ataque;
    private int danoRecibido;
    private int defensa;
    private int bandAtaque;
    private int bandRegreso;
    private int iterador;    
    private LinkedList<GreenfootImage> heroAtaque;
    private GreenfootImage ataque01;
    private GreenfootImage ataque02;
    private GreenfootImage ataque03;
    private GreenfootImage defensa01;
    private Vida vida;
    private long segundo;
    private int coorX;
    private int movimiento;
    private boolean desaparece;
    private int bandDano;
    private World world;
    private GreenfootSound golpe;

    private List muroList;

    /**
     * Constructor de Espadachin 
     * aqui se definen las variables como las lista y se cargan sus respectivas
     * imagenes 
     * ademas de definir el ataque la defensa y la serie de banderas
     */
    public Espadachin()
    {
        ataque=20;
        danoRecibido=0;
        defensa=50;
        bandAtaque=0;
        bandRegreso=0;
        iterador=0;
        
        bandDano=0;
        coorX=450;
        movimiento=20;
        vida=new Vida(800);
        heroAtaque=new LinkedList<GreenfootImage>();
        heroAtaque.add(ataque01=new GreenfootImage("Atack01.png"));
        heroAtaque.add( ataque02=new GreenfootImage("Atack02.png"));
        heroAtaque.add(ataque03=new GreenfootImage("Atack03.png"));
        defensa01=new GreenfootImage("defensa01.png");
        golpe=new GreenfootSound("golpe_A_Heroe.mp3");
        segundo=System.currentTimeMillis();

    }

    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        world=getWorld();

        bandAtaque=super.setCom();
        muroList=world.getObjects(Muro.class);
        if(super.getComando()==1){  
            bandRegreso=ataque();
            bandDano=0;
            super.getTouch();}
        if(bandRegreso==1){
            setReg(true);
            bandRegreso=0;}

        if(super.getComando()==2){
            bandDano=1;
            defensa();
        }
        if(super.getComando()==3){

            Regreso();
        }
        /*if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            bandDano=0;}
        else
            bandDano=1;*/

        if(this.isTouching(Enemigo.class) && bandDano!=1){
            golpe.play();
            danoRecibido=super.restaSalud(defensa);
            desaparece=vida.reduce(danoRecibido,vida.getImage(),1);
            super.setDano(0);
            //System.out.println(danoRecibido);
        }
        if(!this.isTouching(Enemigo.class));
        golpe.stop();
        if(desaparece==false)
            world.addObject(vida,100,220);
        else
           if(desaparece==true){
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
     * @return ataque regresa el ataque de este heroe
     */
    public int getAtk()
    {
        return ataque;
    }

    /**
     * este metodo sirve para poder ejecutar la animacion de ataque y ademas causarle daño
     * al enemigo
     * usa las listas y un indice 
     * para poder ir cambiando las imagenes
     * ademas de regresar una bandera para poder regresar al heroe a sus estado original
     * @return bandRegreso una bandera
     */
    public int ataque()
    {  
        int x=getX();
        if(segundo>1 && x<coorX){
            segundo=System.currentTimeMillis();

            setImage(heroAtaque.get(iterador));
            move(movimiento);
            iterador++;
            if(iterador==2)
                iterador=0;
            x++;
        }
        else
        {
            setImage(heroAtaque.get(2));
            move(0);
            bandRegreso=1;                 
        }

        return bandRegreso;

    }

    /**
     * coloca la imagen para la defensa
     */
    public void defensa()
    {
        setImage(defensa01);
    }

    /**
     * este metodo regresa al heroe a su posicion original
     */

    public void Regreso()
    {   

        setLocation(250,500);
        setImage(ataque01);

    }
}

