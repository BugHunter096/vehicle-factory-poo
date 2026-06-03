import java.util.Date;

public class AdminSistemas extends Trabajador{
    
    private int tiempoReinicioGestion;
    private int tiempoReinicioCadenas;
    
     public AdminSistemas(String nombre, String apellidos, String dni, String direccion, String numSS, String puesto, double salario, Date fechaIngreso){
         
        super(nombre, apellidos, dni, direccion, numSS, puesto, salario, fechaIngreso);
        this.tiempoReinicioGestion = 2;
        this.tiempoReinicioCadenas = 3;
        
    }
    
    public int getTiempoReinicioGestion(){
        
        return tiempoReinicioGestion;
        
    }

    public int getTiempoReinicioCadenas(){
        
        return tiempoReinicioCadenas;
        
    }
    
}