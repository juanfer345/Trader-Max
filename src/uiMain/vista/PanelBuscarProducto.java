package uiMain.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControlBuscarProducto;


public class PanelBuscarProducto extends JFrame{
	public JButton BuscarN = new JButton("Buscar por nombre");
	public JButton BuscarC= new JButton("Buscar por código");
	public JButton Cancelar = new JButton("Cancelar");
	public JTextField texto=new JTextField();
	public JLabel mensaje = new JLabel("Ingrese el código o el nombre");

	/*
	 * Propósito: Se encarga de la parte visual del metodo buscarProducto()
	 */

	public PanelBuscarProducto() {
		this.setLayout(new GridLayout(2,2));
		add(mensaje);
		add(texto);
		add(BuscarN);
		add(BuscarC);
		//add(Cancelar);
		ControlBuscarProducto control = new ControlBuscarProducto();
		BuscarN.addActionListener(control);
		BuscarC.addActionListener(control);
		//Cancelar.addActionListener();

	}
	public void lanzar() {
		this.setTitle("Buscar productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		organizar();
	}

	private void organizar() {
		pack(); // coloca los componentes
		setLocationRelativeTo(null); // centra la ventana en la pantalla
		setVisible(true); 
	}

}
