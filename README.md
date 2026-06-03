# Sistema de gestión de fábrica de vehículos

Proyecto académico desarrollado en Java para la asignatura de Programación Orientada a Objetos.

La aplicación simula la gestión básica de una fábrica de vehículos: almacén de componentes, trabajadores, configuraciones de vehículos, cadenas de montaje, robots asignados a operarios y generación de estadísticas de producción.

## Tecnologías utilizadas

- Java
- Programación orientada a objetos
- Colecciones con `ArrayList`
- Enumeraciones
- Herencia y clases abstractas
- Interfaces
- Simulación por consola

## Funcionalidades principales

- Alta de motores, tapicerías y ruedas.
- Alta de trabajadores: operarios, gestores, administradores y mecánicos.
- Creación de configuraciones de vehículos.
- Gestión de stock de componentes.
- Creación de cadenas de montaje.
- Simulación del ensamblaje de vehículos por fases:
  - chasis
  - motor
  - tapicería
  - ruedas
- Asignación de robots a operarios.
- Listado y filtrado de operarios según rendimiento.
- Listado de vehículos ensamblados.
- Dashboard de estado de fábrica.
- Estadísticas generales de producción.

## Modelo de dominio

El proyecto está construido alrededor de varias entidades principales:

- `Vehiculo`: clase abstracta base para `Turismo`, `Furgoneta` y `BiplazaDeportivo`.
- `Trabajador`: clase abstracta base para `Operario`, `GestorPlanta`, `AdminSistemas` y `MecanicoCinta`.
- `Motor`, `Tapiceria` y `Ruedas`: componentes necesarios para fabricar vehículos.
- `ConfiguracionVehiculo`: une vehículo, motor, tapicería, ruedas y unidades solicitadas.
- `CadenaMontaje`: simula el avance de fabricación por estados.
- `Planificador`: coordina las cadenas de montaje.
- `SistemaGestionFabrica`: clase principal de lógica de negocio.
- `FactoryMain`: interfaz de consola.

## Estructura del proyecto

```text
fabrica-vehiculos-poo/
├── src/
│   ├── FactoryMain.java
│   ├── SistemaGestionFabrica.java
│   ├── CadenaMontaje.java
│   ├── Planificador.java
│   ├── Vehiculo.java
│   ├── Trabajador.java
│   └── ...
├── docs/
│   └── capturas/
├── .gitignore
└── README.md
```

## Cómo ejecutar

Desde la raíz del proyecto:

```bash
cd src
javac *.java
java FactoryMain
```

## Cómo ejecutar los tests básicos

El proyecto incluye una clase de pruebas sencilla con `assert`, sin frameworks externos:

```bash
cd src
javac *.java
java -ea TestSistemaGestionFabrica
```

Si todo va bien, se mostrará:

```text
Todos los tests han pasado correctamente.
```

## Capturas recomendadas

Antes de publicar el repositorio, añade capturas en `docs/capturas/` y enlázalas aquí:

- Menú principal.
- Consulta de stock.
- Creación de configuración de vehículo.
- Simulación de cadena de montaje.
- Dashboard final.

Ejemplo:

```md
![Menú principal](docs/capturas/menu-principal.png)
```

## Qué demuestra este proyecto

Este proyecto demuestra conocimientos de:

- Diseño de clases.
- Herencia y polimorfismo.
- Separación entre modelo, lógica de negocio y visualización por consola.
- Gestión de colecciones.
- Simulación de procesos por estados.
- Uso de interfaces para desacoplar la visualización del dashboard.

## Posibles mejoras futuras

- Migrar a Maven o Gradle.
- Añadir paquetes Java, por ejemplo `model`, `service`, `ui` y `simulation`.
- Añadir tests con JUnit.
- Sustituir algunos bucles manuales por `Comparator` y métodos de ordenación de Java.
- Mejorar validaciones de entrada por consola.
- Añadir persistencia en fichero o base de datos.
- Crear una interfaz gráfica con JavaFX.
