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
    private int i;
    private GreenfootImage Atk01;
    private GreenfootImage Atk02;
    private GreenfootImage Atk03;
    private GreenfootImage Def01;
    private long seg;
    private String regreso;
    
    public Espadachin()
    {
        Ataque=20;
        DañoRes=0;
        Def=100;
        band=0;
        band2=0;
        i=0;
        Atk01=new GreenfootImage("Atack01.png");
        Atk02=new GreenfootImage("Atack02.png");
        Atk03=new GreenfootImage("Atack03.png");
        Def01=new GreenfootImage("Def01.png");
        seg=System.currentTimeMillis();
        
        regreso=" " ;
    }
   public void act() 
    {
        // Agrega tus códigos de acción aquí.
        
       band=super.setCom();
       
      
       if(band==1){  
         
        band2=Ataque();
        super.getTouch(); 
        
        
        
    }
             
           
       if(band==2){
            Def();
      }
      if(band==3){
       
        Regreso();
       }
        
        
       
        
        
        
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
                            move(0);
                             band2=1;                 
                            }
                            
              return band2;
       
        
    }
    public int Ataque2()
    {
        switch(i)
        {
            case 10: setImage(Atk01);
            break;
            case 20: setImage(Atk02);
            break;
            case 0:setImage(Atk03);
            band=3;
            break;
           }
           move(50);
           
           i++;
           if(i==50)
           {
               i=0;
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
  
