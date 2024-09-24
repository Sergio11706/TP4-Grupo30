package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;

public class CollectionContrato {
	public static List<ContratoAlquiler> contratos = new ArrayList<>();

    public static void agregarContrato(ContratoAlquiler contrato) {
        contratos.add(contrato);
        System.out.println("Contrato agregado correctamente.");
    }
}