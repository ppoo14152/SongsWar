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
    private int DanoTotal;
    private int DanoEs;
    private int DanoCab;
    private int DanoArq;
    private Vida V;
    private int band;
    private boolean NivelNew;
    private boolean Vit;
    private Actor heroAtk;
    private boolean Desaparece;
    private World n;
    public void act()
    {        World w=getWorld();
               World n=getWorld();
        if(NivelNew==true){
        }
         if(Resistencia>99)
            w.addObject(V,500,600); 
        if(this.isTouching(Heroe.class)){           
            band=restaSalud();    
                      
                
            Desaparece= V.reduce(band,V.getImage());
            
            DanoTotal=0;
            if(Desaparece==false)
                w.addObject(V,500,600);
            else if(Desaparece==true) {
                w.removeObject(V);
                w.removeObject(this);
                n=new Nivel2();
                Greenfoot.setWorld(n);
                NivelNew=true;
            }
                                         
          }
   }

    public Pared ()
    {
        Resistencia=100; 
        DanoTotal=0;
        DanoEs=0;
        DanoCab=0;
        DanoArq=0;
        heroAtk=new Heroe();
        V=new Vida(1000);
        Desaparece=false;
        NivelNew=false;
    }

    public int restaSalud()
    {
        String NombreClass;
        

        //V.reduceVid(DanoTotal);

        heroAtk=getOneIntersectingObject(Heroe.class);
        NombreClass=heroAtk.getClass().getName();
        if(NombreClass== "Espadachin"){
            DanoEs=((Espadachin)heroAtk).getAtk();
            NombreClass=null;
        }
        else if(NombreClass=="Caballero"){
            DanoCab=((Caballero)heroAtk).getAtk();
              NombreClass=null;}
        DanoTotal=Resistencia-DanoEs-DanoCab;
        System.out.println(DanoEs);
        System.out.println(DanoCab);
        
        return DanoTotal;
    }

}