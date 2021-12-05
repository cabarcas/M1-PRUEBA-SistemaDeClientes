package cl.edutecno.main;

import java.io.IOException;

import cl.edutecno.vista.Menu;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if (System.console() == null) System.setProperty("jansi.passthrough", "true");
		
		Menu menu = new Menu();
		
		menu.iniciarMenu();
	}
}
