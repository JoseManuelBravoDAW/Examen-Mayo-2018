package exJoseManuelBravoMartinez.productosGUI;

import java.util.ListIterator;

import exJoseManuelBravoMartinez.productosNegocio.Perecedero;
import exJoseManuelBravoMartinez.productosNegocio.Producto;

public class Mostrar extends Padre {

	private static final long serialVersionUID = 1L;

	private ListIterator<Producto> productos;
	
	private boolean izquierdaHaSidoPulsado = false;
	private boolean derechaHaSidoPulsado = false;
	
	public Mostrar() {
		super();
		productos = Principal.stock.getListIterator();
		annadirButton.setEnabled(false);
		
		setTitle("Stock");
		annadirButton.setText("<");
		mostrarButton.setText(">");
		nombreTextField.setEditable(false);
		fechaTextField.setEditable(false);
		
		actualizar(productos.next());
		
		if(!productos.hasNext())
			mostrarButton.setEnabled(false);
	}
	
	@Override
	protected void accionBotonIzquierda() {
		izquierdaHaSidoPulsado = true;
		if(derechaHaSidoPulsado) {
			productos.previous();
			derechaHaSidoPulsado = false;
		}
		
		if(productos.hasPrevious()) {
			
			actualizar(productos.previous());
			mostrarButton.setEnabled(true);
		}else {
			annadirButton.setEnabled(false);
		}
		
		if(!productos.hasPrevious()) {
			annadirButton.setEnabled(false);
		}
		
		
	}
	
	@Override
	protected void accionBotonDerecha() {
		derechaHaSidoPulsado = true;
		
		if(izquierdaHaSidoPulsado) {
			productos.next();
			izquierdaHaSidoPulsado = false;
		}
		
		if(productos.hasNext()) {
			
			actualizar(productos.next());
			annadirButton.setEnabled(true);
			
		}else {
			mostrarButton.setEnabled(false);
		}
		
		if(!productos.hasNext()) {
			mostrarButton.setEnabled(false);
		}
		
	}

	private void actualizar(Producto p) {
		
		nombreTextField.setText(p.getNombre());
		fechaTextField.setText("");
		if(p.getClass() == Perecedero.class) {
			Perecedero per = (Perecedero) p;
			fechaTextField.setText(per.getFechaCaducidad());
		}
		

	}
}
