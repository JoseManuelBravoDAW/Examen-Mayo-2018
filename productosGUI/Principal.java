package exJoseManuelBravoMartinez.productosGUI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JOptionPane;

import exJoseManuelBravoMartinez.productosNegocio.Stock;

public class Principal {

	static Stock stock = new Stock();
	
	public static void main(String[] args) {
		
		bienvenida();
		crearYMostrarVentanas();
		
	}



	private static void crearYMostrarVentanas() {
		Alta dialog = new Alta();
		dialog.setVisible(true);
	}



	private static void bienvenida(){
		try {
			if(Ficheros.firma.exists()) {
				JOptionPane.showMessageDialog(null, Ficheros.leer());
				JOptionPane.showMessageDialog(null, "Voy a machacar el fichero.");
				Ficheros.borrar();
			}else 
				JOptionPane.showMessageDialog(null, "No hay ningun fichero que leer");
			
			Ficheros.escribir("Bienvenido al examen final.");
			Ficheros.escribir("Mayo de 2018.");
			Ficheros.escribir(getFechaActual());
			Ficheros.escribir("José Manuel Bravo Martínez.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error de lectura/escritura.");
		}
	}

	
	
	public static String getFechaActual() {
		Locale locale = new Locale("es", "ES");
		LocalDate hoy = LocalDate.now();
		return "Hoy es día " + hoy.getDayOfMonth() + ", " + hoy.getDayOfWeek().getDisplayName(TextStyle.FULL , locale);
	}
}
