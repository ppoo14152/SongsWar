import greenfoot.*;
/**
 * Estaa clase es un Muro , tienen variables de instancia 
 * las cuales son ataque, resistencia ,defensa y vida
 * ademas de una serie de banderas booleanas para poder ejecutar una serie de acciones
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Abril 2015
 */
public class Torreon extends Muro
{
    private int resistencia;
    private int dano;
    private Vida vida;
    private Actor heroAtaque;
    private boolean desaparece;
    private World world;
    /**
     * Constructor de Torreon 
     * aqui se definen las variables de instancia
     */
    public Torreon()
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
