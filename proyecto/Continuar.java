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
    private int nivel;
    private World world;
    private List puntosList;
    private int puntuacion;
    /**
     * Constructor de Continuar, recibe una variable para poder seleccionar que nivel sigue 
     * a ejecutar
     * @param n es el nivel  siguiente
     * @param punt en el puntaje acumulado
     */
    public Continuar(int num,int punt)

    {
        puntuacion=punt;
        nivel=num;
    }

    public void act() 
    {
        world=getWorld();

        if(Greenfoot.mouseClicked(this))
        {

            if(nivel==1){
                world=new Nivel1(0);
                Greenfoot.setWorld(world);
                world.showText("Nivel 1",400,560);}}
        if(Greenfoot.mouseClicked(this))
        {

            if(nivel==2){

                
                world=new Nivel2(puntuacion);
                Greenfoot.setWorld(world);
                world.showText("Nivel 2",400,560);}}
        if(Greenfoot.mouseClicked(this))
        {

            if(nivel==3){
                puntosList=world.getObjects(Puntos.class);

        
                world=new Nivel3(puntuacion);
                Greenfoot.setWorld(world);
                world.showText("Nivel 3",400,560);
            }
        }

    }
}