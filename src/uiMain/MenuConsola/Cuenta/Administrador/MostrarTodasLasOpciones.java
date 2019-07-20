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
			
			//Impresi�n de mensaje y recepci�n de datos
			System.out.println(sb);
			seleccion = Byte.parseByte(br.readLine().trim());
			
			//Ejecuci�n del m�todo e impresi�n de respuesta
			if (seleccion != 0) {
				System.out.println(ImprimirTodasLasOpciones());
			}
			else {
				controlError = true;
			}
			//Impresi�n de mensaje de cancelaci�n en caso de que se haya producido un error
			if (!controlError) {System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0' \n");}
		}
	}
	
	@Override
	public String toString() {return "Agregar opci�n de men�";}
}