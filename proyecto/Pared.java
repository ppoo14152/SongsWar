import greenfoot.*;
import java.awt.*;

/**
 * Escribe una descrición de la clase Pared aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
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
    
    private boolean NivelNew;
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

    public Pared ()
    {
        Resistencia=100; 
        Dano=0;
        heroAtk=new Heroe();
        V=new Vida(1000);
        Desaparece=false;
        NivelNew=false;
    }


}