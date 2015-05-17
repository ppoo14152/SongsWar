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
    private int Resistencia;
    private int Dano;
    private Vida v;
    private Actor heroAtk;
    private boolean Desaparece;
    private World w;
    /**
     * Constructor de Torreon 
     * aqui se definen las variables de instancia
     */
    public Torreon()
    {
        Resistencia=50;
        Dano=0;
        heroAtk=new Heroe();
        v=new Vida(1500);

        Desaparece=false;

    }

    public void act() 
    {
        World w=getWorld();

        if(Resistencia>99)
            w.addObject(v,500,500);
        if(this.isTouching(Heroe.class)){
            super.setRes(100);
            Dano=super.restaSalud();

            Desaparece=v.reduce(Dano,v.getImage(),1);

            super.setDano(0);
            if(Desaparece==false)
                w.addObject(v,500,600);
            else if(Desaparece==true){
                w.removeObject(v);
                w.removeObject(this);
            }
        }
    }

}
