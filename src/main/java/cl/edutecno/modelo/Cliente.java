package cl.edutecno.modelo;

import cl.edutecno.utilidades.ConsoleColors;

public class Cliente {
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	//Constructores
	public Cliente() {
		
	}
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente      = runCliente;
		this.nombreCliente   = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente    = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	
	//Getters/Setters
	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	//toString con Colores
	public void toStringColors() {
		System.out.println(
				"Cliente [" 
				+ "runCliente="        + ConsoleColors.BLUE + runCliente      +  ConsoleColors.RESET
				+ ", nombreCliente="   + ConsoleColors.BLUE + nombreCliente   +  ConsoleColors.RESET
				+ ", apellidoCliente=" + ConsoleColors.BLUE + apellidoCliente +  ConsoleColors.RESET
				+ ", a??osCliente="     + ConsoleColors.BLUE + aniosCliente    +  ConsoleColors.RESET
				+ ", nombreCategoria=" + ConsoleColors.BLUE + nombreCategoria +  ConsoleColors.RESET
				+ "]");
	}
}


//Clase Cliente version Lombok

//import lombok.*;
//import cl.edutecno.utilidades.ConsoleColors;
//
//@Data
//@ToString
//public class Cliente {
//	private String runCliente;
//	private String nombreCliente;
//	private String apellidoCliente;
//	private String aniosCliente;
//	private CategoriaEnum nombreCategoria;
//	
//	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
//			CategoriaEnum nombreCategoria) {
//		super();
//		this.runCliente      = runCliente;
//		this.nombreCliente   = nombreCliente;
//		this.apellidoCliente = apellidoCliente;
//		this.aniosCliente    = aniosCliente;
//		this.nombreCategoria = nombreCategoria;
//	}
//
//	public void toStringColors() {
//		System.out.println(
//				"Cliente [" 
//				+ "runCliente="        + ConsoleColors.BLUE + runCliente      +  ConsoleColors.RESET
//				+ ", nombreCliente="   + ConsoleColors.BLUE + nombreCliente   +  ConsoleColors.RESET
//				+ ", apellidoCliente=" + ConsoleColors.BLUE + apellidoCliente +  ConsoleColors.RESET
//				+ ", a??osCliente="     + ConsoleColors.BLUE + aniosCliente    +  ConsoleColors.RESET
//				+ ", nombreCategoria=" + ConsoleColors.BLUE + nombreCategoria +  ConsoleColors.RESET
//				+ "]");
//	}
//}
