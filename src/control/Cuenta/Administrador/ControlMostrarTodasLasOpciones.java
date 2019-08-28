package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;

public class ControlMostrarTodasLasOpciones extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo ImprimirTodasLasOpciones() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	public void actionPerformed(ActionEvent e) {

		//Impresión de las opciones de menú del usuario
		JOptionPane.showMessageDialog(null, OpcionDeMenu.ImprimirTodasLasOpciones(), 
				"Notificación", JOptionPane.INFORMATION_MESSAGE);
	}
	public String toString() {
		return "Mostrar todas las opciones";
	}
}