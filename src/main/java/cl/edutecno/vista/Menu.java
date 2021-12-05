package cl.edutecno.vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import cl.edutecno.modelo.CategoriaEnum;
import cl.edutecno.modelo.Cliente;
import cl.edutecno.servicio.ArchivoServicio;
import cl.edutecno.servicio.ClienteServicio;
import cl.edutecno.servicio.ExportadorCsv;
import cl.edutecno.servicio.ExportadorTxt;
import cl.edutecno.utilidades.ConsoleColors;
import cl.edutecno.utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	
	Scanner scStr = new Scanner(System.in);	// Scanner String
	Scanner scInt = new Scanner(System.in);	// Scanner int

	private String fileName  = "Clientes";
	private String fileName1 = "DBClientes.csv";

	public void iniciarMenu() throws IOException {
		
		System.out.print(
				ConsoleColors.RED + "1" + ConsoleColors.RESET + ". Listar Clientes  \n" +
				ConsoleColors.RED + "2" + ConsoleColors.RESET + ". Agregar Cliente  \n" +
				ConsoleColors.RED + "3" + ConsoleColors.RESET + ". Editar Cliente   \n" +
				ConsoleColors.RED + "4" + ConsoleColors.RESET + ". Cargar Datos     \n" + 
				ConsoleColors.RED + "5" + ConsoleColors.RESET + ". Exportar Datos   \n" +
				ConsoleColors.RED + "6" + ConsoleColors.RESET + ". Salir            \n" +
				"Ingrese una opción: \n" +
			    "> " + ConsoleColors.GREEN
			    );
		
		int opcion = scInt.nextInt();
		Utilidad.resetColores();
		
		seleccionMenu(opcion);
	}

	private void seleccionMenu(int opcion) throws IOException {

		switch (opcion) {
		case 1:
			listarClientes();
			iniciarMenu();
			break;
		case 2:
			agregarClientes();
			iniciarMenu();
			break;
		case 3:
			editarClientes();
			iniciarMenu();
			break;
		case 4:
			importarDatos();
			iniciarMenu();
			break;
		case 5:
			exportarDatos();
			iniciarMenu();
			break;
		case 6:
			terminarPrograma();
			break;
		default:
			System.out.println(ConsoleColors.RED + "Ingresaste una opción incorrecta!" + ConsoleColors.RESET);
			break;
		}
	}

	private void listarClientes() {
	
		System.out.println("------------Listar Cliente-------------");
		System.out.println("   Listando los clientes Existentes    ");
		System.out.println("---------------------------------------");
		clienteServicio.listarClientes();
	}

	private void agregarClientes() {
			
		System.out.println("-------------Crear Cliente-------------");		
		
		String runCliente = "";
		
		do {
			System.out.println("Ingrese el RUN del cliente");
			runCliente = scStr.nextLine();
			
			if (Utilidad.validaRut(runCliente))
				System.out.println(ConsoleColors.GREEN + "RUN ingresado es correcto" + ConsoleColors.RESET);
			else
				System.out.println(ConsoleColors.RED + "RUN ingresado es incorrecto" + ConsoleColors.RESET);

		} while (!Utilidad.validaRut(runCliente));

		System.out.println("Ingrese el Nombre del cliente  "); String nombreCliente   = scStr.nextLine().trim();
		System.out.println("Ingrese el Apellido del Cliente"); String apellidoCliente = scStr.nextLine().trim();
		System.out.println("Ingrese los Años como cliente  "); String aniosCliente    = scStr.nextLine().trim();
		
		aniosCliente = Utilidad.anualidad(aniosCliente);

		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.Activo);
		clienteServicio.agregarClientes(cliente);
		
		System.out.println("---------------------------------------");
	}

	private void editarClientes() {
		//Scanner scStr = new Scanner(System.in);
		String opcion = "";
		String rut = "";
		
		System.out.println("-------------Editar Cliente-------------");
		
		do {
			System.out.println("Seleccione qué desea hacer:");
			System.out.println(ConsoleColors.RED + "1" + ConsoleColors.RESET + ".-Cambiar el estado del Cliente");
			System.out.println(ConsoleColors.RED + "2" + ConsoleColors.RESET + ".-Editar los datos ingresados del Cliente");
			System.out.println(ConsoleColors.RED + "0" + ConsoleColors.RESET + ".-Retornar al menú principal");
			System.out.print("Ingrese opción:\n> " + ConsoleColors.GREEN);
			opcion = scStr.nextLine().trim();
			Utilidad.resetColores();
			
			int count;
			switch (opcion) {
			case "1": //cambia estado del cliente
				System.out.println("-----Actualizando estado del Cliente----");
				System.out.println("Ingrese RUN del Cliente a editar:");
				rut = scStr.nextLine().trim();
				count = 0;
				for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
					if (rut.equals(clienteTemp.getRunCliente())) {
						clienteServicio.editarEstadoCliente(clienteTemp);
						count++;
					}
				}
				if(count==0) {
					System.out.println(ConsoleColors.RED + "**************************************************");
					System.out.println(ConsoleColors.RED + "No se ha encontrado cliente o valor es incorrecto ");
					System.out.println(ConsoleColors.RED + "**************************************************");
					Utilidad.resetColores();
				}
				break;
			case "2": //edita datos del cliente
				System.out.println("----Actualizando datos del Cliente-----");
				System.out.println("Ingrese RUN del Cliente a editar:");
				rut = scStr.nextLine().trim();
				count = 0;
				for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
					if (rut.equals(clienteTemp.getRunCliente())) {
						clienteServicio.editarDatosCliente(clienteTemp);
						count++;
					}
				}
				if(count==0) {
					System.out.println(ConsoleColors.RED + "**************************************************");
					System.out.println(ConsoleColors.RED + "No se ha encontrado cliente o valor es incorrecto ");
					System.out.println(ConsoleColors.RED + "**************************************************");
					Utilidad.resetColores();
				}
				break;
			case "0":
				break;
			default:
				System.out.println(ConsoleColors.RED + "!Ingresaste una opción incorrecta!");
				Utilidad.resetColores();
				break;
			}
		} while (!opcion.equals("0"));
		//scStr.close();
		//scInt.close();
	}

	public void importarDatos() throws UnsupportedEncodingException, FileNotFoundException {
		String ruta ="";
		
		System.out.println("---------Cargar Datos en Windows---------------");

		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		
		ruta = scStr.nextLine().trim();
		
		if(ruta.isEmpty())
			ruta = "C:\\usuario\\equipo\\Desktop";
		
		while (!Utilidad.compruebaRuta(ruta)) {
			ruta = "";
			System.out.println("Intente nuevamente, Ingrese la ruta para DBClientes.csv");
			ruta = scStr.nextLine().trim();
		}

		String ubicacionArchivo = ruta + File.separator + fileName1;

		ArrayList<Cliente> arrayImportado = archivoServicio.cargarDatos(ubicacionArchivo);
		
		for (Cliente clienteTemp : arrayImportado) {
			clienteTemp.toStringColors();
		}

		if (arrayImportado.size() == 0) {
			importarDatos();
		} else {
			clienteServicio.getListaClientes().addAll(arrayImportado);
			System.out.println(ConsoleColors.GREEN + "Datos cargados correctamente en la lista");
			Utilidad.resetColores();
		}
	}

	private void exportarDatos() throws IOException {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println(ConsoleColors.RED + "1" + ConsoleColors.RESET + ".-Formato csv");
		System.out.println(ConsoleColors.RED + "2" + ConsoleColors.RESET + ".-Formato txt");
		System.out.println("");
		System.out.println("Ingrese una opción para exportar:" + ConsoleColors.GREEN);
		
		int opcion = scInt.nextInt();
		Utilidad.resetColores();

		String ruta ="";
		String ubicacionArchivo;
		switch (opcion) {
		case 1:
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			ruta = scStr.nextLine().trim();
			
			if(ruta.isEmpty())
				ruta = "C:\\usuario\\equipo\\Desktop";
			
			while (!Utilidad.compruebaRuta(ruta)) {
				ruta = "";
				System.out.println("Intente nuevamente, Ingrese la ruta para clientes.csv");
				ruta = scStr.nextLine().trim();
			}

			ubicacionArchivo = ruta + File.separator + fileName;
			exportadorCsv.exportar(ubicacionArchivo, clienteServicio.getListaClientes());
			break;
		case 2:
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			ruta = scStr.nextLine().trim();
			
			if(ruta.isEmpty())
				ruta = "C:\\usuario\\equipo\\Desktop";
			
			while (!Utilidad.compruebaRuta(ruta)) {
				ruta = "";
				System.out.println("Intente nuevamente, Ingrese la ruta para clientes.txt");
				ruta = scStr.nextLine().trim();
			}

			ubicacionArchivo = ruta + File.separator + fileName;
			exportadorTxt.exportar(ubicacionArchivo, clienteServicio.getListaClientes());
			break;
		default:
			System.out.println(ConsoleColors.RED + "!Ingresaste una opción incorrecta!" + ConsoleColors.RESET);
			exportarDatos();
			break;
		}
	}

	private void terminarPrograma() {
		System.out.println("Abandonando el sistema de productos");
		System.out.println("Acaba de salir del sistema");
		scStr.close();
		scInt.close();
		System.exit(0);
	}

}
