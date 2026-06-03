import java.util.ArrayList;

public class SistemaGestionFabrica
{
    
    private AlmacenDatos almacen;
    private Planificador planificador;
    private DashBoard dashboard;

    public SistemaGestionFabrica(){
        
        this.almacen = new AlmacenDatos();
        this.planificador = new Planificador();

        VisualizarDashboard visualizador = new VisualizarTexto();

        this.dashboard = new DashBoard(
            almacen,
            planificador.getListaCadenas(),
            visualizador
        );
        
    }

    public void darAltaTrabajador(Trabajador trabajador){
        
        almacen.addTrabajador(trabajador);
    
    }

    public Trabajador buscarTrabajadorPorDni(String dni){
        
        ArrayList<Trabajador> trabajadores = almacen.getTrabajadores();

        for (Trabajador trabajador : trabajadores){
            
            if (trabajador.getDni().equals(dni)){
                
                return trabajador;
                
            }
        }

        return null;
    }

    public ArrayList<Trabajador> buscarTrabajadoresPorApellido(String apellido){
        
        ArrayList<Trabajador> resultado = new ArrayList<Trabajador>();
        ArrayList<Trabajador> trabajadores = almacen.getTrabajadores();

        for (Trabajador trabajador : trabajadores){
            
            if (trabajador.getApellidos().equalsIgnoreCase(apellido)){
                
                resultado.add(trabajador);
                
            }
        }

        return resultado;
    }

    public void aniadirMotor(Motor motor){
        
        almacen.addMotor(motor);
    
    }

    public void aniadirTapiceria(Tapiceria tapiceria){
        
        almacen.addTapiceria(tapiceria);
    
    }

    public void aniadirRueda(Ruedas rueda){
        
        almacen.addRueda(rueda);
    
    }

    public ConfiguracionVehiculo crearConfiguracionVehiculo(Vehiculo vehiculo, Motor motor, Tapiceria tapiceria,
        Ruedas rueda, int unidadesSolicitadas){
            
        ConfiguracionVehiculo configuracion = new ConfiguracionVehiculo(vehiculo,motor,tapiceria,rueda,unidadesSolicitadas);

        almacen.addConfiguracionVehiculo(configuracion);

        return configuracion;
    }

    public String consultarStock(){

        String resumen = "";

        resumen += "===== STOCK ACTUAL =====\n";
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

        resumen += "Trabajadores: " + almacen.getTrabajadores().size() + "\n";
        resumen += "Configuraciones de vehiculo: " + almacen.getConfiguracionesVehiculo().size() + "\n";

        return resumen;
    }

    public boolean retirarMotor(Motor motor){

        return almacen.getMotores().remove(motor);
        
    }

    public boolean retirarTapiceria(Tapiceria tapiceria){
        
        return almacen.getTapicerias().remove(tapiceria);
        
    }

    public boolean retirarRueda(Ruedas rueda){
        
        return almacen.getRuedas().remove(rueda);
    
    }

    public void registrarCadenaMontaje(CadenaMontaje cadena){
        
        planificador.addCadena(cadena);
    
    }

    public void iniciarPlanificadorSimple(){
        
        planificador.iniciarSimulacionSimple();
    
    }

    public void consultarDashboard(){
        
        dashboard.mostrarDashboard();
    
    }

    public AlmacenDatos getAlmacen(){
        
        return almacen;
    
    }

    public Planificador getPlanificador(){
        
        return planificador;
    
    }

    public DashBoard getDashBoard(){
        
        return dashboard;
    
    }
    
    public ArrayList<Motor> getMotores(){
        
        return almacen.getMotores();
    
    }

    public ArrayList<Tapiceria> getTapicerias(){
        
        return almacen.getTapicerias();
    
    }

    public ArrayList<Ruedas> getRuedas(){
        
        return almacen.getRuedas();

    }

    public ArrayList<ConfiguracionVehiculo> getConfiguracionesVehiculo(){
        
        return almacen.getConfiguracionesVehiculo();
    }

    public ArrayList<Operario> getOperarios(){
        
        ArrayList<Operario> operarios = new ArrayList<Operario>();

        for (Trabajador trabajador : almacen.getTrabajadores()){
            
            if (trabajador instanceof Operario){
                
                operarios.add((Operario) trabajador);
            
            }
        }

        return operarios;
    }
    
    public boolean hayStockSuficiente(ConfiguracionVehiculo configuracion){
        
        int unidades = configuracion.getUnidadesSolicitadas();

        return configuracion.getMotor().getStock() >= unidades &&
               configuracion.getTapiceria().getStock() >= unidades &&
               configuracion.getRuedas().getStock() >= unidades;
    }
    
    public boolean descontarStockConfiguracion(ConfiguracionVehiculo configuracion){
        
        if (!hayStockSuficiente(configuracion)){
            
            return false;
        
        }
    
        int unidades = configuracion.getUnidadesSolicitadas();
    
        configuracion.getMotor().reducirStock(unidades);
        configuracion.getTapiceria().reducirStock(unidades);
        configuracion.getRuedas().reducirStock(unidades);
    
        return true;
    }
    
    public ArrayList<Operario> listarOperarios()
{
    return getOperarios();
}

public ArrayList<Operario> listarOperariosEficientes()
{
    ArrayList<Operario> resultado = new ArrayList<Operario>();

    for (Operario operario : getOperarios())
    {
        if (operario.getMontajesRealizados() > 10)
        {
            resultado.add(operario);
        }
    }

    return resultado;
}

public ArrayList<Operario> listarOperariosEstandar()
{
    ArrayList<Operario> resultado = new ArrayList<Operario>();

    for (Operario operario : getOperarios())
    {
        if (operario.getMontajesRealizados() <= 10)
        {
            resultado.add(operario);
        }
    }

    return resultado;
}

    public ArrayList<Operario> listarOperariosOrdenadosAlfabeticamente(){
        
        ArrayList<Operario> operarios = new ArrayList<Operario>(getOperarios());
    
        for (int i = 0; i < operarios.size() - 1; i++){
            
            for (int j = i + 1; j < operarios.size(); j++){
                
                Operario operarioI = operarios.get(i);
                Operario operarioJ = operarios.get(j);
    
                int comparacionApellidos = operarioI.getApellidos().compareToIgnoreCase(operarioJ.getApellidos());
    
                if (comparacionApellidos > 0){
                    
                    Operario auxiliar = operarios.get(i);
                    operarios.set(i, operarios.get(j));
                    operarios.set(j, auxiliar);
                    
                }else if (comparacionApellidos == 0){
                    
                    int comparacionNombres = operarioI.getNombre().compareToIgnoreCase(operarioJ.getNombre());
    
                    if (comparacionNombres > 0){
                        
                        Operario auxiliar = operarios.get(i);
                        operarios.set(i, operarios.get(j));
                        operarios.set(j, auxiliar);
                        
                    }
                }
            }
        }
    
        return operarios;
    }
    
    public String listarVehiculosEnsamblados(){
        
        String resultado = "";
    
        resultado += "===== VEHICULOS ENSAMBLADOS =====\n";
    
        int totalVehiculos = 0;
    
        for (CadenaMontaje cadena : planificador.getListaCadenas()){
            
            if (cadena.getConfiguracionActual() != null && cadena.getVehiculosTerminados() > 0){
                
                ConfiguracionVehiculo configuracion = cadena.getConfiguracionActual();
    
                resultado += "Tipo vehiculo: " + configuracion.getVehiculoBase().getClass().getSimpleName() + "\n";
                resultado += "Motor: " + configuracion.getMotor().getTipoMotor() + "\n";
                resultado += "Tapiceria: " + configuracion.getTapiceria().getTipoTapiceria() + "\n";
                resultado += "Ruedas: " + configuracion.getRuedas().getTipoRueda() + "\n";
                resultado += "Vehiculos ensamblados: " + cadena.getVehiculosTerminados() + "\n";
                resultado += "----------------------------------\n";
    
                totalVehiculos += cadena.getVehiculosTerminados();
            }
        }
    
        resultado += "TOTAL VEHICULOS ENSAMBLADOS: " + totalVehiculos + "\n";
    
        if (totalVehiculos == 0){
            
            resultado += "Todavia no hay vehiculos ensamblados.\n";
        
        }
    
        return resultado;
    }
    
    public String listarVehiculosEnsambladosPorComponente(String filtro){
        
        String resultado = "";
    
        resultado += "===== VEHICULOS ENSAMBLADOS FILTRADOS =====\n";
        resultado += "Filtro aplicado: " + filtro + "\n";
    
        int totalVehiculos = 0;
    
        for (CadenaMontaje cadena : planificador.getListaCadenas()){
            
            if (cadena.getConfiguracionActual() != null && cadena.getVehiculosTerminados() > 0){
                
                ConfiguracionVehiculo configuracion = cadena.getConfiguracionActual();
    
                String motor = configuracion.getMotor().getTipoMotor();
                String tapiceria = configuracion.getTapiceria().getTipoTapiceria();
                String ruedas = configuracion.getRuedas().getTipoRueda();
    
                boolean coincide = motor.equalsIgnoreCase(filtro) ||
                                   tapiceria.equalsIgnoreCase(filtro) ||
                                   ruedas.equalsIgnoreCase(filtro);
    
                if (coincide){
                    
                    resultado += "Tipo vehiculo: " + configuracion.getVehiculoBase().getClass().getSimpleName() + "\n";
                    resultado += "Motor: " + motor + "\n";
                    resultado += "Tapiceria: " + tapiceria + "\n";
                    resultado += "Ruedas: " + ruedas + "\n";
                    resultado += "Vehiculos ensamblados: " + cadena.getVehiculosTerminados() + "\n";
                    resultado += "----------------------------------\n";
    
                    totalVehiculos += cadena.getVehiculosTerminados();
                
                }
            }
        }
    
        resultado += "TOTAL FILTRADO: " + totalVehiculos + "\n";
    
        if (totalVehiculos == 0){
            
            resultado += "No hay vehiculos ensamblados con ese componente.\n";
        
        }
    
        return resultado;
    }
    
    public String listarConfiguracionesPorTasaEnsamblaje(){
        
        ArrayList<CadenaMontaje> cadenas = new ArrayList<CadenaMontaje>(planificador.getListaCadenas());
    
        for (int i = 0; i < cadenas.size() - 1; i++){
            
            for (int j = i + 1; j < cadenas.size(); j++){
                
                if (cadenas.get(i).getVehiculosTerminados() < cadenas.get(j).getVehiculosTerminados()){
                    
                    CadenaMontaje auxiliar = cadenas.get(i);
                    cadenas.set(i, cadenas.get(j));
                    cadenas.set(j, auxiliar);
                
                }
            }
        }
    
        String resultado = "";
    
        resultado += "===== CONFIGURACIONES POR TASA DE ENSAMBLAJE =====\n";
    
        if (cadenas.size() == 0){
            
            resultado += "No hay cadenas registradas.\n";
            return resultado;
        
        }
    
        for (CadenaMontaje cadena : cadenas){
            
            if (cadena.getConfiguracionActual() != null){
                
                ConfiguracionVehiculo configuracion = cadena.getConfiguracionActual();
    
                resultado += "Configuracion: " + configuracion + "\n";
                resultado += "Vehiculos terminados: " + cadena.getVehiculosTerminados() + "\n";
                resultado += "Unidades pendientes: " + cadena.getUnidadesPendientes() + "\n";
                resultado += "Estado actual: " + cadena.getEstadoActual() + "\n";
                resultado += "----------------------------------\n";
            
            }
        }
    
        return resultado;
    }
    
    public String generarEstadisticasGenerales(){
    
        String resultado = "";
    
        int totalOperarios = 0;
        int operariosEficientes = 0;
        int operariosEstandar = 0;
    
        for (Operario operario : getOperarios()){
            
            totalOperarios++;
    
            if (operario.getMontajesRealizados() > 10){
                
                operariosEficientes++;
            
            }else{
                
                operariosEstandar++;
            
            }
        }
    
        int stockMotores = 0;
        int stockTapicerias = 0;
        int stockRuedas = 0;
    
        for (Motor motor : almacen.getMotores()){
            
            stockMotores += motor.getStock();
        
        }
    
        for (Tapiceria tapiceria : almacen.getTapicerias()){
            
            stockTapicerias += tapiceria.getStock();
        
        }
    
        for (Ruedas ruedas : almacen.getRuedas()){
            
            stockRuedas += ruedas.getStock();
        
        }
    
        int totalVehiculosTerminados = 0;
        int totalCadenas = planificador.getListaCadenas().size();
    
        String cadenaMasProductiva = "No hay cadenas registradas";
        int maxVehiculosTerminados = -1;
    
        for (CadenaMontaje cadena : planificador.getListaCadenas()){
            
            totalVehiculosTerminados += cadena.getVehiculosTerminados();
    
            if (cadena.getVehiculosTerminados() > maxVehiculosTerminados){
                
                maxVehiculosTerminados = cadena.getVehiculosTerminados();
                cadenaMasProductiva = cadena.getTipoVehiculoQueProduce();
            
            }
        }
    
        resultado += "===== ESTADISTICAS GENERALES DE FABRICA =====\n";
        resultado += "Total de operarios: " + totalOperarios + "\n";
        resultado += "Operarios eficientes: " + operariosEficientes + "\n";
        resultado += "Operarios estandar: " + operariosEstandar + "\n";
        resultado += "\n";
    
        resultado += "Stock total de motores: " + stockMotores + "\n";
        resultado += "Stock total de tapicerias: " + stockTapicerias + "\n";
        resultado += "Stock total de ruedas: " + stockRuedas + "\n";
        resultado += "\n";
    
        resultado += "Cadenas de montaje registradas: " + totalCadenas + "\n";
        resultado += "Vehiculos terminados: " + totalVehiculosTerminados + "\n";
        resultado += "Cadena mas productiva: " + cadenaMasProductiva + "\n";
        resultado += "Vehiculos terminados por la cadena mas productiva: " + maxVehiculosTerminados + "\n";
        resultado += "=============================================\n";
    
        return resultado;
    
    }
}