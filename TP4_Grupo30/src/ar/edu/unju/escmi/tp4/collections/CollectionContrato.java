package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCVT;

public class CollectionContrato { 
	
	public static List<ContratoCVT> contratosCVT = new ArrayList<>();
	
	public static void agregarContratoCVT(ContratoCVT contratoCVT) {
		contratosCVT.add(contratoCVT);
	}
	
	public static List<ContratoAlquiler> contratos = new ArrayList<>();

    public static void agregarContrato(ContratoAlquiler contrato) {
        contratos.add(contrato);
    }

	
}
