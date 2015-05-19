import greenfoot.UserInfo;
/**
 * Esta clase guarda los puntos y los regresa en la clase scoreBoard
 * 
 * @autor Ignacio Cerda Varela
 * @versión Mayo 2015
 */
public class Record  
{
    // instance variables - reemplace el ejemplo a continuación por uno propio
    private UserInfo jugador;
    private int score;
   /**
    * define las variables de instancia
    */
    
    public Record() 
    { 
        
        if ((UserInfo.isStorageAvailable()) && (UserInfo.getMyInfo() != null)) {
          this.jugador = UserInfo.getMyInfo();
        }
    }
    /**
     * guarda los puntos 
     */
    public void guardaRecords(int puntos)
    {
         if((UserInfo.isStorageAvailable()) && (this.jugador != null) && ((puntos > this.jugador.getScore())) || (this.jugador.getInt(0))==0){ 
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
        
        if((UserInfo.isStorageAvailable()) && (this.jugador != null) && (puntos > this.jugador.getScore())){
            this.jugador.setScore(puntos);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
    }
     
}

