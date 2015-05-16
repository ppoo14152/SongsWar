import greenfoot.UserInfo;
/**
 * Escribe una descrición de la clase Record aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Record  
{
    // instance variables - reemplace el ejemplo a continuación por uno propio
    private UserInfo jugador;
    
    public Record() 
    { 
        if ((UserInfo.isStorageAvailable()) && (UserInfo.getMyInfo() != null)) {
          this.jugador = UserInfo.getMyInfo();
        }
    }
    
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

