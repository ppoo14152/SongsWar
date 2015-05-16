import greenfoot.*;

/**
 * Escribe una descrición de la clase Atalaya aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Atalaya extends Muro
{
    private int Ataque;
    private int Resistencia;
    private int Dano;
    private Vida v;
    private Actor heroAtk;
    private boolean Desaparece;
    private World w;
    public Atalaya()
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
    public void Ataque()
    {
        
    }
}
