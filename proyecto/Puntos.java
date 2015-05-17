import greenfoot.*;
import java.util.*;

/**
 * Esta clase sirve para poder poner en el mundo el puntaje y el tiempo que ha pasado durante la ejecucion
 * dell tiempo
 * @autor Omar Agustin Valadez Hernandez 
 * @versión Mayo 2015
 */

public class Puntos extends Actor
{
    private int score;

    private Record r;
    private World w;
    private List M;
    private List E;
    private String puntos;
    private String tim;
    private Counter count;
    private int band;
    private int i;
    private int j;
    private int k;

    /**
     * Constructor de Puntos 
     * aqui se definen las variables de instancia 
     * el score es para guardar los records
     * r sera un record el cual servira para poder guardar los puntos 
     * 
     */
    public Puntos()
    {

        score=0;
        r=new Record();
        j=0;
        i=0;
        k=0;
        band=0;
        count=new Counter();
    }

    /**
     * Act - hace lo que Puntos quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
        w=getWorld();
        w.showText("Puntos",50,150);
        M=w.getObjects(Muro.class);
        E=w.getObjects(Enemigo.class);
        if(k==0){
            if(M.isEmpty()&& band==0){

                setPuntos(200);
                w.showText(" "+ score,50,170);
                band=1; }
            if(E.isEmpty() && band==1){
                setPuntos(500);
                w.showText(" "+score,50,170);
                band=2;}
        }
        else
        {
            if(M.isEmpty() && band==0)        {
                setPuntos(100);
                w.showText(" "+score,50,170);
                band=1;}
            if(E.isEmpty()&& band==1){
                setPuntos(300);
                w.showText(" "+score,50,170);
                band=2;}
        }
        w.showText("Tiempo",150,50);  
        ///w.addObject(count,50,300);

        if(i==8){

            if(j<60){
                tim=toString(j);
                w.showText(k+ ":"+ tim,150,100);}
            else
            {
                k++;
                j=0;
                tim=toString(j);
                w.showText(k+":"+tim,150,100);
            }

            j++;
            i=0;}

        i++;
        r.guardaRecords(score);
        //tiempo.mark();

        
    }

    /**
     * cooca los  puntos
     */
    public void setPuntos(int p)
    {         
        score=score+p;
    }    

    /**
     * convierte a cadena un entero
     */
    public String toString(int t)
    {
        return "" + t;
    }

    /**
     * regresa el total de puntos
     */
    public int getPuntos()
    {
        return score;
    }
}
