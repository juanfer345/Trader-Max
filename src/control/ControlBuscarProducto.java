package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelBuscarProducto;

public class ControlBuscarProducto extends OpcionDeMenu implements ActionListener,ChangeListener {
	String opcion;
	PanelBuscarProducto buscarprod;
	String resultado;

	@Override
	public void actionPerformed(ActionEvent arg) {

		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;

		String nombreProducto;
		int idProducto;
		byte seleccion=0;
		

		// Verificación de catalogo no vacío
		if (!usuario.getCatalogo().isEmpty()) {
			buscarprod = new PanelBuscarProducto();
			if (arg.getSource() instanceof JButton)

				// Condicional según selección
				if (arg.getActionCommand().equals("Buscar")) {

					// Selección 1: Búsqueda del producto por código
					if (opcion.equals("cod")) {
						try {
						resultado = usuario.buscarProducto(Integer.parseInt(buscarprod.texto.getText()));
						}
						catch (NumberFormatException NF){
							JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (opcion.equals("nom")) {
						resultado = usuario.buscarProducto(buscarprod.texto.getText());

					} else {
						JOptionPane.showMessageDialog(null, "Debe escoger una opción", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
		}

		else {
			JOptionPane.showMessageDialog(null, "El catálogo se encuentra vacío", "Informacion",
					JOptionPane.ERROR_MESSAGE);
		
		}

	}

	public String toString() {return "Buscar producto";}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(arg0.toString().equals("Buscar por código")) {
			opcion = "cod";
		}
		if(arg0.toString().equals("Buscar por nombre")) {
			opcion = "nom";
		}
		
	}

}
