package uiMain.vista.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarACarrito extends JPanel {
	/*
	 * Propósito: Se encarga de la parte visual del metodo agregarACarrito()
	 */
	
	public JButton agregar = new JButton("Agregar Producto");
	public JTextField text = new JTextField();
	
	public PanelAgregarACarrito(){
		
		JPanel boton = new JPanel();
		this.setLayout(new BorderLayout(2, 1));
		boton.setLayout(new FlowLayout());
		boton.add(agregar);

		this.add(boton, BorderLayout.SOUTH);

		this.add(text, BorderLayout.NORTH);
	}
}
