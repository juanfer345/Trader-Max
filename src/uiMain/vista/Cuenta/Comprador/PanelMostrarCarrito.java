package uiMain.vista.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import control.ControlLogin;
import control.ControlSalir;
import control.Cuenta.Comprador.ControlComprarProductos;
import control.Cuenta.Comprador.ControlMostrarCarrito;
import control.tabla.tablaBotonOidorMouse;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.vista.tabla.tablaBotonRenderizador;
import uiMain.vista.tabla.tablaModelo;

public class PanelMostrarCarrito extends JPanel {
	/*
	 * crea objeto tipo PanelMostrarCarrito
	 * 
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

		this.add(botones, BorderLayout.SOUTH);

		this.add(new TablaCarrito());
		
		// Declaración del oyente
				ControlComprarProductos oidor = new ControlComprarProductos();
				boton_comprar.addActionListener(oidor);
				//boton_vac.addActionListener(oidor);

	}
	
	public void asignarOyente() {
		
		
	}
}
