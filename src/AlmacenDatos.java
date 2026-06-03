import java.util.ArrayList;

public class AlmacenDatos
{
    
    private ArrayList<Motor> motores;
    private ArrayList<Tapiceria> tapicerias;
    private ArrayList<Ruedas> ruedas;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<ConfiguracionVehiculo> configuracionesVehiculo;
    
    public AlmacenDatos(){
        
        motores = new ArrayList<Motor>();
        tapicerias = new ArrayList<Tapiceria>();
        ruedas = new ArrayList<Ruedas>();
        trabajadores = new ArrayList<Trabajador>();
        configuracionesVehiculo = new ArrayList<ConfiguracionVehiculo>();
        
    }
    
    public void addMotor(Motor motor){
        
        motores.add(motor);
        
    }

    public void addTapiceria(Tapiceria tapiceria){
        
        tapicerias.add(tapiceria);
        
    }

    public void addRueda(Ruedas rueda){
        
        ruedas.add(rueda);
        
    }

    public void addTrabajador(Trabajador trabajador){
        
        trabajadores.add(trabajador);
        
    }

    public void addConfiguracionVehiculo(ConfiguracionVehiculo configuracion){
        
        configuracionesVehiculo.add(configuracion);
        
    }

    public ArrayList<Motor> getMotores(){
        
        return motores;
        
    }

    public ArrayList<Tapiceria> getTapicerias(){
        
        return tapicerias;
        
    }

    public ArrayList<Ruedas> getRuedas(){
        
        return ruedas;
        
    }

    public ArrayList<Trabajador> getTrabajadores(){
        
        return trabajadores;
        
    }

    public ArrayList<ConfiguracionVehiculo> getConfiguracionesVehiculo(){
        
        return configuracionesVehiculo;
        
    }
    
}