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

    private Record r;//se usa para un nuevo record
    private World w;//mundo para obtener onjetos de el
    private List M;//se usa para guardar actores en ella
    private List E;
    private String puntos;
    private String tim;//cadena para mostrar el tiempo

    private int band;//banderas
    private int i;//contadores
    private int j;
    private int k;

    /**
     * Constructor de Puntos 
     * aqui se definen las variables de instancia 
     * el score es para guardar los records
     * r sera un record el cual servira para poder guardar los puntos 
     * @param p recibe los puntos acumulados
     */
    public Puntos(int p)
    {

        score=p;
        r=new Record();
        j=0;
        i=0;
        k=0;
        band=0;

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
                int num=Greenfoot.getRandomNumber(300);
                setPuntos(num);
                w.showText(" "+ score,50,170);
                band=1; }
            if(E.isEmpty() && band==1){
                int num=Greenfoot.getRandomNumber(300);
                setPuntos(num);
                w.showText(" "+score,50,170);
                band=2;}
        }
        else if(k>0 && j>0){
        
            if(M.isEmpty() && band==0)        {
                int num=Greenfoot.getRandomNumber(300);
               
                num=num+100;
                setPuntos(num);
                w.showText(" "+score,50,170);
                band=1;}
            if(E.isEmpty()&& band==1){
                int num=Greenfoot.getRandomNumber(500);
                
                num=num+100;
                setPuntos(num);
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
     * @param p coloca los nuevos puntos y los acumula
     */
    public void setPuntos(int p)
    {         
        score=score+p;
    }    

    /**
     * convierte a cadena un entero
     * @param t recibe un entero a comvertir
     * @return " "+t regresa una cadena 
     */
    public String toString(int t)
    {
        return "" + t;
    }

    /**
     * @return score regresa el total de puntos
     */
    public int getPuntos()
    {
        return score;
    }
}
