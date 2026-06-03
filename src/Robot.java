public class Robot
{
    
    private EstadoMontaje tipoTarea;
    private Operario operarioDesignado;
    
    public Robot(EstadoMontaje tipoTarea, Operario operarioDesignado){
        
        this.tipoTarea = tipoTarea;
        this.operarioDesignado = operarioDesignado;
        
    }
    
    public int obtenerTiempoTrabajo(){
    
        return operarioDesignado.obtenerTiempoMontaje();
        
    }
    
    public EstadoMontaje getTipoTarea(){
        
        return tipoTarea;
        
    }
    
     public Operario getOperarioAsignado(){
         
        return operarioDesignado;
        
    }
    
    public void setOperarioAsignado(Operario operarioAsignado){
        
        this.operarioDesignado = operarioAsignado;
        
    }
    
    public void registrarMontajeRealizado(){
        
        operarioDesignado.incrementarMontajesRealizados();
    
    }
}