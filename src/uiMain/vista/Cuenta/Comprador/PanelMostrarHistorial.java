package uiMain.vista.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import control.Cuenta.Comprador.ControlBorrarHistorial;
import control.Cuenta.Comprador.ControlComprarProductos;
import control.Cuenta.Comprador.ControlMostrarCarrito;

public class PanelMostrarHistorial extends JPanel{
	
	/*
	 * Propósito: Se encarga de la parte visual del metodo mostrarHistorial()
	 */

	public JButton boton_borrar = new JButton("Borrar Historial");
	JTable table;
	

	public PanelMostrarHistorial() {

		JPanel botones = new JPanel();
		this.setLayout(new BorderLayout(2, 1));
		botones.setLayout(new FlowLayout());
		botones.add(boton_borrar);

		tablaHistorial tabla = new tablaHistorial();
		this.add(tabla);
		this.add(botones, BorderLayout.SOUTH);

	}
	
	public void asignarOyente() {

		// Declaración del oyente
		ControlBorrarHistorial oidor = new ControlBorrarHistorial();
		boton_borrar.addActionListener(oidor);
		

		
	}
}

