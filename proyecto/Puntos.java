import greenfoot.*;
import java.util.*;

/**
 * Escribe una descrición de la clase Puntos aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
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
     * Act - hace lo que Puntos quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
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
    public void act() 
    {
        w=getWorld();
        w.showText("Puntos",50,150);
        M=w.getObjects(Muro.class);
        E=w.getObjects(Enemigo.class);
        if(k<0){
        if(M.isEmpty()&& band==0){
            
        
         setPuntos(200);
         w.showText(" "+ score,50,200);
         band=1; }
        if(E.isEmpty() && band==1){
        setPuntos(500);
        w.showText(" "+score,50,200);
        band=2;}
        }
        else
        {
        if(M.isEmpty() && band==0)        {
        setPuntos(100);
        w.showText(" "+score,50,200);
        band=1;}
        if(E.isEmpty()&& band==1){
        setPuntos(300);
        w.showText(" "+score,50,200);
         band=2;}
        }
        w.showText("Tiempo",50,300);  
        ///w.addObject(count,50,300);
       
        if(i==8){
            
            if(j<60){
             tim=toString(j);
             w.showText(k+ ":"+ tim,50,320);}
           else
           {
               k++;
               j=0;
               tim=toString(j);
               w.showText(k+":"+tim,50,320);
            }
        
        j++;
        i=0;}
       
        i++;
        r.guardaRecords(score);
        //tiempo.mark();
        
        
        
       }
    
    public void setPuntos(int p)
    {         
            score=score+p;
    }    
    public String toString(int t)
    {
        return "" + t;
    }
    public int getPuntos()
    {
        return score;
    }
}
