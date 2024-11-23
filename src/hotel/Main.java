package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Crear el hotel
        Hotel hotel = new Hotel();

        // Agregar habitaciones al hotel
        System.out.println("¿Cuántas habitaciones desea agregar (máximo 10)?");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        if (numHabitaciones > 10) {
            System.out.println("Error: El número máximo de habitaciones permitidas es 100.");
            return;
        }

        for (int i = 0; i < numHabitaciones; i++) {
            System.out.println("Ingrese el número de la habitación:");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.println("Ingrese el tipo de la habitación (Ej. Simple, Doble):");
            String tipo = scanner.nextLine();
            System.out.println("Ingrese el precio de la habitación:");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea

            Habitacion habitacion = new Habitacion(numero, tipo, precio);
            hotel.agregarHabitacion(habitacion);
        }

        // Funcionalidades básicas: Reservar y consultar disponibilidad
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear una nueva reserva");
            System.out.println("2. Consultar disponibilidad de una habitación");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de habitación para reservar:");
                    int numReserva = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    if (hotel.consultarDisponibilidad(numReserva)) {
                        System.out.println("Ingrese el nombre del cliente:");
                        String nombreCliente = scanner.nextLine();
                        System.out.println("Ingrese la cédula del cliente:");
                        String cedula = scanner.nextLine();
                        System.out.println("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd):");
                        String fechaInicioStr = scanner.nextLine();
                        System.out.println("Ingrese la fecha de fin de la reserva (yyyy-MM-dd):");
                        String fechaFinStr = scanner.nextLine();

                        try {
                            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
                            LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);
                            Habitacion habitacion = hotel.obtenerHabitacion(numReserva);
                            Reserva reserva = new Reserva(nombreCliente, cedula, habitacion, fechaInicio, fechaFin);
                            System.out.println("Reserva realizada con éxito: " + reserva);
                        } catch (Exception e) {
                            System.out.println("Error al realizar la reserva: " + e.getMessage());
                        }
                    } else {
                        System.out.println("La habitación no está disponible ");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el número de habitación para consultar disponibilidad:");
                    int numConsulta = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    boolean disponible = hotel.consultarDisponibilidad(numConsulta);
                    System.out.println("Disponibilidad habitación " + numConsulta + ": " + (disponible ? "Disponible" : "Ocupada"));
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
