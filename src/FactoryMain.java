import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class FactoryMain
{
    private static SistemaGestionFabrica sistema;
    private static Scanner teclado;

    public static void main(String[] args){
        
        sistema = new SistemaGestionFabrica();
        teclado = new Scanner(System.in);
        cargarDatosIniciales();
        boolean salir = false;

        while (!salir){
            
            mostrarMenu();

            int opcion = leerEntero("Elige una opcion: ");

            switch (opcion){
                
                case 1:
                    altaMotor();
                    break;
            
                case 2:
                    altaTapiceria();
                    break;
            
                case 3:
                    altaRueda();
                    break;
            
                case 4:
                    altaTrabajador();
                    break;
            
                case 5:
                    System.out.println(sistema.consultarStock());
                    break;
            
                case 6:
                    buscarTrabajadorPorDni();
                    break;
            
                case 7:
                    sistema.consultarDashboard();
                    break;
            
                case 8:
                    crearConfiguracionVehiculo(teclado, sistema);
                    break;
            
                case 9:
                    crearCadenaMontajePrueba(teclado, sistema);
                    break;
            
                case 10:
                    iniciarSimulacionSimple(sistema);
                    break;
                    
                case 11:
                    listarOperarios();
                    break;
                
                case 12:
                    listarVehiculosEnsamblados();
                    break;
                    
                case 13:
                    listarConfiguracionesPorTasaEnsamblaje();
                    break;
                    
                    case 14:
                        mostrarEstadisticasGenerales();
                        break;
                    
                case 0:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
            
                default:
                    System.out.println("Opcion no valida.");
                    break;
                    
            }
        }
        teclado.close();
    }

    private static void mostrarMenu(){
        
        System.out.println();
        System.out.println("========== SISTEMA DE GESTION DE FABRICA ==========");
        System.out.println("1. Alta de motor");
        System.out.println("2. Alta de tapiceria");
        System.out.println("3. Alta de rueda");
        System.out.println("4. Alta de trabajador");
        System.out.println("5. Consultar stock");
        System.out.println("6. Buscar trabajador por DNI");
        System.out.println("7. Mostrar dashboard");
        System.out.println("8. Crear configuracion de vehiculo");
        System.out.println("9. Crear cadena de montaje de prueba");
        System.out.println("10. Iniciar simulacion simple");
        System.out.println("11. Listar operarios");
        System.out.println("12. Listar vehiculos ensamblados");
        System.out.println("13. Listar configuraciones por tasa de ensamblaje");
        System.out.println("14. Estadisticas generales de fabrica");
        System.out.println("0. Salir");
        System.out.println("===================================================");
    
    }

    private static void cargarDatosIniciales(){
        
        Motor motor1 = new Motor("Gasolina", 1600, 120, 4,10);
        Motor motor2 = new Motor("Hibrido", 1800, 140, 4,10);
        Motor motor3 = new Motor("Electrico", 0, 150, 0,10);

        Tapiceria tapiceria1 = new Tapiceria("Tela", "Gris", 7.5, 10);
        Tapiceria tapiceria2 = new Tapiceria("Cuero", "Negro", 8.0, 10);
        Tapiceria tapiceria3 = new Tapiceria("Alcantara", "Rojo", 8.5, 10);

        Ruedas rueda1 = new Ruedas("Normal", 205, 16, 600, 210, 10);
        Ruedas rueda2 = new Ruedas("Deportiva", 245, 18, 700, 270, 10);
        Ruedas rueda3 = new Ruedas("Todoterreno", 265, 17, 900, 180, 10);

        sistema.aniadirMotor(motor1);
        sistema.aniadirMotor(motor2);
        sistema.aniadirMotor(motor3);

        sistema.aniadirTapiceria(tapiceria1);
        sistema.aniadirTapiceria(tapiceria2);
        sistema.aniadirTapiceria(tapiceria3);

        sistema.aniadirRueda(rueda1);
        sistema.aniadirRueda(rueda2);
        sistema.aniadirRueda(rueda3);

        Operario operario1 = new Operario("Pedro", "Lopez", "11111111A", "Calle A", "123456789", "Robot chasis", 1500, new Date(), 15);
        Operario operario2 = new Operario("Ana", "Garcia", "22222222B", "Calle B", "987654321", "Robot motor", 1500, new Date(), 5);
        Operario operario3 = new Operario("Luis", "Martinez", "33333333C", "Calle C", "456789123", "Robot tapiceria", 1500, new Date(), 20);
        Operario operario4 = new Operario("Laura", "Sanchez", "44444444D", "Calle D", "789123456", "Robot ruedas", 1500, new Date(), 12);

        sistema.darAltaTrabajador(operario1);
        sistema.darAltaTrabajador(operario2);
        sistema.darAltaTrabajador(operario3);
        sistema.darAltaTrabajador(operario4);

        System.out.println("Datos iniciales cargados correctamente.");
        System.out.println("Puede probar directamente las opciones 5, 8, 9, 10, 11, 12, 13, 14 y 7.");
        
    }

    private static void consultarStock(){
        
        System.out.println(sistema.consultarStock());
    
    }

    private static void altaMotor(){
        
        System.out.println("--- Alta de motor ---");

        String tipo = leerTexto("Tipo de motor: ");
        int cilindrada = leerEntero("Cilindrada: ");
        int potencia = leerEntero("Potencia: ");
        int cilindros = leerEntero("Numero de cilindros: ");
        int stock = leerEntero("Numero de stock: ");

        Motor motor = new Motor(tipo, cilindrada, potencia, cilindros, stock);
        sistema.aniadirMotor(motor);

        System.out.println("Motor anadido correctamente.");
    
    }

    private static void altaTapiceria(){
        
        System.out.println("--- Alta de tapiceria ---");

        String tipo = leerTexto("Tipo de tapiceria: ");
        String color = leerTexto("Color: ");
        double metros = leerDouble("Metros cuadrados: ");
        int stock = leerEntero("Numero de stock: ");

        Tapiceria tapiceria = new Tapiceria(tipo, color, metros, stock);
        sistema.aniadirTapiceria(tapiceria);

        System.out.println("Tapiceria anadida correctamente.");
    
    }

    private static void altaRueda(){
        
        System.out.println("--- Alta de rueda ---");

        String tipo = leerTexto("Tipo de rueda: ");
        int ancho = leerEntero("Ancho en mm: ");
        int diametro = leerEntero("Diametro de llanta en pulgadas: ");
        int indiceCarga = leerEntero("Indice de carga en kg: ");
        int codigoVelocidad = leerEntero("Codigo de velocidad en km/h: ");
        int stock = leerEntero("Numero de stock: ");

        Ruedas rueda = new Ruedas(tipo, ancho, diametro, indiceCarga, codigoVelocidad, stock);
        sistema.aniadirRueda(rueda);

        System.out.println("Rueda anadida correctamente.");
    
    }
    
    private static void altaTrabajador(){
        
        System.out.println("--- Alta de trabajador ---");
        System.out.println("1. Operario");
        System.out.println("2. Gestor de planta");
        System.out.println("3. Administrador del sistema");
        System.out.println("4. Mecanico de cinta");
    
        int tipo = leerEntero("Elige tipo de trabajador: ");
    
        String nombre = leerTexto("Nombre: ");
        String apellidos = leerTexto("Apellidos: ");
        String dni = leerTexto("DNI: ");
        String direccion = leerTexto("Direccion: ");
        String numSS = leerTexto("Numero de seguridad social: ");
        String puesto = leerTexto("Puesto: ");
        double salario = leerDouble("Salario: ");
    
        if (tipo == 1)
        {
            int montajes = leerEntero("Montajes realizados: ");
    
            Operario operario = new Operario(nombre, apellidos, dni, direccion, numSS, puesto, salario, new Date(), montajes);
    
            sistema.darAltaTrabajador(operario);
            System.out.println("Operario anadido correctamente.");
        }else if (tipo == 2){
            
            GestorPlanta gestor = new GestorPlanta(nombre, apellidos, dni, direccion, numSS, puesto, salario, new Date());
    
            sistema.darAltaTrabajador(gestor);
            System.out.println("Gestor de planta anadido correctamente.");
        }else if (tipo == 3){
            
            AdminSistemas admin = new AdminSistemas(nombre, apellidos, dni, direccion, numSS, puesto, salario, new Date());
    
            sistema.darAltaTrabajador(admin);
            System.out.println("Administrador del sistema anadido correctamente.");
        
        }else if (tipo == 4){
            
            int reparaciones = leerEntero("Reparaciones realizadas: ");
    
            MecanicoCinta mecanico = new MecanicoCinta(nombre, apellidos, dni, direccion, numSS, puesto, salario, new Date(), reparaciones);
    
            sistema.darAltaTrabajador(mecanico);
            System.out.println("Mecanico de cinta anadido correctamente.");
        
        }else{
            
            System.out.println("Tipo de trabajador no valido.");
        
        }
    }

    private static void buscarTrabajadorPorDni(){
        
        System.out.println("--- Buscar trabajador por DNI ---");
        String dni = leerTexto("Introduce DNI: ");
        Trabajador trabajador = sistema.buscarTrabajadorPorDni(dni);

        if (trabajador == null){
            
            System.out.println("No se ha encontrado ningun trabajador con ese DNI.");
        }else{
            
            System.out.println("Trabajador encontrado:");
            System.out.println("Nombre: " + trabajador.getNombre());
            System.out.println("Apellidos: " + trabajador.getApellidos());
            System.out.println("DNI: " + trabajador.getDni());
            System.out.println("Puesto: " + trabajador.getPuesto());
            System.out.println("Salario: " + trabajador.getSalario());
        
        }
    }

    private static Operario buscarPrimerOperarioDisponible(int posicionBuscada){
        
        int contador = 0;

        for (Trabajador trabajador : sistema.getAlmacen().getTrabajadores()){
            
            if (trabajador instanceof Operario){
                
                if (contador == posicionBuscada){
                    
                    return (Operario) trabajador;
                
                }

                contador++;
            
            }
        }

        return null;
    }

    private static String leerTexto(String mensaje){
        
        System.out.print(mensaje);
        return teclado.nextLine();
    
    }

    private static int leerEntero(String mensaje){
        
        System.out.print(mensaje);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    
    }

    private static double leerDouble(String mensaje){
        
        System.out.print(mensaje);
        double numero = teclado.nextDouble();
        teclado.nextLine();
        return numero;
    
    }
    
    private static void crearConfiguracionVehiculo(Scanner teclado, SistemaGestionFabrica sistema){
        
        System.out.println();
        System.out.println("--- CREAR CONFIGURACION DE VEHICULO ---");
    
        if (sistema.getMotores().size() == 0 || sistema.getTapicerias().size() == 0 || sistema.getRuedas().size() == 0){
        
            System.out.println("No hay suficientes componentes registrados.");
            System.out.println("Debes registrar al menos un motor, una tapiceria y una rueda.");
            return;
        }

        Vehiculo vehiculo = crearVehiculoDesdeTeclado(teclado);

        if (vehiculo == null){
        
            System.out.println("No se pudo crear el vehiculo.");
            return;
        
        }

        Motor motor = seleccionarMotor(teclado, sistema);

        if (motor == null){
        
            System.out.println("Motor no valido.");
            return;
        
        }
    
        Tapiceria tapiceria = seleccionarTapiceria(teclado, sistema);

        if (tapiceria == null){
        
            System.out.println("Tapiceria no valida.");
            return;
    
        }

        Ruedas rueda = seleccionarRueda(teclado, sistema);

        if (rueda == null){
        
            System.out.println("Rueda no valida.");
            return;
        
        }

        System.out.print("Unidades solicitadas: ");
        int unidades = teclado.nextInt();
        teclado.nextLine();

        ConfiguracionVehiculo configuracion = sistema.crearConfiguracionVehiculo(
            vehiculo, motor, tapiceria, rueda, unidades);

        System.out.println("Configuracion creada correctamente.");
    }
    
    private static Vehiculo crearVehiculoDesdeTeclado(Scanner teclado){
        
        System.out.println("Tipo de vehiculo:");
        System.out.println("1. Biplaza deportivo");
        System.out.println("2. Turismo");
        System.out.println("3. Furgoneta");

        System.out.print("Elige tipo: ");
        int tipo = teclado.nextInt();
        teclado.nextLine();
    
        System.out.print("Color: ");
        String color = teclado.nextLine();
    
        System.out.print("Tara del vehiculo: ");
        double tara = teclado.nextDouble();
    
        System.out.print("Peso maximo autorizado: ");
        double pesoMaximoAutorizado = teclado.nextDouble();
        teclado.nextLine();
    
        if (tipo == 1){
            
            return new BiplazaDeportivo(color, tara, pesoMaximoAutorizado);
        
        }else if (tipo == 2){
            
            return new Turismo(color, tara, pesoMaximoAutorizado);
        
        }else if (tipo == 3){
            
            System.out.print("Numero de plazas de la furgoneta: ");
            int numeroPlazas = teclado.nextInt();
            teclado.nextLine();
    
            return new Furgoneta(color, numeroPlazas, tara, pesoMaximoAutorizado);
        
        }else{
        
            return null;
        
        }
    }
    
    private static Motor seleccionarMotor(Scanner teclado, SistemaGestionFabrica sistema){
            
        ArrayList<Motor> motores = sistema.getMotores();
        
        System.out.println();
        System.out.println("--- MOTORES DISPONIBLES ---");
        
        for (int i = 0; i < motores.size(); i++){

            System.out.println((i + 1) + ". " + motores.get(i));
            
        }   
        
        System.out.print("Elige motor: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        
        int indice = opcion - 1;
        
        if (indice < 0 || indice >= motores.size()){
                
            return null;
            
        }
        
        return motores.get(indice);
    }
    
    private static Tapiceria seleccionarTapiceria(Scanner teclado, SistemaGestionFabrica sistema){
        
        ArrayList<Tapiceria> tapicerias = sistema.getTapicerias();
    
        System.out.println();
        System.out.println("--- TAPICERIAS DISPONIBLES ---");
    
        for (int i = 0; i < tapicerias.size(); i++){
            
            System.out.println((i + 1) + ". " + tapicerias.get(i));
        
        }
    
        System.out.print("Elige tapiceria: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();
    
        int indice = opcion - 1;
    
        if (indice < 0 || indice >= tapicerias.size()){
            
            return null;
        
        }
    
        return tapicerias.get(indice);
    }
    
    private static Ruedas seleccionarRueda(Scanner teclado, SistemaGestionFabrica sistema){
        
        ArrayList<Ruedas> ruedas = sistema.getRuedas();
    
        System.out.println();
        System.out.println("--- RUEDAS DISPONIBLES ---");
    
        for (int i = 0; i < ruedas.size(); i++){
            
            System.out.println((i + 1) + ". " + ruedas.get(i));
        
        }
    
        System.out.print("Elige rueda: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();
    
        int indice = opcion - 1;
    
        if (indice < 0 || indice >= ruedas.size()){
            
            return null;
        
        }
    
        return ruedas.get(indice);
    }
    
    private static void crearCadenaMontajePrueba(Scanner teclado, SistemaGestionFabrica sistema){
        
        System.out.println();
        System.out.println("--- CREAR CADENA DE MONTAJE DE PRUEBA ---");
    
        ArrayList<ConfiguracionVehiculo> configuraciones = sistema.getConfiguracionesVehiculo();
        ArrayList<Operario> operarios = sistema.getOperarios();
    
        if (configuraciones.size() == 0){
            
            System.out.println("No hay configuraciones de vehiculo creadas.");
            return;
        
        }
    
        if (operarios.size() < 4){
            
            System.out.println("Necesitas al menos 4 operarios registrados.");
            System.out.println("Uno para chasis, uno para motor, uno para tapiceria y uno para ruedas.");
            return;
        
        }
    
        System.out.println("--- CONFIGURACIONES DISPONIBLES ---");
    
        for (int i = 0; i < configuraciones.size(); i++){
            
            System.out.println((i + 1) + ". " + configuraciones.get(i));
        
        }
    
        System.out.print("Elige configuracion: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();
    
        int indice = opcion - 1;
    
        if (indice < 0 || indice >= configuraciones.size()){
            
            System.out.println("Configuracion no valida.");
            return;
        
        }
    
        ConfiguracionVehiculo configuracion = configuraciones.get(indice);
    
        if (!sistema.hayStockSuficiente(configuracion)){
            
            System.out.println("No hay stock suficiente para fabricar esta configuracion.");
            return;
            
        }

        sistema.descontarStockConfiguracion(configuracion);
        
        ArrayList<Operario> operariosDisponibles = new ArrayList<Operario>(operarios);
    
        Operario operarioChasis = extraerOperarioAleatorio(operariosDisponibles);
        Operario operarioMotor = extraerOperarioAleatorio(operariosDisponibles);
        Operario operarioTapiceria = extraerOperarioAleatorio(operariosDisponibles);
        Operario operarioRuedas = extraerOperarioAleatorio(operariosDisponibles);
    
        Robot robotChasis = new Robot(EstadoMontaje.chasis, operarioChasis);
        Robot robotMotor = new Robot(EstadoMontaje.motor, operarioMotor);
        Robot robotTapiceria = new Robot(EstadoMontaje.tapiceria, operarioTapiceria);
        Robot robotRuedas = new Robot(EstadoMontaje.ruedas, operarioRuedas);
    
        String tipoVehiculo = configuracion.getVehiculoBase().getClass().getSimpleName();
    
        CadenaMontaje cadena = new CadenaMontaje(tipoVehiculo, robotChasis, robotMotor,
            robotTapiceria, robotRuedas);
    
        cadena.configurarCadena(configuracion, configuracion.getUnidadesSolicitadas());
    
        sistema.registrarCadenaMontaje(cadena);
    
        System.out.println("Cadena de montaje creada correctamente.");
        System.out.println("Tipo de vehiculo: " + tipoVehiculo);
        System.out.println("Unidades pendientes: " + configuracion.getUnidadesSolicitadas());
    }
    
    private static Operario extraerOperarioAleatorio(ArrayList<Operario> operarios){
        
        Random random = new Random();
        int indice = random.nextInt(operarios.size());

        return operarios.remove(indice);
    
    }
    
    private static void iniciarSimulacionSimple(SistemaGestionFabrica sistema){
        
        System.out.println();
        System.out.println("--- INICIANDO SIMULACION SIMPLE ---");
    
        sistema.iniciarPlanificadorSimple();
    
        System.out.println("Simulacion finalizada.");
        sistema.consultarDashboard();
        
    }

    private static void listarOperarios(){
    
        System.out.println();
        System.out.println("--- LISTADO DE OPERARIOS ---");
        System.out.println("1. Todos los operarios");
        System.out.println("2. Operarios eficientes");
        System.out.println("3. Operarios estandar");
        System.out.println("4. Operarios ordenados alfabeticamente");
    
        int opcion = leerEntero("Elige una opcion: ");
    
        ArrayList<Operario> operarios;
    
        if (opcion == 1){
            
            operarios = sistema.listarOperarios();
        
        }else if (opcion == 2){
            operarios = sistema.listarOperariosEficientes();
        
        }else if (opcion == 3){
            
            operarios = sistema.listarOperariosEstandar();
        
        }else if (opcion == 4){
            
            operarios = sistema.listarOperariosOrdenadosAlfabeticamente();
        
        }else{
            
            System.out.println("Opcion no valida.");
            return;
        
        }
    
        if (operarios.size() == 0){
            
            System.out.println("No hay operarios para mostrar.");
            return;
        
        }
    
        System.out.println();
    
        for (Operario operario : operarios){
            
            System.out.println(operario);
        
        }
    }
    
    private static void listarVehiculosEnsamblados(){
    
        System.out.println();
        System.out.println("--- LISTADO DE VEHICULOS ENSAMBLADOS ---");
        System.out.println("1. Mostrar todos");
        System.out.println("2. Filtrar por componente");
    
        int opcion = leerEntero("Elige una opcion: ");
    
        if (opcion == 1){
            
            System.out.println(sistema.listarVehiculosEnsamblados());
        
        }else if (opcion == 2){
            
            String filtro = leerTexto("Introduce componente a buscar (Gasolina, Hibrido, Electrico, Cuero, Tela, Deportiva, etc.): ");
            System.out.println(sistema.listarVehiculosEnsambladosPorComponente(filtro));
        
        }else{
            
            System.out.println("Opcion no valida.");
        
        }
    }
    
    private static void listarConfiguracionesPorTasaEnsamblaje(){
    
        System.out.println();
        System.out.println("--- CONFIGURACIONES POR TASA DE ENSAMBLAJE ---");
        System.out.println(sistema.listarConfiguracionesPorTasaEnsamblaje());
    
    }
    
    private static void mostrarEstadisticasGenerales(){
        
        System.out.println();
        System.out.println(sistema.generarEstadisticasGenerales());
    
    }
}