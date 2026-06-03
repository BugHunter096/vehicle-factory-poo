import java.util.Date;

public class TestSistemaGestionFabrica {
    public static void main(String[] args) {
        testStockSuficienteYDescuento();
        testOperariosFiltrados();
        testCadenaMontajeCompletaVehiculos();
        System.out.println("Todos los tests han pasado correctamente.");
    }

    private static void testStockSuficienteYDescuento() {
        SistemaGestionFabrica sistema = new SistemaGestionFabrica();

        Motor motor = new Motor("Gasolina", 1600, 120, 4, 5);
        Tapiceria tapiceria = new Tapiceria("Tela", "Gris", 7.5, 5);
        Ruedas ruedas = new Ruedas("Normal", 205, 16, 600, 210, 5);
        Vehiculo vehiculo = new Turismo("Azul", 1200, 1800);

        ConfiguracionVehiculo configuracion = sistema.crearConfiguracionVehiculo(
                vehiculo, motor, tapiceria, ruedas, 3);

        assert sistema.hayStockSuficiente(configuracion) : "Deberia haber stock suficiente";
        assert sistema.descontarStockConfiguracion(configuracion) : "El descuento de stock deberia realizarse";
        assert motor.getStock() == 2 : "El stock de motores deberia quedar en 2";
        assert tapiceria.getStock() == 2 : "El stock de tapicerias deberia quedar en 2";
        assert ruedas.getStock() == 2 : "El stock de ruedas deberia quedar en 2";
    }

    private static void testOperariosFiltrados() {
        SistemaGestionFabrica sistema = new SistemaGestionFabrica();

        Operario eficiente = new Operario("Ana", "Garcia", "11111111A", "Calle A", "SS1",
                "Robot motor", 1500, new Date(), 15);
        Operario estandar = new Operario("Luis", "Lopez", "22222222B", "Calle B", "SS2",
                "Robot chasis", 1500, new Date(), 5);

        sistema.darAltaTrabajador(eficiente);
        sistema.darAltaTrabajador(estandar);

        assert sistema.listarOperarios().size() == 2 : "Deberia haber dos operarios";
        assert sistema.listarOperariosEficientes().size() == 1 : "Deberia haber un operario eficiente";
        assert sistema.listarOperariosEstandar().size() == 1 : "Deberia haber un operario estandar";
    }

    private static void testCadenaMontajeCompletaVehiculos() {
        Operario op1 = new Operario("A", "A", "1", "C", "SS1", "Chasis", 1500, new Date(), 20);
        Operario op2 = new Operario("B", "B", "2", "C", "SS2", "Motor", 1500, new Date(), 20);
        Operario op3 = new Operario("C", "C", "3", "C", "SS3", "Tapiceria", 1500, new Date(), 20);
        Operario op4 = new Operario("D", "D", "4", "C", "SS4", "Ruedas", 1500, new Date(), 20);

        CadenaMontaje cadena = new CadenaMontaje(
                "Turismo",
                new Robot(EstadoMontaje.chasis, op1),
                new Robot(EstadoMontaje.motor, op2),
                new Robot(EstadoMontaje.tapiceria, op3),
                new Robot(EstadoMontaje.ruedas, op4)
        );

        ConfiguracionVehiculo configuracion = new ConfiguracionVehiculo(
                new Turismo("Rojo", 1200, 1800),
                new Motor("Hibrido", 1800, 140, 4, 10),
                new Tapiceria("Cuero", "Negro", 8.0, 10),
                new Ruedas("Deportiva", 245, 18, 700, 270, 10),
                2
        );

        cadena.configurarCadena(configuracion, 2);

        for (int i = 0; i < 20; i++) {
            cadena.avanzarUnSegundo();
        }

        assert cadena.getVehiculosTerminados() == 2 : "La cadena deberia haber terminado dos vehiculos";
        assert cadena.getUnidadesPendientes() == 0 : "No deberian quedar unidades pendientes";
        assert !cadena.isActiva() : "La cadena deberia quedar inactiva";
    }
}
