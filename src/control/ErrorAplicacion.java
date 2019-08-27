/* 
   Clase ControlErrorDatosUsuario (abstracta, hereda de OpcionDeMenu)
   
   Propósito:
   Opción de menú del usuario, controla errores que pueden surgir 
   en los datos de un Usuario
   
   Estructuras de datos relevantes:
 */

package control;

import java.io.IOException;

import uiMain.MenuConsola.OpcionDeMenu;

public abstract class ErrorAplicacion extends Exception {

	//Control de número real
	public static double controlReal (double limInferior, double limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar el ingreso de un número entero (int) que deba ingresar el usuario
		 */

		// Atributos
		double numeroReal;
		
		while (true) {
			System.out.print(ingreso + " => ");
			numeroReal = OpcionDeMenu.esDouble(OpcionDeMenu.br.readLine().trim());
			if(numeroReal != 0) {
				if(numeroReal != -1) {
					if(numeroReal >= limInferior && numeroReal <= limSuperior) {
						return numeroReal;
					}
					else {
						System.out.println("Por favor ingrese un número entero en el rango [" + limInferior + "," + limSuperior + "].");
					}
				}
				else {
					System.out.println(Error);
				}
				if (!OpcionDeMenu.controlError)
					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
			}
			else {
				OpcionDeMenu.controlError = true; return -1;
			}
		}
	}
	//Control de número real
	public static double controlReal2 (String entrada, double limInferior, double limSuperior, String ingreso, String Error) throws IOException {
		
		//Propósito: Se encarga de controlar el ingreso de un número entero (int) que deba ingresar el usuario

		double numeroReal = OpcionDeMenu.esDouble(entrada) ;
		
		while (true) {
			if(numeroReal != 0) {
				if(numeroReal != -1) {
					if(numeroReal >= limInferior && numeroReal <= limSuperior) {
						return numeroReal;
					}
					else {
						throw new IOException("Por favor ingrese un número en el rango [" + limInferior + "," + limSuperior + "]");
					}
				}
				else {
					throw new IOException("Por favor ingrese un número en el rango [" + limInferior + "," + limSuperior + "]");
				}
			}
			else {
				throw new IOException("Por favor ingrese un número en el rango [" + limInferior + "," + limSuperior + "]");
			}
		}
	}
	
	
	//Control de número de entero
	public static int controlEntero (String entrada, int limInferior, int limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar el ingreso de un número entero (int) que deba ingresar el usuario
		 */

		// Atributos
		int numeroEntero;
		
		numeroEntero = OpcionDeMenu.esInt(entrada);
		if(numeroEntero != -1) {
			if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
				return numeroEntero;
			}
			else {				
				throw new IOException("Por favor ingrese un número entero en el rango [" + limInferior + "," + limSuperior + "]"
					+ " en el campo " + ingreso + ".");
			}
		}
		else {
			throw new IOException(Error);
		}
	}
	
	//Control de número entero pequeño
	public static byte controlByte (String entrada, byte limInferior, byte limSuperior, String ingreso, String Error) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar el ingreso de un número entero (byte) que deba ingresar el usuario
		 */

		byte numeroEntero = OpcionDeMenu.esByte(entrada);
		
		if(numeroEntero != -1) {
			if(numeroEntero >= limInferior && numeroEntero <= limSuperior) {
				return numeroEntero;
			}
			else {
				throw new IOException("Por favor ingrese un número entero en el rango [" + limInferior + "," + limSuperior + "]"
						+ " en el campo " + ingreso + ".");
			}
		}
		else {
			throw new IOException(Error);
		}
	}
	
	// Control de cadenas de texto
	public static String controlString(String entrada, String ingreso, String error) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar una cadena de texto que haya ingresado el usuario
		 */

		// Atributos
		long comprobacionL;
		double comprobacionD;

		comprobacionL = OpcionDeMenu.esLong(entrada);
		comprobacionD = OpcionDeMenu.esDouble(entrada);
		
		// Control de error
		if (!entrada.isEmpty()) {
			if (comprobacionL == -1 && comprobacionD == -1) {
				return entrada;
			} else {
				throw new IOException(error);
			}
		}
		else {
			throw new IOException("Ha ingresado una cadena vacía en el campo " + ingreso);
		}
	}
	
	// Control de correo del Usuario
	public static String controlCorreo(String entrada) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar que el correo ingresado por el Usuario
		              sea válido
		 */

		// Atributos
		String[] correoDividido;
		long comprobacion;
		boolean ingresoCorrecto = false;

		comprobacion = OpcionDeMenu.esLong(entrada);

		// Condicional de que se ha ingresado una cadena
		if (comprobacion == -1) {
			// Condicional de que el correo contiene una @ y un .
			if (entrada.contains("@") && entrada.contains(".")) {
				correoDividido = entrada.split("@");
				// Condicional de que se tiene algo antes del @
				if (correoDividido.length > 1) {
					correoDividido = correoDividido[1].split("\\.");
					// Condicional de que hay algo antes y despues del .
					if (correoDividido.length > 1) {
						ingresoCorrecto = true;
					}
				}
			}
			// Resultado según ingreso
			if (ingresoCorrecto) {
				return entrada;
			} else {
				throw new IOException("Por favor ingresar un correo válido de la forma: \"ejemplo@dirección.com\".");
			}
		} else {
			throw new IOException("Se está ingresando un número en lugar de un correo.");
		}
	}

	// Control de contraseña del Usuario
	public static String controlContrasena(String entrada, String ingreso) throws IOException {
		
		/*
		   Propósito: Se encarga de controlar que la contraseña ingresada por el Usuario
		              sea válida
		 */

		// Atributos
//		String contrasenaComprobada;
//		long comprobacion;

		// Control de error
		if (!entrada.isEmpty()) {
			return entrada;
		}
		else {
			throw new IOException("Ha ingresado una cadena vacía en el campo " + ingreso);
		}
		
//		while (true) {
//			// Impresión de mensaje y recepción de datos
//			System.out.print("Confirmar contraseña => ");
//			contrasenaComprobada = OpcionDeMenu.br.readLine().trim();
//			comprobacion = OpcionDeMenu.esLong(contrasenaComprobada);
//
//			// Control de error
//			if (comprobacion != 0) {
//				if (contrasenaComprobada.equals(contrasenaIngresada)) {
//					return true;
//				} else {
//					System.out.println("\nLas contraseñas no coinciden.");
//				}
//				if (!!OpcionDeMenu.controlError)
//					System.out.println("NOTA: se puede cancelar la operación ingresando el número '0'.\n");
//			} else {
//				return false;
//			}
//		}
	}
}