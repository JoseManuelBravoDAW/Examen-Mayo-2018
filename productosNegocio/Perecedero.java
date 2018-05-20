package exJoseManuelBravoMartinez.productosNegocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exJoseManuelBravoMartinez.productosNegocio.excepciones.FechaNoValidaException;
import exJoseManuelBravoMartinez.productosNegocio.excepciones.NombreNoValidoException;

public class Perecedero extends Producto {

	private String fechaCaducidad;
	private static final Pattern patron = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
	
	public Perecedero(String nombre, String fecha) throws NombreNoValidoException, FechaNoValidaException {
		super(nombre);
		setFechaCaducidad(fecha);
	}
	
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	private void setFechaCaducidad(String fechaCaducidad) throws FechaNoValidaException {
		Matcher m = patron.matcher(fechaCaducidad);
		if(m.matches())
			this.fechaCaducidad = fechaCaducidad;
		else
			throw new FechaNoValidaException("La fecha no es valida.");
	}

}
