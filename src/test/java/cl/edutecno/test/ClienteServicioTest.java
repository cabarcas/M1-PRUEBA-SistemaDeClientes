package cl.edutecno.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import cl.edutecno.modelo.CategoriaEnum;
import cl.edutecno.modelo.Cliente;
import cl.edutecno.servicio.ClienteServicio;

//Pruebas unitarias, requerimientos
//Añadir dependencias 											OK
//Escribir pruebas unitarias para ClienteServicio 				OK
//verificar funcionamiento de agregarCliente 					OK
//verificar funcionamiento de agregarCliente en caso de nulos 	OK

public class ClienteServicioTest {

	//declaran clienteServicio y Cliente para llamados a las clases
	private static ClienteServicio clienteServicio;
	private static Cliente cliente;
	
	@Before
	public void setUp() {
		//instancia para realizacion de pruebas
		clienteServicio = new ClienteServicio();
	}
	
	@Test
	public void agregarClienteTest() {
		
		cliente = new Cliente("11.111.111-1", "Edutecno", "Capacitacion", "3", CategoriaEnum.Activo);
		
		clienteServicio.agregarClientes(cliente);
		assertEquals(clienteServicio.getListaClientes().get(0).getNombreCliente(), "Edutecno");
	}
	
	@Test
	public void agregarClienteNullTest() {

		cliente = new Cliente("11.111.111-1", "Edutecno", "Capacitacion", "3", CategoriaEnum.Activo);
		
		clienteServicio.agregarClientes(cliente);
		assertNull(clienteServicio.getListaClientes().get(0).getNombreCliente(), null);
	}
	
}
