package ar.edu.unju.escmi.tp4.dominio;


public class Terreno extends Inmueble {
	private double latitud;
    private double longitud;
    private double superficie;
    
    
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Terreno(String codigo, double precio, double latitud, double longitud, double superficie, boolean estado) {
        super(codigo, precio, estado);
        this.latitud = latitud;
        this.longitud = longitud;
        this.superficie = superficie;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Terreno: " + codigo + ", Precio: $ " + precio +", Latitud: " + latitud + ", Longitud: " + longitud + ", Superficie: " + superficie + "m²");
    }

}
