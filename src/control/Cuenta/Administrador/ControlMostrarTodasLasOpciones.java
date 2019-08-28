package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;

public class ControlMostrarTodasLasOpciones extends OpcionDeMenu implements ActionListener {

	/*
	 * Prop�sito: Ejecutar el metodo ImprimirTodasLasOpciones() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	public void actionPerformed(ActionEvent e) {

		//Impresi�n de las opciones de men� del usuario
		JOptionPane.showMessageDialog(null, OpcionDeMenu.ImprimirTodasLasOpciones(), 
				"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
	}
	public String toString() {
		return "Mostrar todas las opciones";
	}
}