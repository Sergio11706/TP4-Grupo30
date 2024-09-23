package ar.edu.unju.escmi.tp4.main;

import java.util.Scanner;

import ar.edu.unju.escmi.tp4.collections.CollectionInmueble;
import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class Main {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        int opc;

	        do {
	        
	            System.out.println("******** MENU ******** ");
	            System.out.println("1. Registrar terreno");
	            System.out.println("2. Registrar vivienda");
	            System.out.println("3. Registrar cliente");
	            System.out.println("4. Alquiler de vivienda");
	            System.out.println("5. Venta de terreno");
	            System.out.println("6. Consultar inmuebles disponibles");
	            System.out.println("7. Consultar viviendas alquiladas");
	            System.out.println("8. Consultar terrenos vendidos");
	            System.out.println("9. Salir");
	            System.out.print("Seleccione una opción: ");
	            
	            opc = scanner.nextInt();
	            scanner.nextLine();  

	            switch(opc) {
	                case 1:
	                	registrarTerreno(scanner);
	                    break;
	                case 2:
	                    registrarVivienda(scanner);
	                    break;
	                case 9:
	                    System.out.println("SALIENDO DEL MENU");
	                    break;
	                default:
	                    System.out.println("OPCION INVALIDA. Intentelo nuevamente");
	            }
	        } while(opc != 9);

	        scanner.close();
	    }


	private static void registrarTerreno(Scanner scanner) {
		
		System.out.println("\nINGRESE LOS DATOS DEL TERRENO\n");
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Precio de venta: ");
        double precio = scanner.nextDouble();
        System.out.print("Latitud: ");
        double latitud = scanner.nextDouble();
        System.out.print("Longitud: ");
        double longitud = scanner.nextDouble();
        System.out.print("Superficie (m²): ");
        double superficie = scanner.nextDouble();
        scanner.nextLine();  
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        scanner.nextLine(); 

    
        Terreno terreno = new Terreno(codigo, precio, latitud, longitud, superficie, disponible);
        CollectionInmueble.agregarTerreno(terreno);
        terreno.mostrarDatos();
        }
	
	private static void registrarVivienda(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DE LA VIVIENDA\n");
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Precio de alquiler mensual: ");
        double precioAlquiler = scanner.nextDouble();
        scanner.nextLine();  
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        scanner.nextLine(); 

        Vivienda vivienda = new Vivienda(codigo, precioAlquiler, direccion, cantidadHabitaciones, disponible);
        CollectionInmueble.agregarVivienda(vivienda);
        vivienda.mostrarDatos();
	}
	
}
