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

    private Record record;//se usa para un nuevo record
    private World world;//mundo para obtener onjetos de el
    private List muroList;//se usa para guardar actores en ella
    private List enemigoList;
    private String puntos;
    private String tiempo;//cadena para mostrar el tiempo

    private int bandSuma;//banderas
    private int iterador;//contadores
    private int segundo;
    private int minuto;

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
        record=new Record();
        segundo=0;
        iterador=0;
        minuto=0;
        bandSuma=0;

    }

    /**
     * Act - hace lo que Puntos quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    public void act() 
    {
        world=getWorld();
        world.showText("Puntos",50,150);
        muroList=world.getObjects(Muro.class);
        enemigoList=world.getObjects(Enemigo.class);
        if(minuto==0){
            if(muroList.isEmpty()&& bandSuma==0){
                int num=Greenfoot.getRandomNumber(300);
                setPuntos(num);
                world.showText(" "+ score,50,170);
                bandSuma=1; }
            if(enemigoList.isEmpty() && bandSuma==1){
                int num=Greenfoot.getRandomNumber(300);
                setPuntos(num);
                world.showText(" "+score,50,170);
                bandSuma=2;}
        }
        else if(minuto>0 || segundo>0){
        
            if(muroList.isEmpty() && bandSuma==0)        {
                int num=Greenfoot.getRandomNumber(300);
               
                num=num+100;
                setPuntos(num);
                world.showText(" "+score,50,170);
                bandSuma=1;}
            if(enemigoList.isEmpty()&& bandSuma==1){
                int num=Greenfoot.getRandomNumber(500);
                
                num=num+100;
                setPuntos(num);
                world.showText(" "+score,50,170);
                bandSuma=2;}
        }
        world.showText("Tiempo",150,50);  
        ///w.addObject(count,50,300);

        if(iterador==8){

            if(segundo<60){
                tiempo=toString(segundo);
                world.showText(minuto + ":"+ tiempo,150,100);}
            else
            {
                minuto++;
                segundo=0;
                tiempo=toString(segundo);
                world.showText(minuto +":"+tiempo,150,100);
            }

            segundo++;
            iterador=0;}

        iterador++;
        record.guardaRecords(score);
        //tiempo.mark();

        
    }

    /**
     * @param p coloca los nuevos puntos y los acumula
     */
    public void setPuntos(int punto)
    {         
        score=score+punto;
    }    

    /**
     * convierte a cadena un entero
     * @param t recibe un entero a comvertir
     * @return " "+t regresa una cadena 
     */
    public String toString(int tiempo)
    {
        return "" + tiempo;
    }

    /**
     * @return score regresa el total de puntos
     */
    public int getPuntos()
    {
        return score;
    }
}
