package uiMain.MenuConsola.Cuenta.Administrador;

import java.io.IOException;

import uiMain.OpcionDeMenu;

public class MostrarTodasLasOpciones extends OpcionDeMenu {
	
	public void ejecutar() throws NumberFormatException, IOException {
		
	    byte seleccion;

	    //Guardado de mensaje principal
		sb.append("Usted ha elegido mostrar todas las opciones de menu:\n");
		sb.append("0: Cancelar\n");
		sb.append("1: Continuar\n");
		sb.append("=> ");
		
		//Ciclo para control de error
		while (!controlError) {
			
			//Impresión de mensaje y recepción de datos
			System.out.println(sb);
			seleccion = Byte.parseByte(br.readLine().trim());
			
			//Ejecución del método e impresión de respuesta
			if (seleccion != 0) {
				System.out.println(ImprimirTodasLasOpciones());
			}
			else {
				controlError = true;
			}
			//Impresión de mensaje de cancelación en caso de que se haya producido un error
			if (!controlError) {System.out.println("NOTA: se puede cancelar la operación ingresando el número '0' \n");}
		}
	}
	
	@Override
	public String toString() {return "Agregar opción de menú";}
}