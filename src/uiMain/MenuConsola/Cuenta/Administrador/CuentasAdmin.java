package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class CuentasAdmin extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		
		int seleccion;
		
		sb.append("\nUsted ha elegido la opci�n para mostrar el n�mero total de cuentas �Qu� desea hacer?");
		sb.append("\n0: Volver al men�.");
		sb.append("\n1: Continuar.");
		
		while (!controlError) {
			
		    //Ingreso de valores
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			if (seleccion != 0) {
				if (seleccion == 1) {
					//Ejecuci�n del m�todo e impresi�n de respuesta
					System.out.println(((Administrador) InicializacionAplicacion.usuarioActivo).numeroCuentas());
				} else {
					System.out.println("Por favor ingrese un n�mero entero.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			} else {
				System.out.println(); controlError = true;
			}
		}
	}

	@Override
	public String toString() {return "Numero de cuentas";}
}