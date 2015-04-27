import greenfoot.*;

/**
 * Escribe una descrición de la clase Espadachin aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Espadachin extends Heroe 
{
    private int Ataque;
    private int DañoRes;
    private int Def;
    private int band;
    private int band2;
    private GreenfootImage Atk01;
    private GreenfootImage Atk02;
    private GreenfootImage Atk03;
    private GreenfootImage Def01;
    public Espadachin()
    {
        Ataque=100;
        DañoRes=0;
        Def=100;
        band=0;
        band2=0;
        Atk01=new GreenfootImage("Atack01.png");
        Atk02=new GreenfootImage("Atack02.png");
        Atk03=new GreenfootImage("Atack03.png");
        Def01=new GreenfootImage("Def01.png");
        
    }
   public void act() 
    {
        // Agrega tus códigos de acción aquí.
        int i=0,x=0;
       band=super.setCom();
       
      
       if(band==1){           
        band2=Ataque();
        getAtk();
        super.getTouch();
       
        
    }
             
           
       if(band==2){
            Def();
        comando=0;}
        
       if(band==3){
       Regreso();
        comando=0;}
       
        
        
        
    }
    public int getAtk()
    {
        
        return Ataque;
    }
    
    public int Ataque()
    {  
        int x=getX();
        int x2=0;
        int mod;
       // System.out.println(x);
        //Greenfoot.delay(20);
             if(x<500){
                 mod=x;
                 mod=mod%2;
                 if(mod==0)
                            setImage(Atk01);
                  else
                            setImage(Atk02);
                            
                            move(50);
                            
                        }
                            else
                            {
                            setImage(Atk03);
                             band2=3;                   
                            }
                            
              
       
        return band2;
    }
    public void Def()
    {
        setImage(Def01);
    }
    public void Regreso()
    {   int x=getX();
       
       setLocation(250,500);
        setImage(Atk01);
        
        
    }
}
  
