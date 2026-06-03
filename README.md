# Vehicle Factory Management System

Academic project developed in Java for the Object-Oriented Programming course.

The application simulates the basic management of a vehicle factory: component inventory, workers, vehicle configurations, assembly lines, robots assigned to operators, and production statistics generation.


## Technologies Used

* Java
* Object-oriented programming
* Collections with `ArrayList`
* Enumerations
* Inheritance and abstract classes
* Interfaces
* Console-based simulation


## Main Features

* Registration of engines, upholstery, and wheels.
* Registration of workers: operators, plant managers, system administrators, and assembly line mechanics.
* Creation of vehicle configurations.
* Component stock management.
* Creation of assembly lines.
* Simulation of vehicle assembly through different stages:
  * chassis
  * engine
  * upholstery
  * wheels
* Assignment of robots to operators.
* Listing and filtering operators by performance.
* Listing of assembled vehicles.
* Factory status dashboard.
* General production statistics.


## Domain Model

The project is built around several main entities:

* `Vehiculo`: abstract base class for `Turismo`, `Furgoneta`, and `BiplazaDeportivo`.
* `Trabajador`: abstract base class for `Operario`, `GestorPlanta`, `AdminSistemas`, and `MecanicoCinta`.
* `Motor`, `Tapiceria`, and `Ruedas`: components required to manufacture vehicles.
* `ConfiguracionVehiculo`: connects a vehicle, engine, upholstery, wheels, and requested units.
* `CadenaMontaje`: simulates the manufacturing progress through different states.
* `Planificador`: coordinates the assembly lines.
* `SistemaGestionFabrica`: main business logic class.
* `FactoryMain`: console interface.


## Project Structure

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


## How to Run

From the project root:

```bash
cd src
javac *.java
java FactoryMain
```


## Possible Future Improvements

* Migrate to Maven or Gradle.
* Add Java packages, for example `model`, `service`, `ui`, and `simulation`.
* Add tests with JUnit.
* Replace some manual loops with `Comparator` and Java sorting methods.
* Improve console input validations.
* Add file or database persistence.
* Create a graphical user interface with JavaFX.
