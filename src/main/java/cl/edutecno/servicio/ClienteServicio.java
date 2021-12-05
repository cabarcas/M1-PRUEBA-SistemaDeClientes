package cl.edutecno.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.edutecno.modelo.CategoriaEnum;
import cl.edutecno.modelo.Cliente;
import cl.edutecno.utilidades.ConsoleColors;
import cl.edutecno.utilidades.Utilidad;

public class ClienteServicio {
	
	private List<Cliente> listaClientes;
	private Scanner sc = new Scanner(System.in);
	
	public ClienteServicio() {
		listaClientes = new ArrayList <Cliente>();
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {
		if (listaClientes != null && listaClientes.size() != 0) {
			for (Cliente clienteTemp : listaClientes) {
				//System.out.println(clienteTemp.toString());
				System.out.println("-------------Datos del Cliente-------------");
				System.out.println("RUN del Cliente: "       + ConsoleColors.BLUE + clienteTemp.getRunCliente());
				Utilidad.resetColores();
				System.out.println("Nombre del Cliente: "    + ConsoleColors.BLUE + clienteTemp.getNombreCliente());
				Utilidad.resetColores();
				System.out.println("Apellido del Cliente: "  + ConsoleColors.BLUE + clienteTemp.getApellidoCliente());
				Utilidad.resetColores();
				System.out.println("Años como Cliente: "     + ConsoleColors.BLUE + clienteTemp.getAniosCliente());
				Utilidad.resetColores();
				System.out.println("Categoría del Cliente: " + ConsoleColors.BLUE + clienteTemp.getNombreCategoria());
				Utilidad.resetColores();
				System.out.println("-------------------------------------------");
			}
		} else {
			System.out.println(ConsoleColors.RED + "**************************************************");
			System.out.println(ConsoleColors.RED + "No se ha encontrado clientes o no existen clientes");
			System.out.println(ConsoleColors.RED + "**************************************************");
			Utilidad.resetColores();
		}
	}
	
	public void agregarClientes(Cliente cliente) {

		if (listaClientes != null) {
			listaClientes.add(cliente);
			System.out.println(ConsoleColors.GREEN + "Cliente agregado");
			Utilidad.resetColores();
		} else {
			listaClientes = new ArrayList<Cliente>();
			listaClientes.add(cliente);
			System.out.println(ConsoleColors.GREEN + "Cliente agregado");
			Utilidad.resetColores();
		}
	}

	public void editarEstadoCliente(Cliente clienteTemp) {
		System.out.println("El estado actual es " + ConsoleColors.BLUE + clienteTemp.getNombreCategoria());
		Utilidad.resetColores();
		System.out.println(ConsoleColors.RED+"1"+ConsoleColors.RESET+".-Si desea cambiar el estado del Cliente a Inactivo");
		System.out.println(ConsoleColors.RED+"2"+ConsoleColors.RESET+".-Si desea mantener el estado del cliente Activo");
		System.out.println("");
		System.out.println("Ingrese opcion:"+ ConsoleColors.GREEN);
		String opcion = sc.nextLine().trim();
		Utilidad.resetColores();
		
		do {
			switch (opcion) {
			case "1":
				clienteTemp.setNombreCategoria(CategoriaEnum.Inactivo);
				System.out.println("Estado cambiado a " + ConsoleColors.RED + "Inactivo\n");
				Utilidad.resetColores();
				break;
			case "2":
				clienteTemp.setNombreCategoria(CategoriaEnum.Activo);
				System.out.println("Estado cambiado a " + ConsoleColors.GREEN + "Activo\n");
				Utilidad.resetColores();
				break;
			default:
				System.out.println(ConsoleColors.RED + "Opción inválida, Ingrese nuevamente.");
				Utilidad.resetColores();
				break;
			}
		}while(!(opcion.equals("1") || opcion.equals("2")));
	}
	
	public void editarDatosCliente(Cliente clienteTemp) {

		System.out.println(ConsoleColors.RED+"1"+ConsoleColors.RESET+".-El RUN del Cliente es: " + ConsoleColors.BLUE + clienteTemp.getRunCliente());
		Utilidad.resetColores();
		System.out.println(ConsoleColors.RED+"2"+ConsoleColors.RESET+".-El Nombre del Cliente es: " + ConsoleColors.BLUE + clienteTemp.getNombreCliente());
		Utilidad.resetColores();
		System.out.println(ConsoleColors.RED+"3"+ConsoleColors.RESET+".-El Apellido del Cliente es: " + ConsoleColors.BLUE + clienteTemp.getApellidoCliente());
		Utilidad.resetColores();
		System.out.println(ConsoleColors.RED+"4"+ConsoleColors.RESET+".-Los años como Cliente son: " + ConsoleColors.BLUE + clienteTemp.getAniosCliente());
		Utilidad.resetColores();
		System.out.println("Ingrese opcion a editar de los datos del cliente:"+ ConsoleColors.GREEN);
		String opcion = sc.nextLine();
		Utilidad.resetColores();
		
		//Datos cambiados con éxito
		switch (opcion) {
		case "1":
			System.out.println("1.-Ingrese nuevo RUN del Cliente:");
			clienteTemp.setRunCliente(sc.nextLine());
			System.out.println(ConsoleColors.GREEN + "Actualiza RUN del Cliente");
			Utilidad.resetColores();
			System.out.println("---------------------------------------");
			break;
		case "2":
			System.out.println("2.-Ingrese nuevo Nombre del Cliente:");
			clienteTemp.setNombreCliente(sc.nextLine());
			System.out.println(ConsoleColors.GREEN + "Actualiza Nombre del Cliente");
			Utilidad.resetColores();
			System.out.println("---------------------------------------");
			break;
		case "3":
			System.out.println("2.-Ingrese nuevo Apellido del Cliente:");
			clienteTemp.setApellidoCliente(sc.nextLine());
			System.out.println(ConsoleColors.GREEN + "Actualiza Apellido del Cliente");
			Utilidad.resetColores();
			System.out.println("---------------------------------------");
			break;
		case "4":
			System.out.println("2.-Ingrese Años del Cliente:");
			clienteTemp.setAniosCliente(Utilidad.anualidad(sc.nextLine().trim()));
			System.out.println(ConsoleColors.GREEN + "Actualiza Años del Cliente");
			Utilidad.resetColores();
			System.out.println("---------------------------------------");
			break;
		default:
			System.out.println(ConsoleColors.RED + "¡Ingresaste una opción incorrecta!");
			Utilidad.resetColores();
			break;
		}
	}	

}


