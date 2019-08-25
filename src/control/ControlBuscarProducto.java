package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlBuscarProducto extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		String nombreProducto;
		int idProducto;
		byte seleccion=0;

		// Verificaci�n de catalogo no vac�o
		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selecci�n por parte del usuario
			//seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) 2, sb.toString(), "Por favor ingrese un n�mero entero");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Condicional seg�n selecci�n
			if (seleccion == 1) {

				// Selecci�n 1: B�squeda del producto por c�digo
				while (!OpcionDeMenu.controlError) {

					//Control del ingreso de datos
					//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
					if (OpcionDeMenu.controlError) {System.out.println(); return;}

					//B�squeda por c�digo
					//System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(idProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
				}
			}
			else if (seleccion == 2) {
				// Selecci�n 2: B�squeda del producto por nombre
				while (!OpcionDeMenu.controlError) {

					//Control del ingreso de datos
					//nombreProducto = ControlErrorDatos.controlString("Ingrese el nombre del producto", "Ha ingresado un n�mero en lugar de texto");
					if (OpcionDeMenu.controlError) {System.out.println(); return;}

					//B�squeda por nombre
					//System.out.println(InicializacionAplicacion.usuarioActivo.buscarProducto(nombreProducto));
					if (!OpcionDeMenu.controlError)
						System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
				}
			}
		}
		else {
			System.out.println("El cat�logo se encuentra vac�o.\n");
		}
		
	}

	public String toString() {return "Buscar producto";}

}
