package exJoseManuelBravoMartinez.productosGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public abstract class Padre extends JDialog{

	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField nombreTextField;
	protected JTextField fechaTextField;
	protected JButton annadirButton;
	protected JButton mostrarButton;
	
	
	public Padre() {
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(contentPanel, "Vas a salir del programa, ¿Estás seguro?", "Saliendo", JOptionPane.YES_NO_OPTION)) {
					JOptionPane.showMessageDialog(contentPanel, "Aaaaaaadios.");
					System.exit(0);
				}
				
			}
		});
		setTitle("Producto");
		setBounds(100, 100, 304, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(101, 52, 46, 14);
		contentPanel.add(lblNombre);

		JLabel lblFechaCaducidad = new JLabel("Fecha caducidad");
		lblFechaCaducidad.setBounds(51, 93, 102, 14);
		contentPanel.add(lblFechaCaducidad);

		nombreTextField = new JTextField();
		nombreTextField.setBounds(157, 49, 86, 20);
		contentPanel.add(nombreTextField);
		nombreTextField.setColumns(10);

		fechaTextField = new JTextField();
		fechaTextField.setBounds(157, 90, 86, 20);
		contentPanel.add(fechaTextField);
		fechaTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				annadirButton = new JButton("A\u00F1adir");
				annadirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						accionBotonIzquierda();

					}
				});
				annadirButton.setActionCommand("OK");
				buttonPane.add(annadirButton);
				getRootPane().setDefaultButton(annadirButton);
			}
			{
				mostrarButton = new JButton("Mostrar stock");
				mostrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						accionBotonDerecha();
						
					}
				});
				mostrarButton.setActionCommand("Cancel");
				buttonPane.add(mostrarButton);
			}
		}
	}
	
	protected abstract void accionBotonIzquierda();

	protected abstract void accionBotonDerecha();
	
}
