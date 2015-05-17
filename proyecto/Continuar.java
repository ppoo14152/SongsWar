import greenfoot.*;

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
    /**
     * Constructor de Continuar, recibe una variable para poder seleccionar que nivel sigue 
     * 
     * a ejecutar
     */
    public Continuar(int n)
    {
        Nivel=n;
    }

    public void act() 
    {
        w=getWorld();
        System.out.println(Nivel);
        if(Greenfoot.mouseClicked(this))
        {

            if(Nivel==1){
                w=new Nivel1();
                Greenfoot.setWorld(w);}}
        if(Greenfoot.mouseClicked(this))
        {

            if(Nivel==2){
                w=new Nivel2();
                Greenfoot.setWorld(w);}}
        if(Greenfoot.mouseClicked(this))
        {

            if(Nivel==3){
                w=new Nivel3();
                Greenfoot.setWorld(w);}}

    }
}