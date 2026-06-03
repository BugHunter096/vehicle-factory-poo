import java.util.Date;
import java.util.Random;

public class MecanicoCinta extends Trabajador{
    
    private int reparacionesRealizadas;
    
    public MecanicoCinta(String nombre, String apellidos, String dni, String direccion, String numSS, String puesto, double salario, Date fechaIngreso, int reparacionesRealizadas){
        
        super(nombre, apellidos, dni, direccion, numSS, puesto, salario, fechaIngreso);
        this.reparacionesRealizadas = reparacionesRealizadas;
        
    }
    
    public int getReparacionesRealizadas(){
        
        return reparacionesRealizadas;
        
    }

    public void setReparacionesRealizadas(int reparacionesRealizadas){
        
        this.reparacionesRealizadas = reparacionesRealizadas;
        
    }
    
    public boolean eficiencia(){
        
        return reparacionesRealizadas > 20;
        
    }
    
    public int obtenerTiempoReparacion(){
        
        if (eficiencia()){
            
            return 1;
            
        }else{
            
            Random random = new Random();
            return random.nextInt(4) + 2;
            
        }
    }
    
    
    
}