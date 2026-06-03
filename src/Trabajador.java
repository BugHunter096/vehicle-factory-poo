import java.util.Date;

public abstract class Trabajador{
    
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String numSS;
    private String puesto;
    private double salario;
    private Date fechaIngreso;
    
    public Trabajador(String nombre, String apellidos, String dni, String direccion, String numSS, String puesto, double salario, Date fechaIngreso){
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.numSS = numSS;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        
    }
    
    public String getNombre(){
        
        return nombre;
        
    }

    public String getApellidos(){
        
        return apellidos;
        
    }

    public String getDni(){
        
        return dni;
        
    }

    public String getDireccion(){
        
        return direccion;
        
    }
    
    public void setDireccion(String direccion){
        
        this.direccion = direccion;
        
    }

    public String getNumSS(){
        
        return numSS;
        
    }

    public String getPuesto(){
        
        return puesto;
        
    }
    
     public void setPuesto(String puesto){
        
        this.puesto = puesto;
        
    }

    public double getSalario(){
        
        return salario;
        
    }
    
    public void setSalario(double salario){
        
        this.salario = salario;
        
    }

    public Date getFechaIngreso(){
        
        return fechaIngreso;
        
    }
    


    public String toString(){

        return getClass().getSimpleName() +
               " | nombre: " + nombre + " " + apellidos +
               " | DNI: " + dni +
               " | puesto: " + puesto +
               " | salario: " + salario;
    }

}
