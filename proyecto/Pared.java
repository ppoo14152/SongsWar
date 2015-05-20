import greenfoot.*;
import java.awt.*;

/**
 * Estaa clase es un Muro , tienen variables de instancia 
 * las cuales son ataque, resistencia ,defensa y vida
 * ademas de una serie de banderas booleanas para poder ejecutar una serie de acciones
 * 
 * @autor Omar Agustin Valadez Hernandez
 * @versión Abril 2015
 */
public class Pared extends Muro
{
    /**
     * Act - hace lo que Pared quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    private int resistencia;

    private Vida vida;
    private int dano;
    private Actor heroAtaque;
    private boolean desaparece;
    
    /**
     * Constructor de Pared, en el se definen las variables 
     * de  instancia, como la resistencia la vida y el daño
     */
    public Pared ()
    {
        resistencia=100; 
        dano=0;
        heroAtaque=new Heroe();
        vida=new Vida(1000);
        desaparece=false;

    }


    public void act()
    {        World world=getWorld();

        if(resistencia>99)
            world.addObject(vida,500,550); 
        if(this.isTouching(Heroe.class)){   
            super.setRes(100);
            dano=super.restaSalud();                   
            desaparece= vida.reduce(dano,vida.getImage(),1);           
            super.setDano(0);
            if(desaparece==false)
                world.addObject(vida,500,600);
            else if(desaparece==true) {
                world.removeObject(vida);
                world.removeObject(this);

            }
        }
    }

}