package control.Cuenta.Comprador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import control.ErrorAplicacion;
import gestorAplicacion.Materiales.CarritoDeCompras;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelUsuario;
import uiMain.vista.VentanaAplicacion;
import uiMain.vista.Cuenta.Comprador.PanelAgregarACarrito;
import uiMain.vista.Cuenta.Comprador.PanelMostrarCarrito;

public class ControlAgregarACarrito extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {int idProducto, cantProd;

	// Verificaci�n de catalogo no vac�o
	if (!Cuenta.getCatalogo().isEmpty()) {
		
		while(!OpcionDeMenu.controlError) {
			VentanaAplicacion.panelPrincipal.removeAll();
			PanelUsuario panelresultados= new PanelUsuario();
			panelresultados.panelCambiante.removeAll();
			panelresultados.panelCambiante.setLayout(new BorderLayout());
			panelresultados.panelCambiante.add(new PanelAgregarACarrito());
			VentanaAplicacion.panelPrincipal.add(panelresultados,SwingConstants.CENTER);
			
			//Ingreso del c�digo
			//idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto que desea agregar", "El dato que ingres� como c�digo es inv�lido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}

			//Ingreso de la cantidad del producto
			//cantProd = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese la cantidad de elementos que desea agregar", "El dato que ingres� como cantidad es inv�lido, vuelva a intentarlo");
			if (OpcionDeMenu.controlError) {System.out.println(); return;}
			
			//Ejecuci�n del m�todo
			//System.out.println(CarritoDeCompras.agregarACarrito(idProducto, cantProd));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
		}
	}
	else {
		System.out.println("No hay productos en el cat�logo.\n");
	}
		
	}
	public String toString() {
		return "Agregar a carrito";
	}

}
