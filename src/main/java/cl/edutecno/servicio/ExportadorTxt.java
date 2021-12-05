package cl.edutecno.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import cl.edutecno.modelo.Cliente;
import cl.edutecno.utilidades.ConsoleColors;
import cl.edutecno.utilidades.Utilidad;

public class ExportadorTxt extends Exportador{
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {
		//File archivo = new File("src" + File.separator + fileName + ".csv");
		File archivo = new File(fileName + ".txt");
		
		if (!archivo.exists()) {
			archivo.createNewFile();
		
		}else {
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cliente clienteTemp : listaClientes) {
				clienteTemp.toStringColors();
				bw.write(clienteTemp.getRunCliente() +","+ clienteTemp.getNombreCliente() +","+ clienteTemp.getApellidoCliente() +","+ clienteTemp.getAniosCliente() +","+ clienteTemp.getNombreCategoria());
				bw.newLine();
			}
			bw.close();
			fw.close();
			System.out.println(ConsoleColors.GREEN + "Datos cargados");
			Utilidad.resetColores();
		}
	}
}
