package cl.edutecno.servicio;

import java.io.IOException;
import java.util.List;

import cl.edutecno.modelo.Cliente;

public abstract class Exportador {
	public abstract void exportar(String filename, List<Cliente> listaClientes) throws IOException;
}

