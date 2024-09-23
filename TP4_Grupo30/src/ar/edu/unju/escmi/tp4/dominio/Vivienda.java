package ar.edu.unju.escmi.tp4.dominio;

public class Vivienda extends Inmueble {
	
	private String direccion;
    private int cantidadHabitaciones;

    public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public Vivienda(String codigo, double precioAlquiler, String direccion,int cantidadHabitaciones, boolean estado) {
        super(codigo, precioAlquiler, estado);
        this.direccion = direccion;
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Vivienda: " + codigo + ", Precio Alquiler: $ " + precio +  ", Dirección: " + direccion + ", Habitaciones: " + cantidadHabitaciones);
    }
}
