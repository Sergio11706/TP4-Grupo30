package ar.edu.unju.escmi.tp4.dominio;

public class Cliente {
	private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String email;

    public Cliente(String nombre, String apellido, String dni, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("Email: " + email);
    }

    public String getDni() {
        return dni;
    }
}
