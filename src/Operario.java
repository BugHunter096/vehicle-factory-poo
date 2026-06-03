import java.util.Date;

public class Operario extends Trabajador
{
    
    private int montajesRealizados;
    
    public Operario(String nombre, String apellidos, String dni, String direccion, String numSS, String puesto, double salario, Date fechaIngreso, int montajesRealizados){
        
        super(nombre, apellidos, dni, direccion, numSS, puesto, salario, fechaIngreso);
        this.montajesRealizados = montajesRealizados;
        
    }
    
    public int getMontajesRealizados(){
        
        return montajesRealizados;
        
    }

    public void setMontajesRealizados(int montajesRealizados){
        
        this.montajesRealizados = montajesRealizados;
        
    }

    public int obtenerTiempoMontaje(){
        
        if (montajesRealizados > 10){
            
            return 1;
            
        }else{
            
            return 3;
            
        }
        
    }
    
    public void incrementarMontajesRealizados(){
        
        montajesRealizados++;
    
    }
    
    public String toString(){
        
        String tipoOperario;
    
        if (montajesRealizados > 10){
            
            tipoOperario = "Eficiente";
        }else{
            
            tipoOperario = "Estandar";
       
        }
    
        return getApellidos() + ", " + getNombre() + " | DNI: " + getDni() + " | Puesto: " + getPuesto() +
               " | Montajes realizados: " + montajesRealizados + " | Tipo: " + tipoOperario +
               " | Tiempo montaje: " + obtenerTiempoMontaje() + " segundo(s)";
               
    }
}