package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gestorAplicacion.Materiales.Producto;
import gestorAplicacion.Usuarios.Cuenta;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class ControlMostrarPorCategoria extends OpcionDeMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		byte seleccion;

		if (!Cuenta.getCatalogo().isEmpty()) {
			
			//Selecci�n por parte del usuario
			//seleccion = ControlErrorDatos.controlByte((byte) 1, (byte) Producto.categorias.length, sb.toString(), "Por favor ingrese un n�mero entero");
			
			if (OpcionDeMenu.controlError) {System.out.println(); return;}
			
			//Ejecuci�n del m�todo
			//System.out.println(InicializacionAplicacion.usuarioActivo.mostrarCategoria((byte) (seleccion - 1)));
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "El catalogo se encuentra vacio", "Mostrar productos por categoria", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public String toString() {return "Mostrar productos por categor�a";}


}
