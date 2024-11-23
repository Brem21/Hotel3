package hotel;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        if (!disponible) {
            System.out.println("Error: La habitación ya está reservada.");
            return;
        }
        disponible = false;
        System.out.println("Habitación " + numero + " reservada exitosamente.");
    }

    public void liberar() {
        if (disponible) {
            System.out.println("Error: La habitación ya está disponible.");
            return;
        }
        disponible = true;
        System.out.println("Habitación " + numero + " liberada exitosamente.");
    }
}
