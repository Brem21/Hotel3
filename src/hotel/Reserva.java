package hotel;

import java.time.LocalDate;

public class Reserva {
    private String nombreCliente;
    private String cedula;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(String nombreCliente, String cedula, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        if (!habitacion.isDisponible()) {
            throw new IllegalStateException("Error: La habitación no está disponible para reserva.");
        }
        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        habitacion.reservar();
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", cedula='" + cedula + '\'' +
                ", habitacion=" + habitacion.getNumero() +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
