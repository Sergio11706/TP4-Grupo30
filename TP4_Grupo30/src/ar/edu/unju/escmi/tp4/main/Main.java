package ar.edu.unju.escmi.tp4.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp4.collections.CollectionCliente;
import ar.edu.unju.escmi.tp4.collections.CollectionContrato;
import ar.edu.unju.escmi.tp4.collections.CollectionInmueble;
import ar.edu.unju.escmi.tp4.dominio.Cliente;
import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.Inmobiliaria;
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
	                case 3:
	                	registrarCliente(scanner);
	                    break;
	                
	                case 4:
	                	System.out.println("\n");
	                	List<Vivienda> viviendas = CollectionInmueble.viviendas;
	                	for (Vivienda vivienda : viviendas) {
	                	    if (vivienda.isEstado()) {
	                	        vivienda.mostrarDatos();
	                	    }
	                	}
	                	System.out.println("\nIngrese el codigo de la vivienda que busca alquilar: ");
	                	String codVivienda = scanner.nextLine();
	                	
	                	System.out.println("\n");
	                	List<Cliente> clientes = CollectionCliente.clientes;
	                	for (Cliente cliente : clientes) {
	                		cliente.mostrarDatos();
	                	}
	                	System.out.println("\nIngrese el DNI del inquilino: ");
	                	String dniInquilino = scanner.nextLine();
	                	
	                	Cliente inquilino = CollectionCliente.buscarClientePorDNI(dniInquilino);
	                	Vivienda viviendaAlquilada = CollectionInmueble.buscarVivienda(codVivienda);

	                	if(inquilino!=null || viviendaAlquilada!=null) {
	                		System.out.print("\nIngrese nombre de la inmobiliaria: ");
	                		String nombreInm = scanner.nextLine();
	                		
	                		System.out.print("\nIngrese telefono de la inmobiliaria: ");
	                		int telefonoInm = scanner.nextInt();
	                		scanner.nextLine();
	                		
	                		System.out.print("\nIngrese direccion de la inmobiliaria: ");
	                		String direccionInm = scanner.nextLine();
	                		
	                		Inmobiliaria InmobiliariaAlquiler = new Inmobiliaria(nombreInm, telefonoInm, direccionInm);

	                		System.out.println("\nIngrese el codigo del contrato de alquiler: ");
	                		String codContratoAlquiler = scanner.nextLine();
	                		
	                		System.out.println("\nIngrese la duracion del contrato: ");
	                		Double duracionContrato = scanner.nextDouble();
	           	                		
	                		System.out.println("\nIngrese los gastos de la inmobiliaria: ");
	                		Double gastosInm = scanner.nextDouble();
	                		                		
	                		ContratoAlquiler contrato = new ContratoAlquiler(codContratoAlquiler, LocalDate.now(), inquilino, InmobiliariaAlquiler, duracionContrato, gastosInm, viviendaAlquilada);
	                		
	                		CollectionContrato.agregarContrato(contrato);
	                		
	                		CollectionInmueble.cambiarEstadoVivienda(codVivienda);
	                		
	                		contrato.mostrarDatos();
	                		System.out.println("\nContrato realizado correctamente.\n");
	                	}
	                	else {
	                		System.out.println("\nError al realizar el contrato.\n");
	                	}     	
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
        System.out.println("\n");
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
        System.out.println("\n");
	}
	
	private static void registrarCliente(Scanner scanner) {
		System.out.println("\nIngrese los datos del cliente\n");
		
    	System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.next();
        
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.next();
        
        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.next();
        
        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = scanner.next();
        
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.next();
        
        System.out.println("Ingrese el email del cliente:");
        String email = scanner.next();

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        CollectionCliente.agregarCliente(cliente);
        cliente.mostrarDatos();
        System.out.println("\n");
	}
	
}
