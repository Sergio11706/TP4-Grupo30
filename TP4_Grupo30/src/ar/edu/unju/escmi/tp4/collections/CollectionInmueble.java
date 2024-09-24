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
        System.out.println("TERRENO AGREGADO CORRECTAMENTE");
    }

    public static Terreno buscarTerreno(String codigo) {
        for (Terreno terreno : terrenos) {
            if (terreno.getCodigo().equals(codigo)) {
                return terreno;
            }
        }
        return null;
    }
    
    public static void cambiarEstado(String codigo) {
        for (Terreno terreno : terrenos) {
            if (terreno.getCodigo().equals(codigo)) {
                terreno.setEstado(false);
            }
        }
    }
    
    public static void agregarVivienda(Vivienda vivienda) {
        viviendas.add(vivienda);
        System.out.println("VIVIENDA AGREGADA CORRECTAMENTE");
    }
}
