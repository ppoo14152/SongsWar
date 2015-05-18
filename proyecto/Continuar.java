import greenfoot.*;
import java.util.*;
/**
 * Esta Clase sirve para poder avanzar al siguiente nivel
 * esta recibira una variable para poder seleccionar que  nivel sigue a ejecutar
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Continuar extends Boton
{
    /**
     * Act - hace lo que Continuar quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    private int Nivel;
    private World w;
    private List puntos;
    private int p;
    /**
     * Constructor de Continuar, recibe una variable para poder seleccionar que nivel sigue 
     * 
     * a ejecutar
     */
    public Continuar(int n,int punt)
    
    {
        p=punt;
        Nivel=n;
    }

    public void act() 
    {
        w=getWorld();
       System.out.println(p);
        if(Greenfoot.mouseClicked(this))
        {

            if(Nivel==1){
                w=new Nivel1(0);
                Greenfoot.setWorld(w);
                w.showText("Nivel 1",400,560);}}
        if(Greenfoot.mouseClicked(this))
        {
            
            if(Nivel==2){
                
                
                
                w=new Nivel2(p);
                Greenfoot.setWorld(w);
            w.showText("Nivel 2",400,560);}}
        if(Greenfoot.mouseClicked(this))
        {

            if(Nivel==3){
                 puntos=w.getObjects(Puntos.class);


        
                w=new Nivel3(p);
                Greenfoot.setWorld(w);
            w.showText("Nivel 3",400,560);}}

    }
}