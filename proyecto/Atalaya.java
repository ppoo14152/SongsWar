import greenfoot.*;

/**
 * Estaa clase es un Muro , tienen variables de instancia 
 * las cuales son ataque, resistencia ,defensa y vida
 * ademas de una serie de banderas booleanas para poder ejecutar una serie de acciones
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Abril 2015
 */
public class Atalaya extends Muro
{

    private int resistencia;
    private int dano;
    private Vida vida;
    private Actor heroAtaque;
    private boolean desaparece;
    private World world;
    /**
     * Constructor de Atalaya
     * aqui se define la resistencia y el daño, tambien
     * la vida y las inicializacion de las banderas 
     */
    public Atalaya()
    {    
        resistencia=50;
        dano=0;
        heroAtaque=new Heroe();
        vida=new Vida(1500);
        desaparece=false;

    }

    public void act() 
    {
        World world=getWorld();

        if(resistencia>99)
            world.addObject(vida,500,500);
        if(this.isTouching(Heroe.class)){
            super.setRes(100);
            dano=super.restaSalud();

            desaparece=vida.reduce(dano,vida.getImage(),1);

            super.setDano(0);
            if(desaparece==false)
                world.addObject(vida,500,600);
            else if(desaparece==true){
                world.removeObject(vida);
                world.removeObject(this);
            }
        }
    }

}
