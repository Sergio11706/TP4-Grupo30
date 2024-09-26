package ar.edu.unju.escmi.tp4.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp4.collections.CollectionCliente;
import ar.edu.unju.escmi.tp4.collections.CollectionContrato;
import ar.edu.unju.escmi.tp4.collections.CollectionInmueble;
import ar.edu.unju.escmi.tp4.dominio.Cliente;
import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCVT;
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
	                	
	                	List<Vivienda> viviendasA = CollectionInmueble.viviendas;
	                	for (Vivienda vivienda : viviendasA) {
	                	    if (vivienda.isEstado()) {
	                	        vivienda.mostrarDatos();
	                	    }
	                	}
	                	
	                	System.out.print("\nSeleccione el codigo de la vivienda que busca alquilar: ");
	                	String codVivienda = scanner.nextLine();
	                	
	                	List<Cliente> clientela = CollectionCliente.clientes;
	                	for (Cliente cliente : clientela) {
	                		cliente.mostrarDatos();
	                	}
	                	
	                	System.out.print("\nSeleccione el DNI del inquilino: ");
	                	String dniInquilino = scanner.nextLine();
	                	
	                	Cliente inquilino = CollectionCliente.buscarClientePorDNI(dniInquilino);
	                	Vivienda viviendaAlquilada = CollectionInmueble.buscarVivienda(codVivienda);

	                	if(inquilino!=null && viviendaAlquilada!=null) {
	                		System.out.print("\nIngrese nombre de la inmobiliaria: ");
	                		String nombreInm = scanner.nextLine();
	                		
	                		System.out.print("Ingrese telefono de la inmobiliaria: ");
	                		int telefonoInm = scanner.nextInt();
	                		scanner.nextLine();
	                		
	                		System.out.print("Ingrese direccion de la inmobiliaria: ");
	                		String direccionInm = scanner.nextLine();
	                		
	                		Inmobiliaria InmobiliariaAlquiler = new Inmobiliaria(nombreInm, telefonoInm, direccionInm);

	                		System.out.print("\nIngrese el codigo del contrato de alquiler: ");
	                		String codContratoAlquiler = scanner.nextLine();
	                		
	                		System.out.print("\nIngrese la duracion del contrato: ");
	                		Double duracionContrato = scanner.nextDouble();
	           	                		
	                		System.out.print("\nIngrese los gastos de la inmobiliaria: ");
	                		Double gastosInm = scanner.nextDouble();
	                		                		
	                		ContratoAlquiler contrato = new ContratoAlquiler(codContratoAlquiler, LocalDate.now(), inquilino, InmobiliariaAlquiler, duracionContrato, gastosInm, viviendaAlquilada);
	                		
	                		CollectionContrato.agregarContrato(contrato);
	                		
	                		CollectionInmueble.cambiarEstadoVivienda(codVivienda);
	                		
	                		System.out.println("\nCONTRATO REALIZADO CORRECTAMENTE");
	                		contrato.mostrarDatos();
	                	}
	                	else {
	                		System.out.println("\nERROR AL REALIZAR CONTRATO\n");
	                	}     	
	                	break;
	                
	                case 5:
	                	List<Terreno> terrenos = CollectionInmueble.terrenos;
	                	terrenos.stream().filter(terreno -> terreno.isEstado()).forEach(terreno -> terreno.mostrarDatos());
	                	
	                	System.out.print("\nSeleccione el terreno a vender: ");
	                	String codTerreno = scanner.nextLine();
	                	
	                	List<Cliente> clientes = CollectionCliente.clientes;
	                	clientes.stream().forEach(cliente1 -> cliente1.mostrarDatos());
	                	
	                	System.out.print("\nSeleccione el DNI del comprador: ");
	                	String dniComprador = scanner.nextLine();
	                	
	                	Cliente comprador = CollectionCliente.buscarClientePorDNI(dniComprador);
	                	Terreno terrenoVendido = CollectionInmueble.buscarTerreno(codTerreno);
	                	
	                	if(comprador!=null && terrenoVendido!=null) {
	                		
	                		System.out.print("\nIngrese nombre de la inmobiliaria: ");
	                		String nombreINM = scanner.nextLine();
	                		
	                		System.out.print("Ingrese telefono de la inmobiliaria: ");
	                		int telefonoINM = scanner.nextInt();
	                		scanner.nextLine();
	                		
	                		System.out.print("Ingrese direccion de la inmobiliaria: ");
	                		String direccionINM = scanner.nextLine();
	                		
	                		Inmobiliaria nuevaInmobiliaria = new Inmobiliaria(nombreINM, telefonoINM, direccionINM);
	                		
	                		System.out.print("\nIngrese los impuestos: ");
	                		double impuesto = scanner.nextDouble();
	                		scanner.nextLine();
	                		
	                		System.out.print("\nIngrese codigo del contrato: ");
	                		String codContrato = scanner.nextLine();
	                		
	                		ContratoCVT contrato = new ContratoCVT(codContrato, LocalDate.now(), comprador, nuevaInmobiliaria, terrenoVendido, impuesto);
	                		
	                		CollectionContrato.agregarContratoCVT(contrato);
	                		
	                		CollectionInmueble.cambiarEstadoTerreno(codTerreno);
	                		
	                		System.out.println("\nCONTRATO REALIZADO CORRECTAMENTE");
	                		contrato.mostrarDatos();
	                	}
	                	else {
	                		System.out.println("\nERROR AL REALIZAR CONTRATO\n");
	                	}
	                	break;
	                	
	                case 6:
	                	System.out.println("\n1.Consultar Viviendas");
	                	System.out.println("2.Consultar Terrenos");
	                	int op2 = scanner.nextInt();
	                	scanner.nextLine();
	                	switch(op2) {
	                	case 1:
	                		List<Vivienda> viviendas = CollectionInmueble.viviendas;
	                		
	                		viviendas.stream().filter(vivienda -> vivienda.isEstado()).forEach(vivienda -> vivienda.mostrarDatos());
	                		
	                		break;
	                	
	                	case 2:
	                		List<Terreno> terrenos1 = CollectionInmueble.terrenos;
	                		
	                		terrenos1.stream().filter(terreno -> terreno.isEstado()).forEach(terreno -> terreno.mostrarDatos());
	                		
	                		break;
	                	
	                	default: System.out.println();
	                	}
	                break;
	                	
	                case 7:
	                	System.out.print("\nViviendas alquiladas:");
	                    List<Vivienda> viviendasAlquiladas = CollectionInmueble.viviendas;
	                    viviendasAlquiladas.stream().filter(v -> !v.isEstado()).forEach(Vivienda::mostrarDatos);
	                	break;
	                
	                case 8:
	                	System.out.print("\nTerrenos vendidos:");
	                    List<Terreno> terrenosVendidos = CollectionInmueble.terrenos;
	                    terrenosVendidos.stream().filter(t -> !t.isEstado()).forEach(Terreno::mostrarDatos);
	                    
	                    double montoTotalVentas = CollectionInmueble.calcularMontoTotalVentas();
	                    System.out.printf("Monto total de todas las ventas: %.2f\n", montoTotalVentas);
	                	break;
	                
	                case 9:
	                    System.out.println("\n*****SALIENDO DEL MENU*****\n");
	                    break;
	                default:
	                    System.out.println("\nOPCION INVALIDA. Intentelo nuevamente\n");
	            }
	        } while(opc != 9);

	        scanner.close();
	    }


	private static void registrarTerreno(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DEL TERRENO");
        
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
        
        System.out.println("\nTERRENO AGREGADO CORRECTAMENTE");
        terreno.mostrarDatos();
        }
	
	private static void registrarVivienda(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DE LA VIVIENDA");
        
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
        
        System.out.println("\nVIVIENDA AGREGADA CORRECTAMENTE");
        vivienda.mostrarDatos();
	}
	
	private static void registrarCliente(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DEL CLIENTE");
		
    	System.out.print("Ingrese el nombre del cliente:");
        String nombre = scanner.next();
        
        System.out.print("Ingrese el apellido del cliente:");
        String apellido = scanner.next();
        
        System.out.print("Ingrese el DNI del cliente:");
        String dni = scanner.next();
        
        System.out.print("Ingrese el teléfono del cliente:");
        String telefono = scanner.next();
        
        System.out.print("Ingrese la dirección del cliente:");
        String direccion = scanner.next();
        
        System.out.print("Ingrese el email del cliente:");
        String email = scanner.next();

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        CollectionCliente.agregarCliente(cliente);
        
        System.out.println("\nCLIENTE AGREGADO CORRECTAMENTE");
        cliente.mostrarDatos();
	}
	
}