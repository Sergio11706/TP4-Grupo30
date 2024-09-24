package ar.edu.unju.escmi.tp4.dominio;

public abstract class Inmueble {
	
	protected String codigo;
    protected double precio;
    protected boolean estado;

    public Inmueble(String codigo, double precio, boolean estado) {
        this.codigo = codigo;
        this.precio = precio;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setEstado(boolean estado) {
    	this.estado = estado;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public abstract void mostrarDatos(); 
}
