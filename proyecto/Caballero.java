import greenfoot.*;

/**
 * Escribe una descrición de la clase Caballero aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Caballero extends Heroe
{
    private int Ataque;
    private int DañoRes;
    private int Def;
    private int band;
    public Caballero()
    {
        Ataque=0;
        DañoRes=0;
        Def=100;
        band=0;
    }
    public void act() 
    {
        // Agrega tus códigos de acción aquí.
        int i=0,x=0;
       band=super.setCom();
      if(band==1){           
        Ataque(); 
        comando=0;}
        if(band==2){
            Def();
        comando=0;}
       if(band==3){
       Regreso();
       comando=0;}
    }    
     public void Ataque()
    {  
        int x=getX();
        int mod;
       // System.out.println(x);
        //Greenfoot.delay(20);
             if(x<550){
                 mod=x;
                 mod=mod%2;
                 if(mod==0)
                            setImage("CabAtack01.png");
                  else
                            setImage("CabAtack02.png");
                            
                            move(80);  
                        }
                            else
                            {
                            setImage("CabAtack03.png");
                            
                            }
                            
              
        
        
    }
    public void Regreso()
    {       
       setLocation(200,500); 
        setImage("CabAtack01.png");
        
        
    }
    public void Def()
    {
        setImage("DefCab01.png");
    }
}
