/* 
   Clase ControlErrorDatosUsuario (abstracta, hereda de OpcionDeMenu)
   
   Prop�sito:
   Opci�n de men� del usuario, controla errores que pueden surgir 
   en los datos de un Usuario
   
   Estructuras de datos relevantes:
 */

package uiMain;

import java.io.IOException;

public abstract class ControlErrorDatos {

	//Control de n�mero real
	public static double controlReal (double limInferior, double limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar el ingreso de un n�mero entero (int) que deba ingresar el usuario
		 */

		// Atributos
		double numeroReal;
		
		while (true) {
			System.out.print(ingreso + "=> ");
			numeroReal = OpcionDeMenu.esDouble(OpcionDeMenu.br.readLine().trim());
			if(numeroReal != 0) {
				if(numeroReal != -1) {
					if(numeroReal >= limInferior && numeroReal <= limSuperior) {
						return numeroReal;
					}
					else {
						System.out.println("Por favor ingrese un n�mero entero en el rango [" + limInferior + "," + limSuperior + "].");
					}
				}
				else {
					System.out.print('\n' + Error);
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("\nNOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {
				OpcionDeMenu.controlError = true; return -1;
			}
		}
	}
	
	//Control de n�mero de entero
	public static int controlEntero (int limInferior, int limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar el ingreso de un n�mero entero (int) que deba ingresar el usuario
		 */

		// Atributos
		int numeroEntero;
		
		while (true) {
			System.out.print(ingreso + "=> ");
			numeroEntero = OpcionDeMenu.esInt(OpcionDeMenu.br.readLine().trim());
			if(numeroEntero != 0) {
				if(numeroEntero != -1) {
					if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
						return numeroEntero;
					}
					else {
						System.out.println("Por favor ingrese un n�mero entero en el rango [" + limInferior + "," + limSuperior + "].");
					}
				}
				else {
					System.out.print('\n' + Error);
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("\nNOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {
				OpcionDeMenu.controlError = true; return -1;
			}
		}
	}
	
	//Control de n�mero entero peque�o
	public static byte controlByte (byte limInferior, byte limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar el ingreso de un n�mero entero (byte) que deba ingresar el usuario
		 */

		// Atributos
		byte numeroEntero;
		
		while (true) {
			System.out.print(ingreso + "=> ");
			numeroEntero = OpcionDeMenu.esByte(OpcionDeMenu.br.readLine().trim());
			if(numeroEntero != 0) {
				if(numeroEntero != -1) {
					if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
						return numeroEntero;
					}
					else {
						System.out.println("Por favor ingrese un n�mero entero en el rango [" + limInferior + "," + limSuperior + "].");
					}
				}
				else {
					System.out.print('\n' + Error);
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("\nNOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			}
			else {
				OpcionDeMenu.controlError = true; return -1;
			}
		}
	}
	
	// Control de cadenas de texto
	public static String controlString(String ingreso, String Error) throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar una cadena de texto que haya ingresado el usuario
		 */

		// Atributos
		String nombreIngresado;
		byte comprobacion;

		while (true) {
			// Impresi�n de mensaje y recepci�n de datos
			System.out.print(ingreso + " => ");
			nombreIngresado = OpcionDeMenu.br.readLine().trim();
			comprobacion = OpcionDeMenu.esByte(nombreIngresado);

			// Control de error
			if (comprobacion != 0) {
				if (comprobacion == -1) {
					return nombreIngresado;
				} else {
					System.out.print('\n' + Error);
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			} else {
				OpcionDeMenu.controlError = true; return "";
			}
		}
	}

	// Control de correo del Usuario
	public static String controlCorreo() throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar que el correo ingresado por el Usuario
		              sea v�lido
		 */

		// Atributos
		String[] correoDividido;
		String correoIngresado;
		byte comprobacion;
		boolean ingresoCorrecto = false;

		while (true) {
			// Impresi�n de mensaje y recepci�n de datos
			System.out.print("Correo =>");
			correoIngresado = OpcionDeMenu.br.readLine().trim();
			comprobacion = OpcionDeMenu.esByte(correoIngresado);

			// Condicional de cancelaci�n
			if (comprobacion != 0) {
				// Condicional de que se ha ingresado una cadena
				if (comprobacion == -1) {
					// Condicional de que el correo contiene una @ y un .
					if (correoIngresado.contains("@") && correoIngresado.contains(".")) {
						correoDividido = correoIngresado.split("@");
						// Condicional de que se tiene algo antes del @
						if (correoDividido.length > 1) {
							correoDividido = correoDividido[1].split("\\.");
							// Condicional de que hay algo antes y despues del .
							if (correoDividido.length > 1) {
								ingresoCorrecto = true;
							}
						}
					}
					// Resultado seg�n ingreso
					if (ingresoCorrecto) {
						return correoIngresado;
					} else {
						System.out.println("Ingresar un correo v�lido de la forma: 'ejemplo@direcci�n.com'.");
					}
				} else {
					System.out.println("\nSe est� ingresando un n�mero en lugar de un correo.");
				}
				if (!!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			} else {
				OpcionDeMenu.controlError = true; return "";
			}
		}
	}

	// Control de contrase�a del Usuario
	public static boolean controlContrasena(String contrasenaIngresada) throws IOException {
		
		/*
		   Prop�sito: Se encarga de controlar que la contrase�a ingresada por el Usuario
		              sea v�lida
		 */

		// Atributos
		String contrasenaComprobada;
		byte comprobacion;

		while (true) {
			// Impresi�n de mensaje y recepci�n de datos
			System.out.print("Confirmar contrase�a =>");
			contrasenaComprobada = OpcionDeMenu.br.readLine().trim();
			comprobacion = OpcionDeMenu.esByte(contrasenaComprobada);

			// Control de error
			if (comprobacion != 0) {
				if (contrasenaComprobada.equals(contrasenaIngresada)) {
					return true;
				} else {
					System.out.println("\nLas contrase�as no coinciden.");
				}
				if (!!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operaci�n ingresando el n�mero '0'.");
			} else {
				return false;
			}
		}
	}
}