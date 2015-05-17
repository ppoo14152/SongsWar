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
    private int Resistencia;

    private Vida V;
    private int Dano;

    private boolean Vit;
    private Actor heroAtk;
    private boolean Desaparece;

    public void act()
    {        World w=getWorld();

        if(Resistencia>99)
            w.addObject(V,500,550); 
        if(this.isTouching(Heroe.class)){   
            super.setRes(100);
            Dano=super.restaSalud();                   
            Desaparece= V.reduce(Dano,V.getImage(),1);           
            super.setDano(0);
            if(Desaparece==false)
                w.addObject(V,500,600);
            else if(Desaparece==true) {
                w.removeObject(V);
                w.removeObject(this);

            }
        }
    }

    /**
     * Constructor de Pared, en el se definen las variables 
     * de  instancia, como la resistencia la vida y el daño
     */
    public Pared ()
    {
        Resistencia=100; 
        Dano=0;
        heroAtk=new Heroe();
        V=new Vida(1000);
        Desaparece=false;

    }

}