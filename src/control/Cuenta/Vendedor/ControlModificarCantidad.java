package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlModificarCantidad extends OpcionDeMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		String cod = e.getActionCommand();
		int codigo = Integer.parseInt(cod);
        String precio = JOptionPane.showInputDialog(null, "Nuevo precio del producto:");
        int pre = 0;
    	try {
			pre = ErrorAplicacion.controlEntero((precio), 1, Integer.MAX_VALUE, "Precio", "Por favor ingrese un precio v�lido");
		}
		catch (IOException e1) {
			JOptionPane.showMessageDialog(
					null, "Manejo de errores de la Aplicaci�n: " + e1.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
        vend.cambiarPrecio(codigo, pre);
        
    }
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto, cantidad;
		byte operacion;
		StringBuilder sb = new StringBuilder();

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
			String mensaje1 = "Esta opci�n es para cambiar la cantidad un producto del cat�logo. "
					+ "\n Recuerde que el producto debe ser de su propiedad.";
			vend.mostrarProductos();

			while(!OpcionDeMenu.controlError) {

				//Impresi�n del mensaje principal
				System.out.println(sb);

				//Ingreso del c�digo del producto
				//idProducto = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese el c�digo del producto al que le desea cambiar su cantidad", "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso de la cantidad del producto
				//cantidad = ErrorAplicacion.controlEntero(1, Integer.MAX_VALUE, "Ingrese cantidad a sumar o restar", "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}

				//Ingreso del tipo de operaci�n
				//operacion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, "Ingrese 1 para sumar la cantidad y 2 para restarla", "Por favor ingrese un n�mero entero positivo");
				if (OpcionDeMenu.controlError) {System.out.println(); return;}
				
				//Ejecuci�n del m�todo
				//vend.modificarCantidad(idProducto, cantidad, operacion);
			}
		}
		else {
			System.out.println("Usted a�n no ha subido ning�n producto.\n");
		}
	} */

	public String toString() {
		return "Modificar la cantidad de un producto";
	}


}