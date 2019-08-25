package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlVerProductos extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		
		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {
			//Ejecución del método
			vend.mostrarProductos();
		}
		else {
			String mensaje1 = "Usted aún no ha subido ningún producto.";
		}
	}

	@Override
	public String toString() {return "Ver productos subidos";}
}