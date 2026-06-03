public class CadenaMontaje{
    
    private String tipoVehiculoProduccion;
    private ConfiguracionVehiculo configuracionActual;
    private int unidadesPendientes;
    private EstadoMontaje estadoActual;
    private int tiempoTrabajadoEnEstadoActual;
    
    private Robot robotChasis;
    private Robot robotMotor;
    private Robot robotTapiceria;
    private Robot robotRuedas;
    
    private boolean activa;
    private int vehiculosTerminados;
    
    public CadenaMontaje(String tipoVehiculoQueProduce, Robot robotChasis, Robot robotMotor, Robot robotTapiceria, Robot robotRuedas){
        
        this.tipoVehiculoProduccion = tipoVehiculoQueProduce;
        this.robotChasis = robotChasis;
        this.robotMotor = robotMotor;
        this.robotTapiceria = robotTapiceria;
        this.robotRuedas = robotRuedas;

        this.configuracionActual = null;
        this.unidadesPendientes = 0;
        this.estadoActual = EstadoMontaje.sinIniciar;
        this.tiempoTrabajadoEnEstadoActual = 0;
        this.activa = false;
        this.vehiculosTerminados = 0;
        
    }
    
    public void configurarCadena(ConfiguracionVehiculo configuracion, int unidades){
        
        this.configuracionActual = configuracion;
        this.unidadesPendientes = unidades;
        this.estadoActual = EstadoMontaje.sinIniciar;
        this.tiempoTrabajadoEnEstadoActual = 0;
        this.activa = true;
        this.vehiculosTerminados = 0;
        
    }
    
     public void avanzarUnSegundo(){
         
        if (!activa){
            
            return;
            
        }

        if (unidadesPendientes == 0){
            
            activa = false;
            return;
            
        }

        if (estadoActual == EstadoMontaje.sinIniciar){
            
            estadoActual = EstadoMontaje.chasis;
            tiempoTrabajadoEnEstadoActual = 0;
            
        }

        Robot robotActual = obtenerRobotSegunEstado();

        if (robotActual == null){
            
            return;
            
        }

        int tiempoNecesario = robotActual.obtenerTiempoTrabajo();
        tiempoTrabajadoEnEstadoActual++;

        if (tiempoTrabajadoEnEstadoActual >= tiempoNecesario){
            
            montarParteActual();
            cambiarAlSiguienteEstado();
            tiempoTrabajadoEnEstadoActual = 0;

            if (estadoActual == EstadoMontaje.fin){
                
                vehiculosTerminados++;
                unidadesPendientes--;

                if (unidadesPendientes > 0){

                    estadoActual = EstadoMontaje.sinIniciar;
                    
                }else{
                    
                    activa = false;
                    
                }
            }
        }
    }

    private Robot obtenerRobotSegunEstado(){
        
        if (estadoActual == EstadoMontaje.chasis){
            
            return robotChasis;
            
        }else if (estadoActual == EstadoMontaje.motor){
            
            return robotMotor;
            
        }else if (estadoActual == EstadoMontaje.tapiceria){
            
            return robotTapiceria;
            
        }else if (estadoActual == EstadoMontaje.ruedas){
            
            return robotRuedas;
            
        }else{
            
            return null;
            
        }
    }

    private void cambiarAlSiguienteEstado(){
        
        if (estadoActual == EstadoMontaje.chasis){
            
            estadoActual = EstadoMontaje.motor;
            
        }else if (estadoActual == EstadoMontaje.motor){
            
            estadoActual = EstadoMontaje.tapiceria;
            
        }else if (estadoActual == EstadoMontaje.tapiceria){
            
            estadoActual = EstadoMontaje.ruedas;
            
        }else if (estadoActual == EstadoMontaje.ruedas){
            
            estadoActual = EstadoMontaje.fin;
            
        }
    }

    private void montarParteActual(){
        
        Robot robotActual = obtenerRobotSegunEstado();

        if (robotActual != null){
            
            robotActual.registrarMontajeRealizado();
        
        }
    }

    public String getTipoVehiculoQueProduce(){
        
        return tipoVehiculoProduccion;
        
    }

    public ConfiguracionVehiculo getConfiguracionActual(){
        
        return configuracionActual;
        
    }

    public int getUnidadesPendientes(){
        
        return unidadesPendientes;
        
    }

    public EstadoMontaje getEstadoActual(){
        
        return estadoActual;
        
    }

    public int getTiempoTrabajadoEnEstadoActual(){
        
        return tiempoTrabajadoEnEstadoActual;

    }

    public boolean isActiva(){
        
        return activa;
        
    }

    public int getVehiculosTerminados(){
        
        return vehiculosTerminados;
        
    }
    
}