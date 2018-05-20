package exJoseManuelBravoMartinez.productosGUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ficheros {

	static File firma = new File("JoseManuelBravo.txt");

	public static void escribir(String s) throws IOException {

		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(firma, true)))) {

			writer.println(s);
		}

	}

	public static String leer() throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(firma))) {

			String contenido = "";
			String temp;
			do {
				temp = reader.readLine();
				
				if(temp != null)
					contenido += temp + "\n";
			} while (temp != null);

			return contenido;
		}

	}

	public static void borrar() throws IOException {

		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(firma)))) {

			writer.print("");
		}

	}

}
