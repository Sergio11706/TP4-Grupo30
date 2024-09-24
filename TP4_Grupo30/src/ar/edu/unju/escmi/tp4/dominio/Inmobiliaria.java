package ar.edu.unju.escmi.tp4.dominio;

public class Inmobiliaria {

	private String nombre;
	private int telefono;
	private String direccion;
	
	
	public Inmobiliaria(String nombre, int telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public void mostrarDatos() {
		System.out.println("\nNombre de la inmobiliaria: "+nombre);
		System.out.println("Telefono de la inmobiliaria: "+telefono);
		System.out.println("Direccion de la inmobiliaria: "+direccion);
	}
	
}