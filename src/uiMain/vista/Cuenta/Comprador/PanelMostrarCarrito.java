package uiMain.vista.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import control.Cuenta.Comprador.ControlComprarProductos;
import control.Cuenta.Comprador.ControlMostrarCarrito;
import uiMain.InicializacionAplicacion;

public class PanelMostrarCarrito extends JPanel {
	/*
	 * Propósito: Se encarga de la parte visual del metodo mostrarCarrito()
	 */

	public JButton boton_comprar = new JButton("Comprar productos");
	public JButton boton_vac = new JButton("Vaciar carrito");
	JTable table;

	public PanelMostrarCarrito() {

		JPanel botones = new JPanel();
		this.setLayout(new BorderLayout(2, 1));
		botones.setLayout(new FlowLayout());
		botones.add(boton_comprar);
		botones.add(boton_vac);

		TablaCarrito tabla = new TablaCarrito();
		this.add(tabla);
		this.add(botones, BorderLayout.SOUTH);
	}

	public void asignarOyente() {

		// Declaración del oyente
		if (InicializacionAplicacion.usuarioActivo.getMenuDeConsola().buscarOpcionDeMenu(new ControlComprarProductos())) {
			boton_comprar.addActionListener(new ControlComprarProductos());
		}

		boton_vac.addActionListener(new ControlMostrarCarrito());
	}
}