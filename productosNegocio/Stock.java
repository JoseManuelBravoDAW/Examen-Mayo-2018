package exJoseManuelBravoMartinez.productosNegocio;

import java.util.ArrayList;
import java.util.ListIterator;

import exJoseManuelBravoMartinez.productosNegocio.excepciones.ProductoYaExisteException;

public class Stock {

	private ArrayList<Producto> stock;
	
	public Stock() {
		stock = new ArrayList<Producto>();
	}
	
	public void annadir(Producto p) throws ProductoYaExisteException {
		
		if(stock.contains(p))
			throw new ProductoYaExisteException("Ese producto ya existe.");
		else
			stock.add(p);
		
	}
	
	public ListIterator<Producto> getListIterator(){
		
		return stock.listIterator();
	}
	
	public boolean estaVacio() {
		return stock.isEmpty();
	}
	

}
