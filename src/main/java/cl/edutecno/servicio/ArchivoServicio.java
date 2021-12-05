package cl.edutecno.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import cl.edutecno.modelo.CategoriaEnum;
import cl.edutecno.modelo.Cliente;
import cl.edutecno.utilidades.ConsoleColors;
import cl.edutecno.utilidades.Utilidad;

public class ArchivoServicio {
	
//	Menu menu2 = new Menu();

	public ArrayList<Cliente> cargarDatos(String ubicacionArchivo) throws UnsupportedEncodingException, FileNotFoundException {
		
		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
	
		//File text = new File("src" + File.separator + nombreArchivo + ".csv");
		File text = new File(ubicacionArchivo);
		
		if (text.exists()) {
			try {
				//FileReader fr = new FileReader(text);
				//BufferedReader br = new BufferedReader(fr);
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(text),"Windows-1252"));
				
				//Variable data para leer texto
				String data = br.readLine();
				
				//ciclo if para ver si está vacío o hay información en el texto-
				if (data == null) {
					System.out.println("El archivo de texto está vacío");
				} else {
					while(data !=null) {
						ArrayList<String> datos = new ArrayList<String>(Arrays.asList(data.split(",")));
						
						Cliente cliente = new Cliente(datos.get(0), 					//run
													  datos.get(1), 					//nombre
													  datos.get(2), 					//apellido
													  datos.get(3), 					//años
								CategoriaEnum.valueOf(datos.get(4)));		//estado
						
						arrayClientes.add(cliente);
						data = br.readLine();
					}
				}
				br.close();
				//System.out.println("Datos cargados");
			} catch (IOException e) {
				System.out.println(ConsoleColors.RED + "Error. Intente nuevamente");
				Utilidad.resetColores();
			}
		
		}else {
			System.out.println(ConsoleColors.RED + "El archivo de texto ingresado no existe. Debe crearlo primero.");
			Utilidad.resetColores();
			//esto doble validaría si el archivo existe en la ruta especificada.
		}
		return arrayClientes;
	}
}
