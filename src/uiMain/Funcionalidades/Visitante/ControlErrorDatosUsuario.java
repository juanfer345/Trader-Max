package uiMain.Funcionalidades.Visitante;

import java.io.IOException;

import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

abstract class ControlErrorDatosUsuario extends OpcionDeMenu {

	@Override
	public	abstract void ejecutar() throws IOException;

	@Override
	public	abstract String toString();
	
	byte controlTipoDeCuenta() throws IOException {
		
		byte tipoDeCuenta;

	    //Guardado de mensaje
		sb.append("\nPor favor elija su tipo de usuario:\n");
		sb.append("1: Comprador\n");
		sb.append("2: Vendedor\n");
		sb.append("3: Administrador\n");
		sb.append("=> ");
		
		while (true) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print(sb);
			tipoDeCuenta = MenuDeConsola.esByte(br.readLine().trim());
			
			//Control de error
			if (tipoDeCuenta != 0) {
				if (tipoDeCuenta >= 1 && tipoDeCuenta  <= 3) {return tipoDeCuenta;}
				else {
					System.out.println("Por favor ingrese un n�mero entero en el rango [1,3]");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {controlError = true; return -1;}
		}
	}
	
	String controlNombre() throws IOException {
		
		String nombreIngresado;
		byte comprobacion;
		
		while (true) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print("Nombre: ");
			nombreIngresado = br.readLine().trim();
			comprobacion = (byte) MenuDeConsola.esByte(nombreIngresado);
			
			//Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1)  {return nombreIngresado;}
				else {
					System.out.println("\nSe est� ingresando un n�mero en lugar de un nombre.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {controlError = true; return "";}
		}
	}
	
	String controlCorreo() throws IOException {
		
		String correoIngresado;
		byte comprobacion;
		
		while (true) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print("Correo: ");
			correoIngresado = br.readLine().trim();
			comprobacion = (byte) MenuDeConsola.esByte(correoIngresado);
			
			//Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1)  {
					if (correoIngresado.contains("@") && correoIngresado.contains(".") && correoIngresado.length() >= 7) {
						return correoIngresado;
					}
					else {
						System.out.println("Ingresar un correo valido de la forma: 'ejemplo@direcci�n.com'");
					}
				}
				else {
					System.out.println("\nSe est� ingresando un n�mero en lugar de un correo.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {controlError = true; return "";}
		}
	}
	
	int controlCedula() throws IOException {
		
		Integer cedulaIngresada;
		
		while (true) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print("Cedula: ");
			cedulaIngresada = MenuDeConsola.esInt(br.readLine().trim());
			
			//Control de error
			if (cedulaIngresada != 0) {
				if (cedulaIngresada != -1) {return cedulaIngresada;}
				else {
					System.out.println("Por favor ingrese una c�dula v�lida");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {controlError = true; return -1;}
		}
	}
	
	boolean controlContrasena(String contrasenaIngresada) throws IOException {
		
		String contrasenaComprobada;
		byte comprobacion;
		
		while (true) {
			//Impresi�n de mensaje y recepci�n de datos
			System.out.print("Confirmar contrase�a: ");
			contrasenaComprobada = br.readLine().trim();
			comprobacion = (byte) MenuDeConsola.esByte(contrasenaComprobada);
			
			//Control de error
			if (comprobacion != 0) {
				if (contrasenaComprobada.equals(contrasenaIngresada))  {return true;}
				else {
					System.out.println("\nLas contrase�as no coinciden.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {return false;}
		}
	}
}