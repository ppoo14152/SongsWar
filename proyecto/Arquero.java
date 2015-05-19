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
    private int Ataque;
    private int DanoRes;
    private int Def;
    private int band;
    private int band2;
    private int i;
    private int bandG;
    private Vida v;

    private long seg;
    private int CoorX;
    private int movimiento;
    private boolean Desaparece;
    private int band3;
    private World w;
    /**
     * Constructor de Arquero 
     * aqui se definen las varibles de instancia 
     * 
     */

    public Arquero()
    {
        Ataque=20;
        DanoRes=0;
        Def=50;
        band=0;
        band2=0;
        i=0;
        bandG=0;
        band3=0;

        v=new Vida(300);
        seg=System.currentTimeMillis();
    }
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        w=getWorld();

        band=super.setCom();

        if(super.getComando()==1){  
            // band2=Ataque();
            band3=0;}

        if(band2==1){
            setReg(true);
            band2=0;}

        if(super.getComando()==2){
            band3=1;
            Def();
        }
        if(super.getComando()==3){

            setImage("Arquero.png");

        }
       /* if(this.isTouching(Llama.class) || this.isTouching(Garra.class)){
            band3=0;}
        else
            band3=1;*/
        if(this.isTouching(Enemigo.class) && band3!=1){
            DanoRes=super.restaSalud(Def);
            Desaparece=v.reduce(DanoRes,v.getImage(),1);
            super.setDano(0);
            //System.out.println(DanoRes);
        }
        if(Desaparece==false)
            w.addObject(v,100,240);
        else
        if(Desaparece==true)
            System.out.println(bandG);
        if(Desaparece==true){
            w.removeObject(v);

            w.removeObject(this);

            
        }    

    }
    /**
     * 
     *@return Ataque regresa el ataque
     */
    public int getAtk()
    {
        return Ataque;
    }

    /**
     * se coloca la defensa del arquero
     */
    public void Def()
    {
        Def=50;
    }

}
