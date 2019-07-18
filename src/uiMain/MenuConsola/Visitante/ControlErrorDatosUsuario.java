package uiMain.MenuConsola.Visitante;

import java.io.IOException;

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
			//Impresión de mensaje y recepción de datos
			System.out.print(sb);
			tipoDeCuenta = esByte(br.readLine().trim());
			
			//Control de error
			if (tipoDeCuenta != 0) {
				if (tipoDeCuenta >= 1 && tipoDeCuenta  <= 3) {return tipoDeCuenta;}
				else {
					System.out.println("Por favor ingrese un número entero en el rango [1,3]");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {controlError = true; return -1;}
		}
	}
	
	String controlNombre() throws IOException {
		
		String nombreIngresado;
		byte comprobacion;
		
		while (true) {
			//Impresión de mensaje y recepción de datos
			System.out.print("Nombre: ");
			nombreIngresado = br.readLine().trim();
			comprobacion = esByte(nombreIngresado);
			
			//Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1)  {return nombreIngresado;}
				else {
					System.out.println("\nSe está ingresando un número en lugar de un nombre.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {controlError = true; return "";}
		}
	}
	
	String controlCorreo() throws IOException {

		String [] correoDividido;
		String correoIngresado;
		byte comprobacion;
		boolean ingresoCorrecto = false;
		
		while (true) {
			//Impresión de mensaje y recepción de datos
			System.out.print("Correo: ");
			correoIngresado = br.readLine().trim();
			comprobacion = esByte(correoIngresado);
			
			//Condicional de cancelación
			if (comprobacion != 0) {
				//Condicional de que se ha ingresado una cadena
				if (comprobacion == -1)  {
					//Condicional de que el correo contiene una @ y un .
					if (correoIngresado.contains("@") && correoIngresado.contains(".")) {
						correoDividido = correoIngresado.split("@");
						//Condicional de que se tiene algo antes del @
						if (correoDividido.length > 1) {
							correoDividido = correoDividido[1].split("\\.");
							//Condicional de que hay algo antes y despues del .
							if (correoDividido.length > 1) {
								ingresoCorrecto = true;
							}
						}
					}
					
					//Resultado según ingreso
					if (ingresoCorrecto) {return correoIngresado;}
					else {System.out.println("Ingresar un correo valido de la forma: 'ejemplo@dirección.com'");}
				}
				else {
					System.out.println("\nSe está ingresando un número en lugar de un correo.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {controlError = true; return "";}
		}
	}
	
	int controlCedula() throws IOException {
		
		Integer cedulaIngresada;
		
		while (true) {
			//Impresión de mensaje y recepción de datos
			System.out.print("Cedula: ");
			cedulaIngresada = esInt(br.readLine().trim());
			
			//Control de error
			if (cedulaIngresada != 0) {
				if (cedulaIngresada != -1) {return cedulaIngresada;}
				else {
					System.out.println("Por favor ingrese una cédula válida");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {controlError = true; return -1;}
		}
	}
	
	boolean controlContrasena(String contrasenaIngresada) throws IOException {
		
		String contrasenaComprobada;
		byte comprobacion;
		
		while (true) {
			//Impresión de mensaje y recepción de datos
			System.out.print("Confirmar contraseña: ");
			contrasenaComprobada = br.readLine().trim();
			comprobacion = esByte(contrasenaComprobada);
			
			//Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1 && contrasenaComprobada.equals(contrasenaIngresada))  {return true;}
				else {
					System.out.println("\nLas contraseñas no coinciden.");
				}
				if (!controlError) System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.");
			}
			else {return false;}
		}
	}
}