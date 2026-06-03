public class ConfiguracionVehiculo
{
    
    private Vehiculo vehiculoBase;
    private Motor motor;
    private Tapiceria tapiceria;
    private Ruedas ruedas;
    private int unidadesSolicitadas;
    
    public ConfiguracionVehiculo(Vehiculo vehiculoBase, Motor motor, Tapiceria tapiceria, Ruedas ruedas, int unidadesSolicitadas){
        
        this.vehiculoBase = vehiculoBase;
        this.motor = motor;
        this.tapiceria = tapiceria;
        this.ruedas = ruedas;
        this.unidadesSolicitadas = unidadesSolicitadas;
        
    }
    
     public Vehiculo getVehiculoBase()
    {
        return vehiculoBase;
    }

    public Motor getMotor()
    {
        return motor;
    }

    public Tapiceria getTapiceria()
    {
        return tapiceria;
    }

    public Ruedas getRuedas()
    {
        return ruedas;
    }

    public int getUnidadesSolicitadas()
    {
        return unidadesSolicitadas;
    }

    public void setUnidadesSolicitadas(int unidadesSolicitadas)
    {
        this.unidadesSolicitadas = unidadesSolicitadas;
    }
    
    public String toString(){
        
        return vehiculoBase.getClass().getSimpleName() +
               " | motor: " + motor.getTipoMotor() +
               " | tapiceria: " + tapiceria.getTipoTapiceria() +
               " | ruedas: " + ruedas.getTipoRueda() +
               " | unidades: " + unidadesSolicitadas;
    }
}