package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;

public class ControlVerProductos implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		
		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() != 0) {
			//Ejecuci�n del m�todo
			vend.mostrarProductos();
		}
		else {
			String mensaje1 = "Usted a�n no ha subido ning�n producto.";
		}
	}

	@Override
	public String toString() {return "Ver productos subidos";}
}