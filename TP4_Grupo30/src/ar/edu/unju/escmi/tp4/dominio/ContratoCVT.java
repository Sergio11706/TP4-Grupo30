package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCVT extends Contrato {
	
	private Terreno terreno;
	private double impuesto;
	
	
	public ContratoCVT(String codigo, LocalDate fechaContrato, Cliente cliente, Inmobiliaria inmobiliaria, Terreno terreno, double impuesto) {
		super(codigo, fechaContrato, cliente, inmobiliaria);
		
		this.terreno = terreno;
		this.impuesto = impuesto;
	}


	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}


	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	public double montoTotal() {
		double total = impuesto+terreno.getPrecio();
		return total;
	}
	
	public void mostrarDatos() {
		System.out.println("\nCodigo del contrato: "+codigo);
		System.out.println("Fecha del contrato: "+fechaContrato);
		System.out.println("DNI del comprador: "+cliente.getDni());
		System.out.println("Nombre de la inmobiliaria: "+inmobiliaria.getNombre());
		System.out.println("Codigo del terreno: "+terreno.getCodigo());
		System.out.println("Precio total: "+montoTotal());
	}
}
