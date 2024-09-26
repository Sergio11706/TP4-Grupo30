package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;
import java.util.ArrayList;
import java.util.List;

public class CollectionInmueble { 
    public static List<Terreno> terrenos = new ArrayList<>();
    public static List<Vivienda> viviendas = new ArrayList<>();

    public static void agregarTerreno(Terreno terreno) {
        terrenos.add(terreno);
    }

    public static Terreno buscarTerreno(String codigo) {
        for (Terreno terreno : terrenos) {
            if (terreno.getCodigo().equals(codigo)) {
                return terreno;
            }
        }
        return null;
    }
    
    public static void cambiarEstadoTerreno(String codigo) {
        for (Terreno terreno : terrenos) {
            if (terreno.getCodigo().equals(codigo)) {
                terreno.setEstado(false);
            }
        }
    }
    
    
    public static double calcularMontoTotalVentas() {
        return terrenos.stream().filter(t -> !t.isEstado()).mapToDouble(Terreno::getPrecio).sum();
    }
    
    
    public static void agregarVivienda(Vivienda vivienda) {
        viviendas.add(vivienda);
    }
    
    public static Vivienda buscarVivienda(String codigo) {
    	for (Vivienda vivienda : viviendas) {
    		if(vivienda.getCodigo().equals(codigo)) {
    			return vivienda;
    		}
    	}
    	return null;
    }
    
    public static void cambiarEstadoVivienda(String codigo) {
    	for(Vivienda vivienda : viviendas) {
    		if(vivienda.getCodigo().equals(codigo)) {
    			vivienda.setEstado(false);
    		}
    	}
    }
}
