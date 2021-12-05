package cl.edutecno.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidad {

	public static void limpiezaDePantalla(int saltos) {

		System.out.println(new String(new char[saltos]).replace("\0", "\r\n"));
	}

	public static void tiempoDeEspera(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*** Validación de RUT Chileno* algoritmo Modulo 11*/
    
	/*** Valida rut de la forma XXXXXXXX-X */
    public static Boolean validaRut(String rut) {
        rut = rut.replace(".", "");
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if (matcher.matches() == false)
            return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
    }
    
    /*** Valida el dígito verificador */
    public static String dv(String rut) {
        Integer M = 0, S = 1, T = Integer.parseInt(rut);
        for (; T != 0; T = (int) Math.floor(T /= 10))
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        return (S > 0) ? String.valueOf(S - 1) : "k";
    }
    
    public static void resetColores() {
    	System.out.print("" + ConsoleColors.RESET);
    }
	
    public static String anualidad(String anios) {
    	
    	int cantidad = Integer.parseInt(anios);
    	
    	if( cantidad != 1 ||  cantidad != -1)
    		anios = anios + " Años";
    	else 
    		anios = anios + " Año";
    	
    	return anios;
    }
    
    public static String nombrePropio(String str) {
    	return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static Boolean compruebaRuta(String ruta) {
  
    	//String expresionRegular = "^(?:[\\w]\\:|\\\\)(\\\\[a-z_\\-\\s0-9\\.]+)+\\.(txt|csv)$";
    	String expresionRegular = "^(?:[a-zA-Z]\\:|\\\\\\\\[\\w\\.]+\\\\[\\w.$]+)\\\\(?:[\\w]+\\\\)*\\w([\\w.])+$";
    	
    	return Pattern.matches(expresionRegular, ruta);
    	
    }
}
