package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoAlquiler {
	    private Vivienda vivienda;
	    private Cliente cliente;
	    private double gastosInmobiliaria;
	    private LocalDate fechaContrato;

	    public ContratoAlquiler(Vivienda vivienda, Cliente cliente, double gastosInmobiliaria, LocalDate fechaContrato) {
	        this.vivienda = vivienda;
	        this.cliente = cliente;
	        this.gastosInmobiliaria = gastosInmobiliaria;
	        this.fechaContrato = fechaContrato;
	    }

	    public double calcularMontoTotal() {
	        return vivienda.getPrecio() + gastosInmobiliaria;
	    }

	    public void mostrarDatos() {
	        System.out.println("Cliente:");
	        cliente.mostrarDatos();
	        System.out.println("Vivienda:");
	        vivienda.mostrarDatos();
	        System.out.println("Gastos Inmobiliaria: " + gastosInmobiliaria);
	        System.out.println("Monto Total: " + calcularMontoTotal());
	        System.out.println("Fecha Contrato: " + fechaContrato);
	    }
}
