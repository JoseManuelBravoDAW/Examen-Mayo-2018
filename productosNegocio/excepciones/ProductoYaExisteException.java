package exJoseManuelBravoMartinez.productosNegocio.excepciones;

public class ProductoYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoYaExisteException(String s) {
		super(s);
	}
}
