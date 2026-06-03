import java.util.ArrayList;

public class DashBoard
{
    
    private AlmacenDatos almacen;
    private ArrayList<CadenaMontaje> cadenas;
    private VisualizarDashboard visualizador;
    
    public DashBoard(AlmacenDatos almacen, ArrayList<CadenaMontaje> cadenas, VisualizarDashboard visualizador){
        
        this.almacen = almacen;
        this.cadenas = cadenas;
        this.visualizador = visualizador;
        
    }    
    
    public void mostrarDashboard(){
        
        String contenido = generarResumen();
        visualizador.mostrar(contenido);
        
    }
    
     private String generarResumen(){
         
        String resumen = "";

        resumen += "========== DASHBOARD DE FABRICA ==========\n\n";

        resumen += generarResumenAlmacen();
        resumen += "\n";
        resumen += generarResumenCadenas();

        resumen += "\n==========================================\n";

        return resumen;
        
    }
    
     private String generarResumenAlmacen(){
         
        String resumen = "";

        resumen += "--- RESUMEN DEL ALMACEN ---\n";

        resumen += "Motores registrados: " + almacen.getMotores().size() + "\n";
        for (Motor motor : almacen.getMotores()){
            resumen += "  - " + motor + "\n";
        }

        resumen += "Tapicerias registradas: " + almacen.getTapicerias().size() + "\n";
        for (Tapiceria tapiceria : almacen.getTapicerias()){
            resumen += "  - " + tapiceria + "\n";
        }

        resumen += "Ruedas registradas: " + almacen.getRuedas().size() + "\n";
        for (Ruedas rueda : almacen.getRuedas()){
            resumen += "  - " + rueda + "\n";
        }

        resumen += "Trabajadores registrados: " + almacen.getTrabajadores().size() + "\n";
        resumen += "Configuraciones de vehiculo: " + almacen.getConfiguracionesVehiculo().size() + "\n";

        return resumen;
        
    }
    
    private String generarResumenCadenas(){
        
        String resumen = "";
        resumen += "--- ESTADO DE CADENAS DE MONTAJE ---\n";

        if (cadenas.size() == 0){
            
            resumen += "No hay cadenas de montaje registradas.\n";
            return resumen;
            
        }

        for (CadenaMontaje cadena : cadenas){
            
            resumen += "Cadena: " + cadena.getTipoVehiculoQueProduce() + "\n";
            resumen += "Estado actual: " + cadena.getEstadoActual() + "\n";
            resumen += "Unidades pendientes: " + cadena.getUnidadesPendientes() + "\n";
            resumen += "Vehiculos terminados: " + cadena.getVehiculosTerminados() + "\n";
            resumen += "Tiempo trabajado en estado actual: " + cadena.getTiempoTrabajadoEnEstadoActual() + "\n";
            resumen += "Activa: " + cadena.isActiva() + "\n";
            resumen += "--------------------------------------\n";
            
        }

        return resumen;
    }
    
}