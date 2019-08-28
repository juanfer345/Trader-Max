package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import control.Errores.ErrorTipodeDato;
import control.Errores.MetodosConError;
import gestorAplicacion.Usuarios.Cuenta;
import gestorAplicacion.Usuarios.Visitante;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;
import uiMain.vista.PanelBuscarProducto;

public class ControlBuscarProducto extends OpcionDeMenu implements ActionListener{
	PanelBuscarProducto buscarprod;
	String resultado;

	@Override
	public void actionPerformed(ActionEvent arg) {

		Visitante usuario = (Visitante) InicializacionAplicacion.usuarioActivo;
		PanelBuscarProducto bp = new PanelBuscarProducto();

		// Verificaci�n de catalogo no vac�o
		if (!Cuenta.getCatalogo().isEmpty()) {
			bp.lanzar();
			resultado = buscarprod.texto.getText();
			if ((arg.getSource() instanceof JButton) && !(resultado.equals(""))) {
				// Condicional seg�n selecci�n
				if (arg.getActionCommand().equals("Buscar por c�digo")) {

					try {
						resultado = usuario.buscarProducto(Integer.parseInt(buscarprod.texto.getText()));
					}
					catch (NumberFormatException NF){
						JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					JOptionPane.showMessageDialog(null, resultado, "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				}else if(arg.getActionCommand().equals("Buscar por nombre")) {
					try {
						resultado = MetodosConError.controlString(resultado,"","Error, no ingres� un string");
					}catch(ErrorTipodeDato e){
						JOptionPane.showMessageDialog(null, e, "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			}
			else {
				if(resultado.equals("")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar algo en el campo de texto", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		}
		else {
			JOptionPane.showMessageDialog(null, "El cat�logo se encuentra vac�o", "Informacion",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public String toString() {
		return "Buscar producto";
	}

}
