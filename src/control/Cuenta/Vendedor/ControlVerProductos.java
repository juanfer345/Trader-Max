package control.Cuenta.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import gestorAplicacion.Usuarios.Vendedor;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlVerProductos extends OpcionDeMenu implements ActionListener {
	Vendedor usuario = (Vendedor) InicializacionAplicacion.usuarioActivo;
	@Override
	public void actionPerformed(ActionEvent e) {
		String codigo = e.getActionCommand();
		/*
		Producto producto = Producto.getProductoByCodigo(codigo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, 
               "Cantidad de "+producto.getNombre()+" que desea ordenar"));
        Usuario.currentUser.getCarrito().añadirProductoCarrito(codigo, cantidad);
		//Condicional para vendedores sin productos subidos
        
		if (usuario.getTotalDeProductosSubidos() != 0) {
			//Ejecución del método
			usuario.mostrarProductos();
		}
		else {

			JOptionPane.showMessageDialog(null, "Usted aún no ha subido ningún producto.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}*/
	}

	@Override
	public String toString() {return "Ver productos subidos";}
}