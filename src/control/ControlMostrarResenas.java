package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorAplicacion.Usuarios.Cuenta;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarResenas extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int idProducto=0;

		if (!Cuenta.getCatalogo().isEmpty()) {
			while (!OpcionDeMenu.controlError) {
				
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto", "El dato que ingres� como c�digo es invalido, vuelva a intentarlo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}
				
				//Comprobaci�n de que el producto existe en el cat�logo
				if (!Cuenta.getCatalogo().containsKey(idProducto)) {
					System.out.println("Producto no existente, intentelo de nuevo.");
				} 
				else {
					System.out.println(Cuenta.getCatalogo().get(idProducto).mostrarResenas());
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			}
		} else {
			System.out.println("El cat�logo se ecuentra vac�o.\n");
			OpcionDeMenu.controlError = true;
		}
		
	}
	public String toString() {
		return "Mostrar rese�as";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
