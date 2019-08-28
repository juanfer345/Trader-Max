package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gestorAplicacion.Usuarios.Cuenta;

public class ControlMostrarResenas extends OpcionDeMenu implements ActionListener {

	/*
	 * Propósito: Ejecutar el metodo mostrarResenas() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);

		String resenas =  Cuenta.getCatalogo().get(codigo).mostrarResenas();

		JOptionPane.showMessageDialog(null, resenas,"Reseñas", JOptionPane.INFORMATION_MESSAGE);
	}

	public String toString() {
		return "Mostrar reseñas";
	}
}