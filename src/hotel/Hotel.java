package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (habitaciones.size() >= 100) {
            System.out.println("Error: No se pueden agregar más de 100 habitaciones.");
            return;
        }
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == habitacion.getNumero()) {
                System.out.println("Error: La habitación con número " + habitacion.getNumero() + " ya existe.");
                return;
            }
        }
        habitaciones.add(habitacion);
        System.out.println("Habitación " + habitacion.getNumero() + " añadida exitosamente.");
    }

    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                if (habitacion.isDisponible()) {
                    System.out.println("La habitación está disponible.");
                } else {
                    System.out.println("La habitación está ocupada.");
                }
                return habitacion.isDisponible();
            }
        }
        System.out.println("Error: La habitación con número " + numeroHabitacion + " no existe.");
        return false;
    }


    public Habitacion obtenerHabitacion(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }
}
