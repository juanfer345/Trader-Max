package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ControlErrorDatos;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlEliminarProdCatalogo extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		int idProducto;

		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {

			//Guardado de mensaje principal (incluyendo lista de productos)
           String mensaje = "Recuerde que el producto a eliminar debe ser de su propiedad.";
		   vend.mostrarProductos();

			while (!OpcionDeMenu.controlError) {

				//Ingreso del código del producto
				//idProducto = ControlErrorDatos.controlEntero(1, Integer.MAX_VALUE, "Ingrese el código del producto que desea eliminar del catálogo", "Por favor ingrese un número entero positivo");
				if (!OpcionDeMenu.controlError) {System.out.println(); return;}
				
				//vend.eliminarProductoCatalogo(idProducto);
			}
		}
		else {
			String mensaje2 = "Usted aún no ha subido ningún producto.\n";
		}
	}

	public String toString() {return "Eliminar producto";}
}
