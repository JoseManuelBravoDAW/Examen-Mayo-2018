package exJoseManuelBravoMartinez.productosNegocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exJoseManuelBravoMartinez.productosNegocio.excepciones.NombreNoValidoException;

public class Producto {

	private String nombre;
	private static final Pattern patron = Pattern.compile("((\\w){3,} *)+");
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}


	public Producto(String nombre) throws NombreNoValidoException {
		
		setNombre(nombre);
		
	}


	public String getNombre() {
		return nombre;
	}


	private void setNombre(String nombre) throws NombreNoValidoException {
		
		Matcher m = patron.matcher(nombre);
		
		if(m.matches())
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("El nombre del producto no es válido.");
	}
}
