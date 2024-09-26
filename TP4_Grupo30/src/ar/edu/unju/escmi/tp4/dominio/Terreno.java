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
        System.out.println("\nCodigo Terreno: "+ codigo);
        System.out.println("Precio: $" + precio);
        System.out.println("Latitud: " + latitud);
        System.out.println("Longitud: " + longitud);
        System.out.println("Superficie: " + superficie + "m²");
    }

}
