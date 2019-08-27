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

	String prod;

	public String getProd() {
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
				
		if (vend.getTotalDeProductosSubidos() != 0) {
			prod = vend.mostrarProductos();
			return prod;
		} else {
			return "";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		

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

//	Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String codigo = e.getActionCommand();
//		/*
//		Producto producto = Producto.getProductoByCodigo(codigo);
//        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, 
//               "Cantidad de "+producto.getNombre()+" que desea ordenar"));
//        Usuario.currentUser.getCarrito().añadirProductoCarrito(codigo, cantidad);
//		//Condicional para vendedores sin productos subidos
//        
//		if (usuario.getTotalDeProductosSubidos() != 0) {
//			//Ejecución del método
//			usuario.mostrarProductos();
//		}
//		else {
//
//			JOptionPane.showMessageDialog(null, "Usted aún no ha subido ningún producto.", "Advertencia",
//					JOptionPane.WARNING_MESSAGE);
//		}*/
//	}

	@Override
	public String toString() {
		return "Ver productos subidos";
	}

}