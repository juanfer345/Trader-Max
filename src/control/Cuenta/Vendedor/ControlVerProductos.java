package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.Cuenta.Vendedor.VentanaVerProductos;

public class ControlVerProductos extends OpcionDeMenu implements ActionListener {

	Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
	String prod;

	public String getProd() {
		if (vend.getTotalDeProductosSubidos() != 0) {
			prod = vend.mostrarProductos();
			return prod;
		} else {
			return "";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		VentanaVerProductos x2 = new VentanaVerProductos();

		if (vend.getTotalDeProductosSubidos() != 0) {
			if (e.getSource() instanceof JMenuItem) {
				x2.lanzar();
			}
		} else {
			if (e.getSource() instanceof JMenuItem) {
				JOptionPane.showMessageDialog(null, "Usted no ha subido ningun producto", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		return "Ver productos subidos";
	}

}