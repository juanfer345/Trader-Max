package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import gestorAplicacion.InicializacionAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.ControlErrorDatos;
import uiMain.OpcionDeMenu;

public class VerProductos extends OpcionDeMenu {

	@Override
	public void ejecutar() throws IOException {
		
		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
		
		//Condicional para vendedores sin productos subidos
		if (vend.getTotalDeProductosSubidos() == 0) {

			//Guardado de mensaje principal
			System.out.println();
			sb.append("Usted ha elegido mostrar todos sus productos subidos:\n");
			sb.append("0: Cancelar\n");
			sb.append("1: Continuar\n");

			// Ingreso del dato por parte del usuario
			ControlErrorDatos.controlByte((byte) 1, (byte) 1, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
			if (controlError) {System.out.println(); return;}
			
			//Ejecuci�n del m�todo
			System.out.println(vend.mostrarProductos());
			if (!OpcionDeMenu.controlError)
				System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.\n");
		}
		else {
			System.out.println("Usted a�n no ha subido ning�n producto\n");
		}
	}

	@Override
	public String toString() {return "Ver productos subidos";}
}