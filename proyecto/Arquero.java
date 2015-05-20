import greenfoot.*;

/**
 * Esta clase es un Arquero es unos de lo heroes que actuaran 
 * conforme se halla establecido un comando y ejecutara una animacion 
 * aqui se declaran el ataque ,la defensa las lista con imagenes para la animacion
 * variables de mundo para poder eliminar a este heroe 
 * movimiento sirve para darle un numero para que alcance a los enemigos mas facil  
 * ya que esta clase usa una Flecha par apoder ataque tiene menor vida y no posee animaciones de ataque
 * @autor Omar Agustin Valadez Hernandes 
 * @versión 3.0 Mayo 2015
 */
public class Arquero extends Heroe
{
    private int ataque;
    private int danoRecibido;
    private int defensa;
    private int bandAtaque;
    private int bandRegreso;
    
    private Vida vida;
    private long segundo;
    private int CoorX;
    private int movimiento;
    private boolean desaparece;
    private int bandDano;
    private World world;
    /**
     * Constructor de Arquero 
     * aqui se definen las varibles de instancia 
     * 
     */

    public Arquero()
    {
        ataque=20;
        danoRecibido=0;
        defensa=50;
        bandAtaque=0;
        bandRegreso=0;      
        bandDano=0;
        vida=new Vida(300);
        segundo=System.currentTimeMillis();
    }
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        world=getWorld();

        bandAtaque=super.setCom();

        if(super.getComando()==1){  
            // band2=ataque();
            bandDano=0;
        }

        if(bandRegreso==1){
            setReg(true);
            bandRegreso=0;}

        if(super.getComando()==2){
            bandDano=1;
            defensa();
        }
        if(super.getComando()==3){

            setImage("Arquero.png");

        }
       /* if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            band3=0;}
        else
            band3=1;*/
        if(this.isTouching(Enemigo.class) && bandDano!=1){
            danoRecibido=super.restaSalud(defensa);
            desaparece=vida.reduce(danoRecibido,vida.getImage(),1);
            super.setDano(0);
           
        }
        if(desaparece==false)
            world.addObject(vida,100,240);
        else
        if(desaparece==true){
            world.removeObject(vida);

            world.removeObject(this);

            
        }    

    }
    /**
     * 
     *@return ataque regresa el ataque
     */
    public int getAtk()
    {
        return ataque;
    }

    /**
     * se coloca la defensa del arquero
     */
    public void defensa()
    {
        defensa=50;
    }

}
