package uiMain.MenuConsola.Cuenta.Vendedor;

import java.io.IOException;

import control.ErrorAplicacion;
import gestorAplicacion.Usuarios.Vendedor;
import uiMain.InicializacionAplicacion;
import uiMain.MenuConsola.OpcionDeMenu;

public class VerProductos {

//	@Override
//	public void ejecutar() throws IOException {
//		
//		Vendedor vend = (Vendedor) InicializacionAplicacion.usuarioActivo;
//		byte seleccion;
//		
//		//Condicional para vendedores sin productos subidos
//		if (vend.getTotalDeProductosSubidos() != 0) {
//
//			//Guardado de mensaje principal
//			System.out.println();
//			sb.append("Usted ha elegido mostrar todos sus productos subidos:\n");
//			sb.append("1: Continuar\n");
//			sb.append("2: Cancelar\n");
//			sb.append("Seleccion");
//
//			// Ingreso del dato por parte del usuario
//			seleccion = ErrorAplicacion.controlByte((byte) 1, (byte) 2, sb.toString(), "El dato que ingres� es inv�lido, vuelva a intentarlo");
//			if (controlError || seleccion == 2) {System.out.println(); return;}
//			
//			//Ejecuci�n del m�todo
//			System.out.println(vend.mostrarProductos());
//		}
//		else {
//			System.out.println("Usted a�n no ha subido ning�n producto.\n");
//		}
//	}
//
//	@Override
//	public String toString() {return "Ver productos subidos";}
}