package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class CollectionVivienda {
	public static List<Vivienda> viviendas = new ArrayList<>();

    public static void agregarVivienda(Vivienda vivienda) {
        viviendas.add(vivienda);
    }

    public static void mostrarViviendasDisponibles() {
        for (Vivienda vivienda : viviendas) {
            if (vivienda.isEstado()) {
                vivienda.mostrarDatos();
            }
        }
    }

    public static Vivienda buscarViviendaPorCodigo(String codigo) {
        for (Vivienda vivienda : viviendas) {
            if (vivienda.getCodigo().equals(codigo)) {
                return vivienda;
            }
        }
        return null; 
    }
}
