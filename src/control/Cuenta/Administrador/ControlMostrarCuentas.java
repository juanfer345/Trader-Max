package control.Cuenta.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarCuentas extends OpcionDeMenu implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Administrador administrador = (Administrador) InicializacionAplicacion.usuarioActivo;
		byte seleccion=0;

		System.out.println();
//		sb.append("Por favor elija una de las siguientes opciones:");
//		sb.append("\n1: Mostrar todas las cuentas.");
//		sb.append("\n2: Mostrar las cuentas seg�n su estado (activo/inactivo).");
//		sb.append("\nSelecci�n");

		// Ingreso del dato por parte del usuario
		//seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
		//if (OpcionDeMenu.controlError) {System.out.println(); return;} OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());

		if (seleccion == 1) {
//			sb.append("\n1: Mostrar todas las cuentas.");
//			sb.append("\n2: Mostrar todas las cuentas de tipo \"Comprador\".");
//			sb.append("\n3: Mostrar todas las cuentas de tipo \"Vendedor\".");
//			sb.append("\n4: Mostrar todas las cuentas de tipo \"Administrador\".");
//			sb.append("\nSelecci�n");

			// Ingreso del dato por parte del usuario
		//	seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 4, sb.toString(), "Por favor ingrese un n�mero entero");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			if (seleccion == 1) {
				//Impresi�n del total de cuentas
				System.out.println(administrador.mostrarUsuario((byte) 1));
			}
			else {
				//Impresi�n del total de cuentas seg�n tipo
				System.out.println(administrador.mostrarUsuario((byte) (seleccion - 1), (byte) 1));
			}
		}
		else {
//
//			sb.append("\n1: Consultar cuentas activas.");
//			sb.append("\n2: Consultar cuentas inactivas.");
//			sb.append("\nSelecci�n");

			// Ingreso del dato por parte del usuario
		//	seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
			//if (OpcionDeMenu.controlError) {System.out.println(); return;} OpcionDeMenu.sb.delete(0, OpcionDeMenu.sb.length());

			if (seleccion == 1) {

//				sb.append("\n1: Mostrar todas las cuentas activas.");
//				sb.append("\n2: Mostrar todas las cuentas activas de tipo \"Comprador\".");
//				sb.append("\n3: Mostrar todas las cuentas activas de tipo \"Vendedor\".");
//				sb.append("\n4: Mostrar todas las cuentas activas de tipo \"Administrador\".");
//				sb.append("\nSelecci�n");

				// Ingreso del dato por parte del usuario
			//	seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 4, sb.toString(), "Por favor ingrese un n�mero entero");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				if (seleccion == 1) {
					//Impresi�n del total de cuentas activas
					System.out.println(administrador.mostrarUsuario((byte) 2));
				}
				else {
					//Impresi�n del total de cuentas activas seg�n tipo
					System.out.println(administrador.mostrarUsuario((byte) (seleccion - 1), (byte) 2));
				}
			}
			else {

//				sb.append("\n1: Mostrar todas las cuentas inactivas.");
//				sb.append("\n2: Mostrar todas las cuentas inactivas de tipo \"Comprador\".");
//				sb.append("\n3: Mostrar todas las cuentas inactivas de tipo \"Vendedor\".");
//				sb.append("\n4: Mostrar todas las cuentas inactivas de tipo \"Administrador\".");
//				sb.append("\nSelecci�n");

				// Ingreso del dato por parte del usuario
	//			seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 4, sb.toString(), "Por favor ingrese un n�mero entero");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				if (seleccion == 1) {
					//Impresi�n del total de cuentas inactivas
					System.out.println(administrador.mostrarUsuario((byte) 3));
				}
				else {
					//Impresi�n del total de cuentas inactivas seg�n tipo
					System.out.println(administrador.mostrarUsuario((byte) (seleccion - 1), (byte) 3));
				}
			}
		}
	}
	public String toString() {
		return "Mostrar cuentas";
	}
}