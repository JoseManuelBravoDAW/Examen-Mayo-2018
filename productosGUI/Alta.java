package exJoseManuelBravoMartinez.productosGUI;

import javax.swing.JOptionPane;

import exJoseManuelBravoMartinez.productosNegocio.Perecedero;
import exJoseManuelBravoMartinez.productosNegocio.Producto;

public class Alta extends Padre{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void accionBotonIzquierda(){
		if (fechaTextField.getText().equals("")) {
			try {
				Principal.stock.annadir(new Producto(nombreTextField.getText().trim()));
				nombreTextField.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			} 
		} else {

			try {
				Principal.stock.annadir(new Perecedero(nombreTextField.getText().trim(), fechaTextField.getText()));
				nombreTextField.setText("");
				fechaTextField.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			} 

		}
	}
	
	@Override
	protected void accionBotonDerecha() {

		if(Principal.stock.estaVacio()) {
			JOptionPane.showMessageDialog(contentPanel, "No hay productos que mostrar.");
		}else {
			Mostrar mostrar = new Mostrar();
			mostrar.setVisible(true);
			setVisible(false);
		}
		
		

	}
	
}
