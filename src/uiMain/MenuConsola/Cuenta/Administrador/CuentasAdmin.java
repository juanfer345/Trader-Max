package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Administrador;
import uiMain.OpcionDeMenu;

public class CuentasAdmin extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		
		int seleccion;
		
		sb.append("\nUsted ha elegido la opción para mostrar el número total de cuentas ¿Qué desea hacer?");
		sb.append("\n0: Volver al menú.");
		sb.append("\n1: Continuar.");
		
		while (!controlError) {
			
		    //Ingreso de valores
			System.out.print(sb);
			seleccion = esByte(br.readLine().trim());
			
			if (seleccion != 0) {
				if (seleccion == 1) {
					//Ejecución del método e impresión de respuesta
					System.out.println(((Administrador) InicializacionAplicacion.usuarioActivo).numeroCuentas());
				} else {
					System.out.println("Por favor ingrese un número entero.");
				}
				if (!controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			} else {
				System.out.println(); controlError = true;
			}
		}
	}

	@Override
	public String toString() {return "Numero de cuentas";}
}