package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.OpcionDeMenu;
import control.Errores.ErrorAplicacion;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.InicializacionAplicacion;
import uiMain.vista.VentanaAplicacion;

public class ControlMostrarCuentas extends OpcionDeMenu implements ActionListener {

	/*
	 * Prop�sito: Ejecutar el metodo mostrarCuentas() haciendo los respectivos
	 * controles de error del ingreso de datos
	 */

	public void actionPerformed(ActionEvent e) {

		Administrador administrador = (Administrador) InicializacionAplicacion.usuarioActivo;
		String seleccion;
		Byte seleccionNum = null;

		sb.append("Por favor elija una de las siguientes opciones:");
		sb.append("\n1: Mostrar todas las cuentas.");
		sb.append("\n2: Mostrar las cuentas seg�n su estado (activo/inactivo).");

		// Ingreso del dato por parte del usuario
		seleccion = (String) JOptionPane.showInputDialog(null, sb.toString(), "Selecci�n",
				JOptionPane.INFORMATION_MESSAGE, null, null, "Seleccione");
		if (seleccion != null) {
			try {
				seleccionNum = MetodosConError.controlNumero(seleccion,	(byte) 1, (byte) 2, 
						"", "Por favor ingrese un n�mero entero peque�o (byte).");
			}
			catch (ErrorAplicacion a) {
				JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
				return;
			}
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
		}
		else {
			OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			return;
		}

		if (seleccionNum == 1) {

			sb.append("Por favor elija una de las siguientes opciones:");
			sb.append("\n1: Mostrar todas las cuentas.");
			sb.append("\n2: Mostrar todas las cuentas de tipo \"Comprador\".");
			sb.append("\n3: Mostrar todas las cuentas de tipo \"Vendedor\".");
			sb.append("\n4: Mostrar todas las cuentas de tipo \"Administrador\".");

			// Ingreso del dato por parte del usuario
			seleccion = (String) JOptionPane.showInputDialog(null, sb.toString(), "Selecci�n",
					JOptionPane.INFORMATION_MESSAGE, null, null, "Seleccione");
			if (seleccion != null) {
				try {
					seleccionNum = MetodosConError.controlNumero(seleccion,	(byte) 1, (byte) 4, 
							"", "Por favor ingrese un n�mero entero peque�o (byte).");
				}
				catch (ErrorAplicacion a) {
					JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
					return;
				}
				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			}
			else {
				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
				return;
			}

			if (seleccionNum == 1) {
				//Impresi�n del total de cuentas
				JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) 1), 
						"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				//Impresi�n del total de cuentas seg�n tipo
				JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) (seleccionNum - 1), (byte) 1), 
						"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {

			sb.append("Por favor elija una de las siguientes opciones:");
			sb.append("\n1: Consultar cuentas activas.");
			sb.append("\n2: Consultar cuentas inactivas.");

			// Ingreso del dato por parte del usuario
			seleccion = (String) JOptionPane.showInputDialog(null, sb.toString(), "Selecci�n",
					JOptionPane.INFORMATION_MESSAGE, null, null, "Seleccione");

			if (seleccion != null) {
				try {
					seleccionNum = MetodosConError.controlNumero(seleccion,	(byte) 1, (byte) 2, 
							"", "Por favor ingrese un n�mero entero peque�o (byte).");
				}
				catch (ErrorAplicacion a) {
					JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
					return;
				}
				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
			}
			else {
				OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
				return;
			}

			if (seleccionNum == 1) {

				sb.append("Por favor elija una de las siguientes opciones:");
				sb.append("\n2: Mostrar todas las cuentas activas de tipo \"Comprador\".");
				sb.append("\n3: Mostrar todas las cuentas activas de tipo \"Vendedor\".");
				sb.append("\n4: Mostrar todas las cuentas activas de tipo \"Administrador\".");

				// Ingreso del dato por parte del usuario
				seleccion = (String) JOptionPane.showInputDialog(null, sb.toString(), "Selecci�n",
						JOptionPane.INFORMATION_MESSAGE, null, null, "Seleccione");

				if (seleccion != null) {
					try {
						seleccionNum = MetodosConError.controlNumero(seleccion,	(byte) 1, (byte) 4, 
								"", "Por favor ingrese un n�mero entero peque�o (byte).");
					}
					catch (ErrorAplicacion a) {
						JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
						return;
					}
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
				}
				else {
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
					return;
				}

				if (seleccionNum == 1) {
					//Impresi�n del total de cuentas activas
					JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) 2), 
							"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//Impresi�n del total de cuentas activas seg�n tipo
					JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) (seleccionNum - 1), (byte) 2), 
							"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {

				sb.append("Por favor elija una de las siguientes opciones:");
				sb.append("\n1: Mostrar todas las cuentas inactivas.");
				sb.append("\n2: Mostrar todas las cuentas inactivas de tipo \"Comprador\".");
				sb.append("\n3: Mostrar todas las cuentas inactivas de tipo \"Vendedor\".");
				sb.append("\n4: Mostrar todas las cuentas inactivas de tipo \"Administrador\".");

				// Ingreso del dato por parte del usuario
				seleccion = (String) JOptionPane.showInputDialog(null, sb.toString(), "Selecci�n",
						JOptionPane.INFORMATION_MESSAGE, null, null, "Seleccione");

				if (seleccion != null) {
					try {
						seleccionNum = MetodosConError.controlNumero(seleccion,	(byte) 1, (byte) 4, 
								"", "Por favor ingrese un n�mero entero peque�o (byte).");
					}
					catch (ErrorAplicacion a) {
						JOptionPane.showMessageDialog(null, a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
						return;
					}
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
				}
				else {
					OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
					return;
				}

				if (seleccionNum == 1) {
					//Impresi�n del total de cuentas inactivas
					JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) 3), 
							"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//Impresi�n del total de cuentas inactivas seg�n tipo
					JOptionPane.showMessageDialog(null, administrador.mostrarUsuario((byte) (seleccionNum - 1), (byte) 3), 
							"Notificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		VentanaAplicacion.organizar();
		controlError = false;
		OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());
	}

	public String toString() {
		return "Mostrar cuentas";
	}
}